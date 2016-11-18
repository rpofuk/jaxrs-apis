package com.github.api.cases;

import com.github.api.cases.dto.SimpleGetDTO;

public class SimpleGetService implements SimpleGetEndpoint {

	@Override
	public SimpleGetDTO listData() {
		SimpleGetDTO response = new SimpleGetDTO();
		response.setId(1);
		response.setName("T1");
		return response;
	}

}
