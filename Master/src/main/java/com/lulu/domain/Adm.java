package com.lulu.domain;

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
 * @since 2022-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("stk_adm")
public class Adm implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "adm_id", type = IdType.AUTO)
    private Integer adm_id;

    /**
     * 管理员编号
     */
    private String adm_no;

    /**
     * 项目
     */
    private String adm_name;

    /**
     * 登录名称
     */
    private String adm_logonid;

    /**
     * 登录密码
     */
    private String adm_logonpwd;

    /**
     * 类型
     */
    private String adm_type;

    /**
     * 状态
     */
    private String adm_status;

    /**
     * 照片
     */
    private String adm_photo_bin;

    private String adm_photo_nam;

    private String adm_photo_siz;


}
