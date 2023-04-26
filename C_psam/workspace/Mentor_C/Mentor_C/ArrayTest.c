#include<stdio.h>

void main() {

	// A~F 중 C를 제외하고 배열에 담은 후 출력.

	//char alpha = 'A';
	//printf("%d", alpha); // A의 아스키코드 값은 65.

	// char arAlpha[] = { ' ', };
	// C6385
	// arr[]처럼 배열의 길이를 미지정할 때는 선언할 때 자료를 모두 넣어주자.
	// 위처럼 써놓으면 배열의 길이는 1로 고정되어버린다.

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