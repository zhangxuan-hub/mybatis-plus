package com.zx.mp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName User
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/26 0026 16:41
 * @Version 1.0
 */

@Data
@TableName(value = "user")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private Long pId;
    private String email;
    private Date createTime;
}
