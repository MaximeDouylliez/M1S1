#include <stdio.h>
#include <stdlib.h>


enum ctx_state_e{CTX_INIT,CTX_EXEC,CTX_END};
typedef void (func_t) (void*);
typedef struct ctx_s {

  char* ctx_esp;
  char* ctx_ebp;
  char* ctx_base;
  unsigned int ctx_size;
  char* ctx_magic;
  func_t* ctx_f;
  void* ctx_args;
  enum ctx_state_e ctx_state;

};

static ctx_s* current_ctx;

int init_ctx(struct ctx_s *ctx, int stack_size, func_t f, void *args);
void switch_to_ctx(struct ctx_s *ctx) ;
