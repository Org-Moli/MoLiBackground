package cn.wizzer.app.order.modules.services.impl;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import cn.wizzer.app.order.modules.models.Settlement_order;
import cn.wizzer.app.order.modules.services.SettlementOrderService;
import cn.wizzer.framework.base.service.BaseServiceImpl;

@IocBean(args = {"refer:dao"})
public class SettlementOrderServiceimpl extends BaseServiceImpl<Settlement_order> implements SettlementOrderService{
	public SettlementOrderServiceimpl(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}
}

