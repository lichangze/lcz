package com.bmzy.report.sys.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bmzy.generic.core.controller.ActionBaseController;
import com.bmzy.generic.core.support.PageBaseParameter;
import com.bmzy.generic.core.support.PageGridView;
import com.bmzy.report.model.SysRoleM;
import com.bmzy.report.service.ISysRoleCService;
import com.bmzy.report.service.ISysRoleMService;

import tk.mybatis.mapper.entity.Example;


/**
 * 角色的控制层
 * 
 */
@Controller
@RequestMapping("/sys/sysrolem")
public class SysRoleMController extends ActionBaseController<PageBaseParameter> {

	@Resource
	private ISysRoleMService sysRoleMService;
	@Resource
	private ISysRoleCService sysRoleCService;
	
	@Override
	@RequestMapping(value="/getColHidden",method={ RequestMethod.POST,RequestMethod.GET })
	public void getColHidden(HttpServletRequest request,HttpServletResponse response) throws IOException{
		List<String> cols = new ArrayList<String>();
		writeGridHead(response, cols);
	}

	//查询角色的表格，包括分页、搜索和排序
	@RequestMapping(value = "/getSysRoleM", method = { RequestMethod.POST, RequestMethod.GET })
	public void getSysRoleM(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*Search s =new Search();
		s=FilterToSearch.MakeSearch(request);*/
		String same = null;
		List<SysRoleM> queryResult = sysRoleMService.selectByExample(null);
		PageGridView<SysRoleM> sysRoleMListView = new PageGridView<SysRoleM>();
		//sysRoleMListView.setMaxResults(s.getMaxResults());
		//List<SysRoleM> sysRoleMCnList = queryResult.getResult();
		sysRoleMListView.setRows(queryResult);
		//sysRoleMListView.setRecords(queryResult.getTotalCount());
		writeJSON(response, sysRoleMListView);
	}

	//保存角色的实体Bean
	@RequestMapping(value = "/saveSysRoleM", method = { RequestMethod.POST, RequestMethod.GET })
	public void doSave(SysRoleM entity, HttpServletRequest request, HttpServletResponse response) throws IOException {
		PageBaseParameter parameter = new PageBaseParameter();//((PageBaseParameter) entity);
		sysRoleMService.save(entity);
		parameter.setSuccess(true);
		writeJSON(response, parameter);
	}

	//更新角色的实体Bean
	@RequestMapping(value = "/doUpdate", method = { RequestMethod.POST, RequestMethod.GET })
	public void doUpdate(SysRoleM entity, HttpServletRequest request, HttpServletResponse response) throws IOException {
		PageBaseParameter parameter =new PageBaseParameter();//((PageBaseParameter) entity);
		sysRoleMService.updateAll(entity);
		parameter.setSuccess(true);
		writeJSON(response, parameter);
	}
	
	//操作角色的删除�?导出Excel、字段判断和保存
	@RequestMapping(value = "/operateSysRoleM", method = { RequestMethod.POST, RequestMethod.GET })
	public void operateSysRoleM(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String oper = request.getParameter("oper");
		String id = request.getParameter("id");
		if (oper.equals("del")) {
			String[] ids = id.split(",");
			deleteSysRoleM(request, response, ids);
		} else if (oper.equals("excel")) {
			response.setContentType("application/msexcel;charset=UTF-8");
			try {
				response.addHeader("Content-Disposition", "attachment;filename=file.xls");
				OutputStream out = response.getOutputStream();
				out.write(request.getParameter("csvBuffer").getBytes());
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Map<String, Object> result = new HashMap<String, Object>();
			String rolNo= request.getParameter("rolNo");
			rolNo = rolNo.toUpperCase();
			rolNo = rolNo.replaceAll(" ", "");
			String rolName = request.getParameter("rolName");
			rolName = rolName.replaceAll(" ", "");
			String remark = request.getParameter("remark");
			SysRoleM role = null;
			if (oper.equals("edit")) {
				role = sysRoleMService.selectByKey(id);
			}
			Example example = new Example(SysRoleM.class);
			example.createCriteria().andEqualTo("rolNo", rolNo);
			List<SysRoleM> rolNoRole = sysRoleMService.selectByExample(example);
			Example example2 = new Example(SysRoleM.class);
			example2.createCriteria().andEqualTo("rolName", rolName);
			List<SysRoleM> rolNameRole = sysRoleMService.selectByExample(example);
			Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		    Matcher m = p.matcher(rolNo);
		    if (m.find()){
		    	Map<String, Object> result1 = new HashMap<String, Object>();
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result1.put("message", "对不起角色编码不能输入中文！请重�?");
				writeJSON(response, "对不起角色编码不能输入中文！请重�?");
	        }else if (StringUtils.isBlank(rolName)||StringUtils.isBlank(rolNo)) {
				response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
				result.put("message", "请填写角色编码和角色名称");
				writeJSON(response, "请填写角色编码和角色名称");
			} 
			else if (rolNameRole.size()>0 && oper.equals("add")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "角色名称已存�?");
				writeJSON(response, "角色名称已存�?");
			}
			else if (rolNoRole.size()>0 && oper.equals("add")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "角色编码已存�?");
				writeJSON(response, "角色编码已存�?");
			}
			else if (rolNoRole.size()>0 && !role.getRolNo().equalsIgnoreCase(rolNo) && oper.equals("edit")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此角色编码已存在，请重新输入");
				writeJSON(response, "此角色编码已存在，请重新输入");
			}
			else if (rolNameRole.size()>0 && !role.getRolName().equalsIgnoreCase(rolName) && oper.equals("edit")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此角色名称已存在，请重新输入");
				writeJSON(response, "此角色名称已存在，请重新输入");
			}
			else {
				if (oper.equals("edit")) {
					SysRoleM entity = sysRoleMService.selectByKey(id);
					entity.setRolNo(rolNo);
					entity.setRolName(rolName);
					entity.setRemark(remark);
					doUpdate(entity, request, response);
				} else if (oper.equals("add")) {
					SysRoleM entity = new SysRoleM();
					entity.setRolNo(rolNo);
					entity.setRolName(rolName);
					entity.setRemark(remark);
					doSave(entity, request, response);
				}
			}
		}
	}

	//删除角色
	@RequestMapping("/deleteSysRoleM")
	public void deleteSysRoleM(HttpServletRequest request, HttpServletResponse response, @RequestParam("ids") String[] ids) throws IOException {
		boolean flag = false;
		for(String s:ids){
			 int delete = sysRoleMService.delete(s);
			if(delete != 0){
				flag = true;
				break;
			}
		}
		if (flag) {
			writeJSON(response, "{success:true}");
		} else {
			writeJSON(response, "{success:false}");
		}
	}

	//获取角色名称的下拉框
	 @RequestMapping(value = "/getSysRoleMList", method = {RequestMethod.POST, RequestMethod.GET})
		public void getClassList(HttpServletRequest request,
				HttpServletResponse response) throws Exception
		{
	    	
			List<SysRoleM> sysRoleMList = sysRoleMService.selectByExample(null);
			StringBuilder builder = new StringBuilder();
			builder.append("<select>");
			for(int i = 0; i < sysRoleMList.size(); i++)
			{
				builder.append("<option value='"+sysRoleMList.get(i).getRolNo()+
						"'>"+sysRoleMList.get(i).getRolName()+"</option>");
			}
			builder.append("<select>");
			writeJSON(response, builder.toString());
		}
}
