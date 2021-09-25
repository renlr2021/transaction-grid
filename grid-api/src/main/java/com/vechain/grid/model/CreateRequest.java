package com.vechain.grid.model;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public class CreateRequest implements Serializable {

	private static final long serialVersionUID = -6697098500561145355L;

	private String requestNo;

	private String authorizedUrl;

	private Integer timeout;

	private String type;

	private Integer expire;

	private JSONObject extraParams;

	public String getAuthorizedUrl() {
		return authorizedUrl;
	}

	public void setAuthorizedUrl(String authorizedUrl) {
		this.authorizedUrl = authorizedUrl;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public JSONObject getExtraParams() {
		return extraParams;
	}

	public void setExtraParams(JSONObject extraParams) {
		this.extraParams = extraParams;
	}

	public Integer getExpire() {
		return expire;
	}

	public void setExpire(Integer expire) {
		this.expire = expire;
	}
}
