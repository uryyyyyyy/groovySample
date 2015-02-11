package com.sample.dao.http

import groovy.transform.CompileStatic
import org.apache.http.Header
import org.apache.http.HttpResponse
import org.apache.http.NameValuePair
import org.apache.http.client.config.RequestConfig
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.message.BasicHeader
import org.apache.http.message.BasicNameValuePair
import org.apache.http.util.EntityUtils

@CompileStatic
class HttpClient {

	private static CloseableHttpClient httpClient = init();

	// configurations
	private static CloseableHttpClient init(){
		int socketTimeout = 1000;
		int connectionTimeout = 1000;
		String userAgent = "My Http Client 0.1";
		// request configuration
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(connectionTimeout)
				.setSocketTimeout(socketTimeout)
				.build();
		// headers
		List<Header> headers = new ArrayList<>();
		headers.add(new BasicHeader("Accept-Charset","utf-8"));
		headers.add(new BasicHeader("Accept-Language","ja, en;q=0.8"));
		headers.add(new BasicHeader("User-Agent",userAgent));
		// create client
		return HttpClientBuilder.create()
				.setDefaultRequestConfig(requestConfig)
				.setDefaultHeaders(headers).build();
	}

	static String get(String url) throws IOException {
		HttpResponse response = httpClient.execute(new HttpGet(url));
		int responseStatus = response.getStatusLine().getStatusCode();
		return EntityUtils.toString(response.getEntity(), "UTF-8");
	}

	static String post(String url) throws IOException {
		HttpPost method = new HttpPost(url);
		List<NameValuePair> requestParams = new ArrayList<>();
		requestParams.add(new BasicNameValuePair("foo","var"));
		method.setEntity(new UrlEncodedFormEntity(requestParams));
		HttpResponse response = httpClient.execute(method);
		int responseStatus = response.getStatusLine().getStatusCode();
		return EntityUtils.toString(response.getEntity(), "UTF-8");
	}
}
