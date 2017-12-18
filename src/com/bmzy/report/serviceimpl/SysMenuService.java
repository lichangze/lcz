package com.bmzy.report.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bmzy.report.baseService.BaseService;
import com.bmzy.report.dao.ISysMenuDao;
import com.bmzy.report.dao.ISysRoleCDao;
import com.bmzy.report.model.SysMenu;
import com.bmzy.report.model.SysRoleC;
import com.bmzy.report.service.ISysMenuService;

import tk.mybatis.mapper.entity.Example;




/**   
*
* 项目名称：bigdata
* 类名称：SysMenuService
* 类描述：
* 创建人：July_whj
* 创建时间�?2017�?6�?29�? 下午4:11:54
* 修改人：July_whj
* 修改时间�?2017�?6�?29�? 下午4:11:54
* 修改备注�?
* @version
*
*/
@Service
public class SysMenuService extends BaseService<SysMenu> implements ISysMenuService {

	@Resource
	private ISysMenuDao sysMenuDao;
	
	@Resource
	private ISysRoleCDao sysRoleDao;
	
	
	public List<SysMenu> queryAllMenuList(String[] sysRoleLists, List<SysMenu> mainMenuList) {
		
		List<SysRoleC> roleAuthorityList = new ArrayList<SysRoleC>();
		for(int i=0;i<sysRoleLists.length;i++){
			Example example = new Example(SysRoleC.class);
			example.createCriteria().andEqualTo("rolNo", sysRoleLists[i]);
			List<SysRoleC> list = sysRoleDao.selectByExample(example);
			if(list.size()!=0){
				roleAuthorityList.addAll(list);
			}
		}
		
		List<String> menuNoList = new ArrayList<String>();
		for (int j = 0; j < roleAuthorityList.size(); j++) {
			menuNoList.add(roleAuthorityList.get(j).getMenuNo());
		}
		HashSet<String> hs = new HashSet<String>(menuNoList);
		List<SysMenu> sysmenuList = new ArrayList<SysMenu>();
		for (SysMenu entity : mainMenuList) {
			SysMenu sysmenu = new SysMenu();
			sysmenu.setId(entity.getId());
			sysmenu.setMenuNo(entity.getMenuNo());
			sysmenu.setMenuName(entity.getMenuName());
			sysmenu.setMenuClass(entity.getMenuClass());
			sysmenu.setMenuAddress(entity.getMenuAddress());
			sysmenu.setMenuOrder(entity.getMenuOrder());
			sysmenu.setModNo(entity.getModNo());
			sysmenu.setRemark(entity.getRemark());
			
			Example example = new Example(SysMenu.class);
			example.createCriteria().andEqualTo("modNo", entity.getMenuNo());
			List<SysMenu> subSysMenuList = sysMenuDao.selectByExample(example);
			List<SysMenu> resultSubSysMenuList = new ArrayList<SysMenu>();
			for (int i = 0; i < subSysMenuList.size(); i++) {
				if (hs.contains(subSysMenuList.get(i).getMenuNo())) {
					resultSubSysMenuList.add(subSysMenuList.get(i));
				}
			}
			if (subSysMenuList.size() == 0) {
				sysmenuList.add(null);
			} else {
				sysmenu.setSubSysMenuList(resultSubSysMenuList);
			}
			if(!sysmenuList.contains(sysmenu)){
				sysmenuList.add(sysmenu);
			}
		}		
		return sysmenuList;
	}
}
