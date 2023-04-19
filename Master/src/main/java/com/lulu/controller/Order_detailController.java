package com.lulu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lulu.controller.advice.Code;
import com.lulu.controller.advice.Result;
import com.lulu.dao.Order_detailDao;
import com.lulu.domain.Account;
import com.lulu.domain.Order_detail;
import com.lulu.domain.Trans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lulu
 * @since 2022-05-29
 */
@RestController
@RequestMapping("/order_detail")
public class Order_detailController {

    @Autowired
    private Order_detailDao order_detailDao;

    /**
     * 查询全部
     * @return
     */
    @GetMapping
    public Result getAll() {
        List<Order_detail> order_details = order_detailDao.selectList(null);
        Integer code = order_details != null ? Code.GET_OK : Code.GET_ERR;
        String msg = order_details != null ? "" : "查询失败";
        return new Result(code,order_details,msg);
    }

    /**
     * 根据委托类型 sell或buy查询
     * @param orderType
     * @return
     */
    @JsonProperty
    @GetMapping("/select/{orderType}")
    public Result getByNo(@PathVariable String orderType) {
        LambdaQueryWrapper<Order_detail> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Order_detail::getOrderType,orderType);
        List<Order_detail> order_details = order_detailDao.selectList(wrapper);
        Integer code = order_details != null ? Code.GET_OK : Code.GET_ERR;
        String msg = order_details != null ? "" : "查询失败";
        return new Result(code,order_details,msg);
    }
}

