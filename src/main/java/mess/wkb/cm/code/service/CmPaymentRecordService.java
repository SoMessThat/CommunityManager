package mess.wkb.cm.code.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mess.wkb.cm.code.dao.CmPaymentRecordDAO;
import mess.wkb.cm.code.po.CmPaymentRecordPO;
import mess.wkb.cm.code.vo.CmPaymentRecord;
import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.bean.Query;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.web.MysqlDBException;


@Service("cmPaymentRecordService")
public class CmPaymentRecordService extends BaseService<CmPaymentRecordPO>{
	
	@Autowired
	CmPaymentRecordDAO paymentRecordDAO;
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 新增对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addCmPaymentRecord(CmPaymentRecord obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("新增对象为空");
			log.error("新增对象为空",e);
			throw e;
		}
		paymentRecordDAO.insertSelective(obj);
	}
	
	/**
	 * 更新单个对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void updateCmPaymentRecord(CmPaymentRecordPO obj) throws MysqlDBException{
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
	public void deleteCmPaymentRecordById(String id) throws MysqlDBException{
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
	public CmPaymentRecordPO getCmPaymentRecordById(String id) throws MysqlDBException{
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
	public Paged<CmPaymentRecordPO> queryPageCmPaymentRecord(Integer pageNo,Integer pageSize,
			CmPaymentRecordPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmPaymentRecordPO> q = Query.build(CmPaymentRecordPO.class);
		q.setPaged(pageNo, pageSize);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getPayTime()))q.addEq("payTime", obj.getPayTime()); 
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId()); 
        if(!ObjectUtil.isEmpty(obj.getUserName()))q.addEq("userName", obj.getUserName()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        if(!ObjectUtil.isEmpty(obj.getPaymentId()))q.addEq("paymentId", obj.getPaymentId()); 
        
		//q.addOrder("createtime", DBOrder.DESC);
		Paged<CmPaymentRecordPO> page = this.findPagedByQuery(q);
		return page;
	}
	
	/**
	 * 条件查询  返回列表
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<CmPaymentRecordPO> queryListCmPaymentRecordByParam(CmPaymentRecordPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmPaymentRecordPO> q = Query.build(CmPaymentRecordPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId());
        if(!ObjectUtil.isEmpty(obj.getPayTime()))q.addEq("payTime", obj.getPayTime());
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId());
        if(!ObjectUtil.isEmpty(obj.getUserName()))q.addEq("userName", obj.getUserName());
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState());
        if(!ObjectUtil.isEmpty(obj.getPaymentId()))q.addEq("paymentId", obj.getPaymentId());
		return this.findByQuery(q);
	}
    
    /**
	 * 条件查询  返回对象实体
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public CmPaymentRecordPO getCmPaymentRecordByParam(CmPaymentRecordPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmPaymentRecordPO> q = Query.build(CmPaymentRecordPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getPayTime()))q.addEq("payTime", obj.getPayTime()); 
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId()); 
        if(!ObjectUtil.isEmpty(obj.getUserName()))q.addEq("userName", obj.getUserName()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        if(!ObjectUtil.isEmpty(obj.getPaymentId()))q.addEq("paymentId", obj.getPaymentId()); 
		return this.get(q);
	}
	
	/**
	 * 导出excel 数据表
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> queryCmPaymentRecordForExl(CmPaymentRecordPO obj)throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmPaymentRecordPO> q = Query.build(CmPaymentRecordPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getPayTime()))q.addEq("payTime", obj.getPayTime()); 
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId()); 
        if(!ObjectUtil.isEmpty(obj.getUserName()))q.addEq("userName", obj.getUserName()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        if(!ObjectUtil.isEmpty(obj.getPaymentId()))q.addEq("paymentId", obj.getPaymentId()); 
		String[] columnProperty = {"id","payTime","departmentId","userName","state","paymentId"};
		return this.findExpByQuery(q, columnProperty);
	}
	
	
	
}

