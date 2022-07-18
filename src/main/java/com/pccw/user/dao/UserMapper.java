package com.pccw.user.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

     List<TUser> findAll();

     Long insert(@Param("tUser")TUser tUser);

     TUser selectById(@Param("id")Long id);

     int updateById(@Param("tUser")TUser tUser);

     List<TUser> existsByUserNameOrEmail(@Param("userName")String userName, @Param("email")String email);

}
