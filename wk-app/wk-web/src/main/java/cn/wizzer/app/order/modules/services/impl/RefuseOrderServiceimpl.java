package cn.wizzer.app.order.modules.services.impl;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import cn.wizzer.app.order.modules.models.Refuse_order;
import cn.wizzer.app.order.modules.services.RefuseOrderService;
import cn.wizzer.framework.base.service.BaseServiceImpl;

@IocBean(args = {"refer:dao"})
public class RefuseOrderServiceimpl  extends BaseServiceImpl<Refuse_order>  implements RefuseOrderService{

	public RefuseOrderServiceimpl(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}
	
}

