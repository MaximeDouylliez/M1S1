#include <stdio.h>
#include <stdlib.h>

typedef struct {

  char* ctx_esp;
  char* ctx_ebp;
}ctx_s;

typedef int (func_t) (int);
static ctx_s pctx;

int try(ctx_s* pctx,func_t *f ,int arg);

int throw(ctx_s *pctx,int r);



