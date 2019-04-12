package mess.wkb.cm.code.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.bean.Query;
import mess.wkb.cm.tool.web.MysqlDBException;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.code.dao.CmDepartmentDAO;
import mess.wkb.cm.code.po.CmDepartmentPO;
import mess.wkb.cm.code.vo.CmDepartment;


@Service("cmDepartmentService")
public class CmDepartmentService extends BaseService<CmDepartmentPO>{
	@Autowired
	CmDepartmentDAO departmentDAO;
	
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 新增对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addCmDepartment(CmDepartment obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("新增对象为空");
			log.error("新增对象为空",e);
			throw e;
		}
		departmentDAO.insertSelective(obj);
	}
	
	/**
	 * 更新单个对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void updateCmDepartment(CmDepartmentPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("修改对象为空");
			log.error("修改对象为空",e);
			throw e;
		}
		this.update(obj);
	}
	
	/**
	 * 通过主键删除对象
	 * @param id
	 * @throws MysqlDBException 
	 */
	public void deleteCmDepartmentById(String id) throws MysqlDBException{
		if(ObjectUtil.isEmpty(id)){
			MysqlDBException e = new MysqlDBException("通过主键删除对象，主键 id 不能为空");
			log.error("通过主键删除对象，主键 id 不能为空",e);
			throw e;
		}
		this.delete(id);
	}
	
	/**
	 * 通过主键 查询对象
	 * @param id
	 * @throws MysqlDBException
	 */
	public CmDepartmentPO getCmDepartmentById(String id) throws MysqlDBException{
		if(ObjectUtil.isEmpty(id)){
			MysqlDBException e = new MysqlDBException("通过主键 查询对象，主键 id 不能为空");
			log.error("通过主键 查询对象，主键 id 不能为空",e);
			throw e;
		}
		return this.get(id);
	}
	
	/**
	 * 条件查询返回分页列表
	 * @param pageNo
	 * @param pageSize
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public Paged<CmDepartmentPO> queryPageCmDepartment(Integer pageNo,Integer pageSize,
			CmDepartmentPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmDepartmentPO> q = Query.build(CmDepartmentPO.class);
		q.setPaged(pageNo, pageSize);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getInfo()))q.addEq("info", obj.getInfo()); 
        if(!ObjectUtil.isEmpty(obj.getDuty()))q.addEq("duty", obj.getDuty()); 
        if(!ObjectUtil.isEmpty(obj.getCharacters()))q.addEq("characters", obj.getCharacters()); 
        if(!ObjectUtil.isEmpty(obj.getMasterName()))q.addEq("masterName", obj.getMasterName()); 
        if(!ObjectUtil.isEmpty(obj.getMasterTel()))q.addEq("masterTel", obj.getMasterTel()); 
        if(!ObjectUtil.isEmpty(obj.getLeadOrganize()))q.addEq("leadOrganize", obj.getLeadOrganize()); 
        if(!ObjectUtil.isEmpty(obj.getRegistrationTime()))q.addEq("registrationTime", obj.getRegistrationTime()); 
        if(!ObjectUtil.isEmpty(obj.getRegistrationName()))q.addEq("registrationName", obj.getRegistrationName()); 
        if(!ObjectUtil.isEmpty(obj.getNum()))q.addEq("num", obj.getNum()); 
        if(!ObjectUtil.isEmpty(obj.getGeneralRules()))q.addEq("generalRules", obj.getGeneralRules()); 
        if(!ObjectUtil.isEmpty(obj.getPurpose()))q.addEq("purpose", obj.getPurpose()); 
        if(!ObjectUtil.isEmpty(obj.getDroit()))q.addEq("droit", obj.getDroit()); 
        if(!ObjectUtil.isEmpty(obj.getObligation()))q.addEq("obligation", obj.getObligation()); 
        if(!ObjectUtil.isEmpty(obj.getRequirement()))q.addEq("requirement", obj.getRequirement()); 
        if(!ObjectUtil.isEmpty(obj.getOther()))q.addEq("other", obj.getOther()); 
        
		//q.addOrder("createtime", DBOrder.DESC);
		Paged<CmDepartmentPO> page = this.findPagedByQuery(q);
		return page;
	}
	
	/**
	 * 条件查询  返回列表
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<CmDepartmentPO> queryListCmDepartmentByParam(CmDepartmentPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmDepartmentPO> q = Query.build(CmDepartmentPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId());
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName());
        if(!ObjectUtil.isEmpty(obj.getInfo()))q.addEq("info", obj.getInfo());
        if(!ObjectUtil.isEmpty(obj.getDuty()))q.addEq("duty", obj.getDuty());
        if(!ObjectUtil.isEmpty(obj.getCharacters()))q.addEq("characters", obj.getCharacters());
        if(!ObjectUtil.isEmpty(obj.getMasterName()))q.addEq("masterName", obj.getMasterName());
        if(!ObjectUtil.isEmpty(obj.getMasterTel()))q.addEq("masterTel", obj.getMasterTel());
        if(!ObjectUtil.isEmpty(obj.getLeadOrganize()))q.addEq("leadOrganize", obj.getLeadOrganize());
        if(!ObjectUtil.isEmpty(obj.getRegistrationTime()))q.addEq("registrationTime", obj.getRegistrationTime());
        if(!ObjectUtil.isEmpty(obj.getRegistrationName()))q.addEq("registrationName", obj.getRegistrationName());
        if(!ObjectUtil.isEmpty(obj.getNum()))q.addEq("num", obj.getNum());
        if(!ObjectUtil.isEmpty(obj.getGeneralRules()))q.addEq("generalRules", obj.getGeneralRules());
        if(!ObjectUtil.isEmpty(obj.getPurpose()))q.addEq("purpose", obj.getPurpose());
        if(!ObjectUtil.isEmpty(obj.getDroit()))q.addEq("droit", obj.getDroit());
        if(!ObjectUtil.isEmpty(obj.getObligation()))q.addEq("obligation", obj.getObligation());
        if(!ObjectUtil.isEmpty(obj.getRequirement()))q.addEq("requirement", obj.getRequirement());
        if(!ObjectUtil.isEmpty(obj.getOther()))q.addEq("other", obj.getOther());
		return this.findByQuery(q);
	}
    
    /**
	 * 条件查询  返回对象实体
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public CmDepartmentPO getCmDepartmentByParam(CmDepartmentPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmDepartmentPO> q = Query.build(CmDepartmentPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getInfo()))q.addEq("info", obj.getInfo()); 
        if(!ObjectUtil.isEmpty(obj.getDuty()))q.addEq("duty", obj.getDuty()); 
        if(!ObjectUtil.isEmpty(obj.getCharacters()))q.addEq("characters", obj.getCharacters()); 
        if(!ObjectUtil.isEmpty(obj.getMasterName()))q.addEq("masterName", obj.getMasterName()); 
        if(!ObjectUtil.isEmpty(obj.getMasterTel()))q.addEq("masterTel", obj.getMasterTel()); 
        if(!ObjectUtil.isEmpty(obj.getLeadOrganize()))q.addEq("leadOrganize", obj.getLeadOrganize()); 
        if(!ObjectUtil.isEmpty(obj.getRegistrationTime()))q.addEq("registrationTime", obj.getRegistrationTime()); 
        if(!ObjectUtil.isEmpty(obj.getRegistrationName()))q.addEq("registrationName", obj.getRegistrationName()); 
        if(!ObjectUtil.isEmpty(obj.getNum()))q.addEq("num", obj.getNum()); 
        if(!ObjectUtil.isEmpty(obj.getGeneralRules()))q.addEq("generalRules", obj.getGeneralRules()); 
        if(!ObjectUtil.isEmpty(obj.getPurpose()))q.addEq("purpose", obj.getPurpose()); 
        if(!ObjectUtil.isEmpty(obj.getDroit()))q.addEq("droit", obj.getDroit()); 
        if(!ObjectUtil.isEmpty(obj.getObligation()))q.addEq("obligation", obj.getObligation()); 
        if(!ObjectUtil.isEmpty(obj.getRequirement()))q.addEq("requirement", obj.getRequirement()); 
        if(!ObjectUtil.isEmpty(obj.getOther()))q.addEq("other", obj.getOther()); 
		return this.get(q);
	}
	
	/**
	 * 导出excel 数据表
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> queryCmDepartmentForExl(CmDepartmentPO obj)throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmDepartmentPO> q = Query.build(CmDepartmentPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getInfo()))q.addEq("info", obj.getInfo()); 
        if(!ObjectUtil.isEmpty(obj.getDuty()))q.addEq("duty", obj.getDuty()); 
        if(!ObjectUtil.isEmpty(obj.getCharacters()))q.addEq("characters", obj.getCharacters()); 
        if(!ObjectUtil.isEmpty(obj.getMasterName()))q.addEq("masterName", obj.getMasterName()); 
        if(!ObjectUtil.isEmpty(obj.getMasterTel()))q.addEq("masterTel", obj.getMasterTel()); 
        if(!ObjectUtil.isEmpty(obj.getLeadOrganize()))q.addEq("leadOrganize", obj.getLeadOrganize()); 
        if(!ObjectUtil.isEmpty(obj.getRegistrationTime()))q.addEq("registrationTime", obj.getRegistrationTime()); 
        if(!ObjectUtil.isEmpty(obj.getRegistrationName()))q.addEq("registrationName", obj.getRegistrationName()); 
        if(!ObjectUtil.isEmpty(obj.getNum()))q.addEq("num", obj.getNum()); 
        if(!ObjectUtil.isEmpty(obj.getGeneralRules()))q.addEq("generalRules", obj.getGeneralRules()); 
        if(!ObjectUtil.isEmpty(obj.getPurpose()))q.addEq("purpose", obj.getPurpose()); 
        if(!ObjectUtil.isEmpty(obj.getDroit()))q.addEq("droit", obj.getDroit()); 
        if(!ObjectUtil.isEmpty(obj.getObligation()))q.addEq("obligation", obj.getObligation()); 
        if(!ObjectUtil.isEmpty(obj.getRequirement()))q.addEq("requirement", obj.getRequirement()); 
        if(!ObjectUtil.isEmpty(obj.getOther()))q.addEq("other", obj.getOther()); 
		String[] columnProperty = {"id","name","info","duty","characters","masterName","masterTel","leadOrganize","registrationTime","registrationName","num","generalRules","purpose","droit","obligation","requirement","other"};
		return this.findExpByQuery(q, columnProperty);
	}
	
	
	
}

