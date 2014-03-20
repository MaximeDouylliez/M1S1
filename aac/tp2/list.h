#include"ioap123.h"
#include <assert.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>


typedef struct cell { 
  int val; 
  struct cell * next; //adresse de la suite
} * list;
/*
Une valeur de type list est un pointeur sur une cellule, un maillon, 
de type cell.
Un maillon contient deux champs: un élément, le champs val de type elt
un pointeur sur la suite, la queue, de la liste, le champs next.
 */

 const list emptylist;
/* Une valeur constante qui sera habituellement implantée par la valeur NULL*/


/* La fonction de construction de liste
IN: une valeur v et une liste l
OUT: une nouvelle liste dont la queue est la liste l 
     et le premier élément la valeur v.
ACTION: aucune, en particulier l n'est pas modifiée.
*/
 list cons(int val, list l);

/*teste si son argument est vide */
 bool isEmpty(list l);

/*
IN: une liste non vide
OUT: la valeur contenue dans le premier maillon de la liste,
     i.e. la tête de la liste.
HYPOTHÈSE: son argument n'est pas vide 
*/
 int head(list l);

/*
IN: une liste non vide
OUT: la queue de la liste,
     i.e. la liste qui suit le premier maillon
HYPOTHÈSE: son argument n'est pas vide 
*/
list tail(list l);
list get(list l,int* val);
void aff_all(list l);
list sub(list l);

