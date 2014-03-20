CC = gcc
CFLAGS = -Wall -pedantic -g

EXEC = conso ctx 
all : $(EXEC)

conso : conso.o  init_ctx.o hw.o
	$(CC) -o conso conso.o init_ctx.o hw.o

ctx : ctx_ping_pong.o   init_ctx.o hw.o
	$(CC) -o ctx ctx_ping_pong.o init_ctx.o hw.o

hw.o : hw.c
	$(CC) -c hw.c

init_ctx.o : init_ctx.c
	$(CC) -c init_ctx.c

conso.o : conso.c
	$(CC) -c conso.c

ctx_ping_pong.o : ctx_ping_pong.c
	$(CC) -c ctx_ping_pong.c


.PHONY : clean mrproper

clean :
	rm -f *.o


mrproper :
	rm $(EXEC)
