package com.web.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tino on 1/2/19.
 */
@Slf4j
public class CookieUtil {
    private final static String COOKIE_DOMAIN = ".fashionforconservation.xyz";
    private final static String COOKIE_NAME = "FFC_login_token";
    private final static String CHECK = "FFC_CHECK";

    public static String readLoginToken(HttpServletRequest request) {
        Cookie[] cks = request.getCookies();
        if(cks != null) {
            for(Cookie ck : cks) {
                log.info("Read cookieName:{}, cookieValue:{}", ck.getName(), ck.getValue());
                if(StringUtils.equals(ck.getName(), COOKIE_NAME)) {
                    log.info("Return cookieName:{}, cookieValue:{}", ck.getName(), ck.getValue());
                    return ck.getValue();
                }
            }
        }
        return null;
    }

    public static String readCheckToken(HttpServletRequest request) {
        Cookie[] cks = request.getCookies();
        if(cks != null) {
            for(Cookie ck : cks) {
                log.info("Read cookieName:{}, cookieValue:{}", ck.getName(), ck.getValue());
                if(StringUtils.equals(ck.getName(), CHECK)) {
                    log.info("Return cookieName:{}, cookieValue:{}", ck.getName(), ck.getValue());
                    return ck.getValue();
                }
            }
        }
        return null;
    }

    public static void writeLoginToken(HttpServletResponse response, String token) {
        Cookie ck = new Cookie(COOKIE_NAME, token);
        ck.setDomain(COOKIE_DOMAIN);
        ck.setPath("/"); // root path
        ck.setHttpOnly(true); // safe
        // unit second
        // if setMaxAge is not set, cookie will not be written into disk,
        // it is only valid under this page
        ck.setMaxAge(60 * 60 * 24 * 365); // 1year
        //ck.setMaxAge(-1); permanent
        log.info("Write cookieName:{}, cookieValue:{}", ck.getName(), ck.getValue());
        response.addCookie(ck);
    }

    public static void writeCheckToken(HttpServletResponse response, String token) {
        Cookie ck = new Cookie(CHECK, token);
        ck.setDomain(COOKIE_DOMAIN);
        ck.setPath("/"); // root path
        ck.setHttpOnly(true); // safe
        // unit second
        // if setMaxAge is not set, cookie will not be written into disk,
        // it is only valid under this page
        ck.setMaxAge(60 * 60 * 24 * 365); // 1year
        //ck.setMaxAge(-1); permanent
        log.info("Write cookieName:{}, cookieValue:{}", ck.getName(), ck.getValue());
        response.addCookie(ck);
    }

    public static void delLoginToken(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cks = request.getCookies();
        if(cks != null) {
            for(Cookie ck : cks) {
                if(StringUtils.equals(ck.getName(), COOKIE_NAME)) {
                    ck.setDomain(COOKIE_DOMAIN);
                    ck.setPath("/");
                    ck.setMaxAge(0); // del
                    log.info("Delete cookieName:{}, cookieValue:{}", ck.getName(), ck.getValue());
                    response.addCookie(ck);
                    return;
                }
            }
        }
    }
}
