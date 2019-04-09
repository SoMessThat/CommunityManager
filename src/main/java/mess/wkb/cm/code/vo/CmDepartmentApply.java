package mess.wkb.cm.code.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table cm_department_apply
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class CmDepartmentApply implements Serializable {
    /**
     *
     */
    private Long id;

    /**
     *   申请人id
     */
    private String applyId;

    /**
     *   申请人名字
     */
    private String applyName;

    /**
     *   所属部门
     */
    private String department;

    /**
     *   创建时间
     */
    private Date creatTime;

    /**
     *   状态
     */
    private String state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cm_department_apply
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department_apply.id
     *
     * @return the value of cm_department_apply.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department_apply.id
     *
     * @param id the value for cm_department_apply.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department_apply.apply_id
     *
     * @return the value of cm_department_apply.apply_id
     *
     * @mbg.generated
     */
    public String getApplyId() {
        return applyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department_apply.apply_id
     *
     * @param applyId the value for cm_department_apply.apply_id
     *
     * @mbg.generated
     */
    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department_apply.apply_name
     *
     * @return the value of cm_department_apply.apply_name
     *
     * @mbg.generated
     */
    public String getApplyName() {
        return applyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department_apply.apply_name
     *
     * @param applyName the value for cm_department_apply.apply_name
     *
     * @mbg.generated
     */
    public void setApplyName(String applyName) {
        this.applyName = applyName == null ? null : applyName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department_apply.department
     *
     * @return the value of cm_department_apply.department
     *
     * @mbg.generated
     */
    public String getDepartment() {
        return department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department_apply.department
     *
     * @param department the value for cm_department_apply.department
     *
     * @mbg.generated
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department_apply.creat_time
     *
     * @return the value of cm_department_apply.creat_time
     *
     * @mbg.generated
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department_apply.creat_time
     *
     * @param creatTime the value for cm_department_apply.creat_time
     *
     * @mbg.generated
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department_apply.state
     *
     * @return the value of cm_department_apply.state
     *
     * @mbg.generated
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department_apply.state
     *
     * @param state the value for cm_department_apply.state
     *
     * @mbg.generated
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_department_apply
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
        sb.append(", applyId=").append(applyId);
        sb.append(", applyName=").append(applyName);
        sb.append(", department=").append(department);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}