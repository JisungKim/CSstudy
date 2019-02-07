#include <stdio.h>

int main()
{
    int i;
	int dead=0;
    scanf("%d", &i);

    while(i > 0)
    {
		if(i == 1) break;
	    if(i%2==1) { dead=1; break; }
	    i /= 2;
	}

	if(dead==1)
		printf("0");
	else
	    printf("1");

	return 0;
}
