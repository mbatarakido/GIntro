#include <stdio.h>
/**
 * main - main function description
 * Return: Always 0 (Success)
 */
int main(void)
{
    int x;
    for (x = 'a'; x <= 'z'; x++)
    {
        if ((x == 'e') || (x == 'q'))
        {
            continue;
        }
        else
        {
            int lower_x = x;
            putchar(lower_x);
        }
    }
    putchar('\n');
    return (0);
}