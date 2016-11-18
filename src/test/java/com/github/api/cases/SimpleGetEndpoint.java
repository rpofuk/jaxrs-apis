package com.github.api.cases;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.github.api.cases.dto.SimpleGetDTO;

@Path("cases")
@Produces("application/json")
@Consumes("application/json")
public interface SimpleGetEndpoint {

	@GET
	@Path("list")
	public SimpleGetDTO listData();

}
