package mess.wkb.cm.code.po; 


import mess.wkb.cm.tool.util.ObjectUtil;
import org.apache.log4j.Logger;
import mess.wkb.cm.tool.annotation.Column;
import mess.wkb.cm.tool.annotation.PrimaryKey;
import mess.wkb.cm.tool.annotation.Table;



/**
 * CmDepartmentPO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
@Table("CM_DEPARTMENT")
public class CmDepartmentPO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 4997755820555218872L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**
	 * -- id
	 */
    @PrimaryKey("ID")
	private String id;
	
	/**
	 * -- name
	 */
    @Column("NAME")    
	private String name;
	
	/**
	 * -- info
	 */
    @Column("INFO")    
	private String info;
	
	/**
	 * -- duty
	 */
    @Column("DUTY")    
	private String duty;
	
	/**
	 * -- characters
	 */
    @Column("CHARACTERS")    
	private String characters;
	
	/**
	 * -- master_name
	 */
    @Column("MASTER_NAME")    
	private String masterName;
	
	/**
	 * -- master_tel
	 */
    @Column("MASTER_TEL")    
	private String masterTel;
	
	/**
	 * -- lead_organize
	 */
    @Column("LEAD_ORGANIZE")    
	private String leadOrganize;
	
	/**
	 * -- registration_time
	 */
    @Column("REGISTRATION_TIME")    
	private String registrationTime;
	
	/**
	 * -- registration_name
	 */
    @Column("REGISTRATION_NAME")    
	private String registrationName;
	
	/**
	 * -- num
	 */
    @Column("NUM")    
	private Integer num;
	
	/**
	 * -- general_rules
	 */
    @Column("GENERAL_RULES")    
	private String generalRules;
	
	/**
	 * -- purpose
	 */
    @Column("PURPOSE")    
	private String purpose;
	
	/**
	 * -- droit
	 */
    @Column("DROIT")    
	private String droit;
	
	/**
	 * -- obligation
	 */
    @Column("OBLIGATION")    
	private String obligation;
	
	/**
	 * -- requirement
	 */
    @Column("REQUIREMENT")    
	private String requirement;
	
	/**
	 * -- other
	 */
    @Column("OTHER")    
	private String other;
    

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    

    public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
    

    public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}
    

    public String getCharacters() {
		return characters;
	}

	public void setCharacters(String characters) {
		this.characters = characters;
	}
    

    public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
    

    public String getMasterTel() {
		return masterTel;
	}

	public void setMasterTel(String masterTel) {
		this.masterTel = masterTel;
	}
    

    public String getLeadOrganize() {
		return leadOrganize;
	}

	public void setLeadOrganize(String leadOrganize) {
		this.leadOrganize = leadOrganize;
	}
    

    public String getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(String registrationTime) {
		this.registrationTime = registrationTime;
	}
    

    public String getRegistrationName() {
		return registrationName;
	}

	public void setRegistrationName(String registrationName) {
		this.registrationName = registrationName;
	}
    

    public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
    

    public String getGeneralRules() {
		return generalRules;
	}

	public void setGeneralRules(String generalRules) {
		this.generalRules = generalRules;
	}
    

    public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
    

    public String getDroit() {
		return droit;
	}

	public void setDroit(String droit) {
		this.droit = droit;
	}
    

    public String getObligation() {
		return obligation;
	}

	public void setObligation(String obligation) {
		this.obligation = obligation;
	}
    

    public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
    

    public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
    
    
    
    @Override
	public String toString() {
		 StringBuffer sb = new StringBuffer();
         if(!ObjectUtil.isEmpty(this.getId()))sb.append("id="+this.id+ " | ");
         if(!ObjectUtil.isEmpty(this.getName()))sb.append("name="+this.name+ " | ");
         if(!ObjectUtil.isEmpty(this.getInfo()))sb.append("info="+this.info+ " | ");
         if(!ObjectUtil.isEmpty(this.getDuty()))sb.append("duty="+this.duty+ " | ");
         if(!ObjectUtil.isEmpty(this.getCharacters()))sb.append("characters="+this.characters+ " | ");
         if(!ObjectUtil.isEmpty(this.getMasterName()))sb.append("masterName="+this.masterName+ " | ");
         if(!ObjectUtil.isEmpty(this.getMasterTel()))sb.append("masterTel="+this.masterTel+ " | ");
         if(!ObjectUtil.isEmpty(this.getLeadOrganize()))sb.append("leadOrganize="+this.leadOrganize+ " | ");
         if(!ObjectUtil.isEmpty(this.getRegistrationTime()))sb.append("registrationTime="+this.registrationTime+ " | ");
         if(!ObjectUtil.isEmpty(this.getRegistrationName()))sb.append("registrationName="+this.registrationName+ " | ");
         if(!ObjectUtil.isEmpty(this.getNum()))sb.append("num="+this.num+ " | ");
         if(!ObjectUtil.isEmpty(this.getGeneralRules()))sb.append("generalRules="+this.generalRules+ " | ");
         if(!ObjectUtil.isEmpty(this.getPurpose()))sb.append("purpose="+this.purpose+ " | ");
         if(!ObjectUtil.isEmpty(this.getDroit()))sb.append("droit="+this.droit+ " | ");
         if(!ObjectUtil.isEmpty(this.getObligation()))sb.append("obligation="+this.obligation+ " | ");
         if(!ObjectUtil.isEmpty(this.getRequirement()))sb.append("requirement="+this.requirement+ " | ");
         if(!ObjectUtil.isEmpty(this.getOther()))sb.append("other="+this.other+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}