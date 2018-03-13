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
@TableName("tab_sys_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String account;
	private String password;
	private String nickname;
	private String type;
	private String realname;
	private Integer deptid;
	private String sex;
	private Date birthday;
	private String mobile;
	private String avator;
	private String email;
	private String idcard;
	private String stuffnu;
	private String position;
	private String address;
	private String weixin;
	private String description;
	private String weibo;
	private String qq;
	private String status;
	private String delflag;
	private Date createtime ;
	private Integer createuser;
	private Date updatetime;
	private Integer updateuser;
	private Integer	sort;

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAvator() {
		return avator;
	}

	public void setAvator(String avator) {
		this.avator = avator;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getStuffnu() {
		return stuffnu;
	}

	public void setStuffnu(String stuffnu) {
		this.stuffnu = stuffnu;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", account=" + account +
			", password=" + password +
			", nickname=" + nickname +
			", type=" + type +
			", realname=" + realname +
			", deptid=" + deptid +
			", sex=" + sex +
			", birthday=" + birthday +
			", mobile=" + mobile +
			", avator=" + avator +
			", email=" + email +
			", idcard=" + idcard +
			", stuffnu=" + stuffnu +
			", position=" + position +
			", address=" + address +
			", weixin=" + weixin +
			", description=" + description +
			", weibo=" + weibo +
			", qq=" + qq +
			", status=" + status +
			", delflag=" + delflag +
			", createuser=" + createuser +
			", createtime=" + createtime +
			", updatetime=" + updatetime +
			", updateuser=" + updateuser +
			"}";
	}
}
