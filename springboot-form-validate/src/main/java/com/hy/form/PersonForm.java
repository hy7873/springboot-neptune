package com.hy.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author: wanghai
 * @Date:2019/7/16 9:55
 * @Copyright:reach-life
 * @Description:
 */
public class PersonForm {

    @NotNull
    @Size(min = 2,max = 30)
    private String name;

    @NotNull
    @Min(value = 18)
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
    public String toString() {
        return "PersonForm{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
