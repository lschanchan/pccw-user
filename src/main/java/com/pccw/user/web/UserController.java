package com.pccw.user.web;

import com.pccw.user.common.ApiResponse;
import com.pccw.user.req.QueryUserReq;
import com.pccw.user.req.UserReq;
import com.pccw.user.resp.UserResp;
import com.pccw.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
@Api(tags = {"user-api"})
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value="queryUser",notes = "by id")
    @GetMapping("/queryById")
    public ApiResponse<UserResp> queryById(@RequestParam(value = "id", required = true) Long id) {
        if(Objects.isNull(id)){
            return ApiResponse.buildIllegalParam();
        }
        QueryUserReq queryUserReq = new QueryUserReq();
        queryUserReq.setId(id);
        return userService.queryUserById(queryUserReq);
    }

    @ApiOperation(value="createUser", notes=" by userName and age")
    @PostMapping("/createUser")
    public ApiResponse<Long> createUser(@RequestBody(required = true) UserReq userReq) {

        return userService.insertUser(userReq);
    }

    @ApiOperation(value="updateUser", notes="by id")
    @PostMapping("/updateUser")
    public ApiResponse updateUser(@RequestBody(required = true) UserReq userReq) {
        return userService.updateUser(userReq);
    }

    @ApiOperation(value= "deleteUser", notes="by id")
    @PostMapping("/deleteUser")
    public ApiResponse deleteUser(@RequestBody(required = true) QueryUserReq queryUserReq) {
        return userService.deleteUser(queryUserReq);
    }


}
