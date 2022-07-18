package com.pccw.user.biz;

import com.pccw.user.common.BizCodeEnum;
import com.pccw.user.common.BizException;
import com.pccw.user.common.Constant;
import com.pccw.user.dao.TUser;
import com.pccw.user.dao.UserConverter;
import com.pccw.user.dao.UserMapper;
import com.pccw.user.dto.UserDTO;
import com.pccw.user.util.EmailUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component("userBiz")
public class UserBiz {

    @Resource
    private UserMapper userMapper;



    public List<UserDTO> selectUser() {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<TUser> tUserList = userMapper.findAll();
        if (!tUserList.isEmpty()) {
            userDTOList.addAll(tUserList.stream().map(UserConverter::o2o).collect(Collectors.toList()));
        }

        return userDTOList;
    }

    public UserDTO selectUserById(Long id) {
        TUser tUser = userMapper.selectById(id);
        return UserConverter.o2o(tUser);
    }

    public Long insert(UserDTO userDTO) {
        TUser tUser = UserConverter.o2o(userDTO);
        Date curDate = new Date();
        tUser.setCreatedTime(curDate);
        tUser.setUpdateTime(curDate);
        tUser.setDeleted(Constant.DELETED_NO);
        userMapper.insert(tUser);
        //send welcome email
        EmailUtil.sendEmail(userDTO.getEmail());
        return tUser.getId();
    }

    public int updateById(UserDTO userDTO){
        //todo A distributed lock needs to be added here
        TUser preTUser = userMapper.selectById(userDTO.getId());
        if(Objects.isNull(preTUser)){
            throw new BizException(BizCodeEnum.ILLEGAL_PARAM.getCode(), "要更新的用户不存在！");
        }else if(userDTO.getAge().equals(preTUser.getAge()) && userDTO.getUserName().equals(preTUser.getUserName())){
            throw new BizException(BizCodeEnum.ILLEGAL_PARAM.getCode(), "用户信息未更新！");
        }else{
            TUser tUser = UserConverter.o2o(userDTO);
            tUser.setUpdateTime(new Date());
            return userMapper.updateById(tUser);
        }
    }

    public int deleteById(Long id){
        TUser tUser = new TUser();
        tUser.setId(id);
        tUser.setDeleted(Constant.DELETED_YES);
        return userMapper.updateById(tUser);
    }


}
