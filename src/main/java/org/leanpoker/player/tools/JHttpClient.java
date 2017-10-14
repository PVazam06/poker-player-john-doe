package org.leanpoker.player.tools;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.JsonElement;

public class JHttpClient {

	private CloseableHttpClient client = HttpClients.createDefault();

	public InputStream Post(String url, String body) throws IOException {

		System.out.println("http body: "+ body);
		
		StringEntity stringEntity = new StringEntity(body);
	    int timeout = 5;
	    RequestConfig config = RequestConfig.custom()
	      .setConnectTimeout(timeout * 100)
	      .setConnectionRequestTimeout(timeout * 100)
	      .setSocketTimeout(timeout * 100).build();

	    HttpUriRequest req = RequestBuilder.post(url).setConfig(config).setEntity(stringEntity).build();


		CloseableHttpResponse res;
		try {
			res = client.execute(req);
		} catch (IOException e) {
			System.out.println("http request faild " +e.getMessage());
			e.printStackTrace();
			throw e;
		}
		
		HttpEntity entity = res.getEntity();
		System.out.println("http status code: " +res.getStatusLine().getStatusCode());
		
		return entity.getContent();
	}

}
