package com.paladin.account.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author: paladin
 * @Description:
 * @date: created in 2020/8/28 0:03
 */
public class ExcelData implements Serializable {
	private static final long serialVersionUID = -7305921713161720999L;

	/**
	 * 表头
	 */
	private List<String> titles;

	/**
	 * 数据
	 */
	private List<List<Object>> rows;

	/**
	 * 页签名称
	 */
	private String name;

	public List<String> getTitles() {
		return titles;
	}

	public void setTitles(List<String> titles) {
		this.titles = titles;
	}

	public List<List<Object>> getRows() {
		return rows;
	}

	public void setRows(List<List<Object>> rows) {
		this.rows = rows;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
