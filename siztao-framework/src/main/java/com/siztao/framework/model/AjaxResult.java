package com.siztao.framework.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
* 项目名称：siztao-ailicili Webapp
* 类名称：AjaxResult
* 类描述：封装Ajax结果,所有Ajax请求返回类型
* 创建人：SiZhenTao
* 创建时间：2018年3月3日 下午11:40:54
* 修改人：SiZhenTao
* 修改时间：2018年3月3日 下午11:40:54
* @version 1.0.0
 */
public class AjaxResult extends HashMap<String,Object>{

	private static final long serialVersionUID = -5688982088636204446L;
	/** 返回结果 */
	private boolean success;
	
	/** 返回信息 */
	private String msg;
	
	/** 返回数据 */
	private Object data;
	
	public AjaxResult(){
		put("code",0);
	}

	public static AjaxResult error(){
		return error(500, "系统发生错误，请重试或联系管理员解决！");
	}

	public static AjaxResult error(String msg){
		return  error(500,msg);

	}
	public static AjaxResult error(int code,String msg){
		AjaxResult result = new AjaxResult();
		result.msg = msg;
		result.put("code",code);
		return  result;
	}
	public static AjaxResult ok(){
		AjaxResult result = new AjaxResult();
		result.success = true;
		result.put("code",200);
		return result;
	}

	public static AjaxResult ok(String msg){
		AjaxResult result = new AjaxResult();
		result.msg = msg;
		result.success = true;
		result.put("code",200);
		return result;
	}

	public static AjaxResult ok(Map<String ,Object> map){
		AjaxResult result = new AjaxResult();
		result.putAll(map);
		return result;
	}


	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public AjaxResult put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
