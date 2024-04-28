package webtest.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import webtest.entity.User;
import webtest.mapper.UserMapper;
//解决跨域问题，开放权限
@CrossOrigin
@RestController
@RequestMapping("/user")
public class userController {

    @Resource
    private UserMapper userMapper;

    // 专用
    @PostMapping("/Login")
    public Integer login(@RequestBody User user) {
        System.out.println(user.getUsername()+" " + user.getPassword());
        return userMapper.selectLogin(user.getUsername(),user.getPassword());
    }

    @PostMapping("/Register")
    public Integer register(@RequestBody User user) {
        System.out.println(user.getUsername()+" " + user.getPassword());
        return userMapper.insertUser(user.getUsername(),user.getPassword());
    }
}
