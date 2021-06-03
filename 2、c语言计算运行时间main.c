#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include <time.h>

int main()
{
    //程序运行时间计算
    time_t t_start, t_end;
    t_start = time(NULL) ;
    
    for (int temp=0; temp<900000000; temp++) {
        printf("hello：%d\n",temp);
    }        
    
    t_end = time(NULL) ;
    
    sleep(3);
    
    printf("time: %.0f s\n", difftime(t_end,t_start)) ;    
    
    return 0;
}
