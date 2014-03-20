#include <stdio.h>

static int tab[150][150][150][150];
static int* tab2;
static int cpt;

struct conf{
  int i;
  int j;
  int m;
  int n;};

/* Nom de fonction: o1 -> des fonction utilisé avec tout type de configuration
		    o2 -> des fonction utilisé avec des configurations semi otpimisées, c'est a dire toujours plus/aussi large que haute
		    o3-> des fonctions utilisé avec des configuration completement otpimisé,c'est a dire toujours plus/aussi large que haute, avec le chocolat de la mort toujours 				 positioné le plus en haut a gauche possible ( utilisation des symétries)


/*Inverse la plaque de choco si elle plus haute que large.
  le choix du type de rotation est arbitraire, 
  l'objectif est juste de transformer toute les plaques en plaque plus large que haute.*/
struct conf simpli_conf(int i,int j, int m, int n){

  int ii=i,jj=j,mm=m,nn=n;
  struct conf cf;

  if(i<j){
    ii=j;
    jj=i;
    mm=n;
    nn=m;}
  //printf("état simplifié de\ni:%d j:%d m:%d n:%d\ni:%d j:%d m:%d n:%d\n\n",i,j,m,n,ii,jj,mm,nn);
  cf.i=ii;
  cf.j=jj;
  cf.m=mm;
  cf.n=nn;
  return cf;
}


/* en plus de rendre la plaque plus large que haute, cette fonction va déplacer le choco de la mort
   pour qu'il soit positionné le plus en haut a gauche possible tout en conservant la meme issue au jeu.
   On pose la plaque sur une table, et l'on imagine la face visible,(a) et la face cache(b).
   En passant de la face a à la face b en effectuant un retournant de la plaquette( tourner la page d'un livre), on change la position du choco de la mort sans changer l'issue du jeu. En jouant avec les differents retournements, on peut optimiser une configuration
   en une configuration plus large que haute, avec le choco de la mort le plus en haut a gauche possible.

   ainsi; 3100 a la meme issue que 3101 3110 3111  1300 1301 1310 1311*/


struct conf opti_conf(int i,int j, int m, int n){
  struct conf cf;
  int ii=i,jj=j,mm=m,nn=n;
  if(i<j){
    ii=j;
    jj=i;
    mm=n;
    nn=m;}
  if(mm+1>(ii/2+(ii%2)))
    mm=(ii-(mm+1));
  if(nn+1>(jj/2+(jj%2)))
    nn=(jj-(nn+1));
  //printf("état simplifié de\ni:%d j:%d m:%d n:%d\ni:%d j:%d m:%d n:%d\n\n",i,j,m,n,ii,jj,mm,nn);
  cf.i=ii;
  cf.j=jj;
  cf.m=mm;
  cf.n=nn;
  return cf;
}
/* renvoi la valeur de la configuration d'entree en utilisant des configuration completement optimise (1 conf stocké = 8 conf reelle)*/

