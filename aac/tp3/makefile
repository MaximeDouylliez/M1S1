all:  satisfiable 




satisfiable: satisfiable.o
	gcc -o satisfiable satisfiable.o

satisfiable.o: satisfiable.c
	gcc -c satisfiable.c

userdefined:
	./satisfiable <simpleinput 0

randomcertif:
	./satisfiable <simpleinput 1

allcertif:
	./satisfiable <simpleinput 2

satreduction:
	./satisfiable <reductioninput 3

