package com.dysen.demo;

/**
 * @package com.qinxiaoguai.demo
 * @email dy.sen@qq.com
 * created by dysen on 2018/9/19 - 上午10:38
 * @info
 */
class Person {
    private String name, addr;
    private int age, number;

    public Person(String name, String addr, int age, int number) {
        this.name = name;
        this.addr = addr;
        this.age = age;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
