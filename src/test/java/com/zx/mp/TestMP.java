package com.zx.mp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.mp.dao.UserDao;
import com.zx.mp.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.nio.channels.WritePendingException;
import java.util.List;


/**
 * @ClassName TestMP
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/26 0026 16:42
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMP {

    @Resource
    private UserDao userDao;

    @Test
    public void testSel() {
        System.out.println("开始执行测试方法...");
        List<User> users = userDao.selectList(null);
        Assert.assertEquals(5, users.size());
        users.forEach(System.out::println);
    }

    /**
     * 名字中包含on，
     * 年龄小于30
     */
    @Test
    public void selByWrapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "on").lt("age", 30);
        List<User> users = userDao.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * 名字中包含on，
     * 年龄大于等10小于等于30
     * emai不为空
     */
    @Test
    public void selByWrapper2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "on")
                .between("age", "10","30")
                .isNotNull("email");
        List<User> users = userDao.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /**
     * 名字以J开头
     * 或者年龄大于等25
     * 按照年龄降序排列
     * 年龄相同的按照id升序排列
     */
    @Test
    public void selByWrapper3() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "J")
                .or()
                .ge("age", 25)
                .orderByDesc("age")
                .orderByAsc("id");
        List<User> users = userDao.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

    /**
     * 创建日期为2019年10月16日
     * 直属上级的名字以J开头
     */
    @Test
    public void selByWrapper4() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("date_format(create_time, '%Y-%m-%d') = {0}", "2019-10-16");
        List<User> users = userDao.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
}