int o3_choco_1d(int i,int j,int m, int n){

  struct conf cf;
  int io,jo,mo,no;
  cf =opti_conf(i,j,m,n);
  i=cf.i;
  j=cf.j;
  m=cf.m;
  n=cf.n;

  if(i==1 && j==1){
    tab2[0]=0;
    return 0;}
  int tl,th,bcl,bch,res,fres,commu; // commu permet de traiter le cas où aucun résultat n'est enregistré.
  commu=0;
  if((res=tab2[o3_cti(i,j,m,n)]) != -1){

    return res;}

  for(th=(j),bch=(n);th>1 && bch>0;th--,bch--){ // on coupe par en haut
    cf =opti_conf(i,th,m,bch);
    io=cf.i;
    jo=cf.j;
    mo=cf.m;
    no=cf.n;
    if((res=tab2[o3_cti(io,jo,mo,no)]) == -1)
      res=o3_choco_1d(io,jo-1,mo,no-1);
    if(res==0){
      tab2[o3_cti(i,j,m,n)] = 1;
      return 1;}
    if(commu==0){
      fres=res;
      commu=1;}
    if(fres%2==0){// si les resultats jusque maintenant sont perdant
      if(res%2==1)// si res est gagnant
	fres=res;
      else if(fres<res)//si rez et perdant et plus grand que frez
	fres=res;
    }
    else if( res%2==1 && res<fres)//modif res%2==0
      fres=res;
  }
  for(tl=i,bcl=m;tl>1 && bcl>0;tl--,bcl--){ // on coupe par la gauche
    cf =opti_conf(tl,j,bcl,n);
    io=cf.i;
    jo=cf.j;
    mo=cf.m;
    no=cf.n;
    if((res=tab2[o3_cti(io,jo,mo,no)]) == -1)
      res=o3_choco_1d(io-1,jo,mo-1,no);
    if(res==0){
      tab2[o3_cti(i,j,m,n)] = 1;
      return 1;}
    if(commu==0){
      fres=res;
      commu=1;}
    if(fres%2==0){// si les resultats jusque maintenant sont perdant
      if(res%2==1)// si res est gagnant
	fres=res;
      else if(fres<res)//si rez et perdant et plus grand que frez
	fres=res;
    }
    else if( res%2==1 && res<fres)//modif res%2==0
      fres=res;
  }
  for(th=j;th>n+1;th--){// on coupe par en bas
    cf =opti_conf(i,th,m,n);
    io=cf.i;
    jo=cf.j;
    mo=cf.m;
    no=cf.n;
    if((res=tab2[o3_cti(io,jo,mo,no)]) == -1)
      res=o3_choco_1d(io,jo-1,mo,no);
    if(res==0){
      tab2[o3_cti(i,j,m,n)] = 1;
      return 1;}
    if(commu==0){
      fres=res;
      commu=1;}
    if(fres%2==0){
      if(res%2==1)
	fres=res;
      else if(fres<res)
	fres=res;
    }
    else if( res%2==0 && res<fres)
      fres=res;
  }
  for(tl=i;tl>m+1;tl--){// on coupe par la droite
    cf =opti_conf(tl,j,m,n);
    io=cf.i;
    jo=cf.j;
    mo=cf.m;
    no=cf.n;
    if((res=tab2[o3_cti(io,jo,mo,no)]) == -1)
      res=o3_choco_1d(io-1,jo,mo,no);
    if(res==0){
      tab2[o3_cti(i,j,m,n)] = 1;
      return 1;}
    if(commu==0){
      fres=res;
      commu=1;}
    if(fres%2==0){// si les resultats jusque maintenant sont perdant
      if(res%2==1)// si res est gagnant
	fres=res;
      else if(fres<res)//si rez et perdant et plus grand que frez
	fres=res;
    }
    else if( res%2==1 && res<fres)//modif res%2==0
      fres=res;
  }

  if(tab2[o3_cti(i,j,m,n)] == -1)
    tab2[o3_cti(i,j,m,n)] =fres+1;
  return fres+1;
}




