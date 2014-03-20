#include "try.h"

static int run=166;

int try(ctx_s* pctx,func_t *f ,int arg){
	int val;
	asm ("movl %%esp, %0"
		"\n\t"
		"movl %%ebp, %1"
		: "=r"(pctx->ctx_esp), "=r"(pctx->ctx_ebp)
		:
	);
	printf("Sauvegarde !\nctx_esp : %u \n ctx_ebp : %u\n",pctx->ctx_esp,pctx->ctx_ebp);

	f(arg);

}


int throw(ctx_s *pctx,int r){
	run = r;
	asm ("movl %0,%%esp"
	"\n\t"
	"movl %1,%%ebp"
	:
	: "r"(pctx->ctx_esp), "r"(pctx->ctx_ebp)
	);
	printf("Restauration !\nctx_esp : %u \nctx_ebp : %u\n",pctx->ctx_esp,pctx->ctx_ebp);
	fflush(stdout); 
printf("Valeur de r après rechargement de contexte%d\n",r);
	return run;
}






