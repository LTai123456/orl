package com.orl.auth.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.orl.auth.entity.User;


@Mapper
public interface UserMapper extends BaseMapper<User>{

}
