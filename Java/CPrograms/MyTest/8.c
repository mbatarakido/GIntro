#include <stdio.h>
/**
 * main - main function description
 * Return: Always 0 (Success)
 */
int main(void)
{
    int x;
    for (x = 0; x < 10; x++)
    {
        putchar(48 + x);
    }
    for (x = 'a'; x <= 'f'; x++)
    {
        int lower_x = x;
        putchar(lower_x);
    }
    putchar('\n');
    return (0);
}