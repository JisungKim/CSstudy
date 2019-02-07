SRC 	= stack.c stackModified.c
OBJ 	= stack.o stackModified.o
CC 		= gcc
CFLAGS 	= -o

all: stack stackModified

stack: stack.o
	$(CC) $(CFLAGS) $@ $<

stackModified: stackModified.o
	$(CC) $(CFLAGS) $@ $<

$(OBJ): $(SRC)
	$(CC) -c $^

clean:
	rm $(OBJ) stack stackModified
