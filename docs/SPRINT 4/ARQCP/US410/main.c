#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "asm.h"
int fileTamanho=500;
int linhaMax=4000;

typedef struct { //aqui inicializamos a struct container e escolhemos os atributos que irão fazer dessa struct
	//a ordem dos atributos da struct têm em consideração que devemos utilizar o mínimo de espaço possível
	unsigned int containerId;
	short innerWallThickness;
	short centerWallCondutivity;
	short centerWallThickness;
	short outerWallCondutivity;
	short outerWallThickness;
	short xCoord;
	short yCoord;
	short zCoord;
	short lenght;
	short width;
	short height;
	short exposedArea;
	short refrigerated;	
	short innerWallCondutivity;
	char innerWallMaterial[20];
	char centerWallMaterial[20];
	char outerWallMaterial[20];
	char isoCode[4];
	
	} container;
	
	//variaveis globais
    container *arr; //este pointer aponta para o array de struct containers q vamos reservar
    int posicao = 0;

	
int main(void){
FILE *fp; //criar um pointer para o ficheiro q iremos abrir
char nomeFile[fileTamanho]; //criar um string com espaço suficiente para que o user decida o nome do ficheiro do cargo manifest a importar
char buffer[linhaMax]; //criar um char[] capaz de receber toda a informação contida em cada uma das linhas do cargo manifest
printf("Nome do ficheiro: "); 
scanf("%s",nomeFile);
fp =fopen(nomeFile,"r") ;//o pointer que criámos previamente, agora aponta para o ficheiro pretendido

	if (fp ==NULL){  //verificar que o ficheiro introduzido existe
		printf("File couldn't be opened\n");
		return 1;
	}
	
	
	//contagem do número de containers presentes no ficheiro para determinar o tamanho do array
	
	int counter=0;//inicialização do contador 
	while(fgets(buffer, sizeof(buffer), fp) != NULL){
        counter++;
    }
    //printf("%d",counter);
    
	fclose(fp); //fechamos o ficheiro
	
	fp =fopen(nomeFile,"r") ;//voltamos a abrir o ficheiro para retornar o pointer fp para o início do ficheiro
	//container *arr; //este pointer aponta para o array de struct containers q vamos reservar 
	arr = (container*) calloc(counter, sizeof (container)); //calloc é usado para reservar um array dinamicamente, neste caso um array de struct containers
	
	char *token; //este pointer irá apontar para cada espaço de uma linha do ficheiro que estará delimitado por espaços e que irá indicar um valor de um atributo da instância de struct container criada
	
	
		for(int a=0;a<counter;a++){
		fgets(buffer,linhaMax,fp);
		token=strtok(buffer,",");
		container contentor; //aqui inicializamos uma instância do tipo struct container para depois irmos buscar os seus atributos ao ficheiro
		for(int b=0;b<19;b++){
			token=strtok(NULL,",");
			//ao fazermos contentor.a=b tamos a atribuir o valor a no atributo b da instância contentor do tipo struct container
			//nas linhas a seguir damos cast do array token para short e usamos o atoi para passar o string contido no array para inteiro
			switch (b)
			{
			case 0	:
			contentor.containerId= atoi(token);
			//printf("\n%s", token);
			break;
				
			case 1	:
			strcpy(contentor.innerWallMaterial,token);
			break;
				
			case 2	:
			contentor.innerWallCondutivity=(short) atoi(token);
			break;	
				
			case 3	:
			contentor.innerWallThickness=(short) atoi(token);
			break;
			
			case 4	:
			strcpy(contentor.centerWallMaterial,token);
			break;
			
			case 5	:
			contentor.centerWallCondutivity=(short) atoi(token);
			break;
				
			case 6	:
			contentor.centerWallThickness=(short) atoi(token);
			break;
				
			case 7	:
			strcpy(contentor.outerWallMaterial,token);
			break;	
				
			case 8	:
			contentor.outerWallCondutivity=(short) atoi(token);
			break;
			
			case 9	:
			contentor.outerWallThickness=(short) atoi(token);
			break;
				
			case 10	:
			contentor.xCoord=(short) atoi(token);
			
			break;
			
			case 11	:
			contentor.yCoord=(short) atoi(token);
			break;
			
			case 12	:
			contentor.zCoord=(short) atoi(token);
			break;
			
			case 13	:
			strcpy(contentor.isoCode,token);
			break;
			
			case 14	:
			contentor.lenght=(short) atoi(token);
			break;
			
			case 15	:
			contentor.width=(short) atoi(token);
			break;
			
			case 16	:
			contentor.height=(short) atoi(token);
			break;
			
			case 17	:
			contentor.exposedArea=(short) atoi(token);
			break;
			
			case 18	:
			contentor.refrigerated=(short) atoi(token);
			 
			break;
			
				}
			}
			arr[a]=contentor; //aqui introduzimos a variável struct container contentor no array
		}
		
		//Codigo US 402 
	
	printf("posicao :");
	scanf("%d",&posicao);
	int resp = refrig();
	if(resp ==1){
		printf("O container é refrigerado");
	}else{
		printf("O container não é refrigerado");
	}
	
	return 0;
}
