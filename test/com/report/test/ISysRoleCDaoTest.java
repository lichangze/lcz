package com.report.test;


import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.json.Json;

import org.apache.xmlbeans.impl.xb.xsdschema.NarrowMaxMin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.dao.ISysRoleCDao;
import com.bmzy.report.dao.ISysRoleMDao;
import com.bmzy.report.model.SysRoleC;
import com.bmzy.report.model.SysUser;
import com.bmzy.report.service.ISysRoleCService;
import com.bmzy.report.service.ISysUserRoleService;
import com.bmzy.report.service.ISysUserService;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ISysRoleCDaoTest {

	@Resource
	private ISysRoleCService sysdao;
	
	@Resource
	private ISysRoleMDao sysmdao;
	
	@Resource
	private ISysUserRoleService sysUserRole;
	@Resource
	private ISysUserService sysuser;
	
	@Test
	public void test() {
		Example example = new Example(SysUser.class);
		/*List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(3);*/
		Criteria c = example.createCriteria();
		c.andLike("emp_name", "%王%");
		c = example.or();
		c.andLike("emp_name", "%张%");
		System.out.println(c.getCriteria());
        System.out.println("****************");
		PageHelper.startPage(1, 10);
		List<SysUser> list = sysuser.selectByExample(example);
		System.out.println(list.size());
		for (SysUser sysRoleC : list) {
			System.out.println(sysRoleC.getEmp_name());
		}
//		SysRoleC s = new SysRoleC();
//		s.setMenuNo("test21");
//		s.setPowString("12");
//		s.setRolNo("1");
//		s.setInvalid(true);
//		sysdao.save(s);
	}
	

	
}
