.section .data
	.global ptrVec
	.global numberOfPositions
	
.section .text
.global getNumberOfSPots
	getNumberOfSPots:
		movq ptrVec(%rip),%rdx
		movl $0, %eax
		movl $0, %esi
		movl $0, %edi
		movl $0, %ecx
	getNumberOfPlaces:
		
		incl %ecx
		cmp %ecx, numberOfPositions(%rip)
		je end
		
		
		cmp $0, (%rdx)
		je incFreeSpots
		
		jmp incOccupiedSPots
		
		
	incFreeSpots:
	incl %eax
	
	addq $4,%rdx
	jmp	getNumberOfPlaces
	
	incOccupiedSPots:
	inc %rsi
	addq $4,%rdx
	
	jmp getNumberOfPlaces
	
	end:
	SALQ $32, %rax
	addq %rsi, %rax	
	ret
