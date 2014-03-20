#include "init_ctx.h"
#include "hw.h"

void sem_init(struct sem_s *s,int v)
{
  s->valeur=v;
  s->pt=(struct ctx_s*)0;
  s->max = v;
}

void print_sem(struct sem_s *s)
{
printf("\n%d jetons\n",s->valeur);
}

//consome un jeton ou passe la main et place le contexte dans la file d'attente des demandeurs de jetons
void sem_down(struct sem_s *s)
{
  print_sem(s);
  irq_disable();
  s->valeur--;
  if(s->valeur < 1)
    {
      current_ctx->state=BLK_SEM;
      current_ctx->sem_next=s->pt;
      s->pt=current_ctx;
      irq_enable();
      yield();
    }else
    {
      irq_enable();
    }
}

//rajoute un jeton et debloque un contexte placé dans la fille d'attente des demandeurs de jetons
  void sem_up(struct sem_s *s)
  {
print_sem(s);
    irq_disable();
    if(s->max > s->valeur){
    s->valeur++;
    if(s->valeur < 1)// si s->valeur ==-5, 6  contextes sont bloqués par cette sémaphore
      {
	s->pt->state=CTX_EXEC;
	s->pt=s->pt->sem_next;
	irq_enable();
      }
    }
    irq_enable();
  }


// initialise le contexte
  int init_ctx(struct ctx_s *ctx, int stack_size, func_t* f, void *args)
  {
    ctx->base=malloc(stack_size*sizeof (char));
    ctx->size=stack_size;
    ctx->ebp=ctx->base+ctx->size-4;
    ctx->esp=ctx->base+ctx->size-4;
    ctx->magic="0xABCD";
    ctx->state=CTX_INIT;
    ctx->f=f;
    ctx->args=args;
    printf("Initialisation CTX Terminé !\n\n");
    return 0;
  }

  //la fonction qui permet de lancer la fonction du contexte en mettant a jour les champs necessaires .
  void start_current_ctx(){

    current_ctx->state=CTX_EXEC;
    current_ctx->f(current_ctx->args);
    current_ctx->state=CTX_END;
    printf("Un contexte se place en END !\n");
    yield();

  }

  //la fonction qui permet de changer de contexte
  void switch_to_ctx(struct ctx_s *ctx) 
  {
    assert(ctx);
    assert(ctx->magic==ctx->magic);
    //assert(ctx->state==CTX_INIT||ctx->state==CTX_EXEC);

    while(ctx->state==BLK_SEM)
	{
		ctx=ctx->next;
	}

    while(ctx->state == CTX_END)
      {
	if((ctx->state == CTX_END) && (current_ctx == current_ctx->next))
	  {
	    printf("--------------- END PROGRAM ---------------");
	    exit(0);
	  }
	printf("Un contexte est libéré !\n");
	current_ctx->next = ctx->next;
	free(ctx->base);
	free(ctx);
	ctx=current_ctx->next;
      }
    irq_disable();
    if(current_ctx){
      // mise à jour de la structure du contexte actuel
      asm ("movl %%esp, %0"
	   "\n\t"
	   "movl %%ebp, %1"
	   : "=r"(current_ctx->esp), "=r"(current_ctx->ebp)
	   :
	   );
    }

    /*Après le changement de contexte,le pointeur ctx sera inutilisable et l'on fait pointer current ctx sur le contenu de ctx:-> après le changement de contexte, le contenu de ctx sera toujours accesible !*/
    current_ctx=ctx;
    irq_enable();
    asm ("movl %0,%%esp"
	 "\n\t"
	 "movl %1,%%ebp"
	 :
	 : "r"(current_ctx->esp), "r"(current_ctx->ebp)
	   //si le contexte chargé n'a pas lancé sa fonction, on la lance !
	 );
    if(current_ctx->state==CTX_INIT)
      start_current_ctx();
  }


  //dès qu'un contexte se termine, il se ramene ici, et il doit donc donner la main à un niveau contexte pour qu'il puisse continuer son travail. Il faut donc verifier quel "if else if etc..." mettre pour qu'il puisse se relancer automatiquement
  void yield(){
    if(current_ctx != NULL){
      switch_to_ctx(current_ctx->next);
    }else if (ring != NULL){
      switch_to_ctx(ring->next);
    }else {};
  }




  void create_ctx(int size, func_t f, void* args){
   struct ctx_s *ctx=(struct ctx_s*)malloc(sizeof(struct ctx_s));
    if(ring==NULL){
      ring=ctx;
      ctx->next=ctx;
    }else{
      ctx->next=ring->next;
      ring->next=ctx;
    }
    init_ctx(ctx,size,f,args);

  }

