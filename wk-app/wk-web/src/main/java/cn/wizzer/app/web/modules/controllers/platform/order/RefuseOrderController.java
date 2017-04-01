package cn.wizzer.app.web.modules.controllers.platform.order;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import cn.wizzer.app.order.modules.models.Refuse_order;
import cn.wizzer.app.order.modules.services.impl.RefuseOrderServiceimpl;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.base.Result;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;

@IocBean
@At("/platform/refuse/order")
public class RefuseOrderController {
	private static final Log log = Logs.get();
	@Inject
	private RefuseOrderServiceimpl refuseOrderService;

	@At("/index")
	@Ok("beetl:/platform/order/refuse/order/index.html")
	@RequiresAuthentication
	public void index() {

	}

	@At
	@Ok("json:full")
	@RequiresAuthentication
	public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
		Cnd cnd = Cnd.NEW();
    	return refuseOrderService.data(length, start, draw, order, columns, cnd, null);
    }

    @At
    @Ok("beetl:/platform/order/refuse/order/add.html")
    @RequiresAuthentication
    public void add() {

    }

    @At
    @Ok("json")
    @SLog(tag = "新建Refuse_order", msg = "")
    public Object addDo(@Param("..") Refuse_order refuseOrder, HttpServletRequest req) {
		try {
			refuseOrderService.insert(refuseOrder);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/order/refuse/order/edit.html")
    @RequiresAuthentication
    public Object edit(String id) {
		return refuseOrderService.fetch(id);
    }

    @At
    @Ok("json")
    @SLog(tag = "修改Refuse_order", msg = "ID:${args[0].id}")
    public Object editDo(@Param("..") Refuse_order refuseOrder, HttpServletRequest req) {
		try {
			refuseOrderService.updateIgnoreNull(refuseOrder);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }


    @At({"/delete","/delete/?"})
    @Ok("json")
    @SLog(tag = "删除Refuse_order", msg = "ID:${args[2].getAttribute('id')}")
    public Object delete(String id, @Param("ids") String[] ids ,HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				refuseOrderService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				refuseOrderService.delete(id);
    			req.setAttribute("id", id);
			}
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }


    @At("/detail/?")
    @Ok("beetl:/platform/order/refuse/order/detail.html")
    @RequiresAuthentication
	public Object detail(String id) {
		if (!Strings.isBlank(id)) {
			return refuseOrderService.fetch(id);

		}
		return null;
    }

}
