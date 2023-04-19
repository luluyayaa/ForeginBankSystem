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
@TableName("stk_account")
public class Account implements Serializable {

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
     * 上次清算平仓日期
     */
    @TableField(value="balance_date")
    private String balanceDate;

    /**
     * 上次清算平仓时间
     */
    @TableField(value="balance_time")
    private String balanceTime;


}
