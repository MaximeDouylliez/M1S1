
################################################################################
#################  grille lin + methode aleaT ##################################
# 
# rediriger les resultats des mesures pour le cas 0 dans le fichier cas0.txt
################################################################################
set term png;
set xrange [0:500000];
set yrange[0:200000000];
set output 'lin_aleaT.png';
plot 
'cas0.txt' using 1:2 title 'aleaL' with lines, \
'cas1.txt' using 1:2 title 'aleaT' with lines, \

