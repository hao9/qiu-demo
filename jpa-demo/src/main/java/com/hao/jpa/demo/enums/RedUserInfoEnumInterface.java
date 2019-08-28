package com.hao.jpa.demo.enums;

public interface RedUserInfoEnumInterface {

    static interface SEX{
        Integer MAN =1;
        Integer WOAMN =0;
    }

    static interface STATUS{
        Integer DEL = -1;
        Integer ABLE = 1;
        Integer DISABLE = 0;
    }

}
