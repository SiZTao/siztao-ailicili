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
@TableName("tab_cms_category")
public class Category extends Model<Category> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String name;
    /**
     * 0 栏目 1 列表 2 外部链接
     */
	private String icons;
	private Integer type;
	private String style;
	private String isshow;
	private String status;
	private Date createtime;
	private Date updatetime;
	private Integer createuser;
	private Integer updateuser;
	private Integer menuid;
    /**
     * 自定义名称
     */
	private String alias;
	private String sort;
	private String description;
	private Integer parentid;
	private String imgbg;
	private String keywords;
	private String templatec;
	private String templatel;
	private String templated;
	private Integer pagesize;
    /**
     * 模型ID
     */
	private Integer model;
	private String href;


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

	public String getIcons() {
		return icons;
	}

	public void setIcons(String icons) {
		this.icons = icons;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getIsshow() {
		return isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
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

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
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

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getImgbg() {
		return imgbg;
	}

	public void setImgbg(String imgbg) {
		this.imgbg = imgbg;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getTemplatec() {
		return templatec;
	}

	public void setTemplatec(String templatec) {
		this.templatec = templatec;
	}

	public String getTemplatel() {
		return templatel;
	}

	public void setTemplatel(String templatel) {
		this.templatel = templatel;
	}

	public String getTemplated() {
		return templated;
	}

	public void setTemplated(String templated) {
		this.templated = templated;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Category{" +
			"id=" + id +
			", name=" + name +
			", icons=" + icons +
			", type=" + type +
			", style=" + style +
			", isshow=" + isshow +
			", status=" + status +
			", createtime=" + createtime +
			", updatetime=" + updatetime +
			", createuser=" + createuser +
			", updateuser=" + updateuser +
			", menuid=" + menuid +
			", alias=" + alias +
			", sort=" + sort +
			", description=" + description +
			", parentid=" + parentid +
			", imgbg=" + imgbg +
			", keywords=" + keywords +
			", templatec=" + templatec +
			", templatel=" + templatel +
			", templated=" + templated +
			", pagesize=" + pagesize +
			", model=" + model +
			", href=" + href +
			"}";
	}
}
