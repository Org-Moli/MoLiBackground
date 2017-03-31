package cn.wizzer.app.user.modules.services.impl;

import cn.wizzer.app.user.modules.models.User_Safe;
import cn.wizzer.app.user.modules.services.UserSafeService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/3/22
 */
@IocBean(args = {"refer:dao"})
public class UserSafeServiceImpl extends BaseServiceImpl<User_Safe> implements UserSafeService{
    public UserSafeServiceImpl(Dao dao)
    {
        super(dao);
    }

    @Override
    public void deleteByUserId(Integer userId)
    {
        User_Safe user_safe = (User_Safe) this.query(Cnd.where("userId","=",userId));
        dao().delete(user_safe);
    }
}
