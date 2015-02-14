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
		// request configuration
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(1000)
				.setSocketTimeout(1000)
				.build();
		// headers
		def headers = [
				(Header)new BasicHeader("Accept-Charset","utf-8"),
				(Header)new BasicHeader("Accept-Language","ja, en;q=0.8"),
				(Header)new BasicHeader("User-Agent","My Http Client 0.1")
		];
		// create client
		return HttpClientBuilder.create()
				.setDefaultRequestConfig(requestConfig)
				.setDefaultHeaders(headers).build();
	}

	static String get(String url) throws IOException {
		def response = httpClient.execute(new HttpGet(url));
		int responseStatus = response.getStatusLine().getStatusCode();
		return EntityUtils.toString(response.getEntity(), "UTF-8");
	}

	static String post(String url, Object query) throws IOException {
		def method = new HttpPost(url);
		List<NameValuePair> requestParams = [(NameValuePair)new BasicNameValuePair("foo","var")];
		method.setEntity(new UrlEncodedFormEntity(requestParams));
		def response = httpClient.execute(method);
		int responseStatus = response.getStatusLine().getStatusCode();
		return EntityUtils.toString(response.getEntity(), "UTF-8");
	}
}
