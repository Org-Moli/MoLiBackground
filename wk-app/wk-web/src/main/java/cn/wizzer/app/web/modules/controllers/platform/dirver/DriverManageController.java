package cn.wizzer.app.web.modules.controllers.platform.dirver;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/3/16
 */
@IocBean
@At("/platform/driver")
public class DriverManageController {

    @At("/apply")
    @Ok("beetl:/platform/driver/apply.html")
    @RequiresAuthentication
    public void apply() {

    }

    @At("/viewDriver/?")
    @Ok("beetl:/platform/driver/view.html")
    @RequiresAuthentication
    public void viewDriver() {

    }

    @At("/drivers")
    @Ok("beetl:/platform/driver/drivers.html")
    @RequiresAuthentication
    public void drivers() {

    }

    @At("/viewDriverInfo/?")
    @Ok("beetl:/platform/driver/viewInfo.html")
    @RequiresAuthentication
    public void viewDriverInfo() {

    }

    @At("/orderList")
    @Ok("beetl:/platform/driver/order.html")
    @RequiresAuthentication
    public void order() {

    }
}
