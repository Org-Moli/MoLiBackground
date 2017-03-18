package cn.wizzer.app.web.modules.controllers.platform.my;

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
@At("/platform/my")
public class MyInfoController {

    @At("/wallet")
    @Ok("beetl:/platform/my/wallet.html")
    @RequiresAuthentication
    public void wallet() {

    }

    @At("/invoice")
    @Ok("beetl:/platform/my/invoice.html")
    @RequiresAuthentication
    public void invoice() {

    }

    @At("/friendRequest")
    @Ok("beetl:/platform/my/friendRequest.html")
    @RequiresAuthentication
    public void friendRequest() {

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
