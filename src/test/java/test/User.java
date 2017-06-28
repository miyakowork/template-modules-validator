package test;

import jodd.vtor.constraint.Length;
import jodd.vtor.constraint.Max;

/**
 * Created by wuwenbin on 2017/5/11.
 */
public class User {

    @Length(min = 4, max = 8)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Max(100)
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
