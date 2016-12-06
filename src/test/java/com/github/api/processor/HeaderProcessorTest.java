package com.github.api.processor;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.powermock.modules.junit4.PowerMockRunner;

import com.github.api.request.RestRequest;

@RunWith(PowerMockRunner.class)
public class HeaderProcessorTest {

	@Spy
	HeaderProcessor processor = new HeaderProcessor();
	
	@Test
	public void testHeaders() {
		RestRequest request = new RestRequest();
		Map<String, String> headers = new HashMap<>();
		headers.put("t1", "v1");
		
		processor.process(headers, request);
		
		Assert.assertTrue(request.getHeaders().size() > 0);				
	}

}
