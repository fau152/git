package com.colin;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("hello git2");

        //正常合并演示：edit by hot-fix
        System.out.println("helle git, edit by hot-fix");

        //冲突合并分支演示：
        System.out.println("master test");

        //冲突合并分支演示：
        System.out.println("hot-fix test");

        //----------修改代码，push到远程库测试-----------
        System.out.println("push test");
        
        //----------在远程仓库修改代码，然后拉取合并到本次仓库测试---------
        System.out.println("添加与Github远程仓库");
    }
}
