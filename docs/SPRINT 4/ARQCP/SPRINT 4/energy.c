#include <stdio.h>                                                                                                          
#include <stdlib.h>                                                                                                         
#include <stdbool.h>                                                                                                        
#include <string.h>                                                                                                         
                                                                                                                            
#include "energy.h"                                                                                                         
                                                                                                                            
void parse_csv_ENG()                                                                                                        
{                                                                                                                           
    FILE *fp;                                                                                                               
    char row[MAXCHAR];                                                                                                      
                                                                                                                            
    fp = fopen(PATH_ENG, "r");                                                                                              
                                                                                                                            
    while (feof(fp) != true)                                                                                                
    {                                                                                                                       
        fgets(row, MAXCHAR, fp);                                                                                            
                                                                                                                            
        // split the array of chars by index - no commas                                                                    
        char *field = strtok(row, ",");                                                                                     
        float a, b, c;                                                                                                      
                                                                                                                            
        int counter = 0;                                                                                                    
        while (field != NULL)                                                                                               
        {                                                                                                                   
                                                                                                                            
            if (counter == 0)                                                                                               
            {                                                                                                               
                a = atoi(field);                                                                                            
            }                                                                                                               
            if (counter == 1)                                                                                               
            {                                                                                                               
                b = atoi(field);                                                                                            
            }                                                                                                               
            if (counter == 2)                                                                                               
            {                                                                                                               
                c = atoi(field);                                                                                            
            }                                                                                                               
            field = strtok(NULL, ",");                                                                                      
            counter++;                                                                                                      
        }                                                                                                                   
    }                                                                                                                       
                                                                                                                            
    fclose(fp);                                                                                                             
    printf("\nEnergy imported successfully.\n");                                                                            
}                                                                                                                           
                                                                                                                            
void verifyPosition_ENG(){                                                                                                  
    int a,b,c;                                                                                                              
    printf("Que posição do array pertende saber se existe energia suficiente (Linha, Coluna, Profundidade) --> ");          
    scanf("%d%d%d",&a,&b,&c);                                                                                               
    int flag = func_energy(a,b,c);                                                                                          
                                                                                                                            
    if (flag == 0){                                                                                                         
        printf("ALERTA --> Energia Suficiente");                                                                            
    }                                                                                                                       
    else if(flag == 1){                                                                                                     
        printf("ALERTA --> Energia Insuficiente");                                                                          
    }                                                                                                                       
  }                                                                                                                         
                                                                                                                            
int func_energy(float energia, float t1, float t2){                                                                         
                                                                                                                            
    double resistencia_total = 0.00313;                                                                                     
    float eng;                                                                                                              
    float flx_calor;                                                                                                        
                                                                                                                            
    calculo_fluxoCalor(t1, t2, resistencia_total, 3600, &eng, &flx_calor);                                                  
    if(eng<energia){                                                                                                        
        return 1;                                                                                                           
    }                                                                                                                       
    return 0;                                                                                                               
}                                                                                                                           
                                                                                                                            
void calculo_fluxoCalor(float temp1, float temp2, double resitencia_total, float tempo, float *energia, float *fluxoCalor){ 
//Q=delta_q/delta_t                                                                                                         
//E=Q*T                                                                                                                     
    temp1=temp1-temp2;   //delta_q                                                                                          
    *fluxoCalor = temp1/resitencia_total;                                                                                   
    *energia = (*fluxoCalor)*tempo;                                                                                         
}                                                                                                                           
                                                                                                                            
   

                                                                                                                                                                                                                                                    
                                                                                                                            
                                                                                                                            
                                                                                                                            
