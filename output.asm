.386
.model flat, stdcall
.stack 4096
include masm32\include\kernel.inc
includelib masm32\lib\kernel.lib

.data
	bVar2 db 0
	a dd 0
	c dd 0
	d dd 0
	brg2 db 0
	arg1 dd 0
	var1 dd 0

.code
func1 proc
	push ebp
	mov ebp, esp

	mov eax, dword ptr[ebp + 12]
	mov arg1, eax
	mov eax, dword ptr[ebp + 8]
	mov brg2, eax

	mov eax, 5
	push eax
	mov eax, 5
	push eax
	mov eax, arg1
	pop ebx
	add eax, ebx
	pop ebx
	mul eax, ebx
	mov var1, eax

	mov eax, brg2
	push eax
	mov eax, 1
	pop ebx
	and eax, ebx
	jnz loop0
	mov eax, 0
	jmp loop1
	loop0:
	mov eax, 1
	loop1:
	mov bVar2, eax


func1End:
	mov esp, ebp
	pop ebp
	ret 8
func1 endp


main proc
	push ebp
	mov ebp, esp

	mov eax, 1
	cmp eax, 1
	jne IfEnd2
	mov eax, 3
	mov a, eax

	jmp ifGlobalEnd3
ifEnd2:
	mov eax, 2
	push eax
	mov eax, 5
	pop ebx
	cmp eax, ebx
	jg loop7
	mov eax, 0
	jmp loop8
	loop7:
	mov eax, 1
	loop8:
	push eax
	mov eax, 1
	pop ebx
	and eax, ebx
	jnz loop5
	mov eax, 0
	jmp loop6
	loop5:
	mov eax, 1
	loop6:
	cmp eax, 1
	jne IfEnd4
	mov eax, 4
	mov d, eax

	jmp ifGlobalEnd3
ifEnd4:
	mov eax, 5
	mov c, eax

	mov esp, ebp
	pop ebp
	ret
main endp
