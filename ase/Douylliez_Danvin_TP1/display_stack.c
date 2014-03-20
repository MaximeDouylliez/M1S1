
#include <stdio.h>
#include <stdlib.h>

typedef struct {

  char* ctx_esp;
  char* ctx_ebp;
}ctx_s;


ctx_s getRegOfGetRegCall(ctx_s reg){

  asm ("movl %%esp, %0"
       "\n\t"
       "movl %%ebp, %1"
       : "=r"(reg.ctx_esp), "=r"(reg.ctx_ebp)
       :
       );
  printf("L'adresse stocké dans ebp est:%d\nL'adresse stocké dans esp est:%d \n",reg.ctx_ebp,reg.ctx_esp);
  return reg;}



void g(int pa,int pb,int pc){ 
  ctx_s reg;
  int la,lb,lc;


  asm ("movl %%esp, %0"
       "\n\t"
       "movl %%ebp, %1"
       : "=r"(reg.ctx_esp), "=r"(reg.ctx_ebp)
       :
       );
  printf("In g\nL'adresse stocké dans ebp est:%u\nL'adresse stocké dans esp est:%u \n",reg.ctx_ebp,reg.ctx_esp);


  printf("pa:%u \npb:%u \npc:%u \nla:%u \nlb:%u \nlc:%u\n",&pa,&pb,&pc,&la,&lb,&lc);
 
}


void f(){
  int pa,pb,pc;
  ctx_s reg;
  asm ("movl %%esp, %0"
       "\n\t"
       "movl %%ebp, %1"
       : "=r"(reg.ctx_esp), "=r"(reg.ctx_ebp)
       :
       );
  printf("Avant g:\nL'adresse stocké dans ebp est:%d\nL'adresse stocké dans esp est:%d \n",reg.ctx_ebp,reg.ctx_esp);

  g(pa,pb,pc);
}


int main()
{
  ctx_s reg;
  int ld,le,lf;
  asm ("movl %%esp, %0"
       "\n\t"
       "movl %%ebp, %1"
       : "=r"(reg.ctx_esp), "=r"(reg.ctx_ebp)
       :
       );
  printf("Avant f:\nL'adresse stocké dans ebp est:%d\nL'adresse stocké dans esp est:%d \n",reg.ctx_ebp,reg.ctx_esp);
  int i;
  for(i=0;i< 20;i++)
    g(ld,le,lf);
 
  return 0;
}
