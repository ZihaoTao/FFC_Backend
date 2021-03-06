package com.web.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by tino on 12/1/18.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserListVo {
    private Integer id;
    private String username;
    private String email;
    private String phone;
    private String createTime;
}
