#include "init_ctx.h"



int init_ctx(struct ctx_s *ctx, int stack_size, func_t* f, void *args)
{
ctx->base=malloc(stack_size*(sizeof char));
ctx->size=stack_size;
ctx->ctx_ebp=ctx->base+ctx->size-4;
ctx->ctx_esp=ctx->base+ctx->size-4;
ctx->magic=0xABCD;
ctx->state=CTX_INIT;
ctx->ctx_f=f;
ctx->ctx_args=args;

return 0;
}





void switch_to_ctx(struct ctx_s *ctx) 
{
assert(ctx);
assert(ctx->ctx_magic==ctx->magic);
assert(ctx->ctx_state==CTX_INIT||ctx->ctx_state==CTX_EXEC);
asm ("movl %%esp, %0"
		"\n\t"
		"movl %%ebp, %1"
		: "=r"(current_ctx->ctx_esp), "=r"(current_ctx->ctx_ebp)
		:
	);


	asm ("movl %0,%%esp"
	"\n\t"
	"movl %1,%%ebp"
	:
	: "r"(ctx->ctx_esp), "r"(ctx->ctx_ebp)
	);


if(ctx->state==CTX_INIT){
ctx->state=CTX_EXEC;
ctx->ctx_f(ctx->ctx_args);
ctx->state=CTX_END;}

 }











}



















