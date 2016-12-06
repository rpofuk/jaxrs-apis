package com.github.api.processor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import com.github.api.request.HttpMethod;
import com.github.api.request.JersyRestInvocator;
import com.github.api.request.RestRequest;

@RunWith(PowerMockRunner.class)
public class RequestExecutorTest {

	@Mock
	JersyRestInvocator invocator;

	
	@Test
	public void test() {		
		RestRequest request = Mockito.spy(new RestRequest());
		Mockito.when(request.getHttpMethod()).thenReturn(HttpMethod.PUT);
		Mockito.when(request.getBody()).thenReturn("empty");
		Mockito.when(invocator.sendPut(Mockito.any(),Mockito.any())).thenReturn("\"empty\"");
		
		RequestExecutor executor = new RequestExecutor(invocator);
	
		
		Object response = executor.executeRequest(request, String.class);
		
		Mockito.verify(request).getDateFormat();
	}

}
