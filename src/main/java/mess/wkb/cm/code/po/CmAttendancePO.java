package mess.wkb.cm.code.po; 


import mess.wkb.cm.tool.util.ObjectUtil;

import java.util.Date;

import org.apache.log4j.Logger;
import mess.wkb.cm.tool.annotation.Column;
import mess.wkb.cm.tool.annotation.PrimaryKey;
import mess.wkb.cm.tool.annotation.Table;



/**
 * CmAttendancePO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
@Table("CM_ATTENDANCE")
public class CmAttendancePO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6737105954109584371L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**
	 * -- id
	 */
    @PrimaryKey("ID")
	private Long id;
	
	/**
	 * -- name
	 */
    @Column("NAME")    
	private String name;
	
	/**
	 * -- creat_time
	 */
    @Column("CREAT_TIME")    
	private Date creatTime;
	
	/**
	 * -- begin_time
	 */
    @Column("BEGIN_TIME")    
	private Date beginTime;
	
	/**
	 * -- end_time
	 */
    @Column("END_TIME")    
	private Date endTime;
	
	/**
	 * -- department_id
	 */
    @Column("DEPARTMENT_ID")    
	private String departmentId;
	
	/**
	 * -- user_name
	 */
    @Column("USER_NAME")    
	private String userName;
	
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
    

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    

    public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
    

    public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
    

    public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
    

    public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
    

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
         if(!ObjectUtil.isEmpty(this.getName()))sb.append("name="+this.name+ " | ");
         if(!ObjectUtil.isEmpty(this.getCreatTime()))sb.append("creatTime="+this.creatTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getBeginTime()))sb.append("beginTime="+this.beginTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getEndTime()))sb.append("endTime="+this.endTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getDepartmentId()))sb.append("departmentId="+this.departmentId+ " | ");
         if(!ObjectUtil.isEmpty(this.getUserName()))sb.append("userName="+this.userName+ " | ");
         if(!ObjectUtil.isEmpty(this.getState()))sb.append("state="+this.state+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}