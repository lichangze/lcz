package com.bmzy.report.model;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.Objects;


/**   
*
* 项目名称：bigdata
* 类名称：SysRoleM
* 类描述：
* 创建人：July_whj
* 创建时间�?2017�?6�?29�? 下午5:49:42
* 修改人：July_whj
* 修改时间�?2017�?6�?29�? 下午5:49:42
* 修改备注�?
* @version
*
*/
@Table(name = "SYS_ROLE_M")
public class SysRoleM  {
	@Id
	private int id;
	@Column(name = "rolNo")
	private String rolNo;
	@Column(name = "rolName")
	private String rolName;
	@Column(name = "remark")
	private String remark;

	public SysRoleM() {

	}

	public String getRolNo() {
		return rolNo;
	}

	public void setRolNo(String rolNo) {
		this.rolNo = rolNo;
	}
	
	public String getRolName() {
		return rolName;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SysRoleM other = (SysRoleM) obj;
		return Objects.equal(this.rolNo, other.rolNo) && Objects.equal(this.rolName, other.rolName) && Objects.equal(this.remark, other.remark);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.rolNo, this.rolName, this.remark);
	}

}
