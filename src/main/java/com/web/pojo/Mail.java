package com.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * Created by tino on 1/10/19.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Mail {

    /**
     * 发件人邮箱服务器
     */
    private String emailHost;
    /**
     * 发件人邮箱
     */
    private String emailFrom;

    /**
     * 发件人用户名
     */
    private String emailUserName;

    /**
     * 发件人密码
     */
    private String emailPassword;

    /**
     * 收件人邮箱，多个邮箱以“;”分隔
     */
    private String toEmails;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String content;
    /**
     * 邮件中的图片，为空时无图片。map中的key为图片ID，value为图片地址
     */
    private Map<String, String> pictures;
    /**
     * 邮件中的附件，为空时无附件。map中的key为附件ID，value为附件地址
     */
    private Map<String, String> attachments;


    private String fromAddress;//发送人地址1个

    private String toAddresses;//接收人地址,可以为很多个，每个地址之间用";"分隔，比方说450065208@qq.com;lpf@sina.com

    private String[] attachFileNames;//附件
}
