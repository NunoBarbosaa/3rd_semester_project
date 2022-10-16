prog_ex01: main.o getNumberOfSpotsAsm.o
	gcc main.o getNumberOfSpotsAsm.o -o prog_ex01
	
getNumberOfSpotsAsm.o: getNumberOfSpotsAsm.s
	gcc -g -Wall -c getNumberOfSpotsAsm.s -o getNumberOfSpotsAsm.o
	
main.o: main.c getNumberOfSPots.h
	gcc -g -Wall -c main.c -o main.o
	
clean:
	rm -f *.o prog_ex01
	
run: prog_ex01
	./prog_ex01

debug: prog_ex01
	gdb -tui ./prog_ex01
