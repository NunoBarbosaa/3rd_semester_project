sprintc: main.o
	gcc main.o -o sprintc

main.o: main.c
	gcc -g -Wall -c main.c -o main.o

clean:
	rm -f *.o sprintc

run: sprintc
	./sprintc
