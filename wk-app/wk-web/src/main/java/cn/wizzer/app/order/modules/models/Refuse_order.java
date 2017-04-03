package cn.wizzer.app.order.modules.models;

import org.nutz.dao.entity.annotation.*;

import java.util.Date;

/**
 * Created by Hans on 2017/3/28.
 */
@Table("refuse_order") 
public class Refuse_order {

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
    @Comment("拒单时间")
    @ColDefine(type = ColType.DATETIME)
    private Date refuse_time;
    
    @Column
    @Comment("拒单原因")
    private String refuse_reason;
    
    @Column
    @Comment("客户手机")
    private String mobile;

    @Column
    @Comment("客户姓名")
    private String name;
    
    @Column
    @Comment("接单司机ID")
    private int dj_sj_id;

    @Column
    @Comment("接单司机名")
    private String dj_sj_name;
    
    @Column  
    @Comment("接单司机手机")
    private String dj_sj_mobile;
    
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

	public Date getRefuse_time() {
		return refuse_time;
	}

	public void setRefuse_time(Date refuse_time) {
		this.refuse_time = refuse_time;
	}

	public String getRefuse_reason() {
		return refuse_reason;
	}

	public void setRefuse_reason(String refuse_reason) {
		this.refuse_reason = refuse_reason;
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
		return "Refuse_order [id=" + id + ", orderNo=" + orderNo
				+ ", refuse_time=" + refuse_time + ", refuse_reason="
				+ refuse_reason + ", order_create_user_id="
				+ order_create_user_id + ", order_create_user_name="
				+ order_create_user_name + ", update_time=" + update_time
				+ ", update_user_id=" + update_user_id + ", updatee_user_name="
				+ updatee_user_name + "]";
	}
    
    
    
}
