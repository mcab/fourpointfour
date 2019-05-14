CC = gcc
CFLAGS = -g -m32 -mpreferred-stack-boundary=2 -fno-stack-protector -z execstack -D_FORTIFY_SOURCE=0 -no-pie -z norelro

all: test

test: test.c
	$(CC) $(CFLAGS) $< -o $@
	$(CC) -g -m32 -mpreferred-stack-boundary=2 -z execstack -D_FORTIFY_SOURCE=0 -no-pie -z norelro -fstack-protector $< -o test-canary
	$(CC) -g -m32 -mpreferred-stack-boundary=2 -fno-stack-protector -D_FORTIFY_SOURCE=0 -no-pie -z norelro $< -o test-stackexec
	$(CC) -g -m32 $< -o test-aslr

clean:
	rm -f *.o test test-*
