#define SYSCALL_SWTCH_0 16
#define SYSCALL_SWTCH_1 17


struct tlb_entry_s{
unsigned rfu:8;
unsigned vpage:12;
unsigned ppage:8;
unsigned access:3;
unsigned valid:1;
};

