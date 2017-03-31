package cn.wizzer.app.web.modules.controllers.platform.order;




import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.*;

import cn.wizzer.app.order.modules.models.Settlement_order;
import cn.wizzer.app.order.modules.services.impl.SettlementOrderServiceimpl;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.base.Result;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@IocBean
@At("/platform/settlement/order")
public class SettlementOrderController {
	private static final Log log = Logs.get();
	@Inject
	private SettlementOrderServiceimpl settlementOrderService;

	@At("")
	@Ok("beetl:/platform/settlement/order/index.html")
	@RequiresAuthentication
	public void index() {

	}

	@At
	@Ok("json:full")
	@RequiresAuthentication
	public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
		Cnd cnd = Cnd.NEW();
    	return settlementOrderService.data(length, start, draw, order, columns, cnd, null);
    }

    @At
    @Ok("beetl:/platform/settlement/order/add.html")
    @RequiresAuthentication
    public void add() {

    }

    @At
    @Ok("json")
    @SLog(tag = "新建Settlement_order", msg = "")
    public Object addDo(@Param("..") Settlement_order settlementOrder, HttpServletRequest req) {
		try {
			settlementOrderService.insert(settlementOrder);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/settlement/order/edit.html")
    @RequiresAuthentication
    public Object edit(String id) {
		return settlementOrderService.fetch(id);
    }

    @At
    @Ok("json")
    @SLog(tag = "修改Settlement_order", msg = "ID:${args[0].id}")
    public Object editDo(@Param("..") Settlement_order settlementOrder, HttpServletRequest req) {
		try {

			settlementOrderService.updateIgnoreNull(settlementOrder);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }


    @At({"/delete","/delete/?"})
    @Ok("json")
    @SLog(tag = "删除Settlement_order", msg = "ID:${args[2].getAttribute('id')}")
    public Object delete(String id, @Param("ids") String[] ids ,HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				settlementOrderService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				settlementOrderService.delete(id);
    			req.setAttribute("id", id);
			}
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }


    @At("/detail/?")
    @Ok("beetl:/platform/settlement/order/detail.html")
    @RequiresAuthentication
	public Object detail(String id) {
		if (!Strings.isBlank(id)) {
			return settlementOrderService.fetch(id);

		}
		return null;
    }

}
