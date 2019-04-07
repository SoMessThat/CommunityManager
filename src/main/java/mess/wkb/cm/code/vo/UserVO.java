package mess.wkb.cm.code.vo; 


import org.apache.log4j.Logger;

import mess.wkb.cm.tool.util.ObjectUtil;



/**
 * TUserPO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
public class UserVO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5637658707741978337L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**  -- id */
	private String id;
	
	/**  -- account */
	private String account;
	
	/**  -- username */
	private String username;
	
	/**  -- user_email */
	private String userEmail;
	
	/**  -- avatar */
	private String avatar;
	
	/**  -- tel */
	private String tel;
	
	/**  -- sex */
	private String sex;
	
	/**  -- school */
	private String school;
	
	/**  -- address */
	private String address;
	
	/**  -- creat_time */
	private Long creatTime;
	
	/**  -- last_time */
	private Long lastTime;
	
	/**  -- state */
	private Integer state;
	
	/**  -- lng */
	private Double lng;
	
	/**  -- lat */
	private Double lat;
	
	/**  -- qq */
	private String qq;
	
	/**  -- wechat */
	private String wechat;
	
	/**  -- alipay */
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
    

    public Long getLastTime() {
		return lastTime;
	}

	public void setLastTime(Long lastTime) {
		this.lastTime = lastTime;
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
         if(!ObjectUtil.isEmpty(this.getUserEmail()))sb.append("userEmail="+this.userEmail+ " | ");
         if(!ObjectUtil.isEmpty(this.getAvatar()))sb.append("avatar="+this.avatar+ " | ");
         if(!ObjectUtil.isEmpty(this.getTel()))sb.append("tel="+this.tel+ " | ");
         if(!ObjectUtil.isEmpty(this.getSex()))sb.append("sex="+this.sex+ " | ");
         if(!ObjectUtil.isEmpty(this.getSchool()))sb.append("school="+this.school+ " | ");
         if(!ObjectUtil.isEmpty(this.getAddress()))sb.append("address="+this.address+ " | ");
         if(!ObjectUtil.isEmpty(this.getCreatTime()))sb.append("creatTime="+this.creatTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getLastTime()))sb.append("lastTime="+this.lastTime+ " | ");
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