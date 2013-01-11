package com.hut.domain.vo;

/*
 * 树节点实体对象
 */
public class TreeNode {
	private String id;
	private String text;
	private Boolean leaf = true; // 是否子叶子节点，默认是
	//private String cls; // 图标
	//private String iconCls;
	private String url = null; // 请求路径
	//private String model;
	private Boolean expanded = false; // 展开
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Boolean getLeaf() {
		return leaf;
	}
	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getExpanded() {
		return expanded;
	}
	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}
}
