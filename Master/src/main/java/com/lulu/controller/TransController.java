package com.lulu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lulu.controller.advice.Code;
import com.lulu.controller.advice.Result;
import com.lulu.dao.TransDao;
import com.lulu.domain.Trans;
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
@RequestMapping("/trans")
public class TransController {
    @Autowired
    private TransDao transDao;

    /**
     * 查询全部
     * @return
     */
    @GetMapping
    public Result getAll() {
        List<Trans> trans = transDao.selectList(null);
        Integer code = trans != null ? Code.GET_OK : Code.GET_ERR;
        String msg = trans != null ? "" : "查询失败";
        return new Result(code,trans,msg);
    }

    /**
     * 根据id查询
     * @param transId
     * @return
     */
    @GetMapping("/{transId}")
    public Result getById(@PathVariable Integer transId) {
        Trans trans  = transDao.selectById(transId);
        Integer code = trans != null ? Code.GET_OK : Code.GET_ERR;
        String msg = trans != null ? "" : "查询失败";
        return new Result(code,trans,msg);
    }

    /**
     * 条件查询指定行
     * @param stkNo
     * @return
     */
    @JsonProperty
    @GetMapping("/select/{stkNo}")
    public Result getByNo(@PathVariable String stkNo) {
        LambdaQueryWrapper<Trans> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Trans::getStkNo,stkNo);
        List<Trans> trans = transDao.selectList(wrapper);
        Integer code = trans != null ? Code.GET_OK : Code.GET_ERR;
        String msg = trans != null ? "" : "查询失败";
        return new Result(code,trans,msg);
    }
}

