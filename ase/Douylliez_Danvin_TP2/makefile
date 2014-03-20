



CC = gcc
CFLAGS = -Wall -pedantic -g

EXEC = ctx_ping_pong init_ctx.o 
all : $(EXEC)

ctx_ping_pong : ctx_ping_pong.o  init_ctx.o
	$(CC) -o ctx_ping_pong ctx_ping_pong.o init_ctx.o


init_ctx.o : init_ctx.c
	$(CC) -c init_ctx.c

ctx_ping_pong.o : ctx_ping_pong.c
	$(CC) -c ctx_ping_pong.c


.PHONY : clean mrproper

clean :
	rm -f *.o

mrproper :
	rm $(EXEC)
