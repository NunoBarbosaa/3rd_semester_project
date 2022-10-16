exec: main.o 
	gcc main.o -o exec
		
main.o: main.c
	gcc -g -Wall -c main.c -o main.o


clean: 
	rm -f *.o exec
	
run: exec
	./exec
