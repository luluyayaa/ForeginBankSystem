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
@TableName("stk_order_detail")
public class Order_detail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自动生成，唯一
     */
    @TableId(value = "detail_id", type = IdType.AUTO)
    private Integer detailId;

    /**
     * 委托编号
     */
    @TableField(value="order_id")
    private Integer orderId;

    /**
     * 用户编号
     */
    @TableField(value="user_no")
    private String userNo;

    /**
     * 外汇编号
     */
    @TableField(value="stk_no")
    private String stkNo;

    /**
     * 委托类型
     */
    @TableField(value="order_type")
    private String orderType;

    /**
     * 对手委托编号
     */
    @TableField(value="order_id2")
    private Integer orderId2;

    /**
     * 对手客户编号
     */
    @TableField(value="user_no2")
    private String userNo2;

    /**
     * 成交数量
     */
    @TableField(value="trans_sum")
    private String transSum;

    /**
     * 成交价格
     */
    @TableField(value="trans_price")
    private String transPrice;

    /**
     * 成交日期
     */
    @TableField(value="trans_date")
    private String transDate;

    /**
     * 成交时间
     */
    @TableField(value="trans_time")
    private String transTime;


}
