package com.hao.jpa.demo.Request;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageInfro implements Serializable {
     Integer pageCurr ;
     Integer pageSize ;
}
