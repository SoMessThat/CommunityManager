package mess.wkb.cm.code.po; 


import mess.wkb.cm.tool.util.ObjectUtil;
import org.apache.log4j.Logger;
import mess.wkb.cm.tool.annotation.Column;
import mess.wkb.cm.tool.annotation.PrimaryKey;
import mess.wkb.cm.tool.annotation.Table;



/**
 * CmSchemePO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
@Table("CM_SCHEME")
public class CmSchemePO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1473444791356063663L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**
	 * -- id
	 */
    @PrimaryKey("ID")
	private Long id;
	
	/**
	 * -- code
	 */
    @Column("CODE")    
	private String code;
	
	/**
	 * -- name
	 */
    @Column("NAME")    
	private String name;
	
	/**
	 * -- description
	 */
    @Column("DESCRIPTION")    
	private String description;
	
	/**
	 * -- theme
	 */
    @Column("THEME")    
	private String theme;
	
	/**
	 * -- goal
	 */
    @Column("GOAL")    
	private String goal;
	
	/**
	 * -- begin_time
	 */
    @Column("BEGIN_TIME")    
	private String beginTime;
	
	/**
	 * -- place
	 */
    @Column("PLACE")    
	private String place;
	
	/**
	 * -- person
	 */
    @Column("PERSON")    
	private String person;
	
	/**
	 * -- form
	 */
    @Column("FORM")    
	private String form;
	
	/**
	 * -- arrangements
	 */
    @Column("ARRANGEMENTS")    
	private String arrangements;
	
	/**
	 * -- flow
	 */
    @Column("FLOW")    
	private String flow;
	
	/**
	 * -- content
	 */
    @Column("CONTENT")    
	private String content;
	
	/**
	 * -- budget
	 */
    @Column("BUDGET")    
	private String budget;
	
	/**
	 * -- award
	 */
    @Column("AWARD")    
	private String award;
	
	/**
	 * -- creat_time
	 */
    @Column("CREAT_TIME")    
	private java.util.Date creatTime;
	
	/**
	 * -- creat_person
	 */
    @Column("CREAT_PERSON")    
	private String creatPerson;
	
	/**
	 * -- department
	 */
    @Column("DEPARTMENT")    
	private String department;
	
	/**
	 * -- state
	 */
    @Column("STATE")    
	private String state;
    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
    

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    

    public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
    

    public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}
    

    public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
    

    public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
    

    public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}
    

    public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}
    

    public String getArrangements() {
		return arrangements;
	}

	public void setArrangements(String arrangements) {
		this.arrangements = arrangements;
	}
    

    public String getFlow() {
		return flow;
	}

	public void setFlow(String flow) {
		this.flow = flow;
	}
    

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    

    public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}
    

    public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}
    

    public java.util.Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(java.util.Date creatTime) {
		this.creatTime = creatTime;
	}
    

    public String getCreatPerson() {
		return creatPerson;
	}

	public void setCreatPerson(String creatPerson) {
		this.creatPerson = creatPerson;
	}
    

    public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
    

    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
    
    
    @Override
	public String toString() {
		 StringBuffer sb = new StringBuffer();
         if(!ObjectUtil.isEmpty(this.getId()))sb.append("id="+this.id+ " | ");
         if(!ObjectUtil.isEmpty(this.getCode()))sb.append("code="+this.code+ " | ");
         if(!ObjectUtil.isEmpty(this.getName()))sb.append("name="+this.name+ " | ");
         if(!ObjectUtil.isEmpty(this.getDescription()))sb.append("description="+this.description+ " | ");
         if(!ObjectUtil.isEmpty(this.getTheme()))sb.append("theme="+this.theme+ " | ");
         if(!ObjectUtil.isEmpty(this.getGoal()))sb.append("goal="+this.goal+ " | ");
         if(!ObjectUtil.isEmpty(this.getBeginTime()))sb.append("beginTime="+this.beginTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getPlace()))sb.append("place="+this.place+ " | ");
         if(!ObjectUtil.isEmpty(this.getPerson()))sb.append("person="+this.person+ " | ");
         if(!ObjectUtil.isEmpty(this.getForm()))sb.append("form="+this.form+ " | ");
         if(!ObjectUtil.isEmpty(this.getArrangements()))sb.append("arrangements="+this.arrangements+ " | ");
         if(!ObjectUtil.isEmpty(this.getFlow()))sb.append("flow="+this.flow+ " | ");
         if(!ObjectUtil.isEmpty(this.getContent()))sb.append("content="+this.content+ " | ");
         if(!ObjectUtil.isEmpty(this.getBudget()))sb.append("budget="+this.budget+ " | ");
         if(!ObjectUtil.isEmpty(this.getAward()))sb.append("award="+this.award+ " | ");
         if(!ObjectUtil.isEmpty(this.getCreatTime()))sb.append("creatTime="+this.creatTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getCreatPerson()))sb.append("creatPerson="+this.creatPerson+ " | ");
         if(!ObjectUtil.isEmpty(this.getDepartment()))sb.append("department="+this.department+ " | ");
         if(!ObjectUtil.isEmpty(this.getState()))sb.append("state="+this.state+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}