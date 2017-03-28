package cn.wizzer.app.user.modules.services.impl;

import cn.wizzer.app.user.modules.models.User_Info;
import cn.wizzer.app.user.modules.services.UserInfoService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import java.util.List;

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
public class UserInfoServiceImpl extends BaseServiceImpl<User_Info> implements UserInfoService{
    public UserInfoServiceImpl(Dao dao)
    {
        super(dao);
    }

    @Override
    public int countUser()
    {
        return this.count("user_info");
    }

    @Override
    public List<User_Info> listUserInfoBySysUnitId(Integer sysUnitId)
    {
        return this.query(Cnd.where("sysUnitId", "=", sysUnitId).and("workStatus","=",1).and("userStatus","=",1));
    }
}
