package com.hao.demo.qiu.model;

import com.foo.louis.Hello;

public class DemoUser extends Hello {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column demo_user.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column demo_user.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column demo_user.age
     *
     * @mbggenerated
     */
    private Integer age;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column demo_user.moile
     *
     * @mbggenerated
     */
    private String moile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column demo_user.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column demo_user.sex
     *
     * @mbggenerated
     */
    private Integer sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column demo_user.height
     *
     * @mbggenerated
     */
    private Double height;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column demo_user.weight
     *
     * @mbggenerated
     */
    private Double weight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column demo_user.back
     *
     * @mbggenerated
     */
    private String back;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table demo_user
     *
     * @mbggenerated
     */
    public DemoUser(Integer id, String name, Integer age, String moile, String address, Integer sex, Double height, Double weight, String back) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.moile = moile;
        this.address = address;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.back = back;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column demo_user.id
     *
     * @return the value of demo_user.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column demo_user.name
     *
     * @return the value of demo_user.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column demo_user.age
     *
     * @return the value of demo_user.age
     *
     * @mbggenerated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column demo_user.moile
     *
     * @return the value of demo_user.moile
     *
     * @mbggenerated
     */
    public String getMoile() {
        return moile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column demo_user.address
     *
     * @return the value of demo_user.address
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column demo_user.sex
     *
     * @return the value of demo_user.sex
     *
     * @mbggenerated
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column demo_user.height
     *
     * @return the value of demo_user.height
     *
     * @mbggenerated
     */
    public Double getHeight() {
        return height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column demo_user.weight
     *
     * @return the value of demo_user.weight
     *
     * @mbggenerated
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column demo_user.back
     *
     * @return the value of demo_user.back
     *
     * @mbggenerated
     */
    public String getBack() {
        return back;
    }
}