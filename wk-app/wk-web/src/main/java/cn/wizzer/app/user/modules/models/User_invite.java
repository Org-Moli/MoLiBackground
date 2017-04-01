package cn.wizzer.app.user.modules.models;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/4/1
 */
@Table("user_invite")
public class User_invite implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Prev
    private Integer id;

    @Column
    private Integer userId;

    @Column
    private Integer inviteId;

    @Column
    private Date inviteTime;

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

    public Integer getInviteId()
    {
        return inviteId;
    }

    public void setInviteId(Integer inviteId)
    {
        this.inviteId = inviteId;
    }

    public Date getInviteTime()
    {
        return inviteTime;
    }

    public void setInviteTime(Date inviteTime)
    {
        this.inviteTime = inviteTime;
    }
}
