package com.web.service.impl;

import com.web.common.ServerResponse;
import com.web.dao.UserMapper;
import com.web.pojo.Mail;
import com.web.pojo.User;
import com.web.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.*;

/**
 * Created by tino on 1/10/19.
 */
@Service("iEmailService")
@Slf4j
public class EmailServiceImpl implements IEmailService {


    @Autowired
    private UserMapper userMapper;
    @Resource
    private JavaMailSender javaMailSender;

    @Resource
    private SimpleMailMessage simpleMailMessage;

    @Override
    public ServerResponse<String> emailManage(String username){

        if(StringUtils.isEmpty(username)) {
            return ServerResponse.createByErrorMessage("Incorrect index");
        }

        User user = userMapper.selectUserByUserName(username);
        if(user == null) {
            return ServerResponse.createByErrorMessage("User does not exist");
        }

        log.info("Send email to " + user.getEmail());
        Mail mail = new Mail();
        //主题
        mail.setSubject("Thank you for signing up!");

        //内容
        StringBuilder builder = new StringBuilder();
        builder.append("<html><body>Hi "+ username +", <br />");

        builder.append("<br />");
        builder.append("&nbsp&nbsp&nbsp&nbsp Welcome to FashionForConservation!<br />");
        builder.append("<br />");
        builder.append("&nbsp&nbsp&nbsp&nbsp Username: "+ username +"<br />");
        builder.append("&nbsp&nbsp&nbsp&nbsp Email: "+ user.getEmail() +"<br />");
        builder.append("&nbsp&nbsp&nbsp&nbsp Security Question: "+ user.getQuestion() +"<br />");
        builder.append("&nbsp&nbsp&nbsp&nbsp Security Answer: "+ user.getAnswer() +"<br />");
        builder.append("<br />");
        builder.append("&nbsp&nbsp&nbsp&nbsp Thank you for signing up!<br />");
        builder.append("<br />");
        builder.append("Best,<br />");
        builder.append("FashionForConservation Team<br />");

        builder.append("</body></html>");
        String content = builder.toString();

        mail.setContent(content);
        mail.setToEmails(user.getEmail());

        return sendEmail(mail);
    }

    private ServerResponse<String> sendEmail(Mail mail) {
        // 建立邮件消息
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            // send from
            if (mail.getEmailFrom()!=null) {
                messageHelper.setFrom(mail.getEmailFrom());
            } else {
                messageHelper.setFrom(simpleMailMessage.getFrom());
            }

            // send to
            if (mail.getToEmails()!=null) {
                String[] toEmailArray = mail.getToEmails().split(";");
                List<String> toEmailList = new ArrayList<>();
                if (null == toEmailArray || toEmailArray.length <= 0) {
                    return ServerResponse.createByErrorMessage("Receiver's email cannot be null.");
                } else {
                    for (String s : toEmailArray) {
                        if (s!=null&&!s.equals("")) {
                            toEmailList.add(s);
                        }
                    }
                    if (null == toEmailList || toEmailList.size() <= 0) {
                        return ServerResponse.createByErrorMessage("Receiver's email cannot be null.");
                    } else {
                        toEmailArray = new String[toEmailList.size()];
                        for (int i = 0; i < toEmailList.size(); i++) {
                            toEmailArray[i] = toEmailList.get(i);
                        }
                    }
                }
                messageHelper.setTo(toEmailArray);
            } else {
                messageHelper.setTo(simpleMailMessage.getTo());
            }

            // subject
            if (mail.getSubject() != null) {
                messageHelper.setSubject(mail.getSubject());
            } else {
                messageHelper.setSubject(simpleMailMessage.getSubject());
            }

            // true: html format
            messageHelper.setText(mail.getContent(), true);

            messageHelper.setSentDate(new Date());
            // 发送邮件
            javaMailSender.send(message);
            log.info("------------Sending Email complete----------");

        } catch (javax.mail.MessagingException e) {
            log.error("Mail sending error:", e);
        }
        return ServerResponse.createBySuccessMessage("Please Check your E-mail.");
    }
}
