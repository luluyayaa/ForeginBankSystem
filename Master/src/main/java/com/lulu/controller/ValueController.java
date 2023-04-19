package com.lulu.controller;


import com.lulu.controller.advice.Code;
import com.lulu.controller.advice.Result;
import com.lulu.dao.ValueDao;
import com.lulu.domain.Account;
import com.lulu.domain.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/value")
public class ValueController {
    @Autowired
    private ValueDao valueDao;

    /**
     * 查询全部
     * @return
     */
    @GetMapping
    public Result getAll() {
        List<Value> value = valueDao.selectList(null);
        Integer code = value != null ? Code.GET_OK : Code.GET_ERR;
        String msg = value != null ? "" : "查询失败";
        return new Result(code,value,msg);
    }
}

