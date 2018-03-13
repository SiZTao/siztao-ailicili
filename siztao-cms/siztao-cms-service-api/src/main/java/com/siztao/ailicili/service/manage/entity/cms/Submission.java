package com.siztao.ailicili.service.manage.entity.cms;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.sql.Blob;
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
@TableName("tab_cms_submission")
public class Submission extends Model<Submission> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 自定义url
     */
	private String href;
    /**
     * 文章标题
     */
	private String title;
    /**
     * 栏目ID
     */
	private Integer categoryid;
    /**
     * 菜单ID
     */
	private Integer menuid;
	private Integer template;
    /**
     * 作者
     */
	private String author;
	private String fromurl;
    /**
     * 缩略图
     */
	private String image;
    /**
     * 关键字
     */
	private String keywords;
    /**
     * 描述
     */
	private String description;
	private Integer type;
    /**
     * 是否允许评论
     */
	private Integer allowcomments;
    /**
     * 内容
     */
	private Blob content;
	private Integer memberid;
    /**
     * 浏览次数
     */
	private Integer readnumber;
    /**
     * 收藏次数
     */
	private Integer collectnumber;
    /**
     * 点踩次数
     */
	private Integer hitenum;
    /**
     * 点赞次数
     */
	private Integer pushnum;
	private Integer scored;
	private Date createtime;
	private Integer sort;
	private Date updatetime;
	private String style;
	private String status;
	private String tags;
	private Integer createuser;
	private Integer updateuser;
    /**
     * 发布时间
     */
	private Date publictime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public Integer getTemplate() {
		return template;
	}

	public void setTemplate(Integer template) {
		this.template = template;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFromurl() {
		return fromurl;
	}

	public void setFromurl(String fromurl) {
		this.fromurl = fromurl;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getAllowcomments() {
		return allowcomments;
	}

	public void setAllowcomments(Integer allowcomments) {
		this.allowcomments = allowcomments;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public Integer getReadnumber() {
		return readnumber;
	}

	public void setReadnumber(Integer readnumber) {
		this.readnumber = readnumber;
	}

	public Integer getCollectnumber() {
		return collectnumber;
	}

	public void setCollectnumber(Integer collectnumber) {
		this.collectnumber = collectnumber;
	}

	public Integer getHitenum() {
		return hitenum;
	}

	public void setHitenum(Integer hitenum) {
		this.hitenum = hitenum;
	}

	public Integer getPushnum() {
		return pushnum;
	}

	public void setPushnum(Integer pushnum) {
		this.pushnum = pushnum;
	}

	public Integer getScored() {
		return scored;
	}

	public void setScored(Integer scored) {
		this.scored = scored;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getCreateuser() {
		return createuser;
	}

	public void setCreateuser(Integer createuser) {
		this.createuser = createuser;
	}

	public Integer getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(Integer updateuser) {
		this.updateuser = updateuser;
	}

	public Date getPublictime() {
		return publictime;
	}

	public void setPublictime(Date publictime) {
		this.publictime = publictime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Submission{" +
			"id=" + id +
			", href=" + href +
			", title=" + title +
			", categoryid=" + categoryid +
			", menuid=" + menuid +
			", template=" + template +
			", author=" + author +
			", fromurl=" + fromurl +
			", image=" + image +
			", keywords=" + keywords +
			", description=" + description +
			", type=" + type +
			", allowcomments=" + allowcomments +
			", content=" + content +
			", memberid=" + memberid +
			", readnumber=" + readnumber +
			", collectnumber=" + collectnumber +
			", hitenum=" + hitenum +
			", pushnum=" + pushnum +
			", scored=" + scored +
			", createtime=" + createtime +
			", sort=" + sort +
			", updatetime=" + updatetime +
			", style=" + style +
			", status=" + status +
			", tags=" + tags +
			", createuser=" + createuser +
			", updateuser=" + updateuser +
			", publictime=" + publictime +
			"}";
	}
}
