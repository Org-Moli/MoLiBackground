package cn.wizzer.app.user.modules.models;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.Table;

import java.io.Serializable;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/3/31
 */
@Table("user_safe")
public class User_Safe implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Prev
    private Integer id;

    @Column
    private Integer userId;

    @Column
    private String security_key;

    @Column
    private String api_key;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getSecurity_key()
    {
        return security_key;
    }

    public void setSecurity_key(String security_key)
    {
        this.security_key = security_key;
    }

    public String getApi_key()
    {
        return api_key;
    }

    public void setApi_key(String api_key)
    {
        this.api_key = api_key;
    }
}
