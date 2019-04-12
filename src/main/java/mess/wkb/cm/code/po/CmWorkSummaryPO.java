package mess.wkb.cm.code.po; 


import mess.wkb.cm.tool.util.ObjectUtil;
import org.apache.log4j.Logger;
import mess.wkb.cm.tool.annotation.Column;
import mess.wkb.cm.tool.annotation.PrimaryKey;
import mess.wkb.cm.tool.annotation.Table;



/**
 * CmWorkSummaryPO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
@Table("CM_WORK_SUMMARY")
public class CmWorkSummaryPO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -14528277895722592L;


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
	 * -- title
	 */
    @Column("TITLE")    
	private String title;
	
	/**
	 * -- content
	 */
    @Column("CONTENT")    
	private String content;
	
	/**
	 * -- creat_time
	 */
    @Column("CREAT_TIME")    
	private java.util.Date creatTime;
	
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
    

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    

    public java.util.Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(java.util.Date creatTime) {
		this.creatTime = creatTime;
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
         if(!ObjectUtil.isEmpty(this.getTitle()))sb.append("title="+this.title+ " | ");
         if(!ObjectUtil.isEmpty(this.getContent()))sb.append("content="+this.content+ " | ");
         if(!ObjectUtil.isEmpty(this.getCreatTime()))sb.append("creatTime="+this.creatTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getDepartmentId()))sb.append("departmentId="+this.departmentId+ " | ");
         if(!ObjectUtil.isEmpty(this.getUserName()))sb.append("userName="+this.userName+ " | ");
         if(!ObjectUtil.isEmpty(this.getState()))sb.append("state="+this.state+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}