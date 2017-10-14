package org.leanpoker.player.tools;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class JHttpClient {

	public InputStream Post(String url, String body) throws ClientProtocolException, IOException{
		

	    CloseableHttpClient client = HttpClients.createDefault();
		HttpUriRequest req = RequestBuilder.post(url).setEntity(new StringEntity(body)).build();
		CloseableHttpResponse res = client.execute(req);
		
		HttpEntity entity = res.getEntity();
		return entity.getContent();
	}
}
