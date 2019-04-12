package mess.wkb.cm.code.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.bean.Query;
import mess.wkb.cm.tool.web.MysqlDBException;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.code.dao.CmSchemeDAO;
import mess.wkb.cm.code.po.CmSchemePO;
import mess.wkb.cm.code.vo.CmScheme;


@Service("cmSchemeService")
public class CmSchemeService extends BaseService<CmSchemePO>{
	
	@Autowired
	CmSchemeDAO schemeDAO;
	
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 新增对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addCmScheme(CmScheme obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("新增对象为空");
			log.error("新增对象为空",e);
			throw e;
		}
		schemeDAO.insertSelective(obj);
	}
	
	/**
	 * 更新单个对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void updateCmScheme(CmScheme obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("修改对象为空");
			log.error("修改对象为空",e);
			throw e;
		}
		schemeDAO.updateByPrimaryKeySelective(obj);
	}
	
	/**
	 * 通过主键删除对象
	 * @param id
	 * @throws MysqlDBException 
	 */
	public void deleteCmSchemeById(String id) throws MysqlDBException{
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
	public CmSchemePO getCmSchemeById(String id) throws MysqlDBException{
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
	public Paged<CmSchemePO> queryPageCmScheme(Integer pageNo,Integer pageSize,
			CmSchemePO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmSchemePO> q = Query.build(CmSchemePO.class);
		q.setPaged(pageNo, pageSize);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getCode()))q.addEq("code", obj.getCode()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getDescription()))q.addEq("description", obj.getDescription()); 
        if(!ObjectUtil.isEmpty(obj.getTheme()))q.addEq("theme", obj.getTheme()); 
        if(!ObjectUtil.isEmpty(obj.getGoal()))q.addEq("goal", obj.getGoal()); 
        if(!ObjectUtil.isEmpty(obj.getBeginTime()))q.addEq("beginTime", obj.getBeginTime()); 
        if(!ObjectUtil.isEmpty(obj.getPlace()))q.addEq("place", obj.getPlace()); 
        if(!ObjectUtil.isEmpty(obj.getPerson()))q.addEq("person", obj.getPerson()); 
        if(!ObjectUtil.isEmpty(obj.getForm()))q.addEq("form", obj.getForm()); 
        if(!ObjectUtil.isEmpty(obj.getArrangements()))q.addEq("arrangements", obj.getArrangements()); 
        if(!ObjectUtil.isEmpty(obj.getFlow()))q.addEq("flow", obj.getFlow()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getBudget()))q.addEq("budget", obj.getBudget()); 
        if(!ObjectUtil.isEmpty(obj.getAward()))q.addEq("award", obj.getAward()); 
        if(!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime()); 
        if(!ObjectUtil.isEmpty(obj.getCreatPerson()))q.addEq("creatPerson", obj.getCreatPerson()); 
        if(!ObjectUtil.isEmpty(obj.getDepartment()))q.addEq("department", obj.getDepartment()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        
		//q.addOrder("createtime", DBOrder.DESC);
		Paged<CmSchemePO> page = this.findPagedByQuery(q);
		return page;
	}
	
	/**
	 * 条件查询  返回列表
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<CmSchemePO> queryListCmSchemeByParam(CmSchemePO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmSchemePO> q = Query.build(CmSchemePO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId());
        if(!ObjectUtil.isEmpty(obj.getCode()))q.addEq("code", obj.getCode());
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName());
        if(!ObjectUtil.isEmpty(obj.getDescription()))q.addEq("description", obj.getDescription());
        if(!ObjectUtil.isEmpty(obj.getTheme()))q.addEq("theme", obj.getTheme());
        if(!ObjectUtil.isEmpty(obj.getGoal()))q.addEq("goal", obj.getGoal());
        if(!ObjectUtil.isEmpty(obj.getBeginTime()))q.addEq("beginTime", obj.getBeginTime());
        if(!ObjectUtil.isEmpty(obj.getPlace()))q.addEq("place", obj.getPlace());
        if(!ObjectUtil.isEmpty(obj.getPerson()))q.addEq("person", obj.getPerson());
        if(!ObjectUtil.isEmpty(obj.getForm()))q.addEq("form", obj.getForm());
        if(!ObjectUtil.isEmpty(obj.getArrangements()))q.addEq("arrangements", obj.getArrangements());
        if(!ObjectUtil.isEmpty(obj.getFlow()))q.addEq("flow", obj.getFlow());
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent());
        if(!ObjectUtil.isEmpty(obj.getBudget()))q.addEq("budget", obj.getBudget());
        if(!ObjectUtil.isEmpty(obj.getAward()))q.addEq("award", obj.getAward());
        if(!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime());
        if(!ObjectUtil.isEmpty(obj.getCreatPerson()))q.addEq("creatPerson", obj.getCreatPerson());
        if(!ObjectUtil.isEmpty(obj.getDepartment()))q.addEq("department", obj.getDepartment());
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState());
		return this.findByQuery(q);
	}
    
    /**
	 * 条件查询  返回对象实体
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public CmSchemePO getCmSchemeByParam(CmSchemePO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmSchemePO> q = Query.build(CmSchemePO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getCode()))q.addEq("code", obj.getCode()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getDescription()))q.addEq("description", obj.getDescription()); 
        if(!ObjectUtil.isEmpty(obj.getTheme()))q.addEq("theme", obj.getTheme()); 
        if(!ObjectUtil.isEmpty(obj.getGoal()))q.addEq("goal", obj.getGoal()); 
        if(!ObjectUtil.isEmpty(obj.getBeginTime()))q.addEq("beginTime", obj.getBeginTime()); 
        if(!ObjectUtil.isEmpty(obj.getPlace()))q.addEq("place", obj.getPlace()); 
        if(!ObjectUtil.isEmpty(obj.getPerson()))q.addEq("person", obj.getPerson()); 
        if(!ObjectUtil.isEmpty(obj.getForm()))q.addEq("form", obj.getForm()); 
        if(!ObjectUtil.isEmpty(obj.getArrangements()))q.addEq("arrangements", obj.getArrangements()); 
        if(!ObjectUtil.isEmpty(obj.getFlow()))q.addEq("flow", obj.getFlow()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getBudget()))q.addEq("budget", obj.getBudget()); 
        if(!ObjectUtil.isEmpty(obj.getAward()))q.addEq("award", obj.getAward()); 
        if(!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime()); 
        if(!ObjectUtil.isEmpty(obj.getCreatPerson()))q.addEq("creatPerson", obj.getCreatPerson()); 
        if(!ObjectUtil.isEmpty(obj.getDepartment()))q.addEq("department", obj.getDepartment()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
		return this.get(q);
	}
	
	/**
	 * 导出excel 数据表
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> queryCmSchemeForExl(CmSchemePO obj)throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmSchemePO> q = Query.build(CmSchemePO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getCode()))q.addEq("code", obj.getCode()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getDescription()))q.addEq("description", obj.getDescription()); 
        if(!ObjectUtil.isEmpty(obj.getTheme()))q.addEq("theme", obj.getTheme()); 
        if(!ObjectUtil.isEmpty(obj.getGoal()))q.addEq("goal", obj.getGoal()); 
        if(!ObjectUtil.isEmpty(obj.getBeginTime()))q.addEq("beginTime", obj.getBeginTime()); 
        if(!ObjectUtil.isEmpty(obj.getPlace()))q.addEq("place", obj.getPlace()); 
        if(!ObjectUtil.isEmpty(obj.getPerson()))q.addEq("person", obj.getPerson()); 
        if(!ObjectUtil.isEmpty(obj.getForm()))q.addEq("form", obj.getForm()); 
        if(!ObjectUtil.isEmpty(obj.getArrangements()))q.addEq("arrangements", obj.getArrangements()); 
        if(!ObjectUtil.isEmpty(obj.getFlow()))q.addEq("flow", obj.getFlow()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getBudget()))q.addEq("budget", obj.getBudget()); 
        if(!ObjectUtil.isEmpty(obj.getAward()))q.addEq("award", obj.getAward()); 
        if(!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime()); 
        if(!ObjectUtil.isEmpty(obj.getCreatPerson()))q.addEq("creatPerson", obj.getCreatPerson()); 
        if(!ObjectUtil.isEmpty(obj.getDepartment()))q.addEq("department", obj.getDepartment()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
		String[] columnProperty = {"id","code","name","description","theme","goal","beginTime","place","person","form","arrangements","flow","content","budget","award","creatTime","creatPerson","department","state"};
		return this.findExpByQuery(q, columnProperty);
	}
	
	
	
}

