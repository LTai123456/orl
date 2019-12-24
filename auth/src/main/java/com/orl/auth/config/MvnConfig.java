package com.orl.auth.config;

import java.nio.charset.Charset;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * mvc 基础配置类
 * @author lt
 *
 */
public class MvnConfig extends WebMvcConfigurerAdapter{

	/**
	 * 解决中文乱码问题
	 */
	@Bean
	public StringHttpMessageConverter messageConverter() {
		StringHttpMessageConverter convert = new StringHttpMessageConverter();
		convert.setDefaultCharset(Charset.forName("UTF-8"));
		return convert;
	}
	
}
