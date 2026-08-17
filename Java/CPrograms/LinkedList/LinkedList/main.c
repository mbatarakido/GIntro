//
//  main.c
//  LinkedList
//
//  Created by Benard Ochieng on 7/26/18.
//  Copyright © 2018 Benard Ochieng. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct Element Element;
struct Element
{
    int num;
    Element *ptr;
};
typedef struct List List;
struct List
{
    Element *start; //first element
};

List *initialisation()
{
    List *list = malloc(sizeof(*list));
    Element *element = malloc(sizeof(*element));
    
    if( list == NULL || element == NULL)
    {
        exit(EXIT_FAILURE);
    }
    element->num = 0;
    element->ptr = NULL;
    list->start = element;
    
    return list;
}

//insertion an element
void insertion(List *list, int newNum)
{
    Element *new = malloc(sizeof(*new));
    if( list == NULL || new == NULL)
    {
        exit(EXIT_FAILURE);
    }
    new->num = newNum;
    new->ptr = list->start;
    list->start = new;
}

//deletion an element
void delete(List *list)
{
    if( list == NULL)
    {
        exit(EXIT_FAILURE);
    }
    if( list->start != NULL)
    {
        Element *toDelete = list->start;
        list->start = list->start->ptr;
        free(toDelete);
    }
}

//to show list content
void display(List *list)
{
    if( list == NULL)
    {
        exit(EXIT_FAILURE);
    }
    Element *content = list->start;
    
    while( content != NULL)
    {
        printf("%d ->",content->num);
        content = content->ptr;
    }
    printf("NULL\n");
    
}

int main()
{
    List *myList = initialisation();
    
    insertion(myList, 4);
    insertion(myList, 7);
    insertion(myList, 13);
    insertion(myList, 45);
    display(myList);
    delete(myList);
    display(myList);
    
    return 0;
}












