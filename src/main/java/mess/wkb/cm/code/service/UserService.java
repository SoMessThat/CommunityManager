package mess.wkb.cm.code.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import mess.wkb.cm.code.po.UserPO;
import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.bean.Query;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.web.MysqlDBException;


@Service("UserService")
public class UserService extends BaseService<UserPO>{
	
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 新增对象
	 * @param obj
	 * @throws MysqlDBException
	 */
	public void addTUser(UserPO obj) throws MysqlDBException{
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
	public void updateTUser(UserPO obj) throws MysqlDBException{
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
	public void deleteTUserById(String id) throws MysqlDBException{
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
	public UserPO getTUserById(String id) throws MysqlDBException{
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
	public Paged<UserPO> queryPageTUser(Integer pageNo,Integer pageSize,
			UserPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<UserPO> q = Query.build(UserPO.class);
		q.setPaged(pageNo, pageSize);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getAccount()))q.addEq("account", obj.getAccount()); 
        if(!ObjectUtil.isEmpty(obj.getUsername()))q.addEq("username", obj.getUsername()); 
        if(!ObjectUtil.isEmpty(obj.getPassword()))q.addEq("password", obj.getPassword()); 
        if(!ObjectUtil.isEmpty(obj.getUserEmail()))q.addEq("userEmail", obj.getUserEmail()); 
        if(!ObjectUtil.isEmpty(obj.getAvatar()))q.addEq("avatar", obj.getAvatar()); 
        if(!ObjectUtil.isEmpty(obj.getTel()))q.addEq("tel", obj.getTel()); 
        if(!ObjectUtil.isEmpty(obj.getSex()))q.addEq("sex", obj.getSex()); 
        if(!ObjectUtil.isEmpty(obj.getSchool()))q.addEq("school", obj.getSchool()); 
        if(!ObjectUtil.isEmpty(obj.getAddress()))q.addEq("address", obj.getAddress()); 
//        if(!ObjectUtil.isEmpty(obj.getCreatTimeBegin()) && !ObjectUtil.isEmpty(obj.getCreatTimeEnd())) {
//			q.addBetween("creatTime", obj.getCreatTimeBegin(), obj.getCreatTimeEnd());
//		}else{
//			if(!ObjectUtil.isEmpty(obj.getCreatTimeBegin())) q.addGt("creatTime", obj.getCreatTimeBegin());
//			if(!ObjectUtil.isEmpty(obj.getCreatTimeEnd()))   q.addLt("creatTime", obj.getCreatTimeEnd());
//		}
//        
//        if(!ObjectUtil.isEmpty(obj.getLastTimeBegin()) && !ObjectUtil.isEmpty(obj.getLastTimeEnd())) {
//			q.addBetween("lastTime", obj.getLastTimeBegin(), obj.getLastTimeEnd());
//		}else{
//			if(!ObjectUtil.isEmpty(obj.getLastTimeBegin())) q.addGt("lastTime", obj.getLastTimeBegin());
//			if(!ObjectUtil.isEmpty(obj.getLastTimeEnd()))   q.addLt("lastTime", obj.getLastTimeEnd());
//		}
        
        if(!ObjectUtil.isEmpty(obj.getLoginIp()))q.addEq("loginIp", obj.getLoginIp()); 
        if(!ObjectUtil.isEmpty(obj.getIsAdmin()))q.addEq("isAdmin", obj.getIsAdmin()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        if(!ObjectUtil.isEmpty(obj.getLng()))q.addEq("lng", obj.getLng()); 
        if(!ObjectUtil.isEmpty(obj.getLat()))q.addEq("lat", obj.getLat()); 
        if(!ObjectUtil.isEmpty(obj.getQq()))q.addEq("qq", obj.getQq()); 
        if(!ObjectUtil.isEmpty(obj.getWechat()))q.addEq("wechat", obj.getWechat()); 
        if(!ObjectUtil.isEmpty(obj.getAlipay()))q.addEq("alipay", obj.getAlipay()); 
        
		//q.addOrder("createtime", DBOrder.DESC);
		Paged<UserPO> page = this.findPagedByQuery(q);
		return page;
	}
	
	/**
	 * 条件查询  返回列表
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public List<UserPO> queryListTUserByParam(UserPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<UserPO> q = Query.build(UserPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getAccount()))q.addEq("account", obj.getAccount()); 
        if(!ObjectUtil.isEmpty(obj.getUsername()))q.addEq("username", obj.getUsername()); 
        if(!ObjectUtil.isEmpty(obj.getPassword()))q.addEq("password", obj.getPassword()); 
        if(!ObjectUtil.isEmpty(obj.getUserEmail()))q.addEq("userEmail", obj.getUserEmail()); 
        if(!ObjectUtil.isEmpty(obj.getAvatar()))q.addEq("avatar", obj.getAvatar()); 
        if(!ObjectUtil.isEmpty(obj.getTel()))q.addEq("tel", obj.getTel()); 
        if(!ObjectUtil.isEmpty(obj.getSex()))q.addEq("sex", obj.getSex()); 
        if(!ObjectUtil.isEmpty(obj.getSchool()))q.addEq("school", obj.getSchool()); 
        if(!ObjectUtil.isEmpty(obj.getAddress()))q.addEq("address", obj.getAddress()); 
//        if(!ObjectUtil.isEmpty(obj.getCreatTimeBegin()) && !ObjectUtil.isEmpty(obj.getCreatTimeEnd())) {
//			q.addBetween("creatTime", obj.getCreatTimeBegin(), obj.getCreatTimeEnd());
//		}else{
//			if(!ObjectUtil.isEmpty(obj.getCreatTimeBegin())) q.addGt("creatTime", obj.getCreatTimeBegin());
//			if(!ObjectUtil.isEmpty(obj.getCreatTimeEnd()))   q.addLt("creatTime", obj.getCreatTimeEnd());
//		}
        
//        if(!ObjectUtil.isEmpty(obj.getLastTimeBegin()) && !ObjectUtil.isEmpty(obj.getLastTimeEnd())) {
//			q.addBetween("lastTime", obj.getLastTimeBegin(), obj.getLastTimeEnd());
//		}else{
//			if(!ObjectUtil.isEmpty(obj.getLastTimeBegin())) q.addGt("lastTime", obj.getLastTimeBegin());
//			if(!ObjectUtil.isEmpty(obj.getLastTimeEnd()))   q.addLt("lastTime", obj.getLastTimeEnd());
//		}
        
        if(!ObjectUtil.isEmpty(obj.getLoginIp()))q.addEq("loginIp", obj.getLoginIp()); 
        if(!ObjectUtil.isEmpty(obj.getIsAdmin()))q.addEq("isAdmin", obj.getIsAdmin()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        if(!ObjectUtil.isEmpty(obj.getLng()))q.addEq("lng", obj.getLng()); 
        if(!ObjectUtil.isEmpty(obj.getLat()))q.addEq("lat", obj.getLat()); 
        if(!ObjectUtil.isEmpty(obj.getQq()))q.addEq("qq", obj.getQq()); 
        if(!ObjectUtil.isEmpty(obj.getWechat()))q.addEq("wechat", obj.getWechat()); 
        if(!ObjectUtil.isEmpty(obj.getAlipay()))q.addEq("alipay", obj.getAlipay()); 
		return this.findByQuery(q);
	}
    
    /**
	 * 条件查询  返回对象实体
	 * @param obj
	 * @return
	 * @throws MysqlDBException
	 */
	@SuppressWarnings("unchecked")
	public UserPO getTUserByParam(UserPO obj) throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<UserPO> q = Query.build(UserPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getAccount()))q.addEq("account", obj.getAccount()); 
        if(!ObjectUtil.isEmpty(obj.getUsername()))q.addEq("username", obj.getUsername()); 
        if(!ObjectUtil.isEmpty(obj.getPassword()))q.addEq("password", obj.getPassword()); 
        if(!ObjectUtil.isEmpty(obj.getUserEmail()))q.addEq("userEmail", obj.getUserEmail()); 
        if(!ObjectUtil.isEmpty(obj.getAvatar()))q.addEq("avatar", obj.getAvatar()); 
        if(!ObjectUtil.isEmpty(obj.getTel()))q.addEq("tel", obj.getTel()); 
        if(!ObjectUtil.isEmpty(obj.getSex()))q.addEq("sex", obj.getSex()); 
        if(!ObjectUtil.isEmpty(obj.getSchool()))q.addEq("school", obj.getSchool()); 
        if(!ObjectUtil.isEmpty(obj.getAddress()))q.addEq("address", obj.getAddress()); 
//        if(!ObjectUtil.isEmpty(obj.getCreatTimeBegin()) && !ObjectUtil.isEmpty(obj.getCreatTimeEnd())) {
//			q.addBetween("creatTime", obj.getCreatTimeBegin(), obj.getCreatTimeEnd());
//		}else{
//			if(!ObjectUtil.isEmpty(obj.getCreatTimeBegin())) q.addGt("creatTime", obj.getCreatTimeBegin());
//			if(!ObjectUtil.isEmpty(obj.getCreatTimeEnd()))   q.addLt("creatTime", obj.getCreatTimeEnd());
//		}
//        
//        if(!ObjectUtil.isEmpty(obj.getLastTimeBegin()) && !ObjectUtil.isEmpty(obj.getLastTimeEnd())) {
//			q.addBetween("lastTime", obj.getLastTimeBegin(), obj.getLastTimeEnd());
//		}else{
//			if(!ObjectUtil.isEmpty(obj.getLastTimeBegin())) q.addGt("lastTime", obj.getLastTimeBegin());
//			if(!ObjectUtil.isEmpty(obj.getLastTimeEnd()))   q.addLt("lastTime", obj.getLastTimeEnd());
//		}
        
        if(!ObjectUtil.isEmpty(obj.getLoginIp()))q.addEq("loginIp", obj.getLoginIp()); 
        if(!ObjectUtil.isEmpty(obj.getIsAdmin()))q.addEq("isAdmin", obj.getIsAdmin()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        if(!ObjectUtil.isEmpty(obj.getLng()))q.addEq("lng", obj.getLng()); 
        if(!ObjectUtil.isEmpty(obj.getLat()))q.addEq("lat", obj.getLat()); 
        if(!ObjectUtil.isEmpty(obj.getQq()))q.addEq("qq", obj.getQq()); 
        if(!ObjectUtil.isEmpty(obj.getWechat()))q.addEq("wechat", obj.getWechat()); 
        if(!ObjectUtil.isEmpty(obj.getAlipay()))q.addEq("alipay", obj.getAlipay()); 
		return this.get(q);
	}
	
	/**
	 * 导出excel 数据表
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> queryTUserForExl(UserPO obj)throws MysqlDBException{
		if(ObjectUtil.isEmpty(obj)){
			MysqlDBException e = new MysqlDBException("查询条件对象为空 - 异常");
			log.error("查询条件对象为空 - 异常",e);
			throw e;
		}
        Query<UserPO> q = Query.build(UserPO.class);
		
        if(!ObjectUtil.isEmpty(obj.getId()))q.addEq("id", obj.getId()); 
        if(!ObjectUtil.isEmpty(obj.getAccount()))q.addEq("account", obj.getAccount()); 
        if(!ObjectUtil.isEmpty(obj.getUsername()))q.addEq("username", obj.getUsername()); 
        if(!ObjectUtil.isEmpty(obj.getPassword()))q.addEq("password", obj.getPassword()); 
        if(!ObjectUtil.isEmpty(obj.getUserEmail()))q.addEq("userEmail", obj.getUserEmail()); 
        if(!ObjectUtil.isEmpty(obj.getAvatar()))q.addEq("avatar", obj.getAvatar()); 
        if(!ObjectUtil.isEmpty(obj.getTel()))q.addEq("tel", obj.getTel()); 
        if(!ObjectUtil.isEmpty(obj.getSex()))q.addEq("sex", obj.getSex()); 
        if(!ObjectUtil.isEmpty(obj.getSchool()))q.addEq("school", obj.getSchool()); 
        if(!ObjectUtil.isEmpty(obj.getAddress()))q.addEq("address", obj.getAddress()); 
//        if(!ObjectUtil.isEmpty(obj.getCreatTimeBegin()) && !ObjectUtil.isEmpty(obj.getCreatTimeEnd())) {
//			q.addBetween("creatTime", obj.getCreatTimeBegin(), obj.getCreatTimeEnd());
//		}else{
//			if(!ObjectUtil.isEmpty(obj.getCreatTimeBegin())) q.addGt("creatTime", obj.getCreatTimeBegin());
//			if(!ObjectUtil.isEmpty(obj.getCreatTimeEnd()))   q.addLt("creatTime", obj.getCreatTimeEnd());
//		}
//        
//        if(!ObjectUtil.isEmpty(obj.getLastTimeBegin()) && !ObjectUtil.isEmpty(obj.getLastTimeEnd())) {
//			q.addBetween("lastTime", obj.getLastTimeBegin(), obj.getLastTimeEnd());
//		}else{
//			if(!ObjectUtil.isEmpty(obj.getLastTimeBegin())) q.addGt("lastTime", obj.getLastTimeBegin());
//			if(!ObjectUtil.isEmpty(obj.getLastTimeEnd()))   q.addLt("lastTime", obj.getLastTimeEnd());
//		}
        
        if(!ObjectUtil.isEmpty(obj.getLoginIp()))q.addEq("loginIp", obj.getLoginIp()); 
        if(!ObjectUtil.isEmpty(obj.getIsAdmin()))q.addEq("isAdmin", obj.getIsAdmin()); 
        if(!ObjectUtil.isEmpty(obj.getState()))q.addEq("state", obj.getState()); 
        if(!ObjectUtil.isEmpty(obj.getLng()))q.addEq("lng", obj.getLng()); 
        if(!ObjectUtil.isEmpty(obj.getLat()))q.addEq("lat", obj.getLat()); 
        if(!ObjectUtil.isEmpty(obj.getQq()))q.addEq("qq", obj.getQq()); 
        if(!ObjectUtil.isEmpty(obj.getWechat()))q.addEq("wechat", obj.getWechat()); 
        if(!ObjectUtil.isEmpty(obj.getAlipay()))q.addEq("alipay", obj.getAlipay()); 
		String[] columnProperty = {"id","account","username","password","userEmail","avatar","tel","sex","school","address","creatTime","lastTime","loginIp","isAdmin","state","lng","lat","qq","wechat","alipay"};
		return this.findExpByQuery(q, columnProperty);
	}
	
	
	
}

