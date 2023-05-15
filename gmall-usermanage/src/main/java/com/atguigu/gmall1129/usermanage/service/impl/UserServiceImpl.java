package com.atguigu.gmall1129.usermanage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall1129.bean.UserAddress;
import com.atguigu.gmall1129.bean.UserInfo;
import com.atguigu.gmall1129.usermanage.mapper.UserAddressMapper;
import com.atguigu.gmall1129.usermanage.mapper.UserInfoMapper;
import com.atguigu.gmall1129.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @param
 * @return
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserAddressMapper userAddressMapper;

    public  void addUserInfo(UserInfo userInfo){
        userInfoMapper.insertSelective(userInfo);
    }

    public UserInfo getUserInfo(String id){
        //UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);

/*         UserInfo userInfoQuery=new UserInfo();
       userInfoQuery.setLoginName("zhangchen");

        UserInfo userInfo = userInfoMapper.selectOne(userInfoQuery);*/

        Example example=new Example(UserInfo.class);
        example.createCriteria().andLike("name","%晨%");

        UserInfo userInfo = userInfoMapper.selectOneByExample(example);
        return userInfo;

    }


    public List<UserInfo>  getUserList(UserInfo userInfo){
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        return userInfos;
    }


    public void updateUser(UserInfo userInfo){
        Example example=new Example(UserInfo.class);
        example.createCriteria().andEqualTo("nickName","tingting");

        userInfoMapper.updateByExample(userInfo,example);

    }


    public List<UserAddress> getUserAddressList(String userId){
        UserAddress userAddressQuery=new UserAddress();

        userAddressQuery.setUserId(userId);

        List<UserAddress> userAddressList = userAddressMapper.select(userAddressQuery);

        return userAddressList;
    }



}
