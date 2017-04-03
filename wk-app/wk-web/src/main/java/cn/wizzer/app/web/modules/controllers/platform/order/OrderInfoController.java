package cn.wizzer.app.web.modules.controllers.platform.order;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.*;

import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.base.Result;
import cn.wizzer.app.order.modules.models.Order_Info;
import cn.wizzer.app.order.modules.services.OrderInfoService;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;

import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@IocBean
@At("/platform/order")
public class OrderInfoController {
	private static final Log log = Logs.get();
	@Inject
	private OrderInfoService orderInfoService;
    
	//执行中
	@At("/running")
	@Ok("beetl:/platform/order/running/index.html")
	@RequiresAuthentication
	public void index() {
           
	}
	
	//已销单主页面
	@At("/close")
	@Ok("beetl:/platform/order/running/closeIndex.html")
	@RequiresAuthentication
	public void closeIndex() {
           
	}
	
	

	@At
	@Ok("json:full")
	@RequiresAuthentication
	public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns, Integer orderStatus) {
		 
		Cnd cnd = Cnd.NEW();
		if(orderStatus != null)
        {
            cnd.and("order_status","=",orderStatus);
        }
    	return orderInfoService.data(length, start, draw, order, columns, cnd, null);
    }

    @At
    @Ok("beetl:/platform/order/running/add.html")
    @RequiresAuthentication
    public void add() {

    }

    @At("/addDo")
    @Ok("json")
    @SLog(tag = "新建Order_Info", msg = "")
    public Object addDo(@Param("..") Order_Info orderInfo, HttpServletRequest req) {
		try {
			orderInfo.setOrderNo(createOrderNo());//生成订单
			orderInfo.setOrder_create_time(new Date());
			orderInfo.setUpdate_time(new Date());
			orderInfo.setOrder_create_user_name("测试用户");
			orderInfoService.insert(orderInfo);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/order/running/edit.html")
    @RequiresAuthentication
    public Object edit(String id) {
		return orderInfoService.fetch(id);
    }

    @At
    @Ok("json")
    @SLog(tag = "修改Order_Info", msg = "ID:${args[0].id}")
    public Object editDo(@Param("..") Order_Info orderInfo, HttpServletRequest req) {
		try {

			orderInfo.setUpdate_time(new Date());
			orderInfoService.updateIgnoreNull(orderInfo);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }


    @At({"/delete","/delete/?"})
    @Ok("json")
    @SLog(tag = "删除Order_Info", msg = "ID:${args[2].getAttribute('id')}")
    public Object delete(String id, @Param("ids") String[] ids ,HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				orderInfoService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				orderInfoService.delete(id);
    			req.setAttribute("id", id);
			}
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }


    @At("/detail/?")
    @Ok("beetl:/platform/order/running/detail.html")
    @RequiresAuthentication
	public Object detail(String id) {
		if (!Strings.isBlank(id)) {
			return orderInfoService.fetch(id);

		}
		return null;
    }
    
    
    
    
    
    private String createOrderNo(){
			int hashCodeV = UUID.randomUUID().toString().hashCode();
			if(hashCodeV < 0) {//有可能是负数
			hashCodeV = - hashCodeV;
			}
			// 0 代表前面补充0       
			// 15 代表长度为15      
			// d 代表参数为正数型 
			return new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime())+String.format("%015d", hashCodeV);
    }

}
