package mess.wkb.cm.code.po; 


import mess.wkb.cm.tool.util.ObjectUtil;
import org.apache.log4j.Logger;
import mess.wkb.cm.tool.annotation.Column;
import mess.wkb.cm.tool.annotation.PrimaryKey;
import mess.wkb.cm.tool.annotation.Table;



/**
 * CmPaymentRecordPO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
@Table("CM_PAYMENT_RECORD")
public class CmPaymentRecordPO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 8607218290897639772L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**
	 * -- id
	 */
    @PrimaryKey("ID")
	private Long id;
	
	/**
	 * -- pay_time
	 */
    @Column("PAY_TIME")    
	private java.util.Date payTime;
	
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
	
	/**
	 * -- payment_id
	 */
    @Column("PAYMENT_ID")    
	private Long paymentId;
    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    

    public java.util.Date getPayTime() {
		return payTime;
	}

	public void setPayTime(java.util.Date payTime) {
		this.payTime = payTime;
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
    

    public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
    
    
    
    @Override
	public String toString() {
		 StringBuffer sb = new StringBuffer();
         if(!ObjectUtil.isEmpty(this.getId()))sb.append("id="+this.id+ " | ");
         if(!ObjectUtil.isEmpty(this.getPayTime()))sb.append("payTime="+this.payTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getDepartmentId()))sb.append("departmentId="+this.departmentId+ " | ");
         if(!ObjectUtil.isEmpty(this.getUserName()))sb.append("userName="+this.userName+ " | ");
         if(!ObjectUtil.isEmpty(this.getState()))sb.append("state="+this.state+ " | ");
         if(!ObjectUtil.isEmpty(this.getPaymentId()))sb.append("paymentId="+this.paymentId+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}