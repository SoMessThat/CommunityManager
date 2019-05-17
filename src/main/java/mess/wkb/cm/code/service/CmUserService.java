package mess.wkb.cm.code.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.bean.Query;
import mess.wkb.cm.tool.web.MysqlDBException;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.code.dao.CmUserDAO;
import mess.wkb.cm.code.dto.UserInfoDTO;
import mess.wkb.cm.code.po.CmUserPO;
import mess.wkb.cm.code.vo.CmUser;


@Service("cmUserService")
public class CmUserService extends BaseService<CmUserPO>{
	
	@Autowired
	CmUserDAO userDAO;
	
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 新增对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addCmUser(CmUserPO obj) throws MysqlDBException{
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
	public void updateCmUser(CmUser obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("修改对象为空");
			log.error("修改对象为空",e);
			throw e;
		}
		userDAO.updateByPrimaryKeySelective(obj);
	}
	
	/**
	 * 通过主键删除对象
	 * @param id
	 * @throws MysqlDBException 
	 */
	public void deleteCmUserById(String id) throws MysqlDBException{
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
	public UserInfoDTO getCmUserById(String id) throws MysqlDBException{
		if(ObjectUtil.isEmpty(id)){
			MysqlDBException e = new MysqlDBException("通过主键 查询对象，主键 id 不能为空");
			log.error("通过主键 查询对象，主键 id 不能为空",e);
			throw e;
		}
		return userDAO.getCmUserById(id);
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
	public Paged<CmUserPO> queryPageCmUser(Integer pageNo,Integer pageSize,
			CmUserPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmUserPO> q = Query.build(CmUserPO.class);
		q.setPaged(pageNo, pageSize);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getAccount()))q.addEq("account", obj.getAccount()); 
        if(!ObjectUtil.isEmpty(obj.getUsername()))q.addEq("username", obj.getUsername()); 
        if(!ObjectUtil.isEmpty(obj.getPassword()))q.addEq("password", obj.getPassword()); 
        if(!ObjectUtil.isEmpty(obj.getAvatar()))q.addEq("avatar", obj.getAvatar()); 
        if(!ObjectUtil.isEmpty(obj.getTel()))q.addEq("tel", obj.getTel()); 
        if(!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId()); 
        if(!ObjectUtil.isEmpty(obj.getStudentId()))q.addEq("studentId", obj.getStudentId()); 
        if(!ObjectUtil.isEmpty(obj.getRole()))q.addEq("role", obj.getRole()); 
        
		//q.addOrder("createtime", DBOrder.DESC);
		Paged<CmUserPO> page = this.findPagedByQuery(q);
		return page;
	}
	
	/**
	 * 条件查询  返回列表
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<CmUserPO> queryListCmUserByParam(CmUserPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmUserPO> q = Query.build(CmUserPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId());
        if(!ObjectUtil.isEmpty(obj.getAccount()))q.addEq("account", obj.getAccount());
        if(!ObjectUtil.isEmpty(obj.getUsername()))q.addEq("username", obj.getUsername());
        if(!ObjectUtil.isEmpty(obj.getPassword()))q.addEq("password", obj.getPassword());
        if(!ObjectUtil.isEmpty(obj.getAvatar()))q.addEq("avatar", obj.getAvatar());
        if(!ObjectUtil.isEmpty(obj.getTel()))q.addEq("tel", obj.getTel());
        if(!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime());
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState());
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId());
        if(!ObjectUtil.isEmpty(obj.getStudentId()))q.addEq("studentId", obj.getStudentId());
        if(!ObjectUtil.isEmpty(obj.getRole()))q.addEq("role", obj.getRole());
		return this.findByQuery(q);
	}
    
    /**
	 * 条件查询  返回对象实体
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public CmUserPO getCmUserByParam(CmUserPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmUserPO> q = Query.build(CmUserPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getAccount()))q.addEq("account", obj.getAccount()); 
        if(!ObjectUtil.isEmpty(obj.getUsername()))q.addEq("username", obj.getUsername()); 
        if(!ObjectUtil.isEmpty(obj.getPassword()))q.addEq("password", obj.getPassword()); 
        if(!ObjectUtil.isEmpty(obj.getAvatar()))q.addEq("avatar", obj.getAvatar()); 
        if(!ObjectUtil.isEmpty(obj.getTel()))q.addEq("tel", obj.getTel()); 
        if(!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId()); 
        if(!ObjectUtil.isEmpty(obj.getStudentId()))q.addEq("studentId", obj.getStudentId()); 
        if(!ObjectUtil.isEmpty(obj.getRole()))q.addEq("role", obj.getRole()); 
		return this.get(q);
	}
	
	/**
	 * 导出excel 数据表
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> queryCmUserForExl(CmUserPO obj)throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<CmUserPO> q = Query.build(CmUserPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getAccount()))q.addEq("account", obj.getAccount()); 
        if(!ObjectUtil.isEmpty(obj.getUsername()))q.addEq("username", obj.getUsername()); 
        if(!ObjectUtil.isEmpty(obj.getPassword()))q.addEq("password", obj.getPassword()); 
        if(!ObjectUtil.isEmpty(obj.getAvatar()))q.addEq("avatar", obj.getAvatar()); 
        if(!ObjectUtil.isEmpty(obj.getTel()))q.addEq("tel", obj.getTel()); 
        if(!ObjectUtil.isEmpty(obj.getCreatTime()))q.addEq("creatTime", obj.getCreatTime()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        if(!ObjectUtil.isEmpty(obj.getDepartmentId()))q.addEq("departmentId", obj.getDepartmentId()); 
        if(!ObjectUtil.isEmpty(obj.getStudentId()))q.addEq("studentId", obj.getStudentId()); 
        if(!ObjectUtil.isEmpty(obj.getRole()))q.addEq("role", obj.getRole()); 
		String[] columnProperty = {"id","account","username","password","avatar","tel","creatTime","state","departmentId","studentId","role"};
		return this.findExpByQuery(q, columnProperty);
	}

	public void insertSelective(CmUser user) {
		userDAO.insertSelective(user);
	}
	
	
	/**
	 * 更新个人信息
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void updateUserInfo(CmUser obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("修改对象为空");
			log.error("修改对象为空",e);
			throw e;
		}
		userDAO.updateUserInfo(obj);
	}

	public Paged<UserInfoDTO> queryEmployee(Integer page,Integer limit,String departmentId) {
		List<UserInfoDTO> list = userDAO.queryEmployee(departmentId);
		Paged<UserInfoDTO> pages = new  Paged<UserInfoDTO>(list, list.size(), page, limit, true);
		return pages;
	}
}

