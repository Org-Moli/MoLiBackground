package cn.wizzer.app.web.modules.controllers.platform.user;

import cn.wizzer.app.user.modules.models.User_Info;
import cn.wizzer.app.user.modules.services.UserInfoService;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.base.Result;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@IocBean
@At("/platform/user/info")
public class UserInfoController {
	private static final Log log = Logs.get();
	@Inject
	private UserInfoService userInfoService;

    @At
    @Ok("json:full")
    @RequiresAuthentication
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        return userInfoService.data(length, start, draw, order, columns, cnd, null);
    }

	@At("")
	@Ok("beetl:/platform/user/info/index.html")
	@RequiresAuthentication
	public void index() {

	}

    @At
    @Ok("beetl:/platform/user/info/add.html")
    @RequiresPermissions("user.manager.driver.add")
    @RequiresAuthentication()
    public void add() {
    }

    @At
    @Ok("json")
    @SLog(tag = "新建司机工号[${args[0].jobNumber}]", msg = "")
    public Object addDo(@Param("..") User_Info userInfo, HttpServletRequest req) {
		try {
            int count = userInfoService.countUser();
            String jobNumber = "DR" + String.format("%6d", count + 1).replace(" ", "0");
            userInfo.setJobNumber(jobNumber);
			userInfoService.insert(userInfo);
			return Result.success("system.success");
		} catch (Exception e) {
            e.printStackTrace();
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/user/info/edit.html")
    @RequiresAuthentication
    public Object edit(String id) {
		return userInfoService.fetch(id);
    }

    @At
    @Ok("json")
    @SLog(tag = "修改User_Info", msg = "ID:${args[0].id}")
    public Object editDo(@Param("..") User_Info userInfo, HttpServletRequest req) {
		try {

			userInfoService.updateIgnoreNull(userInfo);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }


    @At({"/delete","/delete/?"})
    @Ok("json")
    @SLog(tag = "删除User_Info", msg = "ID:${args[2].getAttribute('id')}")
    public Object delete(String id, @Param("ids") String[] ids ,HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				userInfoService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				userInfoService.delete(id);
    			req.setAttribute("id", id);
			}
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }


    @At("/detail/?")
    @Ok("beetl:/platform/user/info/detail.html")
    @RequiresAuthentication
	public Object detail(String id) {
		if (!Strings.isBlank(id)) {
			return userInfoService.fetch(id);

		}
		return null;
    }

}
