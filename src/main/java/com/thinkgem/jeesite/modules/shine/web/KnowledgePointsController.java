/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.shine.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.shine.entity.KnowledgePoints;
import com.thinkgem.jeesite.modules.shine.service.KnowledgePointsService;

/**
 * 知识点管理Controller
 * @author ypj
 * @version 2017-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/shine/knowledgePoints")
public class KnowledgePointsController extends BaseController {

	@Autowired
	private KnowledgePointsService knowledgePointsService;
	
	@ModelAttribute
	public KnowledgePoints get(@RequestParam(required=false) String id) {
		KnowledgePoints entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = knowledgePointsService.get(id);
		}
		if (entity == null){
			entity = new KnowledgePoints();
		}
		return entity;
	}
	
	@RequiresPermissions("shine:knowledgePoints:view")
	@RequestMapping(value = {"list", ""})
	public String list(KnowledgePoints knowledgePoints, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<KnowledgePoints> page = knowledgePointsService.findPage(new Page<KnowledgePoints>(request, response), knowledgePoints); 
		model.addAttribute("page", page);
		return "modules/shine/knowledgePointsList";
	}

	@RequiresPermissions("shine:knowledgePoints:view")
	@RequestMapping(value = "form")
	public String form(KnowledgePoints knowledgePoints, Model model) {
		model.addAttribute("knowledgePoints", knowledgePoints);
		return "modules/shine/knowledgePointsForm";
	}

	@RequiresPermissions("shine:knowledgePoints:edit")
	@RequestMapping(value = "save")
	public String save(KnowledgePoints knowledgePoints, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, knowledgePoints)){
			return form(knowledgePoints, model);
		}
		knowledgePointsService.save(knowledgePoints);
		addMessage(redirectAttributes, "保存知识点管理成功");
		return "redirect:"+Global.getAdminPath()+"/shine/knowledgePoints/?repage";
	}
	
	@RequiresPermissions("shine:knowledgePoints:edit")
	@RequestMapping(value = "delete")
	public String delete(KnowledgePoints knowledgePoints, RedirectAttributes redirectAttributes) {
		knowledgePointsService.delete(knowledgePoints);
		addMessage(redirectAttributes, "删除知识点管理成功");
		return "redirect:"+Global.getAdminPath()+"/shine/knowledgePoints/?repage";
	}

}