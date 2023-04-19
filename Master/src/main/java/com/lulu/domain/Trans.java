package com.lulu.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Configuration;

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
@TableName("stk_trans")
public class Trans implements Serializable {


    /**
     * 成交序号
     */
    @TableId(value = "trans_id", type = IdType.AUTO)
    private Integer transId;

    /**
     * 外汇编号
     */
    @TableField(value="stk_no")
    private String stkNo;

    /**
     * 撮合成交日期
     */
    @TableField(value="trans_date")
    private String transDate;

    /**
     * 撮合成交时间
     */
    @TableField(value="trans_time")
    private String transTime;

    /**
     * 买方委托序号
     */
    @TableField(value="order_id_buy")
    private String orderIdBuy;

    /**
     * 买方客户编号
     */
    @TableField(value="user_no_buy")
    private String userNoBuy;

    /**
     * 卖方委托序号
     */
    @TableField(value="order_id_sell")
    private String orderIdSell;

    /**
     * 卖方客户编号
     */
    @TableField(value="user_no_sell")
    private String userNoSell;

    /**
     * 撮合成交价格
     */
    @TableField(value="trans_price")
    private String transPrice;

    /**
     * 撮合成交数量
     */
    @TableField(value="trans_sum")
    private String transSum;


}
