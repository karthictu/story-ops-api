package com.tantec.socials.anonymousstoryapi.beans;

import com.tantec.socials.anonymousstoryapi.constants.CommonConstants;

public class QueryString {
	
	private String queryString;
	private String field;
	private String defaultOperator;
	
	public QueryString() {
		this.queryString = "";
		this.defaultOperator = CommonConstants.OR;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	public String getdefaultOperator() {
		return defaultOperator;
	}

	public void setDefaultOperator(String defaultOperator) {
		this.defaultOperator = defaultOperator;
	}

}
