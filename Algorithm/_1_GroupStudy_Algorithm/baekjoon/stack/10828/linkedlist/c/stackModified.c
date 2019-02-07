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
void push(int data, Head* HEAD);
int pop(Head* HEAD);
int size(Head* HEAD);
int empty(Head* HEAD);
int top(Head* HEAD);

void initNode(Node* node)
{
	node->data = 0;
	node->next = NULL;
}

void initHead(Head* HEAD)
{
	HEAD->head = NULL;
	HEAD->size = 0;
}

void push(int data, Head* HEAD) {
	Node* temp;

	temp = (Node*) malloc(sizeof(Node));

	initNode(temp);

	temp->data = data;
	temp->next = HEAD->head;
	HEAD->head = temp;
	HEAD->size++;
}

int pop(Head* HEAD) {
	Node* temp;
	int ret = -1;

	temp = HEAD->head;

	if(!empty(HEAD)) {
		HEAD->head = temp->next;
		HEAD->size--;
		ret = temp->data;
		free(temp);
	}

	return ret;
}

int size(Head* HEAD) {
	int i = 0;

	return HEAD->size;
}

int empty(Head* HEAD) {
	if(HEAD->size == 0) {
		return STACK_EMPTY;
	}
	return STACK_NOTEMPTY;
}

int top(Head* HEAD) {
	if(!empty(HEAD))
		return HEAD->head->data;
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

	Head* HEAD = NULL;
	HEAD = (Head *) malloc(sizeof(Head));
	initHead(HEAD);

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
			push(num_parse, HEAD);
		} else if(!strcmp(cmd, cmdPop)) {
			ret = pop(HEAD);
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
