package mess.wkb.cm.code.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.bean.Query;
import mess.wkb.cm.tool.web.MysqlDBException;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.code.dao.CmWorkSummaryDAO;
import mess.wkb.cm.code.po.CmWorkSummaryPO;
import mess.wkb.cm.code.vo.CmWorkSummary;


@Service("cmWorkSummaryService")
public class CmWorkSummaryService extends BaseService<CmWorkSummaryPO>{
	
	@Autowired
	CmWorkSummaryDAO workSummaryDAO;
	
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 新增对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addCmWorkSummary(CmWorkSummary obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("新增对象为空");
			log.error("新增对象为空",e);
			throw e;
		}
		workSummaryDAO.insertSelective(obj);
	}
	
	/**
	 * 更新单个对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void updateCmWorkSummary(CmWorkSummary obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("修改对象为空");
			log.error("修改对象为空",e);
			throw e;
		}
		workSummaryDAO.updateByPrimaryKeySelective(obj);
	}
	
	/**
	 * 通过主键删除对象
	 * @param id
	 * @throws MysqlDBException 
	 */
	public void deleteCmWorkSummaryById(String id) throws MysqlDBException{
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
	public CmWorkSummaryPO getCmWorkSummaryById(String id) throws MysqlDBException{
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
	public Paged<CmWorkSummaryPO> queryPageCmWorkSummary(Integer pageNo,Integer pageSize,
			CmWorkSummaryPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmWorkSummaryPO> q = Query.build(CmWorkSummaryPO.class);
		q.setPaged(pageNo, pageSize);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getTitle()))q.addEq("title", obj.getTitle()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime()); 
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId()); 
        if(!ObjectUtil.isEmpty(obj.getUserName()))q.addEq("userName", obj.getUserName()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        
		//q.addOrder("createtime", DBOrder.DESC);
		Paged<CmWorkSummaryPO> page = this.findPagedByQuery(q);
		return page;
	}
	
	/**
	 * 条件查询  返回列表
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<CmWorkSummaryPO> queryListCmWorkSummaryByParam(CmWorkSummaryPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmWorkSummaryPO> q = Query.build(CmWorkSummaryPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId());
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName());
        if(!ObjectUtil.isEmpty(obj.getTitle()))q.addEq("title", obj.getTitle());
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent());
        if(!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime());
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId());
        if(!ObjectUtil.isEmpty(obj.getUserName()))q.addEq("userName", obj.getUserName());
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
	public CmWorkSummaryPO getCmWorkSummaryByParam(CmWorkSummaryPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmWorkSummaryPO> q = Query.build(CmWorkSummaryPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getTitle()))q.addEq("title", obj.getTitle()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime()); 
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId()); 
        if(!ObjectUtil.isEmpty(obj.getUserName()))q.addEq("userName", obj.getUserName()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
		return this.get(q);
	}
	
	/**
	 * 导出excel 数据表
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> queryCmWorkSummaryForExl(CmWorkSummaryPO obj)throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmWorkSummaryPO> q = Query.build(CmWorkSummaryPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getTitle()))q.addEq("title", obj.getTitle()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime()); 
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId()); 
        if(!ObjectUtil.isEmpty(obj.getUserName()))q.addEq("userName", obj.getUserName()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
		String[] columnProperty = {"id","name","title","content","creatTime","departmentId","userName","state"};
		return this.findExpByQuery(q, columnProperty);
	}
	
	
	
}

