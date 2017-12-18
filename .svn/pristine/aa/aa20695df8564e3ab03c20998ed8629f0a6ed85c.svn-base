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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bmzy.generic.core.controller.ActionBaseController;
import com.bmzy.generic.core.support.PageBaseParameter;
import com.bmzy.generic.core.support.PageGridView;
import com.bmzy.report.model.SysMenu;
import com.bmzy.report.model.SysRoleC;
import com.bmzy.report.model.SysRoleM;
import com.bmzy.report.service.ISysMenuService;
import com.bmzy.report.service.ISysRoleCService;
import com.bmzy.report.service.ISysRoleMService;
import com.bmzy.report.service.ISysUserService;
import com.bmzy.report.util.Page;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * 菜单的控制层
 * 
 */
@Controller
@RequestMapping("/sys/sysmenu")
public class SysMenuController extends ActionBaseController<PageBaseParameter> {

	@Resource
	private ISysUserService sysUserService;
	
	@Resource
	private ISysMenuService sysmenuService;
	
	@Resource
	private ISysRoleCService sysrolecService;
	
	@Resource
	private ISysRoleMService sysrolemService;
	
	
	@RequestMapping(value = "/logspage", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView matWatchUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String logid = request.getParameter("id");

		ModelAndView mav = new ModelAndView("/sys/pagelogs/sysmenulogs");
		mav.addObject("logid", logid);
		return mav;
	}
	@Override
	@RequestMapping(value = "/getColHidden", method = { RequestMethod.POST, RequestMethod.GET })
	public void getColHidden(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<String> cols = new ArrayList<String>();
		writeGridHead(response, cols);
	}
	

	

	
	// 查询菜单的表格，包括分页、搜索和排序
	@RequestMapping(value = "/getSysMenu/{id}", method = { RequestMethod.POST, RequestMethod.GET })
	public void getSysMenu(HttpServletRequest request, HttpServletResponse response, @PathVariable String id)
			throws Exception {
		request.getSession().setAttribute("fid", id);
		/*List<SysMenu> sysMenuList = sysmenuService.queryBymenuNo(id);
		String menuNo = null;
		if (id.equals("null")) {
			menuNo = "";
		} else {
			SysMenu sysMenuEntity = sysMenuList.get(0);
			String i = sysMenuEntity.getId()+"";
			SysMenu sysMenu = sysmenuService.getEntity(i);
			menuNo = sysMenu.getMenuNo();
		}*/
		String modNo;
		if (id.equals("null")) {
			modNo = "0";
		} else {
			modNo = id;
		}
		Page page = new Page(SysMenu.class);
		Example example = page.MakeSearch(request);
		page.getAnd().andEqualTo("modNo", modNo);
		List<SysMenu> queryResult = sysmenuService.selectByExample(example);
		PageGridView<SysMenu> sysMenuView = new PageGridView<SysMenu>();
		sysMenuView.setMaxResults(Page.getMaxResults());
		sysMenuView.setRows(queryResult);
		sysMenuView.setRecords(Page.getRecords());
		writeJSON(response, sysMenuView);
	}

	// 保存菜单的实体Bean
	@RequestMapping(value = "/saveSysMenu", method = { RequestMethod.POST, RequestMethod.GET })
	public void doSave(SysMenu entity, HttpServletRequest request, HttpServletResponse response) throws IOException {
		PageBaseParameter parameter = new PageBaseParameter();
		sysmenuService.save(entity);
		parameter.setSuccess(true);
		writeJSON(response, parameter);
	}

	// 保存实体Bean
	@RequestMapping(value = "/doUpdate", method = { RequestMethod.POST, RequestMethod.GET })
	public void doUpdate(SysMenu entity, HttpServletRequest request, HttpServletResponse response) throws IOException {
		PageBaseParameter parameter = new PageBaseParameter();
		sysmenuService.updateAll(entity);
		parameter.setSuccess(true);
		writeJSON(response, parameter);
	}

