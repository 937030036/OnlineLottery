package com.example.onlinelottery.Service.ServiceImpl;

import com.example.onlinelottery.Dao.UserMapper;
import com.example.onlinelottery.Model.User;
import com.example.onlinelottery.Msg.TransMsg;
import com.example.onlinelottery.Service.IService.IUserHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserHandleService implements IUserHandle {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList(Integer id) {
        return userMapper.getUserListByUserMgr(id);
    }

    @Override
    public TransMsg addUser(Integer id, String name, String phone) {

        List<User> userList = userMapper.getUserListByUserMgr(id);
        int userid = 0;
        boolean id_increment_flg = true;

        for (var user : userList) {
            if (id_increment_flg) {
                userid++;
                if (user.getId() != userid)
                    id_increment_flg = false;
            }
            if (phone.equals(user.getPhone()) || name.equals(user.getName())) {
                return TransMsg.ADDUSER_FAIL;
            }
        }
        if (id_increment_flg)
            userid++;

        User user = new User();
        user.setId(userid);
        user.setPhone(phone);
        user.setName(name);
        userMapper.addUser(id, user);
        return TransMsg.ADDUSER_SUCC;
    }

    @Override
    public TransMsg deleteUser(Integer id, String name, String phone) {
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        Integer ret = userMapper.deleteUser(id, user);
        if (ret != 1) {
            return TransMsg.DELETEUSER_FAIL;
        } else {
            return TransMsg.DELETEUSER_SUUC;
        }
    }

    @Override
    public User searchUser(Integer id, String name) {
        return userMapper.gerUserByName(id, name);
    }

    @Override
    public User searchUser(String phone, Integer id) {
        return userMapper.gerUserByPhone(id, phone);
    }
}
