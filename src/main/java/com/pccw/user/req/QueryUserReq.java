package com.pccw.user.req;

import javax.validation.constraints.NotNull;

public class QueryUserReq {


    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
