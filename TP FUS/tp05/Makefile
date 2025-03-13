CC = gcc
CFLAGS = -Wall -Wextra -g

SOURCES = principal.c fichier1.c fichier2.c
OBJETS = $(SOURCES:.c=.o)

principal: $(OBJETS)
	$(CC) $(CFLAGS) -o $@ $^

principalR: CFLAGS := -Wall -Wextra -O3
principalR: $(OBJETS)
	$(CC) $(CFLAGS) -c $< -o $@

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

%.d: %.c
	$(CC) -MM $< > $@

-include $(SOURCES:.c=.d)

clean:
	rm -f $(OBJETS) principal principalR

clean_all: clean
	rm -f $(SOURCES:.c=.d) *~

