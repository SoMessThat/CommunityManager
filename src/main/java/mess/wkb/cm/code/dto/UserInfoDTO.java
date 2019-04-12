package mess.wkb.cm.code.dto;

import mess.wkb.cm.code.vo.CmDepartment;
import mess.wkb.cm.code.vo.CmStudent;

public class UserInfoDTO {
	/**
	 *
	 */
	private String id;

	/**
	 *   账号
	 */
	private String account;

	/**
	 *   名字
	 */
	private String username;

	/**
	 *   头像
	 */
	private String avatar;

	/**
	 *   电话
	 */
	private String tel;

	/**
	 *   创建时间
	 */
	private String creatTime;

	/**
	 *   所属部门id
	 */
	private String departmentId;

	/**
	 *   所属部门
	 */
	private CmDepartment department;

	/**
	 *   学生信息id
	 */
	private String studentId;

	/**
	 *   学生信息
	 */
	private CmStudent student;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public CmDepartment getDepartment() {
		return department;
	}

	public void setDepartment(CmDepartment department) {
		this.department = department;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public CmStudent getStudent() {
		return student;
	}

	public void setStudent(CmStudent student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "UserInfoDTO [id=" + id + ", account=" + account + ", username=" + username + ", avatar=" + avatar + ", tel="
				+ tel + ", creatTime=" + creatTime + ", departmentId=" + departmentId + ", department=" + department
				+ ", studentId=" + studentId + ", student=" + student + "]";
	}

}
