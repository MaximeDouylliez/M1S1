#include "try.h"



static int mul(int depth)
{
  int i;

  switch (scanf("%d", &i)) {
  case EOF :
    return 1; /* neutral element */
  case 0 :
    return 1;
  case 1 :
    if (i) {
      printf("val :%d\n",i);
      return i * mul(depth+1);
    }
    else{
      printf("val :%d\n",i);	  
      throw(&pctx,0);

    }
  }

}



int main()
{

  int rep =0;
  rep= try(&pctx,&mul,0);

  printf("Valeur mul lue dans le main:%d\n",rep);

  return 0;
}
