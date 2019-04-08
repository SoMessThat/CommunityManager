package mess.wkb.cm.code.vo;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table cm_user
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class CmUser implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_user.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     * Database Column Remarks:
     *   账号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_user.account
     *
     * @mbg.generated
     */
    private String account;

    /**
     * Database Column Remarks:
     *   名字
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_user.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     * Database Column Remarks:
     *   密码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_user.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     * Database Column Remarks:
     *   头像
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_user.avatar
     *
     * @mbg.generated
     */
    private String avatar;

    /**
     * Database Column Remarks:
     *   电话
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_user.tel
     *
     * @mbg.generated
     */
    private String tel;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_user.creat_time
     *
     * @mbg.generated
     */
    private String creatTime;

    /**
     * Database Column Remarks:
     *   状态
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_user.state
     *
     * @mbg.generated
     */
    private String state;

    /**
     * Database Column Remarks:
     *   所属部门
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_user.department_id
     *
     * @mbg.generated
     */
    private String departmentId;

    /**
     * Database Column Remarks:
     *   学生信息
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_user.student_id
     *
     * @mbg.generated
     */
    private String studentId;

    /**
     * Database Column Remarks:
     *   角色
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_user.role
     *
     * @mbg.generated
     */
    private Long role;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cm_user
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_user.id
     *
     * @return the value of cm_user.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_user.id
     *
     * @param id the value for cm_user.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_user.account
     *
     * @return the value of cm_user.account
     *
     * @mbg.generated
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_user.account
     *
     * @param account the value for cm_user.account
     *
     * @mbg.generated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_user.username
     *
     * @return the value of cm_user.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_user.username
     *
     * @param username the value for cm_user.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_user.password
     *
     * @return the value of cm_user.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_user.password
     *
     * @param password the value for cm_user.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_user.avatar
     *
     * @return the value of cm_user.avatar
     *
     * @mbg.generated
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_user.avatar
     *
     * @param avatar the value for cm_user.avatar
     *
     * @mbg.generated
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_user.tel
     *
     * @return the value of cm_user.tel
     *
     * @mbg.generated
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_user.tel
     *
     * @param tel the value for cm_user.tel
     *
     * @mbg.generated
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_user.creat_time
     *
     * @return the value of cm_user.creat_time
     *
     * @mbg.generated
     */
    public String getCreatTime() {
        return creatTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_user.creat_time
     *
     * @param creatTime the value for cm_user.creat_time
     *
     * @mbg.generated
     */
    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime == null ? null : creatTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_user.state
     *
     * @return the value of cm_user.state
     *
     * @mbg.generated
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_user.state
     *
     * @param state the value for cm_user.state
     *
     * @mbg.generated
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_user.department_id
     *
     * @return the value of cm_user.department_id
     *
     * @mbg.generated
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_user.department_id
     *
     * @param departmentId the value for cm_user.department_id
     *
     * @mbg.generated
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_user.student_id
     *
     * @return the value of cm_user.student_id
     *
     * @mbg.generated
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_user.student_id
     *
     * @param studentId the value for cm_user.student_id
     *
     * @mbg.generated
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_user.role
     *
     * @return the value of cm_user.role
     *
     * @mbg.generated
     */
    public Long getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_user.role
     *
     * @param role the value for cm_user.role
     *
     * @mbg.generated
     */
    public void setRole(Long role) {
        this.role = role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_user
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", avatar=").append(avatar);
        sb.append(", tel=").append(tel);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", state=").append(state);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", studentId=").append(studentId);
        sb.append(", role=").append(role);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}