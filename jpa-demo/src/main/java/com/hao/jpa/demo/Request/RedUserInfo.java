package com.hao.jpa.demo.Request;

import lombok.Data;

@Data
public class RedUserInfo extends PageInfro {

    private String name;

    private Integer minAge;

    private Integer maxAge;

    private String phone;




}
