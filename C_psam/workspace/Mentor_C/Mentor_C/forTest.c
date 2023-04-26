#include<stdio.h>

void main() {

	// 0 1 2 0 1 2 ...

	for (int i = 0; i < 30; i++) // 30번 반복하기로 함.
	{
		printf("%d\n", i % 3);
	}

	for (int i = 0; i < 128; i++)
	{
		printf("%d %c\n", i, i);
	}

	// A = 65
	// a = 97

	for (int i = 0; i < 26; i++)
	{
		if (i % 2 == 0)
			printf("%c", i + 97);
		else
			printf("%c", i + 65);
	}
}