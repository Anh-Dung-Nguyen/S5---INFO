.equ offsetA, 16
.equ offsetB, 12
.equ offsetRes, 8

.data
	a: .word 5
	b: .word 2
	
.bss
	res: .skip 4

.align

.text

.global _start

_start:
	@ Beginning of the program
	ldr r2, =a
	ldr r0, [r2]		@ r0 = a
	ldr r2, =b
	ldr r1, [r2]		@ r1 = b
	
	stmfd sp!, {r0, r1}	@ stocker a et b
	sub sp, sp, #4		@ réserve espace pour res
	bl pgcd
	
	ldmfd sp!, {r2}		@ récupération du résultat
	add sp, sp, #8		@ libérer la place allouée aux 2 paramètres d'entrée
	
	ldr r0, =res
	str r2, [r0]		@ r2 = res
	b end
	
pgcd:
	stmfd sp!, {lr}			@ sauve adresse retourne
	stmfd sp!, {fp}			@ sauve ancien fp
	mov fp, sp			@ placement de fp
		
	ldr r0, [fp, #offsetA]		@ r0 = a
	cmp r0, #0			@ a == 0
	moveq r2, #0		
	str r2, [fp, #offsetRes]	@ res = 0
	beq return
		
	ldr r1, [fp, #offsetB]		@ r1 = b
	cmp r1, #0			@ r1 == 0
	moveq r2, #0
	str r2, [fp, #offsetRes]	@ res = 0
	beq return
		
	ldr r0, [fp, #offsetA]		@ r0 = a
	ldr r1, [fp, #offsetB]		@ r1 = b
	cmp r0, r1			@ r0 == r1
	moveq r2, r0
	streq r2, [fp, #offsetRes]	@ res = a
	beq return
	
	ldr r0, [fp, #offsetA]		@ r0 = a
	ldr r1, [fp, #offsetB]		@ r1 = b	
	cmp r0, r1
	blt inf				@ si a < b
					@ si a > b
	
	ldr r0, [fp, #offsetA]		@ r0 = a
	ldr r1, [fp, #offsetB]		@ r1 = b
	sub r0, r0, r1			@ a = a - b
	stmfd sp!, {r0, r1}		@ stocke nouvelles a et b
	sub sp, sp, #4			@ réserve espace pour res
	bl pgcd
	ldmfd sp!, {r2}			@ récupération du résultat
	add sp, sp, #8			@ libérer la place allouée aux 2 paramètres d'entrée
	b return
	
	inf:	
		ldr r0, [fp, #offsetA]		@ r0 = a
		ldr r1, [fp, #offsetB]		@ r1 = b
		sub r1, r1, r0			@ b = b - a
		stmfd sp!, {r0, r1}		@ stocke nouvelles a et b
		sub sp, sp, #4			@ réserve espace pour res
		bl pgcd
		ldmfd sp!, {r2}			@ récupération du résultat
		add sp, sp, #8			@ libérer la place allouée aux 2 paramètres d'entrée
		
return:
	str r2, [fp, #offsetRes]
	ldmfd sp!, {fp}
	ldmfd sp!, {lr}
	bx lr
	
end:
.end

