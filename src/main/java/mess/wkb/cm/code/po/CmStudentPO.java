package mess.wkb.cm.code.po; 


import mess.wkb.cm.tool.util.ObjectUtil;
import org.apache.log4j.Logger;
import mess.wkb.cm.tool.annotation.Column;
import mess.wkb.cm.tool.annotation.PrimaryKey;
import mess.wkb.cm.tool.annotation.Table;



/**
 * CmStudentPO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
@Table("CM_STUDENT")
public class CmStudentPO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5744588129936845068L;


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
	 * -- sex
	 */
    @Column("SEX")    
	private String sex;
	
	/**
	 * -- age
	 */
    @Column("AGE")    
	private Integer age;
	
	/**
	 * -- birthday
	 */
    @Column("BIRTHDAY")    
	private String birthday;
	
	/**
	 * -- roots
	 */
    @Column("ROOTS")    
	private String roots;
	
	/**
	 * -- volk
	 */
    @Column("VOLK")    
	private String volk;
	
	/**
	 * -- code
	 */
    @Column("CODE")    
	private String code;
	
	/**
	 * -- id_card
	 */
    @Column("ID_CARD")    
	private String idCard;
	
	/**
	 * -- political
	 */
    @Column("POLITICAL")    
	private String political;
	
	/**
	 * -- address
	 */
    @Column("ADDRESS")    
	private String address;
	
	/**
	 * -- tel
	 */
    @Column("TEL")    
	private String tel;
	
	/**
	 * -- email
	 */
    @Column("EMAIL")    
	private String email;
	
	/**
	 * -- parent_tel
	 */
    @Column("PARENT_TEL")    
	private String parentTel;
	
	/**
	 * -- parent_name1
	 */
    @Column("PARENT_NAME1")    
	private String parentName1;
	
	/**
	 * -- parent_name2
	 */
    @Column("PARENT_NAME2")    
	private String parentName2;
	
	/**
	 * -- school
	 */
    @Column("SCHOOL")    
	private String school;
	
	/**
	 * -- major
	 */
    @Column("MAJOR")    
	private String major;
	
	/**
	 * -- grade
	 */
    @Column("GRADE")    
	private String grade;
	
	/**
	 * -- class
	 */
    @Column("CLAZ")    
	private String clas;
	
	/**
	 * -- house
	 */
    @Column("HOUSE")    
	private Long house;
	
	/**
	 * -- room
	 */
    @Column("ROOM")    
	private Long room;
	
	/**
	 * -- bed
	 */
    @Column("BED")    
	private Integer bed;
	
	/**
	 * -- content
	 */
    @Column("CONTENT")    
	private String content;
    

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
    

    public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
    

    public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
    

    public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
    

    public String getRoots() {
		return roots;
	}

	public void setRoots(String roots) {
		this.roots = roots;
	}
    

    public String getVolk() {
		return volk;
	}

	public void setVolk(String volk) {
		this.volk = volk;
	}
    

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
    

    public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
    

    public String getPolitical() {
		return political;
	}

	public void setPolitical(String political) {
		this.political = political;
	}
    

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    

    public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
    

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    

    public String getParentTel() {
		return parentTel;
	}

	public void setParentTel(String parentTel) {
		this.parentTel = parentTel;
	}
    

    public String getParentName1() {
		return parentName1;
	}

	public void setParentName1(String parentName1) {
		this.parentName1 = parentName1;
	}
    

    public String getParentName2() {
		return parentName2;
	}

	public void setParentName2(String parentName2) {
		this.parentName2 = parentName2;
	}
    

    public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
    

    public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
    

    public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
    

    public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}
    

    public Long getHouse() {
		return house;
	}

	public void setHouse(Long house) {
		this.house = house;
	}
    

    public Long getRoom() {
		return room;
	}

	public void setRoom(Long room) {
		this.room = room;
	}
    

    public Integer getBed() {
		return bed;
	}

	public void setBed(Integer bed) {
		this.bed = bed;
	}
    

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    
    
    
    @Override
	public String toString() {
		 StringBuffer sb = new StringBuffer();
         if(!ObjectUtil.isEmpty(this.getId()))sb.append("id="+this.id+ " | ");
         if(!ObjectUtil.isEmpty(this.getName()))sb.append("name="+this.name+ " | ");
         if(!ObjectUtil.isEmpty(this.getSex()))sb.append("sex="+this.sex+ " | ");
         if(!ObjectUtil.isEmpty(this.getAge()))sb.append("age="+this.age+ " | ");
         if(!ObjectUtil.isEmpty(this.getBirthday()))sb.append("birthday="+this.birthday+ " | ");
         if(!ObjectUtil.isEmpty(this.getRoots()))sb.append("roots="+this.roots+ " | ");
         if(!ObjectUtil.isEmpty(this.getVolk()))sb.append("volk="+this.volk+ " | ");
         if(!ObjectUtil.isEmpty(this.getCode()))sb.append("code="+this.code+ " | ");
         if(!ObjectUtil.isEmpty(this.getIdCard()))sb.append("idCard="+this.idCard+ " | ");
         if(!ObjectUtil.isEmpty(this.getPolitical()))sb.append("political="+this.political+ " | ");
         if(!ObjectUtil.isEmpty(this.getAddress()))sb.append("address="+this.address+ " | ");
         if(!ObjectUtil.isEmpty(this.getTel()))sb.append("tel="+this.tel+ " | ");
         if(!ObjectUtil.isEmpty(this.getEmail()))sb.append("email="+this.email+ " | ");
         if(!ObjectUtil.isEmpty(this.getParentTel()))sb.append("parentTel="+this.parentTel+ " | ");
         if(!ObjectUtil.isEmpty(this.getParentName1()))sb.append("parentName1="+this.parentName1+ " | ");
         if(!ObjectUtil.isEmpty(this.getParentName2()))sb.append("parentName2="+this.parentName2+ " | ");
         if(!ObjectUtil.isEmpty(this.getSchool()))sb.append("school="+this.school+ " | ");
         if(!ObjectUtil.isEmpty(this.getMajor()))sb.append("major="+this.major+ " | ");
         if(!ObjectUtil.isEmpty(this.getGrade()))sb.append("grade="+this.grade+ " | ");
         if(!ObjectUtil.isEmpty(this.getClas()))sb.append("clas="+this.clas+ " | ");
         if(!ObjectUtil.isEmpty(this.getHouse()))sb.append("house="+this.house+ " | ");
         if(!ObjectUtil.isEmpty(this.getRoom()))sb.append("room="+this.room+ " | ");
         if(!ObjectUtil.isEmpty(this.getBed()))sb.append("bed="+this.bed+ " | ");
         if(!ObjectUtil.isEmpty(this.getContent()))sb.append("content="+this.content+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}