	// 操作菜单的删除�?�导出Excel、字段判断和保存
	@RequestMapping(value = "/operateSysMenu", method = { RequestMethod.POST, RequestMethod.GET })
	public void operateSysMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String oper = request.getParameter("oper");
		String id = request.getParameter("id");
		if (oper.equals("del")) {
			String[] ids = id.split(",");
			deleteSysMenu(request, response, ids);
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
			String menuNo = request.getParameter("menuNo");
			//menuNo = menuNo.toUpperCase();
			String menuName = request.getParameter("menuName");
			String menuClass = request.getParameter("menuClass");
			String menuAddress = request.getParameter("menuAddress");
			String menuOrder = request.getParameter("menuOrder");
			String modNo = request.getParameter("modNo");
			//modNo = modNo.toUpperCase();
			String herfTarget = request.getParameter("herfTarget");
			String remark = request.getParameter("remark");
			if (StringUtils.isBlank(modNo)) {
				modNo = "0";
			}
			SysMenu sysmenu = null;
			if (oper.equals("edit")) {
				sysmenu = sysmenuService.selectByKey(id);
			}
			Example example = new Example(SysMenu.class);
			example.createCriteria().andEqualTo("menuNo", menuNo);
			List<SysMenu> menuNoSysMenu = sysmenuService.selectByExample(example);
			Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
			Matcher m = p.matcher(menuNo);
			Matcher m1 = p.matcher(modNo);
			if (m.find()) {
				Map<String, Object> result1 = new HashMap<String, Object>();
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result1.put("message", "对不起菜单编码不能输入中文！请重输！");
				writeJSON(response, result1);
			} else if (m1.find()) {
				response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
				result.put("message", "对不起上级菜单编码不能输入中文！请重输！");
				writeJSON(response, result);
			} else if (StringUtils.isBlank(menuNo) || StringUtils.isBlank(menuName) || StringUtils.isBlank(menuClass)
					|| StringUtils.isBlank(menuAddress)) {
				response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
				result.put("message", "请填写菜单编码,菜单名称,菜单class属性,和菜单data-url属性");
				writeJSON(response, result);
			} else if (0 != menuNoSysMenu.size() && oper.equals("add")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此菜单编码已存在，请重新输入");
				writeJSON(response, result);
			} else if (0 != menuNoSysMenu.size() && !sysmenu.getMenuNo().equalsIgnoreCase(menuNo)
					&& oper.equals("edit")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此菜单编码已存在，请重新输入");
				writeJSON(response, result);
			} else if (!menuAddress.equals("0") && null == modNo) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "上级菜单编码输入有误，请重新输入");
				writeJSON(response, result);
			} else {
				SysMenu entity = new SysMenu();
				if (!id.equals("_empty")) {
					entity = sysmenuService.selectByKey(id);
				}
				entity.setMenuNo(menuNo);
				entity.setHerfTarget(herfTarget);
				entity.setMenuName(menuName);
				entity.setMenuClass(menuClass);
				entity.setMenuAddress(menuAddress);
				entity.setMenuOrder(menuOrder == "" ? null : Long.valueOf(menuOrder));
				entity.setModNo(modNo);
				entity.setRemark(remark);
				if (oper.equals("edit")) {
					doUpdate(entity, request, response);
				} else if (oper.equals("add")) {
					doSave(entity, request, response);
				}
			}
		}
	}

	// 删除菜单
	@RequestMapping("/deleteSysMenu")
	public void deleteSysMenu(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("ids") String[] ids) throws IOException {
		// boolean flag = sysmenuService.deleteByPK(ids);
		boolean flag = false;
		for (String s : ids) {
			int x  = sysmenuService.delete(s);
			if (x != 0) {
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

	// 获取菜单左侧�?
	@RequestMapping(value = "/getSysMenuTreeList/{rolNo}", method = { RequestMethod.POST, RequestMethod.GET })
	public void getSysMenuTreeList(HttpServletRequest request, HttpServletResponse response, @PathVariable String rolNo)
			throws Exception {
		StringBuilder sysmenutree = new StringBuilder();
		String strChecked = "";
		String strMenuNo = ",";
		Example example1 = new Example(SysRoleM.class);
		example1.createCriteria().andEqualTo("rolNo", rolNo);
		List<SysRoleM> sysrolem = sysrolemService.selectByExample(example1);
		Example example2 = new Example(SysRoleC.class);
		example2.createCriteria().andEqualTo("rolNo", sysrolem.get(0).getId()+"");
		List<SysRoleC> menuNo = sysrolecService.selectByExample(example2);
		for (int i = 0; i < menuNo.size(); i++) {
			strMenuNo += menuNo.get(i).getMenuNo();
			strMenuNo += ",";
		}
		sysmenutree.append("[");
		List<SysMenu> sysorgstruList = sysmenuService.selectByExample(null);
		for (int i = 0; i < sysorgstruList.size(); i++) {
			if (strMenuNo.indexOf("," + sysorgstruList.get(i).getMenuNo() + ",") != -1) {
				strChecked = ",checked:true";
			} else {
				strChecked = "";
			}
			String strUpperID = sysorgstruList.get(i).getModNo().equals("") ? "0" : sysorgstruList.get(i).getModNo();
			sysmenutree.append("{ id:\"" + sysorgstruList.get(i).getMenuNo() + "\", pId:\"" + strUpperID + "\", name:\""
					+ sysorgstruList.get(i).getMenuName() + "\"" + strChecked + "},");
		}
		sysmenutree.delete(sysmenutree.length() - 1, sysmenutree.length()).append("]");
		writeJSON(response, sysmenutree.toString());

	}

	// 获取父位置左侧树 不含名称
	@RequestMapping(value = "/getSysMenuTree", method = { RequestMethod.POST, RequestMethod.GET })
	public void getSysMenuTree(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StringBuilder sysMenutree = new StringBuilder();
		sysMenutree.append("[");
		sysMenutree.append(
				"{ id:\"" + "null" + "\", pId:\"" + "null" + "\", name:\"" + "菜单管理" + "\", open:\"" + "true" + "\"},");
		//Search s = new Search().addFilterNotEmpty("invalid");
		List<SysMenu> sysMenuList = sysmenuService.selectByExample(null);
		for (int i = 0; i < sysMenuList.size(); i++) {
			String FID = new String();
			if (sysMenuList.get(i).getModNo().equals("0")) {
				FID = "null";
			} else {
				FID = sysMenuList.get(i).getModNo();
			}
			boolean statu = false;
			sysMenutree.append("{ id:\"" + sysMenuList.get(i).getMenuNo() + "\", pId:\"" + FID + "\", name:\""
					+ sysMenuList.get(i).getMenuNo() + "\", open:\"" + statu + "\"},");
		}
		sysMenutree.delete(sysMenutree.length() - 1, sysMenutree.length()).append("]");
		writeJSON(response, sysMenutree.toString());
	}

	// 获取父位置左侧树 含有名称
	@RequestMapping(value = "/getSysMenuTree1", method = { RequestMethod.POST, RequestMethod.GET })
	public void getSysMenuTree1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StringBuilder sysMenutree = new StringBuilder();
		sysMenutree.append("[");
		sysMenutree.append(
				"{ id:\"" + "null" + "\", pId:\"" + "null" + "\", name:\"" + "菜单管理" + "\", open:\"" + "true" + "\"},");
		//Search s = new Search().addFilterNotEmpty("invalid");
		List<SysMenu> sysMenuList = sysmenuService.selectByExample(null);
		for (int i = 0; i < sysMenuList.size(); i++) {
			String FID = new String();
			if (sysMenuList.get(i).getModNo().equals("0")) {
				FID = "null";
			} else {
				FID = sysMenuList.get(i).getModNo();
			}
			boolean statu = false;
			sysMenutree.append("{ id:\"" + sysMenuList.get(i).getMenuNo() + "\", pId:\"" + FID + "\", name:\""
					+ sysMenuList.get(i).getMenuName() + " (" + sysMenuList.get(i).getMenuNo() + ")\", open:\"" + statu
					+ "\"},");
		}
		sysMenutree.delete(sysMenutree.length() - 1, sysMenutree.length()).append("]");
		writeJSON(response, sysMenutree.toString());
	}

	// 模糊查询
	@RequestMapping(value = "/fund", method = { RequestMethod.POST, RequestMethod.GET })
	public void fund(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String value = request.getParameter("value");
		String Value = this.toUpperStr(value);
		String nameStr = request.getParameter("nameStr");
		Page page = new Page(SysMenu.class);
		Example example = page.MakeSearch(request);
		Criteria and = page.getAnd();
		if (nameStr.equals("haveName")) {
			Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
			Matcher m = p.matcher(Value);
			if (m.find()) {// 中文
				and.andLike("menuName", Value);
				//queryResult = sysmenuService.queryLikemenuName(Value);
			} else {//
				and.andLike("menuNo", Value);
				//queryResult = sysmenuService.queryLikemenuNo(Value);
			}
		} else if (nameStr.equals("noHaveName")) {
			and.andLike("menuNo", Value);
			//queryResult = sysmenuService.queryLikemenuNo(Value);
		}
		List<SysMenu> queryResult = sysmenuService.selectByExample(example);
		PageGridView<SysMenu> sysMenuListView = new PageGridView<SysMenu>();
		sysMenuListView.setMaxResults(Page.getMaxResults());
		sysMenuListView.setRows(queryResult);
		sysMenuListView.setRecords(Page.getRecords());
		writeJSON(response, sysMenuListView);
	}

	private String toUpperStr(String s) {
		StringBuffer sb = new StringBuffer();
		char[] c = s.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if (c[i] >= 97) {
				sb.append((c[i] + "").toUpperCase());
			} else {
				sb.append((c[i] + ""));
			}
		}
		return sb.toString();
	}
}
