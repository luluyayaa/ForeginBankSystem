package com.lulu.dao;

import com.lulu.domain.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lulu
 * @since 2022-05-29
 */
@Mapper
public interface AccountDao extends BaseMapper<Account> {

}