/* renvoi la valeur de la configuration d'entree en utilisant des configuration completement optimise(o3) stocké dans un tableau a 4 dimensions(1 conf stocké = 8 conf reelle)*/
int o3_choco_4d(int i,int j,int m, int n){

  struct conf cf;
  int io,jo,mo,no;
  cf =opti_conf(i,j,m,n);
  i=cf.i;
  j=cf.j;
  m=cf.m;
  n=cf.n;


  if(i==1 && j==1){// c'est le cas perdant
    return 0;}


  int tl,th,bcl,bch,res,fres,commu; // commu permet de traiter le cas où aucun résultat n'est enregistré.
  commu=0;
  if((res=tab[i][j][m][n]) != 0){
    return res;}




  for(th=(j),bch=(n);th>1 && bch>0;th--,bch--){ // on coupe par en haut
    cf =opti_conf(i,th,m,bch);
    io=cf.i;
    jo=cf.j;
    mo=cf.m;
    no=cf.n;
//if((res=tab[i][th][m][bch]) == 0)
//res=o3_choco_4d(i,th-1,m,bch-1);
   if((res=tab[io][jo][mo][no]) == 0)
      res=o3_choco_4d(io,jo-1,mo,no-1);




    if(res==0){
      tab[i][j][m][n] = 1;
      return 1;}
    if(commu==0){
      fres=res;
      commu=1;}
    if(fres%2==0){// si les resultats jusque maintenant sont perdant
      if(res%2==1)// si res est gagnant
	fres=res;
      else if(fres<res)//si rez et perdant et plus grand que frez
	fres=res;
    }
    else if( res%2==1 && res<fres)//modif res%2==0
      fres=res;
  }


  for(tl=i,bcl=m;tl>1 && bcl>0;tl--,bcl--){ // on coupe par la gauche
    cf =opti_conf(tl,j,bcl,n);
    io=cf.i;
    jo=cf.j;
    mo=cf.m;
    no=cf.n;
//if((res=tab[tl][j][bcl][n]) == 0)
//res=o3_choco_4d(tl-1,j,bcl-1,n);
    if((res=tab[io][jo][mo][no]) == 0)
      res=o3_choco_4d(io-1,jo,mo-1,no);
    if(res==0){
      tab[i][j][m][n] = 1;
      return 1;}
    if(commu==0){
      fres=res;
      commu=1;}
    if(fres%2==0){// si les resultats jusque maintenant sont perdant
      if(res%2==1)// si res est gagnant
	fres=res;
      else if(fres<res)//si rez et perdant et plus grand que frez
	fres=res;
    }
    else if( res%2==1 && res<fres)//modif res%2==0
      fres=res;
  }
  for(th=j;th>n+1;th--){// on coupe par en bas
    cf =opti_conf(i,th,m,n);
    io=cf.i;
    jo=cf.j;
    mo=cf.m;
    no=cf.n;
 // if((res=tab[i][th][m][n]) == 0)
//res=o3_choco_4d(i,th-1,m,n);
    if((res=tab[io][jo][mo][no]) == 0)
      res=o3_choco_4d(io,jo-1,mo,no);
    if(res==0){
      tab[i][j][m][n] = 1;
      return 1;}

    if(commu==0){
      fres=res;
      commu=1;}
    if(fres%2==0){
      if(res%2==1)
	fres=res;
      else if(fres<res)
	fres=res;
    }
    else if( res%2==0 && res<fres)
      fres=res;
  }
  for(tl=i;tl>m+1;tl--){// on coupe par la droite
    cf =opti_conf(tl,j,m,n);
    io=cf.i;
    jo=cf.j;
    mo=cf.m;
    no=cf.n;
//if((res=tab[tl][j][m][n]) == 0)
//res=o3_choco_4d(tl-1,j,m,n);
   if((res=tab[io][jo][mo][no]) == 0)
      res=o3_choco_4d(io-1,jo,mo,no);
    if(res==0){
      tab[i][j][m][n] = 1;
      return 1;}
    if(commu==0){
      fres=res;
      commu=1;}
    if(fres%2==0){// si les resultats jusque maintenant sont perdant
      if(res%2==1)// si res est gagnant
	fres=res;
      else if(fres<res)//si rez et perdant et plus grand que frez
	fres=res;
    }
    else if( res%2==1 && res<fres)//modif res%2==0
      fres=res;
  }

  if(tab[i][j][m][n] == 0)
    tab[i][j][m][n] =fres+1;
  return fres+1;
}


/* renvoi la valeur de la configuration d'entree en utilisant des configuration pas optimisé(o1)*/
int o1_choco(int i,int j,int m, int n){

 
  if(i==1 && j==1){
  
    return 0;}
  int tl,th,bcl,bch,res,fres,commu; // commu permet de traiter le cas où aucun résultat n'est enregistré.
  commu=0;

  // printf("for1:  %d:   %d   %d   %d  \n",i,j,m,n);
  for(th=(j),bch=(n);th>1 && bch>0;th--,bch--){ // on coupe par en haut
   
  
      res=o1_choco(i,th-1,m,bch-1);

    if(res==0){
      return 1;}

    if(commu==0){
      fres=res;
      commu=1;}

    if(fres%2==0){// si les resultats jusque maintenant sont perdant
      if(res%2==1)// si res est gagnant
	fres=res;
      else if(fres<res)//si rez et perdant et plus grand que frez
	fres=res;
    }
    else if( res%2==1 && res<fres)//modif res%2==0
      fres=res;
  }


  for(tl=i,bcl=m;tl>1 && bcl>0;tl--,bcl--){ // on coupe par la gauche
      res=o1_choco(tl-1,j,bcl-1,n);

    if(res==0){
      return 1;}

    if(commu==0){
      fres=res;
      commu=1;}

    if(fres%2==0){// si les resultats jusque maintenant sont perdant
      if(res%2==1)// si res est gagnant
	fres=res;
      else if(fres<res)//si rez et perdant et plus grand que frez
	fres=res;
    }
    else if( res%2==1 && res<fres)//modif res%2==0
      fres=res;
  }
  for(th=j;th>n+1;th--){// on coupe par en bas
      res=o1_choco(i,th-1,m,n);

    if(res==0){
      return 1;}

    if(commu==0){
      fres=res;
      commu=1;}
    if(fres%2==0){
      if(res%2==1)
	fres=res;
      else if(fres<res)
	fres=res;
    }
    else if( res%2==0 && res<fres)
      fres=res;
  }
  for(tl=i;tl>m+1;tl--){// on coupe par la droite
   
      res=o1_choco(tl-1,j,m,n);

    if(res==0){
      return 1;}

    if(commu==0){
      fres=res;
      commu=1;}

    if(fres%2==0){// si les resultats jusque maintenant sont perdant
      if(res%2==1)// si res est gagnant
	fres=res;
      else if(fres<res)//si rez et perdant et plus grand que frez
	fres=res;
    }
    else if( res%2==1 && res<fres)//modif res%2==0
      fres=res;
  }
 

  return fres+1;
}







