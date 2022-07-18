package com.pccw.user.service;

import com.pccw.user.common.ApiResponse;
import com.pccw.user.req.QueryUserReq;
import com.pccw.user.req.UserReq;
import com.pccw.user.resp.UserResp;
import com.pccw.user.validation.NotConflictUser;
import com.pccw.user.validation.UniqueUser;

import javax.validation.Valid;


public interface IUserInterface {

    ApiResponse<UserResp> queryUserById(QueryUserReq queryUserReq);

    ApiResponse<Long> insertUser(@UniqueUser @Valid UserReq userReq);

    ApiResponse updateUser(@NotConflictUser @Valid UserReq userReq);

    ApiResponse deleteUser(QueryUserReq queryUserReq);
}
