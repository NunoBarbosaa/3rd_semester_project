#include <stdio.h>
#include <stdlib.h> 
#include <string.h>
#include <math.h>

// Get_NLines para contar o numero total de linhas do ficheiro
int get_nlines(FILE *arq){
	int lines=0;
	FILE *arqAux = arq;
	int c = getc(arqAux);
	while (c != EOF) //para garantir que não passa do tamanho da lista.
	{
     c = getc(arqAux);
     if(c == '\n'){
		  lines++; 
	}
 }
	return lines;
}

//obter container id
int get_containerId(FILE *arq){
	int containerId=0;
	char line[1000];
	char *token;
	
	  while (fgets(line,sizeof(line), arq) != NULL) 
    {
	 //Procuramos o elemento desejado(container id) numa linha do ficheiro.
	   token = strtok(line,",");
	  int p = 0;
	  //verificamos se chegamos ao final dessa linha
	  while( token != NULL )
	  {
		 //Uma vez encontrado o container id guardamos na matriz
		if(p == 6 ){
			containerId = atoi(token);
			//printf( "Entre no if e p é igual a %d s\n\n",p);
		}
         //percorremos a linha
		token = strtok(NULL, ",");
		p++;
	  }
	  break;
  }
	return containerId;
}
	

			 
int main(void) {
	FILE *arq;
	// criamos um pointer para o ficheiro e verificamos se existe
	if((arq = fopen("CargoManifest.csv", "r")) == NULL)
	{
	   printf("Erro ao abrir o arquivo.\n");
	}
	//arq2 = arq;
	// criamos as variaveis necessarias
	int i=0,cont=0,k=0,dim1,dim2,dim3,n_lines = get_nlines(arq); //702
	// numero total de linhas do ficheiro
	printf("Numero de linhas %d\n", n_lines);
	//vemos quanto é preciso para que nossos dados entren na matriz 3d
	while(cont <= n_lines){
		i++;
		cont = i*i*i;
	}
	
	//declaração da matriz 3d
	int m[i][i][i];
	//iniciar toda a matriz 3d a zero
	for(dim1=0;dim1<i;dim1++){
		for(dim2=0;dim2<i;dim2++){
			for(dim3=0;dim3<i;dim3++){
				m[dim1][dim2][dim3]=0;
			}
		}
	}
	
	
    //voltamos a colocar o pointer do file no inicia do ficheiro
    rewind(arq);
    
    // guardamos o valor do container id na matriz (get_containerId)
    for(dim1=0;dim1<i;dim1++){
		for(dim2=0;dim2<i;dim2++){
			for(dim3=0;dim3<i;dim3++){
				if(k < n_lines){
					m[dim1][dim2][dim3]= get_containerId(arq);
					k++;
				}else{
					break;
				}
			}
		}
	}
	
	fclose(arq);
     
	
	//print para testar se esta a guardar os valores do container id.
	for(dim1=0;dim1<i;dim1++){
		for(dim2=0;dim2<i;dim2++){
			for(dim3=0;dim3<i;dim3++){
				printf("vec[%d][%d][%d]=%d &vec[%d][%d][%d]=%p\n",dim1, dim2,dim3,m[dim1][dim2][dim3],dim1,dim2,dim3,&m[dim1][dim2][dim3]);
			}
		}
	}

	return 0;
}


