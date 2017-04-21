/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.shine.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.shine.entity.KnowledgePoints;

/**
 * 知识点管理DAO接口
 * @author ypj
 * @version 2017-04-20
 */
@MyBatisDao
public interface KnowledgePointsDao extends CrudDao<KnowledgePoints> {
	
}