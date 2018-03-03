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
@TableName("tab_sys_dept")
public class Dept extends Model<Dept> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer parentid;
	private String code;
	private String name;
	private String type;
	private Integer bapid;
	private String sysmark;
	private String isopen;
	private Integer sort;
	private String status;
	private String delflag;
	private Date createtime;
	private Integer createuser;
	private Date updatetime;
	private Integer updateuser;
	private String description;


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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getBapid() {
		return bapid;
	}

	public void setBapid(Integer bapid) {
		this.bapid = bapid;
	}

	public String getSysmark() {
		return sysmark;
	}

	public void setSysmark(String sysmark) {
		this.sysmark = sysmark;
	}

	public String getIsopen() {
		return isopen;
	}

	public void setIsopen(String isopen) {
		this.isopen = isopen;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Dept{" +
			"id=" + id +
			", parentid=" + parentid +
			", code=" + code +
			", name=" + name +
			", type=" + type +
			", bapid=" + bapid +
			", sysmark=" + sysmark +
			", isopen=" + isopen +
			", sort=" + sort +
			", status=" + status +
			", delflag=" + delflag +
			", createtime=" + createtime +
			", createuser=" + createuser +
			", updatetime=" + updatetime +
			", updateuser=" + updateuser +
			", description=" + description +
			"}";
	}
}
