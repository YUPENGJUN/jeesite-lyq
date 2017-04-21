/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.shine.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.shine.entity.KnowledgePoints;
import com.thinkgem.jeesite.modules.shine.dao.KnowledgePointsDao;

/**
 * 知识点管理Service
 * @author ypj
 * @version 2017-04-20
 */
@Service
@Transactional(readOnly = true)
public class KnowledgePointsService extends CrudService<KnowledgePointsDao, KnowledgePoints> {

	public KnowledgePoints get(String id) {
		return super.get(id);
	}
	
	public List<KnowledgePoints> findList(KnowledgePoints knowledgePoints) {
		return super.findList(knowledgePoints);
	}
	
	public Page<KnowledgePoints> findPage(Page<KnowledgePoints> page, KnowledgePoints knowledgePoints) {
		return super.findPage(page, knowledgePoints);
	}
	
	@Transactional(readOnly = false)
	public void save(KnowledgePoints knowledgePoints) {
		super.save(knowledgePoints);
	}
	
	@Transactional(readOnly = false)
	public void delete(KnowledgePoints knowledgePoints) {
		super.delete(knowledgePoints);
	}
	
}