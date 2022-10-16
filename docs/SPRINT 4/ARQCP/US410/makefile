exec: main.o asm.o 
	gcc main.o asm.o -o exec
		
main.o: main.c
	gcc -g -Wall -c main.c -o main.o
	
asm.o: asm.s
		gcc -Wall -g -c asm.s -o asm.o
	
clean: 
	rm -f *.o exec
	
run: exec
	./exec
