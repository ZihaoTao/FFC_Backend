package com.web.controller.protal;

import com.web.common.ServerResponse;
import com.web.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tino on 1/10/19.
 */
@Controller
@RequestMapping("/api/")
@Slf4j
public class EmailController {

    @Autowired
    private IEmailService iEmailService;

    @RequestMapping(value = "sendEmail.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse sendEmailTask(String username) {
        log.info("-------------SEND EMAIL START---------------");
        //写入excel
        //insuranceService.excelManage();
        //发邮件
        log.info("-------------SEND EMAIL END---------------");
        return iEmailService.emailManage(username);
    }
}
