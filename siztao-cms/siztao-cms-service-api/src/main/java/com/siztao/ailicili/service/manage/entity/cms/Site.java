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
@TableName("tab_cms_site")
public class Site extends Model<Site> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String logo;
    /**
     * 网站名称
     */
	private String name;
    /**
     * 所属上级
     */
	private Integer parentid;
    /**
     * 链接地址
     */
	private String href;
    /**
     * 标题
     */
	private String title;
	private String content;
	private String about;
	private String copyright;
	private String status;
	private Date createtime;
	private Integer createuser;
	private Date updatetime;
	private Integer updateuser;
	private Integer order;
	private String ismaster;
	private String delflag;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
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

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getIsmaster() {
		return ismaster;
	}

	public void setIsmaster(String ismaster) {
		this.ismaster = ismaster;
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
		return "Site{" +
			"id=" + id +
			", logo=" + logo +
			", name=" + name +
			", parentid=" + parentid +
			", href=" + href +
			", title=" + title +
			", content=" + content +
			", about=" + about +
			", copyright=" + copyright +
			", status=" + status +
			", createtime=" + createtime +
			", createuser=" + createuser +
			", updatetime=" + updatetime +
			", updateuser=" + updateuser +
			", order=" + order +
			", ismaster=" + ismaster +
			", delflag=" + delflag +
			"}";
	}
}
