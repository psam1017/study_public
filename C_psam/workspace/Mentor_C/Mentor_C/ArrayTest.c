#include<stdio.h>

void main() {

	// A~F �� C�� �����ϰ� �迭�� ���� �� ���.

	//char alpha = 'A';
	//printf("%d", alpha); // A�� �ƽ�Ű�ڵ� ���� 65.

	// char arAlpha[] = { ' ', };
	// C6385
	// arr[]ó�� �迭�� ���̸� �������� ���� ������ �� �ڷḦ ��� �־�����.
	// ��ó�� ������� �迭�� ���̴� 1�� �����Ǿ������.

	char arAlpha[5] = { ' ', };

	for (int i = 0; i < 5; i++)
	{
		// arAlpha[i] = i + 65 >= 67 ? i + 65 + 1 : i + 65;
		if (i + 65 >= 67) {
			arAlpha[i] = i + 65 + 1;
		}
		else {
			arAlpha[i] = i + 65;
		}

		printf("%c ", arAlpha[i]);
	}
}