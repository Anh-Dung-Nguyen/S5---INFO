.equ N, 3

.equ offsetM1, 16
.equ offsetM2, 12
.equ offsetRes, 8

.equ i, -16
.equ j, -12
.equ k, -8

.data
	m1: .word 1,2,3,4,5,6,7,8,9
	m2: .word 1,1,1,2,2,2,3,3,3

.bss
	res: .skip 4*N*N

.align

.text

.global _start

_start:
	@ Beginning of the program
	ldr r0, =m1
	ldr r1, =m2
	ldr r2, =res
	
	stmfd sp!, {r0, r1, r2}
	
	bl produit
	
	add sp, sp, #12
	
produit:
	stmfd sp!, {lr}
	stmfd sp!, {fp}
	mov fp, lr

