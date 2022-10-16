.section .data
	.global values
	.global posicao

.section .text
	.global refrig
	refrig:
		movq arr(%rip),%rdx #place vec in rdx
		movq posicao(%rip),%rax #place posicao in rcx
		movq $112,%rsi
		mulq %rsi #(rax * tamanho_struct) numero de bytes que temos que percorrer para chegar a posicao desejada
		addq %rax,%rdx  #offset para o elemento do array desejado
		movq (%rdx),%rax #copiamos o valor para o rax
		#movq (%rdx,%rcx,112),%rax #copiamos o valor de edx para eax.
		ret
