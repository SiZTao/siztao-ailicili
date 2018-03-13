package com.siztao.queue.service.model;

/**
 * @项目名称: siztao-ailicili
 * @模块名称:
 * @类名称:
 * @类描述:
 * @创建人: SiZhenTao
 * @创建时间: 2018-03-13 10:51
 * @修改人: SiZhenTao
 * @修改时间: 2018-03-13 10:51
 * @email: 982637685@qq.com
 * @version:
 **/
public class MessageInfo {
    private Integer uuid;
    private String msg;
    private String author;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
