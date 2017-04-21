/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.shine.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 知识点管理Entity
 * @author ypj
 * @version 2017-04-20
 */
public class KnowledgePoints extends DataEntity<KnowledgePoints> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 标题
	private String url;		// 指向URL
	private String annexUrl;		// 相关附件URL
	private String knowledgeContent;		// 知识内容
	private String status;		// 状态
	private String column1;		// 备用字段1
	private String column2;		// column2
	
	public KnowledgePoints() {
		super();
	}

	public KnowledgePoints(String id){
		super(id);
	}

	@Length(min=0, max=255, message="标题长度必须介于 0 和 255 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=255, message="指向URL长度必须介于 0 和 255 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Length(min=0, max=255, message="相关附件URL长度必须介于 0 和 255 之间")
	public String getAnnexUrl() {
		return annexUrl;
	}

	public void setAnnexUrl(String annexUrl) {
		this.annexUrl = annexUrl;
	}
	
	@Length(min=0, max=4000, message="知识内容长度必须介于 0 和 4000 之间")
	public String getKnowledgeContent() {
		return knowledgeContent;
	}

	public void setKnowledgeContent(String knowledgeContent) {
		this.knowledgeContent = knowledgeContent;
	}
	
	@Length(min=0, max=255, message="状态长度必须介于 0 和 255 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=255, message="备用字段1长度必须介于 0 和 255 之间")
	public String getColumn1() {
		return column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	
	@Length(min=0, max=255, message="column2长度必须介于 0 和 255 之间")
	public String getColumn2() {
		return column2;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
	}
	
}