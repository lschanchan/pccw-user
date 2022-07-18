package com.pccw.user.service;

import com.pccw.user.dto.UserDTO;
import com.pccw.user.req.UserReq;
import com.pccw.user.resp.UserResp;

public class UserTransfer {

    public static UserResp o2o(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        UserResp userResp = new UserResp();
        userResp.setId(userDTO.getId());
        userResp.setUserName(userDTO.getUserName());
        userResp.setEmail(userDTO.getEmail());
        userResp.setAge(userDTO.getAge());
        return userResp;
    }

    public static UserDTO o2o(UserReq userReq) {
        if (userReq == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userReq.getId());
        userDTO.setUserName(userReq.getUserName());
        userDTO.setEmail(userReq.getEmail());
        userDTO.setAge(userReq.getAge());
        return userDTO;
    }
}
