sprintc: createMatriz.o
	gcc createMatriz.o -o sprintc

createMatriz.o: createMatriz.c
	gcc -g -Wall -c createMatriz.c -o createMatriz.o

clean:
	rm -f *.o sprintc

run: sprintc
	./sprintc
