package mess.wkb.cm.code.po; 


import mess.wkb.cm.tool.util.ObjectUtil;
import org.apache.log4j.Logger;
import mess.wkb.cm.tool.annotation.Column;
import mess.wkb.cm.tool.annotation.PrimaryKey;
import mess.wkb.cm.tool.annotation.Table;



/**
 * CmDepartmentApplyPO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
@Table("CM_DEPARTMENT_APPLY")
public class CmDepartmentApplyPO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2366566961090090386L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**
	 * -- id
	 */
    @PrimaryKey("ID")
	private Long id;
	
	/**
	 * -- apply_id
	 */
    @Column("APPLY_ID")    
	private String applyId;
	
	/**
	 * -- apply_name
	 */
    @Column("APPLY_NAME")    
	private String applyName;
	
	/**
	 * -- department
	 */
    @Column("DEPARTMENT")    
	private String department;
	
	/**
	 * -- creat_time
	 */
    @Column("CREAT_TIME")    
	private java.util.Date creatTime;
	
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
    

    public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
    

    public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
    

    public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
    

    public java.util.Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(java.util.Date creatTime) {
		this.creatTime = creatTime;
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
         if(!ObjectUtil.isEmpty(this.getApplyId()))sb.append("applyId="+this.applyId+ " | ");
         if(!ObjectUtil.isEmpty(this.getApplyName()))sb.append("applyName="+this.applyName+ " | ");
         if(!ObjectUtil.isEmpty(this.getDepartment()))sb.append("department="+this.department+ " | ");
         if(!ObjectUtil.isEmpty(this.getCreatTime()))sb.append("creatTime="+this.creatTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getState()))sb.append("state="+this.state+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}