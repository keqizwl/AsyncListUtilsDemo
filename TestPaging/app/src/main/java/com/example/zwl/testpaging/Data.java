package com.example.zwl.testpaging;

/**
 * Created by zwl on 9/23/17.
 */

public class Data {
    static int ageStarter = 10;
    static String nameStarter = "xiaoming";

    private int age;
    private String name;

    public Data() {
        age = ageStarter++;
        name = nameStarter + age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
