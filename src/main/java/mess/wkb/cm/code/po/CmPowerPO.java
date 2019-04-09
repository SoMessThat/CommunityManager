package mess.wkb.cm.code.po; 


import mess.wkb.cm.tool.util.ObjectUtil;
import org.apache.log4j.Logger;
import mess.wkb.cm.tool.annotation.Column;
import mess.wkb.cm.tool.annotation.PrimaryKey;
import mess.wkb.cm.tool.annotation.Table;



/**
 * CmPowerPO
 * Description:
 * @author:WuKaiBin
 * @email:842387850@qq.com
 */  
@Table("CM_POWER")
public class CmPowerPO implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1636155879012805287L;


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
	 * -- parent_id
	 */
    @Column("PARENT_ID")    
	private String parentId;
	
	/**
	 * -- content
	 */
    @Column("CONTENT")    
	private String content;
	
	/**
	 * -- soft
	 */
    @Column("SOFT")    
	private String soft;
    

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
    

    public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
    

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    

    public String getSoft() {
		return soft;
	}

	public void setSoft(String soft) {
		this.soft = soft;
	}
    
    
    
    @Override
	public String toString() {
		 StringBuffer sb = new StringBuffer();
         if(!ObjectUtil.isEmpty(this.getId()))sb.append("id="+this.id+ " | ");
         if(!ObjectUtil.isEmpty(this.getName()))sb.append("name="+this.name+ " | ");
         if(!ObjectUtil.isEmpty(this.getParentId()))sb.append("parentId="+this.parentId+ " | ");
         if(!ObjectUtil.isEmpty(this.getContent()))sb.append("content="+this.content+ " | ");
         if(!ObjectUtil.isEmpty(this.getSoft()))sb.append("soft="+this.soft+ " | ");
		 log.debug(sb.toString());
		 return sb.toString();
	}
	
    
    
}