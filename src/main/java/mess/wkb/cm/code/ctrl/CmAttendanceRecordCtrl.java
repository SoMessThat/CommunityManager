package mess.wkb.cm.code.ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.fabric.xmlrpc.base.Data;

import mess.wkb.cm.code.po.CmAttendancePO;
import mess.wkb.cm.code.po.CmAttendanceRecordPO;
import mess.wkb.cm.code.service.CmAttendanceRecordService;
import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.util.ajax.Response;
import mess.wkb.cm.tool.util.ajax.ResponseFactory;
import mess.wkb.cm.tool.web.MysqlDBException;


@Controller
@RequestMapping("/CmAttendanceRecord") 
public class CmAttendanceRecordCtrl {

	@Autowired
	private CmAttendanceRecordService cmAttendanceRecordService;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@RequestMapping(value ="/queryPageCmAttendanceRecord")
	@ResponseBody
	public Response<List<CmAttendanceRecordPO>> queryPageCmAttendanceRecord(Integer page,Integer limit,HttpServletRequest request) throws ParseException{
		Response<List<CmAttendanceRecordPO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<CmAttendanceRecordPO> cmAttendanceRecords = null;
		
		
		CmAttendanceRecordPO condition=new CmAttendanceRecordPO();
        String id = request.getParameter("cmAttendanceRecord_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Long.valueOf(id));
        String signTime = request.getParameter("cmAttendanceRecord_signTime");
		if(!ObjectUtil.isEmpty(signTime)) condition.setSignTime(dateFormat.parse(signTime));
        String departmentId = request.getParameter("cmAttendanceRecord_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) condition.setDepartmentId(String.valueOf(departmentId));
        String userName = request.getParameter("cmAttendanceRecord_userName");
		if(!ObjectUtil.isEmpty(userName)) condition.setUserName(String.valueOf(userName));
        String state = request.getParameter("cmAttendanceRecord_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
        String attendanceId = request.getParameter("cmAttendanceRecord_attendanceId");
		if(!ObjectUtil.isEmpty(attendanceId)) condition.setAttendanceId(Long.valueOf(attendanceId));
	
		try {
			cmAttendanceRecords = cmAttendanceRecordService.queryPageCmAttendanceRecord(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(cmAttendanceRecords.getListData());
		response.setCount(cmAttendanceRecords.getTotalHit());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	@RequestMapping(value="/delCmAttendanceRecord")
	@ResponseBody
	public Response<CmAttendanceRecordPO> delCmAttendanceRecord(String id){
		Response<CmAttendanceRecordPO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			cmAttendanceRecordService.deleteCmAttendanceRecordById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findCmAttendanceRecordById")
	@ResponseBody
	public Response<CmAttendanceRecordPO> findCmAttendanceRecordById(String id){
		Response<CmAttendanceRecordPO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(cmAttendanceRecordService.getCmAttendanceRecordById(Long.parseLong(id)));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/updateCmAttendanceRecordById")
	@ResponseBody
	public Response<CmAttendanceRecordPO> updateCmAttendanceRecordById(HttpServletRequest request) throws ParseException{
		Response<CmAttendanceRecordPO> response =ResponseFactory.getDefaultSuccessResponse();
		CmAttendanceRecordPO condition=new CmAttendanceRecordPO();
        String id = request.getParameter("cmAttendanceRecord_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Long.valueOf(id));
        String signTime = request.getParameter("cmAttendanceRecord_signTime");
		if(!ObjectUtil.isEmpty(signTime)) condition.setSignTime(dateFormat.parse(signTime));
        String departmentId = request.getParameter("cmAttendanceRecord_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) condition.setDepartmentId(String.valueOf(departmentId));
        String userName = request.getParameter("cmAttendanceRecord_userName");
		if(!ObjectUtil.isEmpty(userName)) condition.setUserName(String.valueOf(userName));
        String state = request.getParameter("cmAttendanceRecord_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
        String attendanceId = request.getParameter("cmAttendanceRecord_attendanceId");
		if(!ObjectUtil.isEmpty(attendanceId)) condition.setAttendanceId(Long.valueOf(attendanceId));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			cmAttendanceRecordService.updateCmAttendanceRecord(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	/**
	 * 签到
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addCmAttendanceRecord")
	@ResponseBody
	public Response<CmAttendanceRecordPO> addCmAttendanceRecord(HttpServletRequest request) throws ParseException{
		Response<CmAttendanceRecordPO> response =ResponseFactory.getDefaultSuccessResponse();
		
		CmAttendanceRecordPO po=new CmAttendanceRecordPO();
        String signTime = request.getParameter("cmAttendanceRecord_signTime");
		if(!ObjectUtil.isEmpty(signTime)) po.setSignTime(dateFormat.parse(signTime));
        String departmentId = request.getParameter("cmAttendanceRecord_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) po.setDepartmentId(String.valueOf(departmentId));
        String userName = request.getParameter("cmAttendanceRecord_userName");
		if(!ObjectUtil.isEmpty(userName)) po.setUserName(String.valueOf(userName));
        String state = request.getParameter("cmAttendanceRecord_state");
		if(!ObjectUtil.isEmpty(state)) po.setState(String.valueOf(state));
        String attendanceId = request.getParameter("cmAttendanceRecord_attendanceId");
		if(!ObjectUtil.isEmpty(attendanceId)) po.setAttendanceId(Long.valueOf(attendanceId));
		
		try {
			cmAttendanceRecordService.addCmAttendanceRecord(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	
	@RequestMapping(value="/shouDao")
	@ResponseBody
	public Response<CmAttendanceRecordPO> shouDao(HttpServletRequest request) {
		Response<CmAttendanceRecordPO> response =ResponseFactory.getDefaultSuccessResponse();
//		HttpSession session = request.getSession();
//		CmUserPO userSession = (CmUserPO) session.getAttribute("user");
		CmAttendanceRecordPO po = new CmAttendanceRecordPO();
		po.setUserName("1");
		
		//不越界，查找属于自己部门的会议
		String departmentId = "1";
		po.setDepartmentId(departmentId);
		String id = request.getParameter("id");
		po.setAttendanceId(Long.parseLong(id));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		po.setState(df.format(new Data())+":收到,");
		
		try {
			cmAttendanceRecordService.addCmAttendanceRecord(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		return response;
	}
	
	
	@RequestMapping(value="/attend")
	@ResponseBody
	public Response<String> attend(HttpServletRequest request) {
		Response<String> response =ResponseFactory.getDefaultSuccessResponse();
		
		CmAttendanceRecordPO po=new CmAttendanceRecordPO();
//		HttpSession session = request.getSession();
//		CmUserPO userSession = (CmUserPO) session.getAttribute("user");
		HttpSession session = request.getSession();
		CmAttendancePO meeting = (CmAttendancePO) session.getAttribute("meeting");
		po.setAttendanceId(meeting.getId());
        po.setUserName("1");
        CmAttendanceRecordPO result = null;
		result = cmAttendanceRecordService.getAttend(po);
        if (ObjectUtil.isEmpty(result)) {
        	try {
        		po.setDepartmentId("1");
        		po.setState("签到");
        		cmAttendanceRecordService.addCmAttendanceRecord(po);
        	} catch (MysqlDBException e) {
        		response.setError("网络连接失败，请检查网络");
        		return response;
        	}
		}else {
			po.setState(result.getState()+"签到");
			po.setId(result.getId());
			try {
				cmAttendanceRecordService.updateCmAttendanceRecord(po);
			} catch (MysqlDBException e) {
				e.printStackTrace();
			}
		}
		
        String seat = request.getParameter("seat");
        Map<String, String> map = new HashMap<String,String>();
		if(!ObjectUtil.isEmpty(seat)) map.put("seat", seat);
		map.put("userName", po.getUserName());
		map.put("attendanceId", po.getUserName());
		cmAttendanceRecordService.seat(map);
//		response.setData(userSession.getusername()+"在"+seat+"坐下下了");
        response.setData("mess"+"在"+seat+"坐下下了");
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
}
