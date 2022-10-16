#include <stdio.h>
#include "position.h"


int main(void) {
	int array [4][2][3]=  {{{2,0,3},{0,2,2}},
		                   {{3,0,0},{0,0,0}},
		                   {{2,4,2},{2,2,2}},
	                       {{2,4,2},{2,2,2}}};
	                       

	int matriz [8][8][8];
	matriz[1][1][1]=2;
	matriz[1][2][1]=7;
	matriz[0][0][0]=0;
	matriz[1][0][1]=4;
	matriz[4][5][4]=0;
	printf("%i",checkSlots(8,8,8, matriz));

		
	
	if (verifyContainer(0,0,0, array)) {
		return 1;
		
	} else {
	return 0;
	}
	
}
