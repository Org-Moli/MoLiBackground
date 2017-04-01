package cn.wizzer.app.order.modules.models;

import org.nutz.dao.entity.annotation.*;

import java.util.Date;

/**
 * Created by Hans on 2017/3/28.
 */
@Table("order_info") 
public class Order_Info {

    private static final long serialVersionUID = 1L;

    @Id
    @Prev
    private Integer id;

    @Column
    @Comment("订单号")  
    @ColDefine(notNull=true,type = ColType.VARCHAR, width = 50)
    private String orderNo;


    @Column
    @Comment("代驾地点")
    @ColDefine(notNull=true,type = ColType.VARCHAR, width = 100)
    private String dj_address;

    //代驾地点经度
    //private String dj_address_lng;
    
    //代驾地点纬度
    //private String dj_address_lat;
    
    @Column
    @Comment("代驾预约时间")
    @ColDefine(type = ColType.DATETIME)
    private Date dj_apment_time;

    @Column
    @Comment("乘车人数")
    private int num_passengers;

    @Column
    @Comment("被代驾人手机")
    private String mobile;

    @Column
    @Comment("被代驾人姓名")
    private String name;

    @Column
    @Comment("代驾订单来源")
    private String dj_order_source;

    @Column
    @Comment("代驾所属公司")
    private String dj_corporation;

    @Column
    @Comment("代驾客户经理ID")
    private int dj_manager_id;

    @Column
    @Comment("代驾客户经理名")
    private String dj_manager_name;

    @Column
    @Comment("是否订单定价")
    @Default("0")
    private int order_is_pricing;

    @Column
    @Comment("定价金额")  
    @Default("0")  
    @ColDefine(customType="double",type=ColType.AUTO,width=15,precision=2)    
    private Double order_pricing_amount;

    @Column
    @Comment("订单备注")
    private String order_remark;

    @Column
    @Comment("订单状态")
    private int order_status;

    @Column
    @Comment("订单类型")
    private int order_type;

    @Column
    @Comment("接单司机ID")
    private int dj_sj_id;

    @Column
    @Comment("接单司机名")
    private String dj_sj_name;

    @Column
    @Comment("销单原因")
    private String cancel_reamk;

    @Column
    @Comment("订单创建时间")
    @ColDefine(type = ColType.DATETIME)
    private Date order_create_time;

    @Column
    @Comment("订单创建人ID")
    private int order_create_user_id;

    @Column
    @Comment("订单创建人name")
    private String order_create_user_name;

    @Column
    @Comment("订单最后修改时间")
    @ColDefine(type = ColType.DATETIME)
    private Date update_time;

    @Column
    @Comment("最后修改人ID")
    private int update_user_id;

    @Column
    @Comment("最后修改人name")
    private String updatee_user_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getDj_address() {
		return dj_address;
	}

	public void setDj_address(String dj_address) {
		this.dj_address = dj_address;
	}

	public Date getDj_apment_time() {
		return dj_apment_time;
	}

	public void setDj_apment_time(Date dj_apment_time) {
		this.dj_apment_time = dj_apment_time;
	}

	public int getNum_passengers() {
		return num_passengers;
	}

	public void setNum_passengers(int num_passengers) {
		this.num_passengers = num_passengers;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDj_order_source() {
		return dj_order_source;
	}

	public void setDj_order_source(String dj_order_source) {
		this.dj_order_source = dj_order_source;
	}

	public String getDj_corporation() {
		return dj_corporation;
	}

	public void setDj_corporation(String dj_corporation) {
		this.dj_corporation = dj_corporation;
	}

	public int getDj_manager_id() {
		return dj_manager_id;
	}

	public void setDj_manager_id(int dj_manager_id) {
		this.dj_manager_id = dj_manager_id;
	}

	public String getDj_manager_name() {
		return dj_manager_name;
	}

	public void setDj_manager_name(String dj_manager_name) {
		this.dj_manager_name = dj_manager_name;
	}

	public int getOrder_is_pricing() {
		return order_is_pricing;
	}

	public void setOrder_is_pricing(int order_is_pricing) {
		this.order_is_pricing = order_is_pricing;
	}

	public Double getOrder_pricing_amount() {
		return order_pricing_amount;
	}

	public void setOrder_pricing_amount(Double order_pricing_amount) {
		this.order_pricing_amount = order_pricing_amount;
	}

	public String getOrder_remark() {
		return order_remark;
	}

	public void setOrder_remark(String order_remark) {
		this.order_remark = order_remark;
	}

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	public int getOrder_type() {
		return order_type;
	}

	public void setOrder_type(int order_type) {
		this.order_type = order_type;
	}

	public int getDj_sj_id() {
		return dj_sj_id;
	}

	public void setDj_sj_id(int dj_sj_id) {
		this.dj_sj_id = dj_sj_id;
	}

	public String getDj_sj_name() {
		return dj_sj_name;
	}

	public void setDj_sj_name(String dj_sj_name) {
		this.dj_sj_name = dj_sj_name;
	}

	public String getCancel_reamk() {
		return cancel_reamk;
	}

	public void setCancel_reamk(String cancel_reamk) {
		this.cancel_reamk = cancel_reamk;
	}

	public Date getOrder_create_time() {
		return order_create_time;
	}

	public void setOrder_create_time(Date order_create_time) {
		this.order_create_time = order_create_time;
	}

	public int getOrder_create_user_id() {
		return order_create_user_id;
	}

	public void setOrder_create_user_id(int order_create_user_id) {
		this.order_create_user_id = order_create_user_id;
	}

	public String getOrder_create_user_name() {
		return order_create_user_name;
	}

	public void setOrder_create_user_name(String order_create_user_name) {
		this.order_create_user_name = order_create_user_name;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public int getUpdate_user_id() {
		return update_user_id;
	}

	public void setUpdate_user_id(int update_user_id) {
		this.update_user_id = update_user_id;
	}

	public String getUpdatee_user_name() {
		return updatee_user_name;
	}

	public void setUpdatee_user_name(String updatee_user_name) {
		this.updatee_user_name = updatee_user_name;
	}

	@Override
	public String toString() {
		return "Order_Info [id=" + id + ", orderNo=" + orderNo
				+ ", dj_address=" + dj_address + ", dj_apment_time="
				+ dj_apment_time + ", num_passengers=" + num_passengers
				+ ", mobile=" + mobile + ", name=" + name
				+ ", dj_order_source=" + dj_order_source + ", dj_corporation="
				+ dj_corporation + ", dj_manager_id=" + dj_manager_id
				+ ", dj_manager_name=" + dj_manager_name
				+ ", order_is_pricing=" + order_is_pricing
				+ ", order_pricing_amount=" + order_pricing_amount
				+ ", order_remark=" + order_remark + ", order_status="
				+ order_status + ", order_type=" + order_type + ", dj_sj_id="
				+ dj_sj_id + ", dj_sj_name=" + dj_sj_name + ", cancel_reamk="
				+ cancel_reamk + ", order_create_time=" + order_create_time
				+ ", order_create_user_id=" + order_create_user_id
				+ ", order_create_user_name=" + order_create_user_name
				+ ", update_time=" + update_time + ", update_user_id="
				+ update_user_id + ", updatee_user_name=" + updatee_user_name
				+ "]";
	}

    
    
    
}
