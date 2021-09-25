package com.vechain.grid.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.vechain.api.BaseResponseMessage;
import com.vechain.grid.model.CreateResponse;

@FeignClient(name = "grid-service", path = "/v1/grid", url = "${grid.service.url:}")
public interface ExampleApi {

	@GetMapping("/create")
	BaseResponseMessage<CreateResponse> createSession();

}