/* l'objectif et de stocker 4 valeurs entieres en un seul entier.
   Cette fonction ne s'utilise que si la plaquette est plus large que haute(o2).*/
struct conf o2_itc ( int val){
  struct conf cf;
  int bak=val;
  int i,j,m,n; // on commence par la conf la plus simple
  i=1;
  j=1;
  m=0;
  n=0;
  while(val>0){// tant que l'on est pas arrivé à la configuration voulue
    if(j==i && m==i-1 && n==j-1){ // si l'on a parcouru tout les cas pour une valeur de i donné: 2211 par exemple
      val--;
      i++;
      j=1;
      n=0;
      m=0;
    }
    else if(m==i-1 && n==j-1 ){ // si l'on a parcouru tout les cas pour une valeur de i,j donné: 3221 par exemple
      val--;
      j++;
      m=0;
      n=0;
    }
    else if( n==j-1 ){//si l'on a parcouru tout les cas pour une valeur de i,j,m donné 4403 par exemple
      val--;
      n=0;
      m++;
    }
    else{ // pour tout les autres cas
      n++;
      val--;
    }
  }
 
  simpli_conf(i,j,m,n);
  cf.i=i;
  cf.j=j;
  cf.m=m;
  cf.n=n;
  return cf;
}

/*l'opération inverse de o2_itc*/

int o2_cti ( int i,int j,int m,int n){
  struct conf cf=simpli_conf(i,j,m,n);
  j=cf.j;
  i=cf.i;
  m=cf.m;
  n=cf.n;
  int val=0;

  while(!(j==1 && m==0 && n==0 && i==1)){
    if(j==1 && m==0 && n==0){
      val++;
      i--;
      j=i;
      n=j-1;
      m=i-1;
    }
    else if(m==0 && n==0 ){
      val++;
      j--;
      m=i-1;
      n=j-1;
    }
    else if( n==0){
      val++;
      n=j-1;
      m--;
    }
    else{
      n--;
      val++;
    }
  }
  return val;
}

/*Fonction qui stocke 4 valeur entiere dans un seul entier, pour des configuration non optimisées(o1). Elle ne
  sera pas utilisé mais elle est correcte. Elle est là pour justifier la présence des fonctions d'optimisation simple, facilitant
  grandement la manipulation des données avant l'optimisation complète.*/
