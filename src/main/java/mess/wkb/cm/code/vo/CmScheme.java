package mess.wkb.cm.code.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table cm_scheme
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class CmScheme implements Serializable {
    /**
     *
     */
    private Long id;

    /**
     *   编号
     */
    private String code;

    /**
     *   活动名称
     */
    private String name;

    /**
     *   活动说明
     */
    private String description;

    /**
     *   活动主题
     */
    private String theme;

    /**
     *   活动目的
     */
    private String goal;

    /**
     *   活动时间
     */
    private String beginTime;

    /**
     *   活动地点
     */
    private String place;

    /**
     *   活动人员
     */
    private String person;

    /**
     *   活动形式
     */
    private String form;

    /**
     *   活动人员安排
     */
    private String arrangements;

    /**
     *   活动流程
     */
    private String flow;

    /**
     *   活动内容
     */
    private String content;

    /**
     *   资金预算
     */
    private String budget;

    /**
     *   奖励
     */
    private String award;

    /**
     *   创建时间
     */
    private Date creatTime;

    /**
     *   创建人
     */
    private String creatPerson;

    /**
     *   所属部门
     */
    private String department;

    /**
     *   状态
     */
    private String state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cm_scheme
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.id
     *
     * @return the value of cm_scheme.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.id
     *
     * @param id the value for cm_scheme.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.code
     *
     * @return the value of cm_scheme.code
     *
     * @mbg.generated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.code
     *
     * @param code the value for cm_scheme.code
     *
     * @mbg.generated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.name
     *
     * @return the value of cm_scheme.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.name
     *
     * @param name the value for cm_scheme.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.description
     *
     * @return the value of cm_scheme.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.description
     *
     * @param description the value for cm_scheme.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.theme
     *
     * @return the value of cm_scheme.theme
     *
     * @mbg.generated
     */
    public String getTheme() {
        return theme;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.theme
     *
     * @param theme the value for cm_scheme.theme
     *
     * @mbg.generated
     */
    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.goal
     *
     * @return the value of cm_scheme.goal
     *
     * @mbg.generated
     */
    public String getGoal() {
        return goal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.goal
     *
     * @param goal the value for cm_scheme.goal
     *
     * @mbg.generated
     */
    public void setGoal(String goal) {
        this.goal = goal == null ? null : goal.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.begin_time
     *
     * @return the value of cm_scheme.begin_time
     *
     * @mbg.generated
     */
    public String getBeginTime() {
        return beginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.begin_time
     *
     * @param beginTime the value for cm_scheme.begin_time
     *
     * @mbg.generated
     */
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime == null ? null : beginTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.place
     *
     * @return the value of cm_scheme.place
     *
     * @mbg.generated
     */
    public String getPlace() {
        return place;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.place
     *
     * @param place the value for cm_scheme.place
     *
     * @mbg.generated
     */
    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.person
     *
     * @return the value of cm_scheme.person
     *
     * @mbg.generated
     */
    public String getPerson() {
        return person;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.person
     *
     * @param person the value for cm_scheme.person
     *
     * @mbg.generated
     */
    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.form
     *
     * @return the value of cm_scheme.form
     *
     * @mbg.generated
     */
    public String getForm() {
        return form;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.form
     *
     * @param form the value for cm_scheme.form
     *
     * @mbg.generated
     */
    public void setForm(String form) {
        this.form = form == null ? null : form.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.arrangements
     *
     * @return the value of cm_scheme.arrangements
     *
     * @mbg.generated
     */
    public String getArrangements() {
        return arrangements;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.arrangements
     *
     * @param arrangements the value for cm_scheme.arrangements
     *
     * @mbg.generated
     */
    public void setArrangements(String arrangements) {
        this.arrangements = arrangements == null ? null : arrangements.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.flow
     *
     * @return the value of cm_scheme.flow
     *
     * @mbg.generated
     */
    public String getFlow() {
        return flow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.flow
     *
     * @param flow the value for cm_scheme.flow
     *
     * @mbg.generated
     */
    public void setFlow(String flow) {
        this.flow = flow == null ? null : flow.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.content
     *
     * @return the value of cm_scheme.content
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.content
     *
     * @param content the value for cm_scheme.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.budget
     *
     * @return the value of cm_scheme.budget
     *
     * @mbg.generated
     */
    public String getBudget() {
        return budget;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.budget
     *
     * @param budget the value for cm_scheme.budget
     *
     * @mbg.generated
     */
    public void setBudget(String budget) {
        this.budget = budget == null ? null : budget.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.award
     *
     * @return the value of cm_scheme.award
     *
     * @mbg.generated
     */
    public String getAward() {
        return award;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.award
     *
     * @param award the value for cm_scheme.award
     *
     * @mbg.generated
     */
    public void setAward(String award) {
        this.award = award == null ? null : award.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.creat_time
     *
     * @return the value of cm_scheme.creat_time
     *
     * @mbg.generated
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.creat_time
     *
     * @param creatTime the value for cm_scheme.creat_time
     *
     * @mbg.generated
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.creat_person
     *
     * @return the value of cm_scheme.creat_person
     *
     * @mbg.generated
     */
    public String getCreatPerson() {
        return creatPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.creat_person
     *
     * @param creatPerson the value for cm_scheme.creat_person
     *
     * @mbg.generated
     */
    public void setCreatPerson(String creatPerson) {
        this.creatPerson = creatPerson == null ? null : creatPerson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.department
     *
     * @return the value of cm_scheme.department
     *
     * @mbg.generated
     */
    public String getDepartment() {
        return department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.department
     *
     * @param department the value for cm_scheme.department
     *
     * @mbg.generated
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_scheme.state
     *
     * @return the value of cm_scheme.state
     *
     * @mbg.generated
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_scheme.state
     *
     * @param state the value for cm_scheme.state
     *
     * @mbg.generated
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_scheme
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
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", theme=").append(theme);
        sb.append(", goal=").append(goal);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", place=").append(place);
        sb.append(", person=").append(person);
        sb.append(", form=").append(form);
        sb.append(", arrangements=").append(arrangements);
        sb.append(", flow=").append(flow);
        sb.append(", content=").append(content);
        sb.append(", budget=").append(budget);
        sb.append(", award=").append(award);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", creatPerson=").append(creatPerson);
        sb.append(", department=").append(department);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}