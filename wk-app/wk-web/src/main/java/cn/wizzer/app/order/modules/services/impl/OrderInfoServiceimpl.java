package cn.wizzer.app.order.modules.services.impl;
import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import cn.wizzer.app.order.modules.models.Order_Info;
import cn.wizzer.app.order.modules.services.OrderInfoService;
import cn.wizzer.framework.base.service.BaseServiceImpl;

@IocBean(args = {"refer:dao"})
public class OrderInfoServiceimpl   extends BaseServiceImpl<Order_Info> implements  OrderInfoService {

	
	public OrderInfoServiceimpl(Dao dao) {
		super(dao);
	}

	@Override
	public List<Order_Info> queryOrderInfo(int order_status) {
		// TODO Auto-generated method stub
		return null;
	}

}

