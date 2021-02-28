package xyz.microloong.resumetemplate.bean;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * 用户编号
     */
    private int id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 城市
     */
    private String city;

    /**
     * 详细住址
     */
    private String address;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 微信
     */
    private String weixin;

    /**
     * qq
     */
    private String qq;

    /**
     * 微博
     */
    private String weibo;

    /**
     * 性别
     */
    private String sex;

    /**
     * 简介
     */
    private String description;

    public User(String name, int age, String city, String address, String email, String phone, String weixin, String qq, String weibo, String sex, String description) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.weixin = weixin;
        this.qq = qq;
        this.weibo = weibo;
        this.sex = sex;
        this.description = description;
    }
}
