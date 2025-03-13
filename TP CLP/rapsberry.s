.data
	led: .word 0x00000000010000000000000000000000

.global _start
.text
_start:
	@ Beginning of the program
	ldr r1, =0x3F200010
	ldr r2, =led
	ldr r3, [r2]
	str r3, [r1]
	
