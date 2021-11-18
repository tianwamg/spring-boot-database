package com.mp.springmybatisplus.domain;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class SysUser {


    private Integer id;

    private String userName;

    private String phone;

    private Integer gender;

    @TableLogic(value = "1",delval = "-1")
    @TableField(fill = FieldFill.INSERT)
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private Date ctime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date mtime;


}
