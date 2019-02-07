SRC 	= 11966.c
OBJ 	= 11966.o
EXEC 	= 11966
CC 		= gcc
CFLAGS 	= -o

$(EXEC): $(OBJ)
	$(CC) $(CFLAGS) $@ $<

$(OBJ): $(SRC)
	$(CC) -c $<

clean:
	rm $(OBJ) $(EXEC)
