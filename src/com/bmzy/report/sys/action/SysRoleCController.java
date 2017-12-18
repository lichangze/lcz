package com.bmzy.report.sys.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bmzy.generic.core.controller.ActionBaseController;
import com.bmzy.generic.core.support.PageBaseParameter;
import com.bmzy.report.model.SysRoleC;
import com.bmzy.report.model.SysRoleM;
import com.bmzy.report.service.ISysRoleCService;
import com.bmzy.report.service.ISysRoleMService;

import tk.mybatis.mapper.entity.Example;


/**
 * 角色权限的控制层
 * 
 */
@Controller
@RequestMapping("/sys/sysrolec")
public class SysRoleCController extends ActionBaseController<PageBaseParameter> {

	@Resource
	private ISysRoleMService sysRoleMService;
	@Resource
	private ISysRoleCService sysRoleCService;
	
	
	@Override
	@RequestMapping(value="/getColHidden",method={ RequestMethod.POST,RequestMethod.GET })
	public void getColHidden(HttpServletRequest request,HttpServletResponse response) throws IOException{
	}

	/**
	 * 保存角色权限
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/saveSysRoleC")
	public void saveRoleAuthority(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String rolNo = request.getParameter("rolNo");
		rolNo = rolNo.replaceAll(" ", "");
		rolNo.toUpperCase();
		String menuNo = request.getParameter("CheckedNodes");
		Example example = new Example(SysRoleM.class);
		example.createCriteria().andEqualTo("rolNo", rolNo);
		SysRoleM sysrolem = sysRoleMService.selectByExample(example).get(0);
		Example example1 = new Example(SysRoleC.class);
		example1.createCriteria().andEqualTo("rolNo", sysrolem.getId()+"");
		List<SysRoleC> list = sysRoleCService.selectByExample(example1);
		for(SysRoleC sysRoleC:list){
			sysRoleCService.delete(sysRoleC.getId());
		}
		String[] menuNosValue = menuNo.split(",");
		for (int i = 0; i < menuNosValue.length; i++) {
			SysRoleC sysrolec = new SysRoleC();
			sysrolec.setRolNo(sysrolem.getId()+"");
			sysrolec.setMenuNo(menuNosValue[i]);
			sysRoleCService.save(sysrolec);
		}
	
		writeJSON(response, "");
	}

}
