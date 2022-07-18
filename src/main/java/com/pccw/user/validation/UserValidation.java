package com.pccw.user.validation;

import com.pccw.user.dao.TUser;
import com.pccw.user.dao.UserMapper;
import com.pccw.user.req.UserReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class UserValidation<T extends Annotation> implements ConstraintValidator<T, UserReq> {

    protected Predicate<UserReq> predicate = c -> true;

    @Resource
    protected UserMapper userMapper;

    @Override
    public boolean isValid(UserReq user, ConstraintValidatorContext constraintValidatorContext) {
        return userMapper == null || predicate.test(user);
    }

    /**
     * Check if user is unique
     * judge whether there is information about the current new user in the database, such as user name, email
     */
    public static class UniqueUserValidator extends UserValidation<UniqueUser>{
        @Override
        public void initialize(UniqueUser uniqueUser) {
            predicate = c -> {
                List<TUser> tUserList = userMapper.existsByUserNameOrEmail(c.getUserName(),c.getEmail());
                return CollectionUtils.isEmpty(tUserList) ? true : false;
            };
        }
    }

    /**
     * Check for conflicts with other users
     * Change the username and email to something that is completely different from the existing one, or only repeats itself, it is not a conflict
     */
    public static class NotConflictUserValidator extends UserValidation<NotConflictUser>{
        @Override
        public void initialize(NotConflictUser notConflictUser) {
            predicate = c -> {
                log.info("user detail is {}",c);
                List<TUser> tUserList = userMapper.existsByUserNameOrEmail(c.getUserName(),c.getEmail());
                return tUserList.isEmpty() || (tUserList.size() == 1 && tUserList.iterator().next().getId().equals(c.getId()));
            };
        }
    }

}
