package com.lulu.domain;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("stk_app")
public class App implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 配置编号
     */
    private Integer app_no;

    /**
     * 应用标题
     */
    private String app_title;

    /**
     * 头部连接URL1
     */
    private String app_url1;

    /**
     * 头部连接URL2中国外汇交易中心http://www.chainamoney.com
     */
    private String app_url2;

    /**
     * 应用logo二进制	登录页面的名称和图片
     */
    private String app_logo_bin;

    /**
     * logo上传文件名称
     */
    private String app_logo_nam;

    /**
     * 二进制大小
     */
    private String app_logo_siz;

    /**
     * 是否允许自己交易
     */
    private String app_selftrade;

    /**
     * 委托超时设置单位：分钟
     */
    private Integer app_cancel_timeout;

    /**
     * 用户初始保证金额
     */
    private String app_init_deposit;


}
