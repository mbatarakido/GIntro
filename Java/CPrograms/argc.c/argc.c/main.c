//
//  main.c
//  argc.c
//
//  Created by Benard Ochieng on 11/3/18.
//  Copyright © 2018 Benard Ochieng. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[])
{
    int i, sum;
    printf("argc =%d\n",argc);
    printf("Lets see what's in argv[]\n");
    
    if( argc >1 )
    {
        for(i=1; i<argc; i++)
        {
            printf("argv[%d] = %s\n", i, argv[i]);
            sum += atoi(argv[i]);
        }
        printf("Total = %d\n",sum);
    }
    
    return 0;
}
