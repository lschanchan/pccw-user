package com.pccw.user.dao;

import com.pccw.user.dto.UserDTO;

public class UserConverter {
    public static TUser o2o(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        TUser tUser = new TUser();
        tUser.setId(userDTO.getId());
        tUser.setUserName(userDTO.getUserName());
        tUser.setEmail(userDTO.getEmail());
        tUser.setAge(userDTO.getAge());
        return tUser;
    }

    public static UserDTO o2o(TUser tUser) {
        if (tUser == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(tUser.getId());
        userDTO.setUserName(tUser.getUserName());
        userDTO.setEmail(tUser.getEmail());
        userDTO.setAge(tUser.getAge());
        return userDTO;
    }
}
