/*
 * 백준 10828
 *
 * JAVA의 경우 : Array List를 사용하면 좀 더 쉬움.
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define STACK_EMPTY 		1
#define STACK_NOTEMPTY		0
#define STACK_VALUE_EMPTY 	-1

typedef struct Node {
	int data;
	struct Node* next;
} Node;

typedef struct Head {
	int size;
	struct Node* head;
} Head;

void initNode(Node* node);
void push(int data, Node** HEAD);
int pop(Node** HEAD);
int size(Node* HEAD);
int empty(Node* HEAD);
int top(Node* HEAD);

void initNode(Node* node)
{
	node->data = 0;
	node->next = NULL;
}

void push(int data, Node** HEAD) {
	Node* temp;

	temp = (Node*) malloc(sizeof(Node));

	initNode(temp);

	temp->data = data;
	temp->next = *HEAD;
	*HEAD = temp;
}

int pop(Node** HEAD) {
	Node* temp;
	int ret = -1;

	temp = *HEAD;

	if(!empty(temp)) {
		*HEAD = temp->next;
		ret = temp->data;
		free(temp);
	}

	return ret;
}

int size(Node* HEAD) {
	int i = 0;

	if(!empty(HEAD)) {
		i = 1;
		while((HEAD=HEAD->next)!=NULL) { i++; }
	}

	return i;
}

int empty(Node* HEAD) {
	if(HEAD == NULL) {
		return STACK_EMPTY;
	}
	return STACK_NOTEMPTY;
}

int top(Node* HEAD) {
	if(!empty(HEAD))
		return HEAD->data;
	return STACK_VALUE_EMPTY;
}

void printAll(Node* HEAD) {
	while(HEAD != NULL)
	{
		printf("%d ", HEAD->data);
		HEAD = HEAD->next;
	}
	printf("\n");
}

int main()
{
	int i, j;
	int ret;

	char buf[12];
	char cmd[7];
	char num[7];
	int num_parse = 0;

	char cmdPush[] 	= "push";
	char cmdPop[] 	= "pop\n";
	char cmdSize[] 	= "size\n";
	char cmdEmpty[] = "empty\n";
	char cmdTop[] 	= "top\n";
	char delimiter[] = " ";
	char *token = NULL;

	Node* HEAD = NULL;

	i = 0;
	scanf("%d", &i);

	if(i > 10000) return 0;
	if(i < 1) return 0;

	for(j=0;j<=i;j++)
	{
		fgets(buf, 12, stdin);

		token = strtok(buf, delimiter);
		strncpy(cmd, token, 7);

		token = strtok(NULL, delimiter);
		if(token != NULL) {
			strncpy(num, token, 7);
			num_parse = atoi(num);
		}

		if(!strcmp(cmd, cmdPush)) {
			push(num_parse, &HEAD);
		} else if(!strcmp(cmd, cmdPop)) {
			ret = pop(&HEAD);
			printf("%d\n", ret);
		} else if(!strcmp(cmd, cmdSize)) {
			ret = size(HEAD);
			printf("%d\n", ret);
		} else if(!strcmp(cmd, cmdEmpty)) {
			ret = empty(HEAD);
			printf("%d\n", ret);
		} else if(!strcmp(cmd, cmdTop)) {
			ret = top(HEAD);
			printf("%d\n", ret);
		} else {
			// ERROR
		}
	}

	return 0;
}
