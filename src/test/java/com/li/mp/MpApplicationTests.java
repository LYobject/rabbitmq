package com.li.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.mp.Mapper.UserMapper;
import com.li.mp.pojo.User;
import com.li.mp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.*;

@SpringBootTest
class MpApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testInsert() {
        User user = new User();
        user.setAge(20);
        user.setName("小李");
        user.setEmail("qq@qq.com");
        userMapper.insert(user);
        System.out.println(user.getId());
    }

    @Test
    void testDelete() {
        userMapper.deleteById("1772493378829979653");
        // User user = new User();
        // user.setName("??");
        // user.setAge(20);
        // user.setEmail("qq@qq.com");
        // user.setId(1772457803884281858L);
        // userMapper.deleteById(user);
        // Map<String,Object> map=new HashMap<>();
        // map.put("name","??");
        // map.put("age","20");
        // userMapper.deleteByMap(map);
        //
        // List<String> list = Arrays.asList("1772471961665220610", "1772472016803512322");
        // userMapper.deleteBatchIds(list);
    }

    @Test
    void testSelect(){
        Map<String,Object> map=new HashMap<>();
        map.put("age","20");
        List<User> users = userMapper.selectByMap(map);
        System.out.println(users);
    }

    @Test
    void testSave(){
        User user1=new User();
        user1.setName("小李");
        user1.setAge(20);
        user1.setEmail("qq@qq.com");
        User user2=new User();
        user2.setName("小李");
        user2.setAge(20);
        user2.setEmail("qq@qq.com");
        List<User> list=new ArrayList<>();
        list.add(user1);
        list.add(user2);
        //userService.saveBatch(list,1);
        userService.saveBatch(list);
    }

    @Test
    void testWrapper(){
        LambdaQueryWrapper<User> wrapper=new LambdaQueryWrapper<>();
        wrapper.like(User::getName,"小李").between(User::getAge,20,30).isNotNull(User::getEmail);
        List<User> list = userMapper.selectList(wrapper);
        System.out.println(list);
    }

    @Test
    void testPage(){
        // 创建分页构造器

        Page<User> page= new Page<>(3, 3);
        // 执行SQL：分页查询所有条件（还可以使用QueryWrapper对象进行条件过滤）
        Page<User> userPage = userMapper.selectPage(page, null);
            // 这里和前面获取生成id是一样的，MP将查询的数据重新赋值给了Page对象
            System.out.println("当前页码 = " + page.getCurrent());
            System.out.println("当前页展示的记录条数 = " + page.getSize());
            System.out.println("当前页展示的记录: ");
            page.getRecords().forEach(System.out::println);
            System.out.println("分页查询的总页数 = " + page.getPages());
            System.out.println("分页查询的总记录数 = " + page.getTotal());
            System.out.println("是否存在上一页: " + page.hasPrevious());
            System.out.println("是否存在下一页: " + page.hasNext());
    }
}
