#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include "hw.h"

#define TIMER_IRQ 2

static struct sem_s mutex, vide, plein;
static struct sem_s sem1;
static struct ctx_s main_ctx;
static int i=0;
static struct ctx_s* current_ctx= NULL;
static struct ctx_s* ring;

enum ctx_state_e{CTX_INIT,CTX_EXEC,CTX_END,BLK_SEM};
typedef void (func_t) (void*);


struct sem_s{
int valeur;
struct ctx_s *pt;
int max;
};

struct ctx_s{
  char* esp;
  char* ebp;
  char* base;
  int size;
  char* magic;
  func_t* f;
  void* args;
  enum ctx_state_e state;
  struct ctx_s* next;
  struct ctx_s* sem_next;
};


void create_ctx(int size,func_t f,void *args);
int init_ctx(struct ctx_s *ctx, int stack_size, func_t f, void *args);
void switch_to_ctx(struct ctx_s *ctx) ;
void yield();
void start_schedule();
