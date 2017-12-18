package com.bmzy.report.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.common.base.Objects;



/**   
*
* 项目名称：bigdata
* 类名称：SysRoleC
* 类描述：
* 创建人：July_whj
* 创建时间：2017：6：29 下午5:49:31
* 修改人：July_whj
* 修改时间：2017：6：29 下午5:49:31
* 修改备注：
* @version
*
*/
@Table(name = "SYS_ROLE_C")
public class SysRoleC  {
	@Id
	@GeneratedValue(generator = "UUID")
	private String id;
	@Column(name = "rolNo")
	private String rolNo;
	@Column(name = "menuNo")
	private String menuNo;
	@Column(name = "powString")
	private String powString;
	
	private int version;
	@Column(name = "createdTime")
	private Date createdTime;
	@Column(name = "lastModifidTime")
	private Date lastModifidTime;
	private boolean invalid;
	
	public SysRoleC() {

	}
	
	public String getRolNo() {
		return rolNo;
	}

	public void setRolNo(String rolNo) {
		this.rolNo = rolNo;
	}

	public String getMenuNo() {
		return menuNo;
	}


	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}

	
	public String getPowString() {
		return powString;
	}


	public void setPowString(String powString) {
		this.powString = powString;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getLastModifidTime() {
		return lastModifidTime;
	}

	public void setLastModifidTime(Date lastModifidTime) {
		this.lastModifidTime = lastModifidTime;
	}

	public boolean isInvalid() {
		return invalid;
	}

	public void setInvalid(boolean invalid) {
		this.invalid = invalid;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SysRoleC other = (SysRoleC) obj;
		return Objects.equal(this.rolNo, other.rolNo) && Objects.equal(this.menuNo, other.menuNo);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.rolNo, this.menuNo);
	}

}
