package com.vechain.grid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vechain.api.BaseResponseCode;
import com.vechain.error.BizException;
import com.vechain.grid.core.IExampleService;
import com.vechain.grid.dao.ExampleDAO;
import com.vechain.grid.db.model.SessionEntity;
import com.vechain.grid.model.CreateRequest;
import com.vechain.grid.model.CreateResponse;
import com.vechain.grid.provider.ExampleExternalServiceProvider;
import com.vechain.utils.IDGenerator;
import com.vechain.utils.ShaUtils;

@Service
public class ExampleService implements IExampleService{

	@Autowired
	private ExampleExternalServiceProvider exampleExternalServiceProvider;

	@Autowired
	private ExampleDAO exampleDAO;

	public CreateResponse createSession(CreateRequest request) {
		SessionEntity session = this.exampleDAO.readSessionEntity(request.getRequestNo());
		if (session == null) {
			session = new SessionEntity();
			session.setRequestNo(request.getRequestNo());
			session.setSession(ShaUtils.sha1(IDGenerator.getNo()));
			session.setAuthUrl(request.getAuthorizedUrl());
			session.setExpire(request.getExpire());
			session.setType(request.getType());
			session.setStatus("AUTHING");
			session.setTimeOut(request.getTimeout());
			session.setExtraParams(request.getExtraParams().toJSONString());
			if (!this.exampleDAO.saveSessionEntity(session)) {
				throw new BizException(BaseResponseCode.ERROR_TOKENFAILURE);
			}
		}
		CreateResponse response = new CreateResponse();
		response.setToken(session.getSession());
		response.setStatus(session.getStatus());
		response.setType(session.getType());
		response.setRequestNo(session.getRequestNo());
		return response;
	}
}
