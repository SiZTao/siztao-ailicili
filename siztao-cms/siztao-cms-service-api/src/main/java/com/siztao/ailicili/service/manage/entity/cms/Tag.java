package com.siztao.ailicili.service.manage.entity.cms;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-13
 */
@TableName("tab_cms_tag")
public class Tag extends Model<Tag> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String name;
	private String description;
	private String icon;
	private Integer type;
	private String alias;
	private Date createtime;
	private Date updatetime;
	private Integer updateuser;
	private Integer createuser;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(Integer updateuser) {
		this.updateuser = updateuser;
	}

	public Integer getCreateuser() {
		return createuser;
	}

	public void setCreateuser(Integer createuser) {
		this.createuser = createuser;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Tag{" +
			"id=" + id +
			", name=" + name +
			", description=" + description +
			", icon=" + icon +
			", type=" + type +
			", alias=" + alias +
			", createtime=" + createtime +
			", updatetime=" + updatetime +
			", updateuser=" + updateuser +
			", createuser=" + createuser +
			"}";
	}
}
