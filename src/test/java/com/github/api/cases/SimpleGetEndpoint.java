package com.github.api.cases;

import javax.ws.rs.Path;

import com.github.api.cases.dto.SimpleGetDTO;

@Path("cases")
public interface SimpleGetEndpoint {
	
	@Path("list")
	public SimpleGetDTO listData();

}