struct conf o1_itc ( int val){
  struct conf cf;
  int bak=val;
  int tick=1;// tick permet de gerer l'altenance j>i -> i>j
  /* tock permet d'empecher les doublons j==i qui s'il ne sont pas traité, apparaissent deux fois. quand i s'incremete jusqua j, et quand j s'incremente jusqua i, les cas i==j sont traité*/
  int tock=0;
  int i,j,m,n,max; // max représente la valeur max atteinte par i ou j dans l'éxecution de la fonction
  i=1;
  j=1;
  m=0;
  n=0;
  max=2;
  /* Ignorons m et n qui sont traité de la meme maniere dans toute les fonctions de conversion.
     cette fonction gere lévolution de i et j ainsi:
     j s'incrémente jusqua i, j reste et i est reinitialisé , puis s'incrémente jusqu'a j et enfin le cas ou i==j est considéré,
     puis l'on reinitialise j et l'on incrémente i de 1*/
  while(val>0){
    if(j==i && ((m==i-1 && n==j-1)|| tock) && val>0){
      val--;
      if(tick){
	i=max;
	j=1;
	tick=0;
	if(tock)
	  val++;
	tock=1-tock;
      }
      else{
	j=max;
	i=1;
	tick=1;
	max++;
	tock=1-tock;
      }
      n=0;
      m=0;
    }
    else if(m==i-1 && n==j-1 && val>0){
      val--;
      if(!tick)
	j++;
      else
	i++;
      m=0;
      n=0;
      if(i==j && tock)
        val++;
    }
    else if( n==j-1 && val>0){
      val--;
      n=0;
      m++;
    }
    else{
      n++;
      val--;
    }
  }
  printf("état final pour %d: i:%d j:%d m:%d n:%d\n",bak,i,j,m,n);
  cf.i=i;
  cf.j=j;
  cf.m=m;
  cf.n=n;
  return cf;
}

/* donne une configuration en fonction de l'entier  dans une situation
   ou le vecteur ne contient que des configuration completement optimisé(o3),
   c'est a dire toute les configuration stocké font reference a des tablette plus large que haute
   et le carré de la mort est le plus en haut a gauche possible*/
struct conf o3_itc ( int val){
  struct conf cf;
  cpt++;
  int bak=val;
  int i,j,m,n;
  i=1;
  j=1;
  m=0;
  n=0;
  while(val>0){
    if(j==i && m==((i/2)-1+i%2) && n==((j/2)-1+j%2) ){
      val--;
      i++;
      j=1;
      n=0;
      m=0;
    }
    else if(m==((i/2)-1+i%2) && n==((j/2)-1+j%2) ){
      val--;
      j++;
      m=0;
      n=0;
    }
    else if( n==((j/2)-1+j%2) ){
      val--;
      n=0;
      m++;
    }
    else{
      n++;
      val--;
    }
  }
  printf("état final pour %d: i:%d j:%d m:%d n:%d\n",bak,i,j,m,n);
  cf.i=i;
  cf.j=j;
  cf.m=m;
  cf.n=n;
  return cf;
}

//Prend n'importe quelle configuration et la stocke dans un entier. la configuration est d'abord optimisé(o3).
int o3_cti ( int i,int j,int m,int n){
  cpt++;
  struct conf cf=opti_conf(i,j,m,n);
  j=cf.j;
  i=cf.i;
  m=cf.m;
  n=cf.n;
  int val=0;

  while(!(j==1 && m==0 && n==0 && i==1)){
    if(j==1 && m==0 && n==0){
      val++;
      i--;
      j=i;
      n=((j/2)-1+j%2);
      m=((i/2)-1+i%2);
    }
    else if(m==0 && n==0 ){
      val++;
      j--;
      m=((i/2)-1+i%2);
      n=((j/2)-1+j%2);
    }
    else if( n==0){
      val++;
      n=((j/2)-1+j%2);
      m--;
    }
    else{
      n--;
      val++;
    }
  }
  return val;
}

void init_tab(int val){
  int i;

  for (i = 0; i <= val ; i++)
    tab2[i] = -1;
}

void init_tab_4d(int val){
  int i,j,m,n;

  for (i = 0; i <= val ; i++){
    for (j = 0; j <= val ; j++){
      for (m = 0; m <= val ; m++){
	for (n = 0; n <= val ; n++){
	  tab[i][j][m][n] = -1;
	}}}}}



int main(int argc,char**argv){


  struct conf cf;
  int i,j;
  int valeur,v,v2;





  cf = opti_conf(atoi(argv[1]),atoi(argv[2]),atoi(argv[3]),atoi(argv[4]));
 v2 = o3_choco_4d(atoi(argv[1]),atoi(argv[2]),atoi(argv[3]),atoi(argv[4]));
   v = o1_choco(atoi(argv[1]),atoi(argv[2]),atoi(argv[3]),atoi(argv[4]));
  printf("opti_opti valeur: %d  v2:%d\n",v,v2);




  
  return 0;
}
