package cn.wizzer.app.user.modules.services;

import cn.wizzer.app.user.modules.models.User_Safe;
import cn.wizzer.framework.base.service.BaseService;

public interface UserSafeService extends BaseService<User_Safe> {

    void deleteByUserId(Integer userId);
}

