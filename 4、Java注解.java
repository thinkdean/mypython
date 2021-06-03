package com.company;

/*
1、注解的概念：特殊功能的标记
2、准确重写：让重写不再犯错
3、过期声明：过期的方法，要告诉开发者
4、压制警告：有的警告是可以忽略不计的，强迫症患者的福音

重写方法: @Override
过时的方法: @Deprecated
压制警告:
 1、不检查方法的警告 @SuppressWarnings("unchecked")
 2、忽略类型的警告 @SuppressWarnings("rawtypes")
*/

class Book<T>{
    String name;

    @Override //重写方法
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }

    @Deprecated  //过时的方法
    public void abc(){
        System.out.println("过时了");
    }
}

public class 注解 {
    @SuppressWarnings("unchecked")  //不检查方法的警告
    public static void main(String[] args) {
        //黄色的浪线，叫警告
        @SuppressWarnings("rawtypes") //忽略类型的警告
        Book b = new Book();
        b.name = "java";
        System.out.println(b);
        b.abc();
    }
}
