package mess.wkb.cm.code.po; 


import org.apache.log4j.Logger;

import mess.wkb.cm.tool.annotation.Column;
import mess.wkb.cm.tool.annotation.PrimaryKey;
import mess.wkb.cm.tool.annotation.Table;
import mess.wkb.cm.tool.util.ObjectUtil;



/**
 * TUserPO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
@Table("T_USER")
public class UserPO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5637658707741978337L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**  -- id */
    @PrimaryKey("ID")
	private String id;
	
	/**  -- account */
    @Column("ACCOUNT")    
	private String account;
	
	/**  -- username */
    @Column("USERNAME")    
	private String username;
	
	/**  -- password */
    @Column("PASSWORD")    
	private String password;
	
	/**  -- user_email */
    @Column("USER_EMAIL")    
	private String userEmail;
	
	/**  -- avatar */
    @Column("AVATAR")    
	private String avatar;
	
	/**  -- tel */
    @Column("TEL")    
	private String tel;
	
	/**  -- sex */
    @Column("SEX")    
	private String sex;
	
	/**  -- school */
    @Column("SCHOOL")    
	private String school;
	
	/**  -- address */
    @Column("ADDRESS")    
	private String address;
	
	/**  -- creat_time */
    @Column("CREAT_TIME")    
	private Long creatTime;
//	// (查询条件 - 开始) 
//	private Long creatTimeBegin;
//    // (查询条件 - 结束)  
//    private Long creatTimeEnd;
    
	
	/**  -- last_time */
    @Column("LAST_TIME")    
	private Long lastTime;
//	// (查询条件 - 开始) 
//	private Long lastTimeBegin;
//    // (查询条件 - 结束)  
//    private Long lastTimeEnd;
    
	
	/**  -- login_ip */
    @Column("LOGIN_IP")    
	private String loginIp;
	
	/**  -- is_admin */
    @Column("IS_ADMIN")    
	private Integer isAdmin;
	
	/**  -- state */
    @Column("STATE")    
	private Integer state;
	
	/**  -- lng */
    @Column("LNG")    
	private Double lng;
	
	/**  -- lat */
    @Column("LAT")    
	private Double lat;
	
	/**  -- qq */
    @Column("QQ")    
	private String qq;
	
	/**  -- wechat */
    @Column("WECHAT")    
	private String wechat;
	
	/**  -- alipay */
    @Column("ALIPAY")    
	private String alipay;
    
    

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
    

    public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
    

    public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
    

    public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
    

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    

    public Long getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Long creatTime) {
		this.creatTime = creatTime;
	}
//	public Long getCreatTimeBegin() {
//		return creatTimeBegin;
//	}
//	public void setCreatTimeBegin(Long creatTimeBegin) {
//		this.creatTimeBegin = creatTimeBegin;
//	}
//    public Long getCreatTimeEnd() {
//		return creatTimeEnd;
//	}
//	public void setCreatTimeEnd(Long creatTimeEnd) {
//		this.creatTimeEnd = creatTimeEnd;
//	}
    
    

    public Long getLastTime() {
		return lastTime;
	}

	public void setLastTime(Long lastTime) {
		this.lastTime = lastTime;
	}
//	public Long getLastTimeBegin() {
//		return lastTimeBegin;
//	}
//	public void setLastTimeBegin(Long lastTimeBegin) {
//		this.lastTimeBegin = lastTimeBegin;
//	}
//    public Long getLastTimeEnd() {
//		return lastTimeEnd;
//	}
//	public void setLastTimeEnd(Long lastTimeEnd) {
//		this.lastTimeEnd = lastTimeEnd;
//	}
//    
    

    public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
    

    public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}
    

    public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
    

    public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}
    

    public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}
    

    public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
    

    public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
    

    public String getAlipay() {
		return alipay;
	}

	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}
    
    
    
    @Override
	public String toString() {
		 StringBuffer sb = new StringBuffer();
         if(!ObjectUtil.isEmpty(this.getId()))sb.append("id="+this.id+ " | ");
         if(!ObjectUtil.isEmpty(this.getAccount()))sb.append("account="+this.account+ " | ");
         if(!ObjectUtil.isEmpty(this.getUsername()))sb.append("username="+this.username+ " | ");
         if(!ObjectUtil.isEmpty(this.getPassword()))sb.append("password="+this.password+ " | ");
         if(!ObjectUtil.isEmpty(this.getUserEmail()))sb.append("userEmail="+this.userEmail+ " | ");
         if(!ObjectUtil.isEmpty(this.getAvatar()))sb.append("avatar="+this.avatar+ " | ");
         if(!ObjectUtil.isEmpty(this.getTel()))sb.append("tel="+this.tel+ " | ");
         if(!ObjectUtil.isEmpty(this.getSex()))sb.append("sex="+this.sex+ " | ");
         if(!ObjectUtil.isEmpty(this.getSchool()))sb.append("school="+this.school+ " | ");
         if(!ObjectUtil.isEmpty(this.getAddress()))sb.append("address="+this.address+ " | ");
         if(!ObjectUtil.isEmpty(this.getCreatTime()))sb.append("creatTime="+this.creatTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getLastTime()))sb.append("lastTime="+this.lastTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getLoginIp()))sb.append("loginIp="+this.loginIp+ " | ");
         if(!ObjectUtil.isEmpty(this.getIsAdmin()))sb.append("isAdmin="+this.isAdmin+ " | ");
         if(!ObjectUtil.isEmpty(this.getState()))sb.append("state="+this.state+ " | ");
         if(!ObjectUtil.isEmpty(this.getLng()))sb.append("lng="+this.lng+ " | ");
         if(!ObjectUtil.isEmpty(this.getLat()))sb.append("lat="+this.lat+ " | ");
         if(!ObjectUtil.isEmpty(this.getQq()))sb.append("qq="+this.qq+ " | ");
         if(!ObjectUtil.isEmpty(this.getWechat()))sb.append("wechat="+this.wechat+ " | ");
         if(!ObjectUtil.isEmpty(this.getAlipay()))sb.append("alipay="+this.alipay+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}