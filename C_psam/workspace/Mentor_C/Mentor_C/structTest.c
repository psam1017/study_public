#include<stdio.h>
#include<stdlib.h>

typedef struct fruits {
	char name[100];
	int price;
	char season[100];
} fruits;

void main() {
	fruits* userFruits = 0;
	int size = 0;

	printf("몇 개의 과일을 입력할 건가요? : ");
	scanf_s("%d", &size);

	userFruits = (fruits*)calloc(size, sizeof(fruits)); // sizeof(자료형)

	for (int i = 0; i < size; i++)
	{
		printf("과일 이름 : ");
		scanf_s("%s", userFruits[i].name, sizeof(userFruits[i].name));
		printf("과일 가격 : ");
		scanf_s("%d", &userFruits[i].price);
		printf("과일 제철 : ");
		scanf_s("%s", userFruits[i].season, sizeof(userFruits[i].season));
	}

	// printf("\n%s", userFruits->name); // userFruits 배열의 첫 번째 값(즉, 주소값)의 name을 출력.

	//for (int i = 0; i < size; i++) {
	//	printf("%d번째 과일명 : ", i + 1);
	//	scanf_s("%s", fruits->name, sizeof(fruits->name));
	//	printf("%s 가격", fruits->name);
	//	scanf_s("%d", &fruits[i].price);
	//	printf("%s 시즌", fruits->name);
	//	scanf_s("%s", fruits->season, sizeof(fruits->season));

	for (int i = 0; i < size; i++)
	{
		printf("%s, %d, %s \n", userFruits[i].name, userFruits[i].price, userFruits[i].season);
	}

	free(userFruits);
}