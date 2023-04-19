package com.lulu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lulu.controller.advice.Code;
import com.lulu.controller.advice.Result;
import com.lulu.dao.OrderDao;
import com.lulu.domain.Order;
import jdk.nashorn.internal.runtime.JSONFunctions;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderDao orderDao;
    /**
     * 新增
     */
    @PostMapping
    public Result save(@RequestBody Order order) {
        int flag = orderDao.insert(order);
        return new Result(flag>0? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    /**
     * 修改
     * @param
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Order order) {
        int flag = orderDao.updateById(order);
        return new Result(flag>0? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    /**
     * 删除
     * @param sid
     * @return
     */
    @DeleteMapping("/{sid}")
    public Result delete(@PathVariable Integer sid) {
        int flag = orderDao.deleteById(sid);
        return new Result(flag>0 ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    /**
     * 根据id查询
     * @param sid
     * @return
     */
    @GetMapping("/{sid}")
    public Result getById(@PathVariable Integer sid) {
        Order order = orderDao.selectById(sid);
        Integer code = order != null ? Code.GET_OK : Code.GET_ERR;
        String msg = order != null ? "" : "查询失败";
        return new Result(code,order,msg);
    }

    /**
     * 查询全部
     * @return
     */
    @GetMapping
    public Result getAll() {
        List<Order> order = orderDao.selectList(null);
        Integer code = order != null ? Code.GET_OK : Code.GET_ERR;
        String msg = order != null ? "" : "查询失败";
        return new Result(code,order,msg);
    }

    /**
     * 分页查询
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/{current}/{size}")
    public Result selectPage(@PathVariable Integer current,@PathVariable Integer size) {
        IPage<Order> page =new Page<>(current,size);
        orderDao.selectPage(page,null);
        Integer code = Code.GET_OK;
        String msg = "";
        return new Result(code,page,msg);
    }
}

