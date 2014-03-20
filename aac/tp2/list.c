#include "list.h"
const list emptylist = NULL;

list cons(int v, list tail) {
  list l;
  l= malloc(sizeof(struct cell));
  l->val =v;
  l->next = tail;
  return l;
}

bool isEmpty(list l) {
  return(emptylist==l);
}

int head (list l){
  assert (l != emptylist) ;
  return l->val;
}

list tail(list l) {
  assert (l != emptylist);
  return l->next;
}


list get(list l,int* val){
  *val=head(l); 
  l= tail(l);
  return l;
}
  
list sub(list l){
  return l=tail(l);
}
  

void aff_all(list l){

if (!(isEmpty(l))){
  print_int(head(l));
    print_char(' ');
  aff_all(tail(l));}
}

