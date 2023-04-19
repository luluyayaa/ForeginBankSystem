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
@TableName("stk_value")
public class Value implements Serializable {

    /**
     * 自增序号
     */
    @TableId(value = "stk_id", type = IdType.AUTO)
    private Integer stkId;

    /**
     * 货币编号SD CAD EUR
     */
    @TableField(value="stk_no")
    private String stkNo;

    /**
     * 货币中文简称美元 加元 欧元
     */
    @TableField(value="stk_name")
    private String stkName;

    /**
     * 当前汇率价格与人民币的汇率
     */
    @TableField(value="stk_price")
    private String stkPrice;

    /**
     * 委托报价下限%
     */
    @TableField(value="min_perc")
    private String minPerc;

    /**
     * 委托报价上限%
     */
    @TableField(value="max_perc")
    private String maxPerc;

    /**
     * 最小委托数量
     */
    @TableField(value="min_qty")
    private String minQty;

    /**
     * 最大委托数量
     */
    @TableField(value="max_qty")
    private String maxQty;

    /**
     * 汇率价格日期
     */
    @TableField(value="stk_date")
    private String stkDate;

    /**
     * 汇率价格时间
     */
    @TableField(value="stk_time")
    private String stkTime;

    /**
     * 汇率单位日元为100，其它为1
     */
    @TableField(value="stk_unit")
    private String stkUnit;

    /**
     * 状态，日元为100，其它为1
     */
    @TableField(value="stk_status")
    private String stkStatus;

    /**
     * 价格来源
     */
    @TableField(value="stk_src")
    private String stkSrc;


}
