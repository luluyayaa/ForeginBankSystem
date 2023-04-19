package com.lulu.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author lulu
 * @since 2022-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("stk_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增序号
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户编号
     */
    @TableField(value="user_no")
    private String userNo;

    /**
     * 用户名称
     */
    @TableField(value="user_name")
    private String userName;

    /**
     * 性别
     */
    @TableField(value="user_sex")
    private String userSex;

    /**
     * 类别:班级、部门、单位
     */
    @TableField(value="user_class")
    private String userClass;

    /**
     * 登录名称
     */
    @TableField(value="user_logonid")
    private String userLogonid;

    /**
     * 登录密码
     */
    @TableField(value="user_logonpwd")
    private String userLogonpwd;

    /**
     * 用户类型
     */
    @TableField(value="user_type")
    private String userType;

    /**
     * 用户状态,启用或停止
     */
    @TableField(value="user_status")
    private String userStatus;

    /**
     * 照片二进制数据
     */
    @TableField(value="user_img_bin")
    private String userImgBin;

    /**
     * 上传照片文件名称
     */
    @TableField(value="user_img_nam")
    private String userImgNam;

    /**
     * 照片二进制数据大小
     */
    @TableField(value="user_img_siz")
    private String userImgSiz;


}
