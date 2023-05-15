package com.atguigu.gmall1129.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.atguigu.gmall1129.bean.UserAddress;
import com.atguigu.gmall1129.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @param
 * @return
 */

@Controller
public class OrderController {


    @Reference
    UserService userService;

    @GetMapping("trade")
    @ResponseBody
    public String trade(@RequestParam("userId") String userId){
        List<UserAddress> userAddressList=userService.getUserAddressList(userId);
        String jsonString = JSON.toJSONString(userAddressList);
        return jsonString;
    }
}
