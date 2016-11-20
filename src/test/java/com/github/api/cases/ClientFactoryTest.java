package com.github.api.cases;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.ws.rs.core.Application;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.modules.junit4.PowerMockRunner;

import com.github.api.App;
import com.github.api.ClientFactory;
import com.github.api.cases.dto.SimpleGetDTO;

@RunWith(PowerMockRunner.class)
public class ClientFactoryTest {

	@Spy
	SimpleGetService service = new SimpleGetService();

	@Before
	public void init() throws ServletException {
		Set<Object> services = new HashSet<>();
		services.add(service);

		Application app = new Application() {
			public java.util.Set<Object> getSingletons() {
				return services;
			};

		};

		App.startServer(app);
	}

	@Test
	public void testResponseNotNull() {
		SimpleGetEndpoint simpleGetClient = ClientFactory.createClient(SimpleGetEndpoint.class);
		SimpleGetDTO response = simpleGetClient.listData();

		Assert.assertNotNull(response);
	}

	@Test
	public void testServerMethodCalled() {
		SimpleGetEndpoint simpleGetClient = ClientFactory.createClient(SimpleGetEndpoint.class);
		simpleGetClient.listData();

		Mockito.verify(service, Mockito.times(1)).listData();
	}

	@Test
	public void testClientNotNull() {
		SimpleGetEndpoint simpleGetClient = ClientFactory.createClient(SimpleGetEndpoint.class);
		Assert.assertNotNull(simpleGetClient);
	}

	@After
	public void stop() {
		App.stopServer();
	}

}
