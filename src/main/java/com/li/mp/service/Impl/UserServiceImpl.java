package com.li.mp.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.mp.Mapper.UserMapper;
import com.li.mp.pojo.User;
import com.li.mp.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author LiYe
 * @Date 2024/3/26 13:09
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService  {
}
