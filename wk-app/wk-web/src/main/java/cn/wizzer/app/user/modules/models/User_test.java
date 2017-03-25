package cn.wizzer.app.user.modules.models;

import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/3/25
 */
@Table("user_test")
public class User_test implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Prev
    private Integer id;

    @Name
    @Column
    @Comment("名称")
    private String name;

    @Column
    @Comment("密码")
    private String password;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
