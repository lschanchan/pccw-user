package com.pccw.user.service;

import com.pccw.user.biz.UserBiz;
import com.pccw.user.common.ApiResponse;
import com.pccw.user.dto.UserDTO;
import com.pccw.user.req.QueryUserReq;
import com.pccw.user.req.UserReq;
import com.pccw.user.resp.UserResp;
import com.pccw.user.validation.NotConflictUser;
import com.pccw.user.validation.UniqueUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service("userService")
@Validated
public class UserService implements IUserInterface{

    @Autowired
    private UserBiz userBiz;


    @Override
    public ApiResponse<UserResp> queryUserById(QueryUserReq queryUserReq) {
        UserDTO userDTO = userBiz.selectUserById(queryUserReq.getId());
        return ApiResponse.buildSuccess(UserTransfer.o2o(userDTO));
    }

    @Override
    public ApiResponse<Long> insertUser(@UniqueUser @Valid UserReq userReq) {
        UserDTO userDTO = UserTransfer.o2o(userReq);
        Long userId = userBiz.insert(userDTO);
        return ApiResponse.buildSuccess(userId);
    }

    @Override
    public ApiResponse updateUser(@NotConflictUser @Valid UserReq userReq) {
        UserDTO userDTO = UserTransfer.o2o(userReq);

        userBiz.updateById(userDTO);
        return ApiResponse.buildSuccess();
    }

    @Override
    public ApiResponse deleteUser(QueryUserReq queryUserReq) {
        userBiz.deleteById(queryUserReq.getId());
        return ApiResponse.buildSuccess();
    }
}
