package mess.wkb.cm.code.po; 


import mess.wkb.cm.tool.util.ObjectUtil;
import org.apache.log4j.Logger;
import mess.wkb.cm.tool.annotation.Column;
import mess.wkb.cm.tool.annotation.PrimaryKey;
import mess.wkb.cm.tool.annotation.Table;



/**
 * CmUserPO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
@Table("CM_USER")
public class CmUserPO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7442247192263177522L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**
	 * -- id
	 */
    @PrimaryKey("ID")
	private String id;
	
	/**
	 * -- account
	 */
    @Column("ACCOUNT")    
	private String account;
	
	/**
	 * -- username
	 */
    @Column("USERNAME")    
	private String username;
	
	/**
	 * -- password
	 */
    @Column("PASSWORD")    
	private String password;
	
	/**
	 * -- avatar
	 */
    @Column("AVATAR")    
	private String avatar;
	
	/**
	 * -- tel
	 */
    @Column("TEL")    
	private String tel;
	
	/**
	 * -- creat_time
	 */
    @Column("CREAT_TIME")    
	private String creatTime;
	
	/**
	 * -- state
	 */
    @Column("STATE")    
	private String state;
	
	/**
	 * -- department_id
	 */
    @Column("DEPARTMENT_ID")    
	private String departmentId;
	
	/**
	 * -- student_id
	 */
    @Column("STUDENT_ID")    
	private String studentId;
	
	/**
	 * -- role
	 */
    @Column("ROLE")    
	private Long role;
    

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
    

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
    

    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    

    public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
    

    public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
    

    public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}
    
    
    
    @Override
	public String toString() {
		 StringBuffer sb = new StringBuffer();
         if(!ObjectUtil.isEmpty(this.getId()))sb.append("id="+this.id+ " | ");
         if(!ObjectUtil.isEmpty(this.getAccount()))sb.append("account="+this.account+ " | ");
         if(!ObjectUtil.isEmpty(this.getUsername()))sb.append("username="+this.username+ " | ");
         if(!ObjectUtil.isEmpty(this.getPassword()))sb.append("password="+this.password+ " | ");
         if(!ObjectUtil.isEmpty(this.getAvatar()))sb.append("avatar="+this.avatar+ " | ");
         if(!ObjectUtil.isEmpty(this.getTel()))sb.append("tel="+this.tel+ " | ");
         if(!ObjectUtil.isEmpty(this.getCreatTime()))sb.append("creatTime="+this.creatTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getState()))sb.append("state="+this.state+ " | ");
         if(!ObjectUtil.isEmpty(this.getDepartmentId()))sb.append("departmentId="+this.departmentId+ " | ");
         if(!ObjectUtil.isEmpty(this.getStudentId()))sb.append("studentId="+this.studentId+ " | ");
         if(!ObjectUtil.isEmpty(this.getRole()))sb.append("role="+this.role+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}