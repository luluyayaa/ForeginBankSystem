package com.lulu.controller;


import com.lulu.controller.advice.Code;
import com.lulu.controller.advice.Result;
import com.lulu.dao.Account_stkDao;
import com.lulu.domain.Account;
import com.lulu.domain.Account_stk;
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
@RequestMapping("/account_stk")
public class Account_stkController {
    @Autowired
    private Account_stkDao account_stkDao;
    /**
     * 查询全部
     * @return
     */
    @GetMapping
    public Result getAll() {
        List<Account_stk> account_stk = account_stkDao.selectList(null);
        Integer code = account_stk != null ? Code.GET_OK : Code.GET_ERR;
        String msg = account_stk != null ? "" : "查询失败";
        return new Result(code,account_stk,msg);
    }
}

