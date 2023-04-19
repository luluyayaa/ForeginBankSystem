package com.gener;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lulu.controller.advice.Code;
import com.lulu.controller.advice.Result;
import com.lulu.dao.TransDao;
import com.lulu.domain.Trans;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@SpringBootTest
class Mybatisplus04GeneratorApplicationTests {

    @Autowired
    private TransDao transDao;

    @Test
    public void getById(){
        Trans trans = transDao.selectById(2);
        System.out.println(trans);
    }

    @Test
    public void getByNo() {
        QueryWrapper<Trans> wrapper = new QueryWrapper<>();
        //查询指定字段
        wrapper.eq("stk_no","USD");
        List<Map<String, Object>> trans = transDao.selectMaps(wrapper);
        System.out.println(trans);
    }
}
