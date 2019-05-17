package mess.wkb.cm.code.po; 

import javax.persistence.Id;

import org.apache.log4j.Logger;

import mess.wkb.cm.code.vo.CmDepartment;
import mess.wkb.cm.tool.annotation.Column;
import mess.wkb.cm.tool.annotation.Table;
import mess.wkb.cm.tool.annotation.UnColumn;
import mess.wkb.cm.tool.util.ObjectUtil;



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
	private static final long serialVersionUID = 7089741095671191313L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**
	 * -- id
	 */
	@Id
	private Long id;
	
	/**
	 * -- name
	 */
    @Column("NAME")    
	private String name;
	
	/**
	 * -- content
	 */
    @Column("CONTENT")    
	private String content;
	
	/**
	 * -- place
	 */
    @Column("PLACE")    
	private String place;
	
	/**
	 * -- creat_time
	 */
    @Column("CREAT_TIME")    
	private String creatTime;
	
	/**
	 * -- begin_time
	 */
    @Column("BEGIN_TIME")    
	private String beginTime;
	
	/**
	 * -- end_time
	 */
    @Column("END_TIME")    
	private String endTime;
	
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
    
    @UnColumn
    private CmDepartment department;
    
    @UnColumn
    private CmAttendanceRecordPO record; 

    @UnColumn
    private String userId;
    
    public CmAttendanceRecordPO getRecord() {
		return record;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setRecord(CmAttendanceRecordPO record) {
		this.record = record;
	}

	public CmDepartment getDepartment() {
		return department;
	}

	public void setDepartment(CmDepartment department) {
		this.department = department;
	}

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
    

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    

    public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
    

    public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String string) {
		this.creatTime = string;
	}
    

    public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
    

    public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
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
         if(!ObjectUtil.isEmpty(this.getContent()))sb.append("content="+this.content+ " | ");
         if(!ObjectUtil.isEmpty(this.getPlace()))sb.append("place="+this.place+ " | ");
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