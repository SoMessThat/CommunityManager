package mess.wkb.cm.code.vo;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table cm_department
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class CmDepartment implements Serializable {
    /**
     *
     */
    private String id;

    /**
     *   部门名称
     */
    private String name;

    /**
     *   部门信息
     */
    private String info;

    /**
     *   部门职责
     */
    private String duty;

    /**
     *   部门性质
     */
    private String characters;

    /**
     *   负责人姓名
     */
    private String masterName;

    /**
     *   负责人电话
     */
    private String masterTel;

    /**
     *   领导组织
     */
    private String leadOrganize;

    /**
     *   成立时间
     */
    private String registrationTime;

    /**
     *   创始人
     */
    private String registrationName;

    /**
     *   部门总人数
     */
    private Integer num;

    /**
     *   总则
     */
    private String generalRules;

    /**
     *   宗旨
     */
    private String purpose;

    /**
     *   权利
     */
    private String droit;

    /**
     *   义务
     */
    private String obligation;

    /**
     *   要求
     */
    private String requirement;

    /**
     *   其他
     */
    private String other;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cm_department
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.id
     *
     * @return the value of cm_department.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.id
     *
     * @param id the value for cm_department.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.name
     *
     * @return the value of cm_department.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.name
     *
     * @param name the value for cm_department.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.info
     *
     * @return the value of cm_department.info
     *
     * @mbg.generated
     */
    public String getInfo() {
        return info;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.info
     *
     * @param info the value for cm_department.info
     *
     * @mbg.generated
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.duty
     *
     * @return the value of cm_department.duty
     *
     * @mbg.generated
     */
    public String getDuty() {
        return duty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.duty
     *
     * @param duty the value for cm_department.duty
     *
     * @mbg.generated
     */
    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.characters
     *
     * @return the value of cm_department.characters
     *
     * @mbg.generated
     */
    public String getCharacters() {
        return characters;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.characters
     *
     * @param characters the value for cm_department.characters
     *
     * @mbg.generated
     */
    public void setCharacters(String characters) {
        this.characters = characters == null ? null : characters.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.master_name
     *
     * @return the value of cm_department.master_name
     *
     * @mbg.generated
     */
    public String getMasterName() {
        return masterName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.master_name
     *
     * @param masterName the value for cm_department.master_name
     *
     * @mbg.generated
     */
    public void setMasterName(String masterName) {
        this.masterName = masterName == null ? null : masterName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.master_tel
     *
     * @return the value of cm_department.master_tel
     *
     * @mbg.generated
     */
    public String getMasterTel() {
        return masterTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.master_tel
     *
     * @param masterTel the value for cm_department.master_tel
     *
     * @mbg.generated
     */
    public void setMasterTel(String masterTel) {
        this.masterTel = masterTel == null ? null : masterTel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.lead_organize
     *
     * @return the value of cm_department.lead_organize
     *
     * @mbg.generated
     */
    public String getLeadOrganize() {
        return leadOrganize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.lead_organize
     *
     * @param leadOrganize the value for cm_department.lead_organize
     *
     * @mbg.generated
     */
    public void setLeadOrganize(String leadOrganize) {
        this.leadOrganize = leadOrganize == null ? null : leadOrganize.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.registration_time
     *
     * @return the value of cm_department.registration_time
     *
     * @mbg.generated
     */
    public String getRegistrationTime() {
        return registrationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.registration_time
     *
     * @param registrationTime the value for cm_department.registration_time
     *
     * @mbg.generated
     */
    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime == null ? null : registrationTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.registration_name
     *
     * @return the value of cm_department.registration_name
     *
     * @mbg.generated
     */
    public String getRegistrationName() {
        return registrationName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.registration_name
     *
     * @param registrationName the value for cm_department.registration_name
     *
     * @mbg.generated
     */
    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName == null ? null : registrationName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.num
     *
     * @return the value of cm_department.num
     *
     * @mbg.generated
     */
    public Integer getNum() {
        return num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.num
     *
     * @param num the value for cm_department.num
     *
     * @mbg.generated
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.general_rules
     *
     * @return the value of cm_department.general_rules
     *
     * @mbg.generated
     */
    public String getGeneralRules() {
        return generalRules;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.general_rules
     *
     * @param generalRules the value for cm_department.general_rules
     *
     * @mbg.generated
     */
    public void setGeneralRules(String generalRules) {
        this.generalRules = generalRules == null ? null : generalRules.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.purpose
     *
     * @return the value of cm_department.purpose
     *
     * @mbg.generated
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.purpose
     *
     * @param purpose the value for cm_department.purpose
     *
     * @mbg.generated
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.droit
     *
     * @return the value of cm_department.droit
     *
     * @mbg.generated
     */
    public String getDroit() {
        return droit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.droit
     *
     * @param droit the value for cm_department.droit
     *
     * @mbg.generated
     */
    public void setDroit(String droit) {
        this.droit = droit == null ? null : droit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.obligation
     *
     * @return the value of cm_department.obligation
     *
     * @mbg.generated
     */
    public String getObligation() {
        return obligation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.obligation
     *
     * @param obligation the value for cm_department.obligation
     *
     * @mbg.generated
     */
    public void setObligation(String obligation) {
        this.obligation = obligation == null ? null : obligation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.requirement
     *
     * @return the value of cm_department.requirement
     *
     * @mbg.generated
     */
    public String getRequirement() {
        return requirement;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.requirement
     *
     * @param requirement the value for cm_department.requirement
     *
     * @mbg.generated
     */
    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_department.other
     *
     * @return the value of cm_department.other
     *
     * @mbg.generated
     */
    public String getOther() {
        return other;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_department.other
     *
     * @param other the value for cm_department.other
     *
     * @mbg.generated
     */
    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_department
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
        sb.append(", name=").append(name);
        sb.append(", info=").append(info);
        sb.append(", duty=").append(duty);
        sb.append(", characters=").append(characters);
        sb.append(", masterName=").append(masterName);
        sb.append(", masterTel=").append(masterTel);
        sb.append(", leadOrganize=").append(leadOrganize);
        sb.append(", registrationTime=").append(registrationTime);
        sb.append(", registrationName=").append(registrationName);
        sb.append(", num=").append(num);
        sb.append(", generalRules=").append(generalRules);
        sb.append(", purpose=").append(purpose);
        sb.append(", droit=").append(droit);
        sb.append(", obligation=").append(obligation);
        sb.append(", requirement=").append(requirement);
        sb.append(", other=").append(other);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}