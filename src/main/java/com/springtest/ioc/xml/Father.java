package com.springtest.ioc.xml;

/**
 * @ClassName Father
 * @Description TODO
 * Author sunhong
 * Date 2020-3-7 11:29
 **/
public class Father {

    private Hobby hobby;

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public void say(){
        System.out.println("fatherËµ»°");
    }


    public void peak(){
        say();
    }
}
