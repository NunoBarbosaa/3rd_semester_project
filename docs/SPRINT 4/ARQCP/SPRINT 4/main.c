#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "energy.h"
#include "energy.c"
#include "fillArray.c"
#include "array.h"
#include "asm.h"



int main(void){
	int option =0;
	do {
		printf("\nMENU\n");
		printf("\n1 - US409\n");
		printf("\n2 - US410\n");
		printf("\n3 - US411\n");
		printf("\n0 - SAIR \n");
	    printf("\nEscolha a opção pretendida\n");
	    scanf(" %d", &option );
	    
	    switch(option) {
			case 0:
				break;
			case 1: 
				fillArray();
				break;
			case 2:/*
				printf("posicao :");
				scanf("%d",&posicao);
				int resp = refrig();
				if(resp ==1){
					printf("O container é refrigerado");
				}else{
					printf("O container não é refrigerado");
				}
				break;
				*/
			case 3: 
				verifyPosition_ENG();
				break;
				default:
				printf("A tua escolha é inválida\n");
				break;
			}
		}
		while (option != 0);
	
		return 0;	
}
