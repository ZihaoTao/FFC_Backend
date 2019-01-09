package com.web.service;

import com.web.common.ServerResponse;
import com.web.pojo.User;

/**
 * Created by geely
 */

public interface IUserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str, String type);
}
