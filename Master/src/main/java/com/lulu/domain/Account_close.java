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
@TableName("stk_account_close")
public class Account_close implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;

    /**
     * 用户编号
     */
    @TableField(value="user_no")
    private String userNo;

    /**
     * 当前保证金额
     */
    private String deposit;

    /**
     * 总体头寸盈亏
     */
    private String balance;

    /**
     * 买空交易成本
     */
    @TableField(value="balance_cost")
    private String balanceCost;

    /**
     * 卖空交易额度
     */
    @TableField(value="balance_real")
    private String balanceReal;

    /**
     * 次清算平仓日期
     */
    @TableField(value="close_date")
    private String closeDate;

    /**
     * 上次清算平仓时间
     */
    @TableField(value = "close_time")
    private String closeTime;

    /**
     * 平仓清算后的保证金额
     */
    @TableField(value="new_deposit")
    private String newDeposit;


}
