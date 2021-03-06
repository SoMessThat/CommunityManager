package mess.wkb.cm.code.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.bean.Query;
import mess.wkb.cm.tool.web.MysqlDBException;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.code.dao.CmPowerDAO;
import mess.wkb.cm.code.dto.PowerDTO;
import mess.wkb.cm.code.po.CmPowerPO;


@Service("cmPowerService")
public class CmPowerService extends BaseService<CmPowerPO>{
	
	@Autowired
	CmPowerDAO powerDAO;

	Logger log = Logger.getLogger(this.getClass());
	/**
	 * 新增对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addCmPower(CmPowerPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("新增对象为空");
			log.error("新增对象为空",e);
			throw e;
		}
		this.insert(obj);
	}
	
	/**
	 * 更新单个对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void updateCmPower(CmPowerPO obj) throws MysqlDBException{
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
	public void deleteCmPowerById(String id) throws MysqlDBException{
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
	public CmPowerPO getCmPowerById(String id) throws MysqlDBException{
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
	public Paged<CmPowerPO> queryPageCmPower(Integer pageNo,Integer pageSize,
			CmPowerPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmPowerPO> q = Query.build(CmPowerPO.class);
		q.setPaged(pageNo, pageSize);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getParentId()))q.addEq("parentId", obj.getParentId()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getSoft()))q.addEq("soft", obj.getSoft()); 
        
		//q.addOrder("createtime", DBOrder.DESC);
		Paged<CmPowerPO> page = this.findPagedByQuery(q);
		return page;
	}
	
	/**
	 * 条件查询  返回列表
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<CmPowerPO> queryListCmPowerByParam(CmPowerPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmPowerPO> q = Query.build(CmPowerPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId());
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName());
        if(!ObjectUtil.isEmpty(obj.getParentId()))q.addEq("parentId", obj.getParentId());
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent());
        if(!ObjectUtil.isEmpty(obj.getSoft()))q.addEq("soft", obj.getSoft());
		return this.findByQuery(q);
	}
    
    /**
	 * 条件查询  返回对象实体
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public CmPowerPO getCmPowerByParam(CmPowerPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmPowerPO> q = Query.build(CmPowerPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getParentId()))q.addEq("parentId", obj.getParentId()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getSoft()))q.addEq("soft", obj.getSoft()); 
		return this.get(q);
	}
	
	/**
	 * 导出excel 数据表
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> queryCmPowerForExl(CmPowerPO obj)throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmPowerPO> q = Query.build(CmPowerPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getParentId()))q.addEq("parentId", obj.getParentId()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getSoft()))q.addEq("soft", obj.getSoft()); 
		String[] columnProperty = {"id","name","parentId","content","soft"};
		return this.findExpByQuery(q, columnProperty);
	}

	public List<PowerDTO> queryMenu(String userID) throws MysqlDBException {
		if(ObjectUtil.isEmpty(userID)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
		return powerDAO.selectPowerRootByUserID(userID);
	}
	
	
	
}

