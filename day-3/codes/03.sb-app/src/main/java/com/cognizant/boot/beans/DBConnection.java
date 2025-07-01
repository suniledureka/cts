package com.cognizant.boot.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties

//@PropertySource("dbconfig.properties")
//@PropertySource(value =  "dbconfig.properties")
@PropertySource(value = "classpath:dbconfig.properties")
@ConfigurationProperties(prefix = "jdbc")
public class DBConnection {
	// @Value("${driverClassName}")
	private String driverClassName;
	private String url;
	private String usrName;
	private String password;

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsrName(String userName) {
		this.usrName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DBConnection [driverClassName=" + driverClassName + ", url=" + url + ", userName=" + usrName
				+ ", password=" + password + "]";
	}

}
