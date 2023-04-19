package com.lulu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lulu.controller.advice.Code;
import com.lulu.controller.advice.Result;
import com.lulu.dao.AccountDao;
import com.lulu.domain.Account;
import com.lulu.domain.Trans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lulu
 * @since 2022-05-29
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountDao accountDao;

    /**
     * 新增
     * @param account
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Account account) {
        int flag = accountDao.insert(account);
        return new Result(flag>0? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    /**
     * 修改
     * @param account
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Account account) {
        int flag = accountDao.updateById(account);
        return new Result(flag>0? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    /**
     * 删除
     * @param sid
     * @return
     */
    @DeleteMapping("/{sid}")
    public Result delete(@PathVariable Integer sid) {
        int flag = accountDao.deleteById(sid);
        return new Result(flag>0 ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    /**
     * 根据id查询
     * @param sid
     * @return
     */
    @GetMapping("/{sid}")
    public Result getById(@PathVariable(required = false) Integer sid) {
        Account account = accountDao.selectById(sid);
        Integer code = account != null ? Code.GET_OK : Code.GET_ERR;
        String msg = account != null ? "" : "查询失败";
        return new Result(code,account,msg);
    }

    /**
     * 查询全部
     * @return
     */
    @GetMapping
    public Result getAll() {
        List<Account> accounts = accountDao.selectList(null);
        Integer code = accounts != null ? Code.GET_OK : Code.GET_ERR;
        String msg = accounts != null ? "" : "查询失败";
        return new Result(code,accounts,msg);
    }

    /**
     * 分页查询
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/{current}/{size}")
    public Result selectPage(@PathVariable Integer current,@PathVariable Integer size) {
        IPage<Account> page =new Page<>(current,size);
        accountDao.selectPage(page,null);
        Integer code = Code.GET_OK;
        String msg = "";
        return new Result(code,page,msg);
    }

    /**
     * 条件查询
     * @return
     */
//    @RequestMapping("/search/{userNo}")
//    public Result getByNo(@PathVariable String userNo) {
//        QueryWrapper<Account> wrapper = new QueryWrapper<>();
//        wrapper.eq("user_no",userNo);
//        List<Map<String, Object>> account = accountDao.selectMaps(wrapper);
//        Integer code = account != null ? Code.GET_OK : Code.GET_ERR;
//        String msg = account != null ? "" : "查询失败";
//        return new Result(code,account,msg);
    }



