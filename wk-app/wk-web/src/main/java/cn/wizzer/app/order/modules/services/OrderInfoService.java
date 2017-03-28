package cn.wizzer.app.order.modules.services;
import java.util.List;

import cn.wizzer.app.order.modules.models.Order_Info;
import cn.wizzer.app.user.modules.models.User_Info;
import cn.wizzer.framework.base.service.BaseService;

public interface OrderInfoService extends BaseService<Order_Info> {
	List<Order_Info> queryOrderInfo(int order_status);
}

