exec: main.o position.o 
	gcc main.o position.o -o exec
	
position.o: position.s 
	gcc -g -Wall -c position.s -o position-o
	
main.o: main.c position.h
	gcc -g -Wall -c main.c -o main.o
	
clean: 
	rm -f *.o exec
	
run: 
	./exec
