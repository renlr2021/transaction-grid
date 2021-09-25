package com.vechain.grid.controller;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.vechain.api.BaseResponseCode;
import com.vechain.api.BaseResponseMessage;
import com.vechain.error.BizException;
import com.vechain.grid.api.ExampleApi;
import com.vechain.grid.model.CreateRequest;
import com.vechain.grid.model.CreateResponse;
import com.vechain.grid.service.ExampleService;
import com.vechain.utils.RandomUtils;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/grid")
public class ExampleController implements ExampleApi {

	private Logger logger = LoggerFactory.getLogger(ExampleController.class);

	@Autowired
	private ExampleService exampleService;

	@Override
	@ApiOperation(value = "example create session")
	public BaseResponseMessage<CreateResponse> createSession() {
		CreateRequest request = new CreateRequest();
		request.setRequestNo(RandomUtils.nextHexString(12));
		request.setAuthorizedUrl("http://192.168.50.242:8521/data");
		request.setExpire(60 * 60 * 3);
		request.setType("SYNC");
		request.setTimeout(86400);
		request.setExtraParams(this.createParams());
		this.logger.info("start example createSession request:{}", request);
		this.checkCreate(request);
		CreateResponse response = this.exampleService.createSession(request);
		this.logger.info("call example createSession service response:{}", response);
		return new BaseResponseMessage<>(response, BaseResponseCode.SUCCESS_CODE);
	}
	
	private JSONObject createParams() {
		JSONObject json = new JSONObject();
		json.put("dataId", "7");
		return json;
	}

	private void checkCreate(CreateRequest request) {
		if (StringUtils.isBlank(request.getRequestNo())) {
			throw new BizException(BaseResponseCode.ERROR_PARAMEMPTY, "requestNo");
		} else if (StringUtils.isBlank(request.getAuthorizedUrl())) {
			throw new BizException(BaseResponseCode.ERROR_PARAMEMPTY, "authorizedUrl");
		} else if (request.getTimeout() == null || request.getTimeout().intValue() <= 0) {
			throw new BizException(BaseResponseCode.ERROR_PARAMEMPTY, "timeout");
		} else if (StringUtils.isBlank(request.getType())) {
			throw new BizException(BaseResponseCode.ERROR_PARAMEMPTY, "type");
		} else if (!Arrays.asList("sync", "async").contains(request.getType().toLowerCase())) {
			throw new BizException(BaseResponseCode.ERROR_PARAMEMPTY,"type");
		}
	}
}
