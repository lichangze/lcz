package com.bmzy.report.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * 项目名称：bigdata 类名称：SysUser 类描述： 创建人：July_whj 创建时间: 2017:6:29 下午3:20:48
 * 修改人：July_whj 修改时间: 2017:6:29 下午3:20:48 修改备注:
 * 
 * @version
 *
 */
@Table(name = "HR_USER_EMP")
public class SysUser {
	@Id
	@Column(name = "EMP_NO")
	private String emp_no;
	@Column(name = "EMP_CATEGORY")
	private String emp_category;
	@Column(name = "DEPT_NO")
	private String dept_no;
	@Column(name = "COMP_NO")
	private int comp_no;
	@Column(name = "EMP_NAME")
	private String emp_name;
	@Column(name = "ID_CODE")
	private String id_code;
	@Column(name = "P_C_NO")
	private String p_c_no;
	@Column(name = "SAL_SN")
	private String sal_sn;
	@Column(name = "WORK_TYPE")
	private String work_type;
	@Column(name = "E_STEP")
	private String e_step;
	
	@Column(name = "POST_NO")
	private String post_no;
	@Column(name = "POST_LEVEL")
	private String post_level;
	@Column(name = "PS_NO")
	private String ps_no;
	@Column(name = "F_GENDER")
	private String f_gender;
	@Column(name = "F_BIRTHDAY")
	private Timestamp f_birthday;
	@Column(name = "F_EMAIL")
	private String f_email;
	@Column(name = "F_ADDRESS")
	private String f_address;
	@Column(name = "F_HOME_PHONE")
	private String f_home_phone;
	@Column(name = "F_OFFICE_PHONE")
	private String f_office_phone;
	
	
	@Column(name = "F_CELL")
	private String f_cell;
	@Column(name = "F_ACTU_SERVICE")
	private int f_actu_service;
	@Column(name = "F_POLITICAL_ID")
	private String f_political_id;
	@Column(name = "F_FOLK_ID")
	private String f_folk_id;
	@Column(name = "F_EMP_TYPE_ID")
	private String f_emp_type_id;
	@Column(name = "F_HIGH_TECH_ID")
	private String f_high_tech_id;
	
	
	@Column(name = "F_EMP_TECH")
	private String f_emp_tech;
	@Column(name = "F_NAME_NUM")
	private String f_name_num;
	@Column(name = "CREATETIME")
	private Timestamp createtime;
	@Column(name = "LASTUPDATETIME")
	private Timestamp lastupdatetime;
	@Column(name = "EMPID")
	private String empid;
	@Column(name = "ENTRYDATE")
	private Timestamp entrydate;
	@Column(name = "F_NAME")
	private String f_name;
	@Column(name = "F_CERTIFICATENAME")
	private String f_certificatename;
	@Column(name = "MEMO")
	private String memo;
	@Column(name = "DEPTNO")
	private String deptno;
	@Column(name = "POSTNO")
	private String postno;
	
	public String getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	public String getEmp_category() {
		return emp_category;
	}
	public void setEmp_category(String emp_category) {
		this.emp_category = emp_category;
	}
	public String getDept_no() {
		return dept_no;
	}
	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}
	public int getComp_no() {
		return comp_no;
	}
	public void setComp_no(int comp_no) {
		this.comp_no = comp_no;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getId_code() {
		return id_code;
	}
	public void setId_code(String id_code) {
		this.id_code = id_code;
	}
	public String getP_c_no() {
		return p_c_no;
	}
	public void setP_c_no(String p_c_no) {
		this.p_c_no = p_c_no;
	}
	public String getSal_sn() {
		return sal_sn;
	}
	public void setSal_sn(String sal_sn) {
		this.sal_sn = sal_sn;
	}
	public String getWork_type() {
		return work_type;
	}
	public void setWork_type(String work_type) {
		this.work_type = work_type;
	}
	public String getE_step() {
		return e_step;
	}
	public void setE_step(String e_step) {
		this.e_step = e_step;
	}
	public String getPost_no() {
		return post_no;
	}
	public void setPost_no(String post_no) {
		this.post_no = post_no;
	}
	public String getPost_level() {
		return post_level;
	}
	public void setPost_level(String post_level) {
		this.post_level = post_level;
	}
	public String getPs_no() {
		return ps_no;
	}
	public void setPs_no(String ps_no) {
		this.ps_no = ps_no;
	}
	public String getF_gender() {
		return f_gender;
	}
	public void setF_gender(String f_gender) {
		this.f_gender = f_gender;
	}
	public Timestamp getF_birthday() {
		return f_birthday;
	}
	public void setF_birthday(Timestamp f_birthday) {
		this.f_birthday = f_birthday;
	}
	public String getF_email() {
		return f_email;
	}
	public void setF_email(String f_email) {
		this.f_email = f_email;
	}
	public String getF_address() {
		return f_address;
	}
	public void setF_address(String f_address) {
		this.f_address = f_address;
	}
	public String getF_home_phone() {
		return f_home_phone;
	}
	public void setF_home_phone(String f_home_phone) {
		this.f_home_phone = f_home_phone;
	}
	public String getF_office_phone() {
		return f_office_phone;
	}
	public void setF_office_phone(String f_office_phone) {
		this.f_office_phone = f_office_phone;
	}
	public String getF_cell() {
		return f_cell;
	}
	public void setF_cell(String f_cell) {
		this.f_cell = f_cell;
	}
	public int getF_actu_service() {
		return f_actu_service;
	}
	public void setF_actu_service(int f_actu_service) {
		this.f_actu_service = f_actu_service;
	}
	public String getF_political_id() {
		return f_political_id;
	}
	public void setF_political_id(String f_political_id) {
		this.f_political_id = f_political_id;
	}
	public String getF_folk_id() {
		return f_folk_id;
	}
	public void setF_folk_id(String f_folk_id) {
		this.f_folk_id = f_folk_id;
	}
	public String getF_emp_type_id() {
		return f_emp_type_id;
	}
	public void setF_emp_type_id(String f_emp_type_id) {
		this.f_emp_type_id = f_emp_type_id;
	}
	public String getF_high_tech_id() {
		return f_high_tech_id;
	}
	public void setF_high_tech_id(String f_high_tech_id) {
		this.f_high_tech_id = f_high_tech_id;
	}
	public String getF_emp_tech() {
		return f_emp_tech;
	}
	public void setF_emp_tech(String f_emp_tech) {
		this.f_emp_tech = f_emp_tech;
	}
	public String getF_name_num() {
		return f_name_num;
	}
	public void setF_name_num(String f_name_num) {
		this.f_name_num = f_name_num;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Timestamp getLastupdatetime() {
		return lastupdatetime;
	}
	public void setLastupdatetime(Timestamp lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public Timestamp getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(Timestamp entrydate) {
		this.entrydate = entrydate;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_certificatename() {
		return f_certificatename;
	}
	public void setF_certificatename(String f_certificatename) {
		this.f_certificatename = f_certificatename;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getPostno() {
		return postno;
	}
	public void setPostno(String postno) {
		this.postno = postno;
	}
	
	
}
