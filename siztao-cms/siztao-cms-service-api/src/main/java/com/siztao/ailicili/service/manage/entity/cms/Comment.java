package com.siztao.ailicili.service.manage.entity.cms;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("tab_cms_comment")
public class Comment extends Model<Comment> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private Integer outid;
	private Integer parentid;
	private Integer type;
	private String membername;
	private String email;
	private String website;
	private String content;
	@TableField("IP")
	private String ip;
	@TableField("UserAgent")
	private String UserAgent;
	private String status;
	private String sort;
	private Integer popnum;
	private Integer pushnum;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOutid() {
		return outid;
	}

	public void setOutid(Integer outid) {
		this.outid = outid;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUserAgent() {
		return UserAgent;
	}

	public void setUserAgent(String UserAgent) {
		this.UserAgent = UserAgent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getPopnum() {
		return popnum;
	}

	public void setPopnum(Integer popnum) {
		this.popnum = popnum;
	}

	public Integer getPushnum() {
		return pushnum;
	}

	public void setPushnum(Integer pushnum) {
		this.pushnum = pushnum;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Comment{" +
			"id=" + id +
			", outid=" + outid +
			", parentid=" + parentid +
			", type=" + type +
			", membername=" + membername +
			", email=" + email +
			", website=" + website +
			", content=" + content +
			", ip=" + ip +
			", UserAgent=" + UserAgent +
			", status=" + status +
			", sort=" + sort +
			", popnum=" + popnum +
			", pushnum=" + pushnum +
			"}";
	}
}
