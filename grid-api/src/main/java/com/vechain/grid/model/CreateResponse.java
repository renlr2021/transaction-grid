package com.vechain.grid.model;

import java.io.Serializable;

public class CreateResponse implements Serializable {

	private static final long serialVersionUID = -6221608686285926911L;

	private String token;

	/** 授权状态(AUTHING,SUCCESS,FAILUE) */
	private String status;

	/** 授权类型(SYNC:同步,ASYNC:异步) */
	private String type;

	private String requestNo;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
}
