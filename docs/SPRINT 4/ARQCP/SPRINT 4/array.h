#ifndef ARRAY_H 
#define ARRAY_H
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>


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
	
	int fillArray(void);
#endif
