package com.gzu.repairsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gzu.repairsystem.common.Result;
import com.gzu.repairsystem.entity.User;
import com.gzu.repairsystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Result<User> login(String username, String password) {

        //定义user变量
        User user = userMapper.selectOne(
                new LambdaQueryWrapper<User>().eq(User::getUsername, username)
        );

        //用户名不存在
        if(user == null){
            return Result.error("用户名不存在");
        }

        //密码错误
        if(!user.getPassword().equals(password)){
            return Result.error("密码错误");
        }

        //验证通过，返回用户信息
        return Result.success(user);
    }
}
