package com.bmzy.report.sys.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bmzy.generic.core.controller.ActionBaseController;
import com.bmzy.generic.core.support.PageBaseParameter;
import com.bmzy.report.model.SysRoleM;
import com.bmzy.report.model.SysUserRole;
import com.bmzy.report.service.ISysRoleCService;
import com.bmzy.report.service.ISysRoleMService;
import com.bmzy.report.service.ISysUserRoleService;

import tk.mybatis.mapper.entity.Example;

@Controller
@RequestMapping("/sys/userroleaccess")
public class UserRoleAccessContoller extends ActionBaseController<PageBaseParameter>{

	//转换json�?
	private Integer count = 1;
	

	@Resource
	private ISysRoleMService sysRoleMService;
	@Resource
	private ISysRoleCService sysRoleCService;
	@Resource
	private ISysUserRoleService sysUserRoleService;


	private String userRoleJson(List<SysRoleM> roleList) {
		StringBuffer json = new StringBuffer();
		json.append("{\"recordsTotal\": "+roleList.size()+
				",\"recordsFiltered\": "+roleList.size()+",\"data\": [");
		for(SysRoleM entity : roleList){
			json.append("{\"id\":"+(count++)+",\"rolName\":\""+entity.getRolName()+"\"},");
		}
		json = new StringBuffer(json.substring(0,json.length() - 1));
		json.append("]}");
		count = 1;
		return json.toString();
	}

	private String userRoleJson(List<SysUserRole> userRoleList,List<SysRoleM> roleList) {
		StringBuffer json = new StringBuffer();
		json.append("{\"recordsTotal\": "+(userRoleList.size()+roleList.size())+
				",\"recordsFiltered\": "+(userRoleList.size()+roleList.size())+",\"data\": [");
		for(SysUserRole entity : userRoleList){
			SysRoleM sysRolem = sysRoleMService.selectByKey(entity.getRoleId());
			//if(sysRolem.size()>0){
				json.append("{\"id\":"+(count++)+",\"rolName\":\""+entity.getRolName()+"\",\"rolNo\":\""+sysRolem.getRolNo()+"\",\"checked\":\"true\""+"},");
			//}
		}
		for(SysRoleM entity : roleList){
			json.append("{\"id\":"+(count++)+",\"rolName\":\""+entity.getRolName()+"\",\"rolNo\":\""+entity.getRolNo()+"\"},");
		}
		json = new StringBuffer(json.substring(0,json.length() - 1));
		json.append("]}");
		count = 1;
		return json.toString();
	}
	

	@RequestMapping(value="/getRoleNameList",method={ RequestMethod.POST,RequestMethod.GET })
	public void getRoleNameList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userNo = request.getParameter("userId");
		List<SysUserRole> userRoleList = new ArrayList<SysUserRole>();
		Example example = new Example(SysUserRole.class);
		example.createCriteria().andEqualTo("userNo", userNo);
		userRoleList = sysUserRoleService.selectByExample(example);
	
		List<SysRoleM> roleList = sysRoleMService.selectByExample(null);
		List<SysRoleM> repeatRole = new ArrayList<SysRoleM>();
		String json = "";
		if( userRoleList != null){
			for(SysUserRole entity : userRoleList){
				for(SysRoleM role : roleList){
					if(entity.getRoleId().equals(role.getId()+"")){
						entity.setRolName(role.getRolName());
						repeatRole.add(role);
						break;
					}
				}
			}
			roleList.removeAll(repeatRole);
			json = userRoleJson(userRoleList, roleList);
			writeJSON(response, json);
		} else {
			json = userRoleJson(roleList);
			writeJSON(response, json);
		}
		
	}

	@Override
	@RequestMapping(value="/getColHidden",method={ RequestMethod.POST,RequestMethod.GET })
	public void getColHidden(HttpServletRequest arg0, HttpServletResponse arg1) throws IOException {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		writeJSON(arg1, list);
	}
	
	
	
	//接收前台传过来的参数：需要修改的userNo，访问组，权限组
	@RequestMapping(value="/saveUserIsRoleAndAccess",method={ RequestMethod.POST,RequestMethod.GET })
	public void saveUserIsRoleAndAccess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userNo = request.getParameter("userNo");
		String checkedRoleStr = request.getParameter("checkedRole");
			String[] checkedRoleNames = checkedRoleStr.split(",");
			compareRole(userNo, checkedRoleNames);
	}
	
	private void compareRole(String userNo, String[] checkedRoleNames) {
		Example example = new Example(SysUserRole.class);
		example.createCriteria().andEqualTo("userNo", userNo);
		List<SysUserRole> oldUserRoleList = sysUserRoleService.selectByExample(example);
		List<SysUserRole> repeatUserRoleList = new ArrayList<SysUserRole>();
		if (oldUserRoleList.size() > 0) {
			deleteUserRole(oldUserRoleList);
		}
		for (String name : checkedRoleNames) {
			if (null != name && "" != name && name.length() != 0) {
				SysUserRole sysUserRole = new SysUserRole();
				sysUserRole.setRolName(name);
				sysUserRole.setUserNo(userNo);
				Example example1 = new Example(SysUserRole.class);
				example1.createCriteria().andEqualTo("rolNo", name);
				sysUserRole.setRoleId(sysRoleMService.selectByExample(example1).get(0).getId()+"");
				repeatUserRoleList.add(sysUserRole);
			}
		}
		if (repeatUserRoleList.size() > 0) {
			addUserRole(repeatUserRoleList);
		}
	}
	
	private void deleteUserRole(List<SysUserRole> userRoleList){
		for(SysUserRole entity : userRoleList){
			sysUserRoleService.delete(entity.getRoleId());
		}
	}
	private void addUserRole(List<SysUserRole> userRoleList){
		for(SysUserRole entity : userRoleList){
			Example example = new Example(SysUserRole.class);
			example.createCriteria().andEqualTo("userNo", entity.getUserNo());
			example.createCriteria().andEqualTo("roleId", entity.getRoleId());
			List<SysUserRole> selectByExample = sysUserRoleService.selectByExample(example);
			if(selectByExample.size()>0){
				
			}else{
				sysUserRoleService.save(entity);
			}
		}
	}
	
}
