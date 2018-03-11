package com.siztao.ailicili.service.manage.entity.sys;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
@TableName("tab_sys_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String code;
	private Integer deptid;
	private Integer type;
	private Integer sort;
	private Date createtime;
	private Integer createuser;
	private Date updatetime;
	private Integer updateuser;
	private String status;
	private String delflag;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
		return "Role{" +
			"id=" + id +
			", name=" + name +
			", code=" + code +
			", deptid=" + deptid +
			", type=" + type +
			", sort=" + sort +
			", createtime=" + createtime +
			", createuser=" + createuser +
			", updatetime=" + updatetime +
			", updateuser=" + updateuser +
			", status=" + status +
			", delflag=" + delflag +
			"}";
	}
}
