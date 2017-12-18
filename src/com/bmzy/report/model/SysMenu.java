package com.bmzy.report.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bmzy.report.util.SupperModel;
import com.google.common.base.Objects;


/**   
*
* 项目名称：bigdata
* 类名称：SysMenu
* 类描述：
* 创建人：July_whj
* 创建时间2017：6：29 下午5:45:58
* 修改人：July_whj
* 修改时间：2017：6：29 下午5:45:58
* 修改备注：
* @version
*
*/
@Table(name = "SYS_MENU")
public class SysMenu extends SupperModel {

	/**
	 * 菜单编码
	 */
	
	@Column(name = "menuNo")
	private String menuNo;
	/**
	 * 菜单名称
	 */
	@Column(name = "menuName")
	private String menuName;
	/**
	 * 菜单属性
	 */
	@Column(name = "menuClass")
	private String menuClass;
	/**
	 * 菜单地址ַ
	 */
	@Column(name = "menuAddress")
	private String menuAddress;
	/**
	 * 排序
	 */
	@Column(name = "menuOrder")
	private Long menuOrder;
	/**
	 * 父级菜单
	 */
	@Column(name = "modNo")
	private String modNo;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 打开方式
	 */
	@Column(name = "herfTarget")
	private String herfTarget;
	@Transient
	private List<SysMenu> subSysMenuList;

	public String getHerfTarget() {
		return herfTarget;
	}

	public void setHerfTarget(String herfTarget) {
		this.herfTarget = herfTarget;
	}

	// private List<SysMenu> subSysMenuList;
	public String getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuClass() {
		return menuClass;
	}

	public void setMenuClass(String menuClass) {
		this.menuClass = menuClass;
	}

	public String getMenuAddress() {
		return menuAddress;
	}

	public void setMenuAddress(String menuAddress) {
		this.menuAddress = menuAddress;
	}

	public Long getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(Long menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getModNo() {
		return modNo;
	}

	public void setModNo(String modNo) {
		this.modNo = modNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public SysMenu() {

	}


	public List<SysMenu> getSubSysMenuList() {
		return subSysMenuList;
	}

	public void setSubSysMenuList(List<SysMenu> subSysMenuList) {
		this.subSysMenuList = subSysMenuList;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SysMenu other = (SysMenu) obj;
		return Objects.equal(this.menuNo, other.menuNo) && Objects.equal(this.menuName, other.menuName)
				&& Objects.equal(this.menuClass, other.menuClass) && Objects.equal(this.menuAddress, other.menuAddress)
				&& Objects.equal(this.menuOrder, other.menuOrder) && Objects.equal(this.modNo, other.modNo)
				&& Objects.equal(this.remark, other.remark);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.menuNo, this.menuName, this.menuClass, this.menuAddress, this.menuOrder,
				this.modNo, this.remark);
	}

}
