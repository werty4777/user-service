package com.sulluscocha.user_persistence.persistence;

import com.sulluscocha.types.types.UserRequest;
import com.sulluscocha.user_domain.domain.User;
import com.sulluscocha.user_domain.exception.UserNotFoundException;

public interface UserBuilder {

    UserDO fromUser(User user) ;//cambiar por el domain

    User toUser(UserDO user);//cambiar por el domain


}
