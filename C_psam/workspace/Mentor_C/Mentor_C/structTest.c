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

	printf("�� ���� ������ �Է��� �ǰ���? : ");
	scanf_s("%d", &size);

	userFruits = (fruits*)calloc(size, sizeof(fruits)); // sizeof(�ڷ���)

	for (int i = 0; i < size; i++)
	{
		printf("���� �̸� : ");
		scanf_s("%s", userFruits[i].name, sizeof(userFruits[i].name));
		printf("���� ���� : ");
		scanf_s("%d", &userFruits[i].price);
		printf("���� ��ö : ");
		scanf_s("%s", userFruits[i].season, sizeof(userFruits[i].season));
	}

	// printf("\n%s", userFruits->name); // userFruits �迭�� ù ��° ��(��, �ּҰ�)�� name�� ���.

	//for (int i = 0; i < size; i++) {
	//	printf("%d��° ���ϸ� : ", i + 1);
	//	scanf_s("%s", fruits->name, sizeof(fruits->name));
	//	printf("%s ����", fruits->name);
	//	scanf_s("%d", &fruits[i].price);
	//	printf("%s ����", fruits->name);
	//	scanf_s("%s", fruits->season, sizeof(fruits->season));

	for (int i = 0; i < size; i++)
	{
		printf("%s, %d, %s \n", userFruits[i].name, userFruits[i].price, userFruits[i].season);
	}

	free(userFruits);
}