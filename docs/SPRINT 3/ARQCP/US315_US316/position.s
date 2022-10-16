.section .data
.section .text
.global verifyContainer,checkSlots
verifyContainer:
	movswq	%di, %rdi
	salq	$8, %rdi
	addq	%rcx, %rdi
	movswq	%dx, %rdx
	movswq	%si, %rsi
	leaq	(%rdx,%rsi,8), %rax
	cmpl	$0, (%rdi,%rax,4)
	setne	%al
	movzbl	%al, %eax
	ret
checkSlots:
	pushq	%r15
	pushq	%r14
	pushq	%r13
	pushq	%r12
	pushq	%rbp
	pushq	%rbx
	subq	$8, %rsp
	movq	%rcx, %r15
	movw	%di, 6(%rsp)
	movw	%si, 4(%rsp)
	movl	%edx, %r13d
	movl	$0, %r14d
	movl	$0, %ebp
	jmp	place2
place10:
	addl	$1, %r12d
place5:
	cmpw	4(%rsp), %r12w
	jge	place9
	movl	$0, %ebx
place4:
	cmpw	%r13w, %bx
	jge	place10
	movswl	%bx, %edx
	movswl	%r12w, %esi
	movswl	%r14w, %edi
	movq	%r15, %rcx
	call	verifyContainer
	cmpl	$1, %eax
	sete	%dl
	movswl	%bp, %ecx
	addl	$1, %ecx
	cmpl	$1, %eax
	setne	%al
	movzbl	%dl, %edx
	imull	%ecx, %edx
	movzbl	%al, %eax
	imull	%eax, %ebp
	addl	%edx, %ebp
	addl	$1, %ebx
	jmp	place4
place9:
	addl	$1, %r14d
place2:
	cmpw	6(%rsp), %r14w
	jge	place11
	movl	$0, %r12d
	jmp	place5
place11:
	movl	%ebp, %eax
	addq	$8, %rsp
	popq	%rbx
	popq	%rbp
	popq	%r12
	popq	%r13
	popq	%r14
	popq	%r15
	ret