#include "syscall.h"
#include "hw_ini.h"
#include <stdio.h>
#include <stdlib.h>
#include "hardware.h"



struct tlb_entry_e tlbe;

static int ppage_of_vaddr(int process ,unsigned vaddr){
unsigned ppage;
if(vaddr<virtual_memory || virtual_memory +VM_SIZE-1<vaddr)
return -1;
vpage=(vaddr>>12)&0xFFF;
if(vadr<1 || vaddr>(n/2)-1)
return -1;
if(processus==1) ppage=vpage+n/2+1
if(processus==0) ppage=vpage+1
return ppage;}

static void mmu_handler(){
struct tlb_entry_s tlb;
vaddr==in(MMU_FAULT_ADDR);
ppage=ppage_of_vaddr(current_context,vaddr);
if(ppage==-1){printf("C'est pas bon!");exit(0);}
tlb.vpage=(vaddr>>12)&0xFFF;
tlb.ppage=ppage;
tlb.acces=7;
tlb.valid=1;
_out(TLB_ADD_ENTRY,tlbe);
}
static int current_process;

static int 
sum(void *ptr) 
{
    int i;
    int sum = 0;
    
    for(i = 0; i < PAGE_SIZE * N/2 ; i++)
        sum += ((char*)ptr)[i];
    return sum;
}

static void 
switch_to_process0(void) 
{
    current_process = 0;
    _out(MMU_CMD, MMU_RESET);
}

static void
switch_to_process1(void) 
{
    current_process = 1;
    _out(MMU_CMD, MMU_RESET);
}


int main(int argc, char **argv) 
{
    void *ptr;
    int res;

      if(init_hardware("hardware.ini") == 0) {
      fprintf(stderr, "Error in hardware initialization\n");
      exit(EXIT_FAILURE);
    }
    IRQVECTOR[16] = switch_to_process0;
    IRQVECTOR[17] = switch_to_process1;
    _mask(0x1001);

    ptr = virtual_memory;

    _int(16);
    memset(ptr, 1, PAGE_SIZE * N/2);
    _int(17);
    memset(ptr, 3, PAGE_SIZE * N/2);

    _int(16);
    res = sum(ptr);
    printf("Resultat du processus 0 : %d\n",res);
    _int(17);
    res = sum(ptr);
    printf("Resultat processus 1 : %d\n",res);
}

