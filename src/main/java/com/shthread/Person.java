package com.shthread;

/**
 * @ClassName Person
 * @Description TODO
 * Author sunhong
 * Date 2019-9-25 13:29
 **/
public class Person {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return 11;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Person) obj).getName());
    }
}
