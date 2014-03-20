



CC = gcc
CFLAGS = -Wall -pedantic -g

EXEC = try_mul try.o display_stack

all : $(EXEC)

try_mul : try_mul.o  try.o
	$(CC) -o try_mul try_mul.o try.o



display_stack: display_stack.o 
	$(CC) -o simple display_stack.o

display_stack.o : display_stack.c
	$(CC) -c display_stack.c


try.o : try.c
	$(CC) -c try.c

try_mul.o : try_mul.c
	$(CC) -c try_mul.c


.PHONY : clean mrproper

clean :
	rm -f *.o

mrproper :
	rm $(EXEC)
