package com.bmzy.report.sys.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bmzy.generic.core.controller.ActionBaseController;
import com.bmzy.generic.core.support.PageBaseParameter;
import com.bmzy.generic.core.support.PageGridView;
import com.bmzy.report.model.SysUser;
import com.bmzy.report.service.IHROrgDeptService;
import com.bmzy.report.service.ISysUserService;
import com.bmzy.report.util.Page;

import tk.mybatis.mapper.entity.Example;

/**
 * 用户的控制层
 */

@Controller
@RequestMapping("/sys/sysuser")
public class SysUserController extends ActionBaseController<PageBaseParameter> {

	final static String loginSuccess = "0x00000000";// 登陆成功
	final static String updPassword1 = "0x00010004";// 要修改密
	final static String updPassword2 = "0x00010005";// 要修改密

	@Resource
	private ISysUserService sysUserService;
	@Resource
	private IHROrgDeptService hrOrgDept;
	
	

	@Override
	@RequestMapping(value = "/getColHidden", method = { RequestMethod.POST, RequestMethod.GET })
	public void getColHidden(HttpServletRequest request, HttpServletResponse response) throws IOException {
	}

	// 登录
	@RequestMapping("/login")
	public void login(SysUser sysUserModel, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		SysUser sysUser = new SysUser();
		sysUser.setEmp_no("00100020");
		sysUser.setF_cell("13810276762");
		sysUser.setEmp_name("王华颖");
		
		System.out.println("-------");
		
		//sysUser.setEmail("deram@163.com");
		/*List<SysUser> list = sysUserService.queryAll();
		if (list.size() > 0) {
			sysUser = list.get(0);*/
			HttpSession session = request.getSession();
			//System.out.println(sysUser.getUserName() + "===" + sysUser.getEmail());
			session.setAttribute(SESSION_SYS_USER, sysUser);
			session.setAttribute(SESSION_SYS_USER_ID, sysUser.getEmp_no());
			session.setAttribute("IP", getRemoteHost(request));
		/*} else {
			HttpSession session = request.getSession();
			session.setAttribute(SESSION_SYS_USER, sysUser);
			session.setAttribute(SESSION_SYS_USER_ID, sysUser.getId());
			detail = "success";
		}*/
		//sysUserService.save(sysUser);
		writeJSON(response, "success");
	}

	// 登出
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute(SESSION_SYS_USER);
		request.getSession().removeAttribute("userAuthorization");
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
	@RequestMapping("/getSysUser")
	public void getSysUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Page page = new Page(SysUser.class);
		Example example = page.MakeSearch(request);
		List<SysUser> queryResult = sysUserService.selectByExample(example);
		for (SysUser sysUser : queryResult) {
			sysUser.setDept_no(hrOrgDept.selectByKey(sysUser.getDeptno()).getDept_name());
		}
		
		PageGridView<SysUser> lineList = new PageGridView<>();
		lineList.setMaxResults(Page.getMaxResults());
		lineList.setRows(queryResult);
		lineList.setRecords(Page.getRecords());
		writeJSON(response, lineList);
		
	}

	public String getRemoteHost(javax.servlet.http.HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

}
