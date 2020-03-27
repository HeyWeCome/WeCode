package com.kang.service.user;

import com.kang.pojo.UserDiary;

import java.util.List;

/**
 * @description:
 * @author: HeyWeCome
 * @createDate: 2020/3/26 10:29
 * @version: 1.0
 */
public interface UserService {
    int addDairy(UserDiary userDiary);
    List<UserDiary> queryAlldiary(String userId);    //查询全部日志,返回list集合
}