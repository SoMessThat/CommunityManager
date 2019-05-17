package mess.wkb.cm.code.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mess.wkb.cm.code.dao.CmAttendanceDAO;
import mess.wkb.cm.code.po.CmAttendancePO;
import mess.wkb.cm.code.vo.CmAttendance;
import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.bean.Query;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.web.MysqlDBException;


@Service("cmAttendanceService")
public class CmAttendanceService extends BaseService<CmAttendancePO>{
	@Autowired
	CmAttendanceDAO attendanceDAO;
	
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 新增对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addCmAttendance(CmAttendance obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("新增对象为空");
			log.error("新增对象为空",e);
			throw e;
		}
		attendanceDAO.insertSelective(obj);
	}
	
	/**
	 * 更新单个对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void updateCmAttendance(CmAttendancePO obj) throws MysqlDBException{
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
	public void deleteCmAttendanceById(String id) throws MysqlDBException{
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
	public CmAttendancePO getCmAttendanceById(String id) throws MysqlDBException{
		if(ObjectUtil.isEmpty(id)){
			MysqlDBException e = new MysqlDBException("通过主键 查询对象，主键 id 不能为空");
			log.error("通过主键 查询对象，主键 id 不能为空",e);
			throw e;
		}
		return attendanceDAO.selectByPrimaryKey(Long.parseLong(id));
	}
	
	/**
	 * 条件查询返回分页列表
	 * @param pageNo
	 * @param pageSize
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	public Paged<CmAttendancePO> queryPageCmAttendance(Integer pageNo,Integer pageSize,
			CmAttendancePO obj) throws MysqlDBException{
		List<CmAttendancePO> list = attendanceDAO.queryListCmAttendance(obj);
		return new Paged<>(list, list.size(), pageNo, pageSize, true);
	}
	
	/**
	 * 条件查询  返回列表
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<CmAttendancePO> queryListCmAttendanceByParam(CmAttendancePO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmAttendancePO> q = Query.build(CmAttendancePO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId());
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName());
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent());
        if(!ObjectUtil.isEmpty(obj.getPlace()))q.addEq("place", obj.getPlace());
        if(!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime());
        if(!ObjectUtil.isEmpty(obj.getBeginTime()))q.addEq("beginTime", obj.getBeginTime());
        if(!ObjectUtil.isEmpty(obj.getEndTime()))q.addEq("endTime", obj.getEndTime());
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
	public CmAttendancePO getCmAttendanceByParam(CmAttendancePO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmAttendancePO> q = Query.build(CmAttendancePO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getPlace()))q.addEq("place", obj.getPlace()); 
        if(!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime()); 
        if(!ObjectUtil.isEmpty(obj.getBeginTime()))q.addEq("beginTime", obj.getBeginTime()); 
        if(!ObjectUtil.isEmpty(obj.getEndTime()))q.addEq("endTime", obj.getEndTime()); 
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
	public List<String[]> queryCmAttendanceForExl(CmAttendancePO obj)throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmAttendancePO> q = Query.build(CmAttendancePO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getName()))q.addEq("name", obj.getName()); 
        if(!ObjectUtil.isEmpty(obj.getContent()))q.addEq("content", obj.getContent()); 
        if(!ObjectUtil.isEmpty(obj.getPlace()))q.addEq("place", obj.getPlace()); 
        if(!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime()); 
        if(!ObjectUtil.isEmpty(obj.getBeginTime()))q.addEq("beginTime", obj.getBeginTime()); 
        if(!ObjectUtil.isEmpty(obj.getEndTime()))q.addEq("endTime", obj.getEndTime()); 
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId()); 
        if(!ObjectUtil.isEmpty(obj.getUserName()))q.addEq("userName", obj.getUserName()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
		String[] columnProperty = {"id","name","content","place","creatTime","beginTime","endTime","departmentId","userName","state"};
		return this.findExpByQuery(q, columnProperty);
	}

	/**
	 * 通过主键 查询对象
	 * @param id
	 * @throws MysqlDBException
	 */
	public CmAttendancePO getCmAttendanceById(Map<String, String> map) throws MysqlDBException {
		if(ObjectUtil.isEmpty(map)){
			MysqlDBException e = new MysqlDBException("通过主键 查询对象，主键 id 不能为空");
			log.error("通过主键 查询对象，主键 id 不能为空",e);
			throw e;
		}
		return attendanceDAO.selectMeeting(map);
	}

	public Map<String, String> getCount(Map<String, String> map) {
		return attendanceDAO.getCount(map);
	}

	public List<Map<String, String>> getSeat(Map<String, String> map) {
		return attendanceDAO.getSeat(map);
	}
	
	
	
}

