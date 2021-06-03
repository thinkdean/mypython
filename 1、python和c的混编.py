
'''
追求运行速度：c写耗时较长的循环内容

本文就来讲解python,c的混合编程。其中循环部分用c编写，其他部分用Python编写，并将c编译成一个动态链接库，作为Python调用的接口。
# test.c文件

# include<stdio.h>
# include<stdlib.h>
void
say()
{
for (int temp=0;temp < 10000;temp++)
printf("hello\n");

}
'''

import ctypes
import time

a = time.time()

ll = ctypes.cdll.LoadLibrary
lib = ll("/Users/qinsuo/Documents/C-demo/demo/demo/text.so")   #这里面的test.so是用test.c编译成的动态链接库
lib.say()   #调用test.c里面定义的函数

b = time.time()
print("用时:")
print(b-a)

# 面代码实质就是先将test.c文件编译成一个test.so动态链接库，然后在python代码里面调用这个动态链接库，这就实现了python,c的混合调用。

'''
上面程序执行的步骤分别是：
第一步：用命令 gcc -o test.so -shared -fPIC test.c
这一步就是将test.c编译成一个test.so动态链接库文件，如果没问题的话，会在当前文件下生成一个test.so文件。
第二部：用命令 python main.py
这一步就是调用Python代码，就可以看到程序的输出结果。
'''

