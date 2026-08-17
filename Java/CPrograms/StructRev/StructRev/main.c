//
//  main.c
//  StructRev
//
//  Created by Benard Ochieng on 8/28/18.
//  Copyright © 2018 Benard Ochieng. All rights reserved.
//

#include <stdio.h>
#include <string.h>
#define MARRIED 1;
#define SINGLE 0;

typedef struct Books Books;
typedef struct Author Author;
struct Author
{
    int age;
    float height;
    char address[50];
    int status;
};

struct Books
{
    char name[20];
    char author[30];
    int id_no;
    Author r;
};
void printBook( Books b);
void display(char *n, char *a, int i);
void showBook(Books *book);
int main()
{
    Books b1,b2,b3 = {"Java", "Some genius", 9987534};
    strcpy(b1.name, "C Programming");
    strcpy(b1.author, "Donald Ritchie");
    b1.id_no = 1029384756;
    b1.r.age = 23;
    b1.r.height = 1.87;
    strcpy(b1.r.address, "NorthStreet");
    b1.r.status = MARRIED;
    b3.r.age = 34;
    b3.r.height = 1.84;
    strcpy(b3.r.address, "45 Wallstreet");
    b3.r.status = SINGLE;
    
    
    strcpy(b2.name, "C++");
    strcpy(b2.author, "John Sbd");
    b2.id_no = 834793;
    
    printBook(b1);
    display(b2.name, b2.author, b2.id_no);
    showBook(&b3);
    return 0;
}
void printBook( Books b)
{
    printf("Book name = %s\n",b.name);
    printf("Author = %s\n",b.author);
    printf("ID No. = %d\n",b.id_no);
    printf("Author's age = %d\n",b.r.age);
}
void display(char *n, char *a, int i)
{
    printf("\n%s\n%s\n%d\n",n,a,i);
}
void showBook(Books *book)
{
    printf("\nBook title = %s\n",book->name);
    printf("Author = %s\n",book->author);
    printf("Author's age = %d\n",book->r.age);
    printf("ID no. = %d\n",book->id_no);
    printf("Height = %f\n",book->r.height);
    printf("Address = %s\n",book->r.address);
    printf("Status = %d\n",book->r.status);

}
