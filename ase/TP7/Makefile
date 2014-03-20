# $Id: Makefile,v 1.1 2002/12/06 14:25:18 marquet Exp $
##############################################################################

ROOTDIR=/home/m1/douylliez/master/ase

CC	= gcc
CFLAGS	= -m32
LIBDIR  = -L$(ROOTDIR)
INCDIR  = -I$(ROOTDIR)
LIBS    =  -lhardware

###------------------------------
### Main targets 
###------------------------------------------------------------
BINARIES= test
OBJECTS	= $(addsuffix .o,\
	  mi_kernel)

all: $(BINARIES) $(OBJECTS)

###------------------------------
### Binaries
###------------------------------------------------------------
test: mi_kernel.o
	$(CC) $(CFLAGS) -o $@ $^ $(LIBDIR) $(LIBS)


###------------------------------
### #include dependences 
###------------------------------------------------------------
# you may fill these lines with "make depend"
mi_kernel.o: mi_kernel.c
#mmu_manager.o: mmu_manager.c



%.o: %.c
	$(CC) $(CFLAGS) -c $< $(INCDIR)

###------------------------------
### Misc.
###------------------------------------------------------------
.PHONY: clean realclean depend
clean:
	$(RM) *.o $(BINARIES)
realclean: clean 
	$(RM) vdiskA.bin vdiskB.bin
depend : 
	$(CC) -MM $(INCDIR) *.c

