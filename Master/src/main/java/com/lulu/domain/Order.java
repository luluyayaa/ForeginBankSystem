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
@TableName("stk_order")
public class Order implements Serializable {

    /**
     * 委托序号 自动生成
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 外汇编号
     */
    @TableField(value="stk_no")
    private String stkNo;

    /**
     * 委托类型buy sell
     */
    @TableField(value="order_type")
    private String orderType;

    /**
     * 委托用户编号
     */
    @TableField(value="user_no")
    private String userNo;

    /**
     * 委托日期
     */
    @TableField(value="order_date")
    private String orderDate;

    /**
     * 委托时间
     */
    @TableField(value="order_time")
    private String orderTime;

    /**
     * 委托数量
     */
    @TableField(value="order_sum")
    private String orderSum;

    /**
     * 委托价格
     */
    @TableField(value="order_price")
    private String orderPrice;

    /**
     * 状态:等待 撤销 超时 成交
     */
    @TableField(value="order_status")
    private String orderStatus;

    /**
     * 剩余数量
     */
    @TableField(value="order_remain_sum")
    private String orderRemainSum;


}
