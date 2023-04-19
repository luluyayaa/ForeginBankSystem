package com.lulu.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2022-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("stk_account_stk")
public class Account_stk implements Serializable {


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
     * 持有头寸<0 为卖空 >0 为买空
     */
    @TableField(value="stk_qty")
    private Integer stkQty;

    /**
     * 持有成本同上
     */
    @TableField(value="stk_cost")
    private String stkCost;


}
