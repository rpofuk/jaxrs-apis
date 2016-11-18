package com.github.api;

import javax.servlet.ServletException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.api.cases.SimpleGetEndpoint;
import com.github.api.cases.dto.SimpleGetDTO;

public class ClientFactoryTest {

	@BeforeClass
	public static void init() throws ServletException {
		App.startServer();
	}

	
	@Test
	public void testResponseNotNull() {
		SimpleGetEndpoint simpleGetClient = ClientFactory.createClient(SimpleGetEndpoint.class);
		SimpleGetDTO response = simpleGetClient.listData();
		
		Assert.assertNotNull(response);
	}

	@Test
	public void testClientNotNull() {
		SimpleGetEndpoint simpleGetClient = ClientFactory.createClient(SimpleGetEndpoint.class);		
		Assert.assertNotNull(simpleGetClient);
	}

	@After
	public void stop() {

	}

}
