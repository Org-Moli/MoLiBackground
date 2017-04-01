package cn.wizzer.app.user.modules.services.impl;

import cn.wizzer.app.user.modules.models.User_invite;
import cn.wizzer.app.user.modules.services.UserInviteService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
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
public class UserInviteServiceImpl extends BaseServiceImpl<User_invite> implements UserInviteService{
    public UserInviteServiceImpl(Dao dao)
    {
        super(dao);
    }

}
