package com.hao.jpa.demo.Reponse;

import lombok.Data;

import java.util.List;

@Data
public class PageResponse2<T> {
    Integer pageCurr;
    Integer pageSize;
    Integer pageCount;
    Integer listSize;
    List<T> rows;
}
