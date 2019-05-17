package mess.wkb.cm.code.po;

import org.apache.log4j.Logger;

import mess.wkb.cm.tool.annotation.Column;
import mess.wkb.cm.tool.annotation.PrimaryKey;
import mess.wkb.cm.tool.annotation.Table;
import mess.wkb.cm.tool.util.ObjectUtil;



/**
 * CmAwardPO
 * Description:
 * @author:wkb
 * @email:842387850@qq.com
 */  
@Table("CM_AWARD")
public class CmAwardPO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6014025316153410691L;


	Logger log = Logger.getLogger(this.getClass());
    
	
	/**  -- id */
    @PrimaryKey("ID")
	private Long id;
	
	/**  -- student_id */
    @Column("STUDENT_ID")    
	private String studentId;
	
	/**  -- award_name */
    @Column("AWARD_NAME")    
	private String awardName;
	
	/**  -- rating_id */
    @Column("RATING_ID")    
	private Long ratingId;
	
	/**  -- time */
    @Column("TIME")    
	private String time;
	
	/**  -- state */
    @Column("STATE")    
	private String state;
    
    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

    public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

    public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

    public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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
         if(!ObjectUtil.isEmpty(this.getStudentId()))sb.append("studentId="+this.studentId+ " | ");
         if(!ObjectUtil.isEmpty(this.getAwardName()))sb.append("awardName="+this.awardName+ " | ");
         if(!ObjectUtil.isEmpty(this.getRatingId()))sb.append("ratingId="+this.ratingId+ " | ");
         if(!ObjectUtil.isEmpty(this.getTime()))sb.append("time="+this.time+ " | ");
         if(!ObjectUtil.isEmpty(this.getState()))sb.append("state="+this.state+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}