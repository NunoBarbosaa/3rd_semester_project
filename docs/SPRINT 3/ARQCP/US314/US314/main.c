#include <stdio.h>
#include "getNumberOfSPots.h"

int* ptrVec;
int numberOfPositions;

int main(void) {
	
	/*
	int vec [3][3][5]={{{2,0,2,0,2},{0,2,2,2,0},{2,2,0,2,2}},
					   {{3,0,0,2,2},{0,0,0,0,0},{0,0,0,0,0}},
					   {{2,4,2,2,0},{2,2,2,2,2},{2,0,2,2,2}}};
					   				   
	numberOfPositions=45+1;	
			   	
	ptrVec=vec;
	unsigned long occupied_free = getNumberOfSPots();
	
	printf("Long = %ld\n", occupied_free);
	int *ptrLong= &occupied_free;
	printf("Free = %d\n",*(ptrLong+1));
	printf("Occupied = %d\n",*(ptrLong));
	
	/*
	int vec [3][4][5]={{{2,0,2,0,2},{0,2,2,2,0},{2,2,0,2,2},{0,0,0,0,0}},
					   {{3,0,0,2,2},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}},
					   {{2,4,2,2,0},{2,2,2,2,2},{2,0,2,2,2},{0,0,0,0,0}}};
					   				   
	numberOfPositions=60+1;	
			   	
	ptrVec=vec;
	unsigned long occupied_free = getNumberOfSPots();
	
	printf("Long = %ld\n", occupied_free);
	int *ptrLong= &occupied_free;
	printf("Free = %d\n",*(ptrLong+1));
	printf("Occupied = %d\n",*(ptrLong));
	*/
	
	
	int vec2 [4][2][3]={{{2,0,3},{0,2,2}},
						{{3,0,0},{0,0,0}},
						{{2,4,2},{2,2,2}},
						{{2,4,2},{2,2,2}}};
	
	ptrVec=vec2;
	numberOfPositions=24+1;
	printf("3\0\0  Value:%d\n",vec2[3][0][0]);			
	unsigned long occupied_free2 = getNumberOfSPots();
	printf("Long = %ld\n", occupied_free2);
	int *ptrLong2= &occupied_free2;
	printf("Free = %d\n",*(ptrLong2+1));
	printf("Occupied = %d\n",*(ptrLong2));
	
	
	return 0;
}
