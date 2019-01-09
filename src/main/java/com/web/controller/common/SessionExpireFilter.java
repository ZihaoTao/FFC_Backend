package com.web.controller.common;

import com.web.common.Const;
import com.web.pojo.User;
import com.web.util.CookieUtil;
import com.web.util.JsonUtil;
import com.web.util.RedisShardedPoolUtil;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by tino on 1/2/19.
 */
public class SessionExpireFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);

        if(StringUtils.isNotEmpty(loginToken)) {
            String userJsonStr = RedisShardedPoolUtil.get(loginToken);
            User user = JsonUtil.String2Obj(userJsonStr, User.class);
            if(user != null) {
                // reset expiration
                RedisShardedPoolUtil.expire(loginToken, Const.RedisCacheEx.REDIS_SESSION_EXTIME);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
