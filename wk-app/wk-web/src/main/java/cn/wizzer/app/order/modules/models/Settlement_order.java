package cn.wizzer.app.order.modules.models;

import org.nutz.dao.entity.annotation.*;

import java.util.Date;

/**
 * Created by Hans on 2017/3/28.
 */
@Table("settlement_order") 
public class Settlement_order {

    private static final long serialVersionUID = 1L;

    @Id
    @Prev
    private Integer id;

    @Column
    @Name
    @Comment("订单号")
    @ColDefine(notNull=true,type = ColType.VARCHAR, width = 50)
    private String orderNo;

    @Column
    @Comment("订单类型")
    private int order_type;
    
    @Column
    @Comment("出发时间")
    @ColDefine(type = ColType.DATETIME)
    private Date start_time;
    
    @Column
    @Comment("预约地—-代驾地点")
    @ColDefine(notNull=true,type = ColType.VARCHAR, width = 100)
    private String dj_address;
    
    @Column
    @Comment("结算时间")
    @ColDefine(type = ColType.DATETIME)
    private Date Settlement_end_time;
    
    @Column
    @Comment("目的地")
    @ColDefine(notNull=true,type = ColType.VARCHAR, width = 100)
    private String dj_end_address;
    
    @Column
    @Comment("里程")
    private double mileage;
    
    @Column
    @Comment("等候时间_分钟")
    private int waited_time;
    
    @Column
    @Comment("应收金额")
    private double re_amount;
    
    @Column
    @Comment("实收金额")
    private double ac_amount;
    
    @Column
    @Comment("客户手机")
    private String mobile;
    
    @Column
    @Comment("客户姓名")
    private String name;
    
    @Column
    @Comment("接单司机手机")
    private String dj_sj_mobile;
    
    @Column
    @Comment("接单司机名")
    private String dj_sj_name;
    
    @Column
    @Comment("接单司机ID")
    private int dj_sj_id;
    
    @Column
    @Comment("车牌号")
    private String dj_plate_number;
    
    @Column
    @Comment("备注")
    @ColDefine(type = ColType.VARCHAR, width = 300)
    private String remark;
    
    @Column
    @Comment("是否已报单")
    @Default("0")
    private int is_check;
    
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
    @Comment("最后修改时间")
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

	public int getOrder_type() {
		return order_type;
	}

	public void setOrder_type(int order_type) {
		this.order_type = order_type;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public String getDj_address() {
		return dj_address;
	}

	public void setDj_address(String dj_address) {
		this.dj_address = dj_address;
	}

	public Date getSettlement_end_time() {
		return Settlement_end_time;
	}

	public void setSettlement_end_time(Date settlement_end_time) {
		Settlement_end_time = settlement_end_time;
	}

	public String getDj_end_address() {
		return dj_end_address;
	}

	public void setDj_end_address(String dj_end_address) {
		this.dj_end_address = dj_end_address;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public int getWaited_time() {
		return waited_time;
	}

	public void setWaited_time(int waited_time) {
		this.waited_time = waited_time;
	}

	public double getRe_amount() {
		return re_amount;
	}

	public void setRe_amount(double re_amount) {
		this.re_amount = re_amount;
	}

	public double getAc_amount() {
		return ac_amount;
	}

	public void setAc_amount(double ac_amount) {
		this.ac_amount = ac_amount;
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

	public String getDj_sj_mobile() {
		return dj_sj_mobile;
	}

	public void setDj_sj_mobile(String dj_sj_mobile) {
		this.dj_sj_mobile = dj_sj_mobile;
	}

	public String getDj_sj_name() {
		return dj_sj_name;
	}

	public void setDj_sj_name(String dj_sj_name) {
		this.dj_sj_name = dj_sj_name;
	}

	public int getDj_sj_id() {
		return dj_sj_id;
	}

	public void setDj_sj_id(int dj_sj_id) {
		this.dj_sj_id = dj_sj_id;
	}

	public String getDj_plate_number() {
		return dj_plate_number;
	}

	public void setDj_plate_number(String dj_plate_number) {
		this.dj_plate_number = dj_plate_number;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getIs_check() {
		return is_check;
	}

	public void setIs_check(int is_check) {
		this.is_check = is_check;
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
		return "Settlement_order [id=" + id + ", orderNo=" + orderNo
				+ ", order_type=" + order_type + ", start_time=" + start_time
				+ ", dj_address=" + dj_address + ", Settlement_end_time="
				+ Settlement_end_time + ", dj_end_address=" + dj_end_address
				+ ", mileage=" + mileage + ", waited_time=" + waited_time
				+ ", re_amount=" + re_amount + ", ac_amount=" + ac_amount
				+ ", mobile=" + mobile + ", name=" + name + ", dj_sj_mobile="
				+ dj_sj_mobile + ", dj_sj_name=" + dj_sj_name + ", dj_sj_id="
				+ dj_sj_id + ", dj_plate_number=" + dj_plate_number
				+ ", remark=" + remark + ", is_check=" + is_check
				+ ", order_create_time=" + order_create_time
				+ ", order_create_user_id=" + order_create_user_id
				+ ", order_create_user_name=" + order_create_user_name
				+ ", update_time=" + update_time + ", update_user_id="
				+ update_user_id + ", updatee_user_name=" + updatee_user_name
				+ "]";
	}
    
    
    
}
