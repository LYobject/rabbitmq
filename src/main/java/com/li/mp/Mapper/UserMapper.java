package com.li.mp.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.mp.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author LiYe
 * @Date 2024/3/26 10:42
 * @Version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
