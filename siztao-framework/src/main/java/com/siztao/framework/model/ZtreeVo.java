package com.siztao.framework.model;

import java.io.Serializable;

/**
 * @项目名称: siztao-ailicili
 * @模块名称:
 * @类名称:
 * @类描述:
 * @创建人: SiZhenTao
 * @创建时间: 2018-03-12 20:22
 * @修改人: SiZhenTao
 * @修改时间: 2018-03-12 20:22
 * @email: 982637685@qq.com
 * @version:
 **/
public class ZtreeVo implements Serializable{
    private static final long serialVersionUID = -566337220075461882L;


    private String id;
    private String pId;
    private String name;
    private boolean open;
    private boolean checked;
    private boolean isParent;
    private boolean chkDisabled;


    public boolean getChkDisabled() {
        return chkDisabled;
    }

    public void setChkDisabled(boolean chkDisabled) {
        this.chkDisabled = chkDisabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean isParent) {
        this.isParent = isParent;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
