package cn.wizzer.app.user.modules.services;

import cn.wizzer.app.user.modules.models.User_Info;
import cn.wizzer.framework.base.service.BaseService;

public interface UserInfoService extends BaseService<User_Info> {

    int countUser();

    User_Info findById(Integer id);

    void deleteUserById(Integer id);
}

