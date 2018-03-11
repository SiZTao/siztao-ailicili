package com.siztao.ailicili.service.manage.entity.sys;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.siztao.framework.model.Tree;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
@TableName("tab_sys_permission")
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer parentid;
	private String parentids;
	private String code;
	private String name;
	private String href;
	private Integer appid;
	private String isopen;
	private Integer type;
	private String icons;
	private String permission;
	private Integer sort;
	private Date createtime;
	private Integer createuser;
	private Date updatetime;
	private Integer updateuser;
	private String status;
	private String delflag;
	@TableLogic
	@TableField(exist = false)
	private List<?>	list;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getParentids() {
		return parentids;
	}

	public void setParentids(String parentids) {
		this.parentids = parentids;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Integer getAppid() {
		return appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	public String getIsopen() {
		return isopen;
	}

	public void setIsopen(String isopen) {
		this.isopen = isopen;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getIcons() {
		return icons;
	}

	public void setIcons(String icons) {
		this.icons = icons;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getCreateuser() {
		return createuser;
	}

	public void setCreateuser(Integer createuser) {
		this.createuser = createuser;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
