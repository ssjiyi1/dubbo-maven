package cn.zw.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @description  学生实体操作类
 * @auther 'Amos'
 * @created 2016/8/3  10:14
 */

public class Student extends  BaseEntity{

    private String uname;
    @JsonIgnore
    private String pwd;
    private int age;
    private String gender;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
