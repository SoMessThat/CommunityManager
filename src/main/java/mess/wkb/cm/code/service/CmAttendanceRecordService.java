package mess.wkb.cm.code.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.bean.Query;
import mess.wkb.cm.tool.web.MysqlDBException;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.code.dao.CmAttendanceRecordDAO;
import mess.wkb.cm.code.po.CmAttendanceRecordPO;


@Service("cmAttendanceRecordService")
public class CmAttendanceRecordService extends BaseService<CmAttendanceRecordPO>{
	
	@Autowired
	CmAttendanceRecordDAO attendanceRecordDAO;
	
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 新增对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addCmAttendanceRecord(CmAttendanceRecordPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("新增对象为空");
			log.error("新增对象为空",e);
			throw e;
		}
		attendanceRecordDAO.insertSelective(obj);
	}
	
	/**
	 * 更新单个对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void updateCmAttendanceRecord(CmAttendanceRecordPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("修改对象为空");
			log.error("修改对象为空",e);
			throw e;
		}
		attendanceRecordDAO.updateByPrimaryKeySelective(obj);
	}
	
	/**
	 * 通过主键删除对象
	 * @param id
	 * @throws MysqlDBException 
	 */
	public void deleteCmAttendanceRecordById(String id) throws MysqlDBException{
		if(ObjectUtil.isEmpty(id)){
			MysqlDBException e = new MysqlDBException("通过主键删除对象，主键 id 不能为空");
			log.error("通过主键删除对象，主键 id 不能为空",e);
			throw e;
		}
		this.delete(id);
	}
	
	/**
	 * 通过主键 查询对象
	 * @param long1
	 * @throws MysqlDBException
	 */
	public CmAttendanceRecordPO getCmAttendanceRecordById(Long long1) throws MysqlDBException{
		return attendanceRecordDAO.selectByPrimaryKey(long1);
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
	public Paged<CmAttendanceRecordPO> queryPageCmAttendanceRecord(Integer pageNo,Integer pageSize,
			CmAttendanceRecordPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmAttendanceRecordPO> q = Query.build(CmAttendanceRecordPO.class);
		q.setPaged(pageNo, pageSize);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getSignTime()))q.addEq("signTime", obj.getSignTime()); 
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId()); 
        if(!ObjectUtil.isEmpty(obj.getUserName()))q.addEq("userName", obj.getUserName()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        if(!ObjectUtil.isEmpty(obj.getAttendanceId()))q.addEq("attendanceId", obj.getAttendanceId()); 
        
		//q.addOrder("createtime", DBOrder.DESC);
		Paged<CmAttendanceRecordPO> page = this.findPagedByQuery(q);
		return page;
	}
	
	/**
	 * 条件查询  返回列表
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<CmAttendanceRecordPO> queryListCmAttendanceRecordByParam(CmAttendanceRecordPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmAttendanceRecordPO> q = Query.build(CmAttendanceRecordPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId());
        if(!ObjectUtil.isEmpty(obj.getSignTime()))q.addEq("signTime", obj.getSignTime());
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId());
        if(!ObjectUtil.isEmpty(obj.getUserName()))q.addEq("userName", obj.getUserName());
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState());
        if(!ObjectUtil.isEmpty(obj.getAttendanceId()))q.addEq("attendanceId", obj.getAttendanceId());
		return this.findByQuery(q);
	}
    
    /**
	 * 条件查询  返回对象实体
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public CmAttendanceRecordPO getCmAttendanceRecordByParam(CmAttendanceRecordPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmAttendanceRecordPO> q = Query.build(CmAttendanceRecordPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getSignTime()))q.addEq("signTime", obj.getSignTime()); 
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId()); 
        if(!ObjectUtil.isEmpty(obj.getUserName()))q.addEq("userName", obj.getUserName()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        if(!ObjectUtil.isEmpty(obj.getAttendanceId()))q.addEq("attendanceId", obj.getAttendanceId()); 
		return this.get(q);
	}
	
	/**
	 * 导出excel 数据表
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> queryCmAttendanceRecordForExl(CmAttendanceRecordPO obj)throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmAttendanceRecordPO> q = Query.build(CmAttendanceRecordPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getSignTime()))q.addEq("signTime", obj.getSignTime()); 
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId()); 
        if(!ObjectUtil.isEmpty(obj.getUserName()))q.addEq("userName", obj.getUserName()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        if(!ObjectUtil.isEmpty(obj.getAttendanceId()))q.addEq("attendanceId", obj.getAttendanceId()); 
		String[] columnProperty = {"id","signTime","departmentId","userName","state","attendanceId"};
		return this.findExpByQuery(q, columnProperty);
	}

	public void seat(Map<String, String> map) {
		attendanceRecordDAO.seat(map);
	}

	public CmAttendanceRecordPO getAttend(CmAttendanceRecordPO po) {
		return attendanceRecordDAO.getAttend(po);
	}
	
	
	
}

