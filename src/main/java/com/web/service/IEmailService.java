package com.web.service;

import com.web.common.ServerResponse;

/**
 * Created by tino on 1/10/19.
 */
public interface IEmailService {
    ServerResponse<String> emailManage(String username);
    ServerResponse<String> confirm(String username);
}
