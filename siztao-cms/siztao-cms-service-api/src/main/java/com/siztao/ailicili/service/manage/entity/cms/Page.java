package com.siztao.ailicili.service.manage.entity.cms;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-13
 */
@TableName("tab_cms_page")
public class Page extends Model<Page> {

    private static final long serialVersionUID = 1L;
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String title;
	private String content;
	private String author;
	private String description;
	private String status;
	private String delflag;
	private Date createtime;
	private Integer createuser;
	private Date updatetime;
	private Integer updateuser;
	private Integer type;
	private String keywords;
	private String imgurl;
	private String alias;
	private String viewtemplate;
	private Integer sort;
	private Integer readnum;
	private Integer commentnum;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getViewtemplate() {
		return viewtemplate;
	}

	public void setViewtemplate(String viewtemplate) {
		this.viewtemplate = viewtemplate;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getReadnum() {
		return readnum;
	}

	public void setReadnum(Integer readnum) {
		this.readnum = readnum;
	}

	public Integer getCommentnum() {
		return commentnum;
	}

	public void setCommentnum(Integer commentnum) {
		this.commentnum = commentnum;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Page{" +
			"id=" + id +
			", title=" + title +
			", content=" + content +
			", author=" + author +
			", description=" + description +
			", status=" + status +
			", delflag=" + delflag +
			", createtime=" + createtime +
			", createuser=" + createuser +
			", updatetime=" + updatetime +
			", updateuser=" + updateuser +
			", type=" + type +
			", keywords=" + keywords +
			", imgurl=" + imgurl +
			", alias=" + alias +
			", viewtemplate=" + viewtemplate +
			", sort=" + sort +
			", readnum=" + readnum +
			", commentnum=" + commentnum +
			"}";
	}
}
