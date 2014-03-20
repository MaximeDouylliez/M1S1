
#include "init_ctx.h"
#include "hw.h"
#define N 100

static int pp,pr;







void start_schedule(){
  printf("Activation du start_schedule\n");
  setup_irq(TIMER_IRQ,yield);
  start_hw();  
  yield();
} 

int main(int argc, char *argv[])
{


  printf("-------------- Demarrage --------------"); 
void f_ping(void *arg);
void f_pong(void *arg);
void f_pang(void *arg);
void producteur();
void consommateur();

sem_init(&mutex, 1);                /* controle d'acces au tampon */
sem_init(&vide, N);                 /* nb de places libres */
sem_init(&plein, 20);                /* nb de places occupees */


  create_ctx(16384,producteur,NULL);
  printf("1st Create Terminé !\n");
  create_ctx(16384,consommateur,NULL);
  printf("2nd Create Terminé !\n");
 create_ctx(16384,consommateur,NULL);
  printf("2nd Create Terminé !\n");
	
	
  start_schedule();
	
  exit(EXIT_SUCCESS);
}

void f_ping(void *args)
{	
  while(1) {
    sem_down(&sem1);
//    sem_down(&sem1);
    printf("A");
    printf("B");
    printf("C");
    
  }
}

void producteur (void)
{


  while (1) {
    printf("produit l'objet suivant\n");
pp++;
    sem_down(&vide);                  /* dec. nb places libres */
    sem_down(&mutex);                 /* entree en section critique */
    printf("mettre l'objet dans le tampon\n");
    sem_up(&mutex);                   /* sortie de section critique */
    sem_up(&plein);                   /* inc. nb place occupees */
  }
}

void consommateur (void)
{


  while (1) {
    sem_down(&plein);                 /* dec. nb emplacements occupes */
    sem_down(&mutex);                 /* entree section critique */
    printf("retire un objet du tampon\n");
pp--;
pr++;
 printf("objets produits jusque maintenant:%d,  objets consommés jusque maintenant:%d\n",pp,pr);
    sem_up(&mutex);                   /* sortie de la section critique */
    sem_up(&vide);                    /* inc. nb emplacements libres */
    printf("utiliser l'objet\n");

  }
}
void f_pong(void *args)
{
  while(1){
    printf("1\n");      
    printf("2\n");    
    printf("3\n");
    sem_up(&sem1);       
  }
}

void f_pang(void *args){

  while(1){
    
    printf("ALPHA\n");
    printf("EPSILON\n");
    printf("THETA\n");
    sem_up(&sem1);
}
}
