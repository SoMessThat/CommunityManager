package mess.wkb.cm.code.ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mess.wkb.cm.code.po.CmAttendancePO;
import mess.wkb.cm.code.service.CmAttendanceService;
import mess.wkb.cm.code.vo.CmAttendance;
import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.util.ajax.Response;
import mess.wkb.cm.tool.util.ajax.ResponseFactory;
import mess.wkb.cm.tool.web.MysqlDBException;


@Controller
@RequestMapping("/CmAttendance") 
public class CmAttendanceCtrl {

	@Autowired
	private CmAttendanceService cmAttendanceService;
	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 查看会议分页
	 * @param page
	 * @param limit
	 */
	@RequestMapping(value ="/queryPageCmAttendance")
	@ResponseBody
	public Response<List<CmAttendancePO>> queryPageCmAttendance(Integer page,Integer limit,HttpServletRequest request) throws ParseException{
		Response<List<CmAttendancePO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<CmAttendancePO> cmAttendances = null;

		CmAttendancePO condition=new CmAttendancePO();
		
		//不越界，查找属于自己部门的会议
		String departmentId = request.getParameter("cmAttendance_departmentId");
		if(ObjectUtil.isEmpty(departmentId)){
			response.setError("未查询到您的部门身份，请重新登录");
			return response;
		}
		condition.setDepartmentId(departmentId);
		String id = request.getParameter("cmAttendance_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Long.valueOf(id));
		String name = request.getParameter("cmAttendance_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
		String content = request.getParameter("cmAttendance_content");
		if(!ObjectUtil.isEmpty(content)) condition.setContent(String.valueOf(content));
        String place = request.getParameter("cmAttendance_place");
		if(!ObjectUtil.isEmpty(place)) condition.setPlace(String.valueOf(place));
		String creatTime = request.getParameter("cmAttendance_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) condition.setCreatTime(dateFormater.parse(creatTime));
		String beginTime = request.getParameter("cmAttendance_beginTime");
		if(!ObjectUtil.isEmpty(beginTime)) condition.setBeginTime(dateFormater.parse(beginTime));
		String endTime = request.getParameter("cmAttendance_endTime");
		if(!ObjectUtil.isEmpty(endTime)) condition.setEndTime(dateFormater.parse(endTime));
		String userName = request.getParameter("cmAttendance_userName");
		if(!ObjectUtil.isEmpty(userName)) condition.setUserName(String.valueOf(userName));
		String state = request.getParameter("cmAttendance_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));

		try {
			cmAttendances = cmAttendanceService.queryPageCmAttendance(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(cmAttendances.getListData());
		response.setCount(cmAttendances.getTotalHit());
		response.setResult(Response.RESULT_SUCCESS);
		return response;

	}

	@RequestMapping(value="/delCmAttendance")
	@ResponseBody
	public Response<CmAttendancePO> delCmAttendance(String id){
		Response<CmAttendancePO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}

		try {
			cmAttendanceService.deleteCmAttendanceById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}

	@RequestMapping(value="/findCmAttendanceById")
	@ResponseBody
	public Response<CmAttendancePO> findCmAttendanceById(String id){
		Response<CmAttendancePO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(cmAttendanceService.getCmAttendanceById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}

	@RequestMapping(value="/updateCmAttendanceById")
	@ResponseBody
	public Response<CmAttendancePO> updateCmAttendanceById(HttpServletRequest request) throws ParseException{
		Response<CmAttendancePO> response =ResponseFactory.getDefaultSuccessResponse();
		CmAttendancePO condition=new CmAttendancePO();
		String id = request.getParameter("cmAttendance_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Long.valueOf(id));
		String name = request.getParameter("cmAttendance_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
		String content = request.getParameter("cmAttendance_content");
		if(!ObjectUtil.isEmpty(content)) condition.setContent(String.valueOf(content));
        String place = request.getParameter("cmAttendance_place");
		if(!ObjectUtil.isEmpty(place)) condition.setPlace(String.valueOf(place));
		String creatTime = request.getParameter("cmAttendance_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) condition.setCreatTime(dateFormater.parse(creatTime));
		String beginTime = request.getParameter("cmAttendance_beginTime");
		if(!ObjectUtil.isEmpty(beginTime)) condition.setBeginTime(dateFormater.parse(beginTime));
		String endTime = request.getParameter("cmAttendance_endTime");
		if(!ObjectUtil.isEmpty(endTime)) condition.setEndTime(dateFormater.parse(endTime));
		String departmentId = request.getParameter("cmAttendance_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) condition.setDepartmentId(String.valueOf(departmentId));
		String userName = request.getParameter("cmAttendance_userName");
		if(!ObjectUtil.isEmpty(userName)) condition.setUserName(String.valueOf(userName));
		String state = request.getParameter("cmAttendance_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));

		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			cmAttendanceService.updateCmAttendance(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	/**
	 * 发布会议 
	 */
	@RequestMapping(value="/addCmAttendance")
	@ResponseBody
	public Response<CmAttendance> addCmAttendance(HttpServletRequest request) throws ParseException{
		Response<CmAttendance> response =ResponseFactory.getDefaultSuccessResponse();

		CmAttendance po=new CmAttendance();
		String name = request.getParameter("cmAttendance_name");
		if(!ObjectUtil.isEmpty(name)) po.setName(String.valueOf(name));
		String content = request.getParameter("cmAttendance_content");
		if(!ObjectUtil.isEmpty(content)) po.setContent(String.valueOf(content));
        String place = request.getParameter("cmAttendance_place");
		if(!ObjectUtil.isEmpty(place)) po.setPlace(String.valueOf(place));
		String creatTime = request.getParameter("cmAttendance_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) po.setCreatTime(dateFormater.parse(creatTime));
		String beginTime = request.getParameter("cmAttendance_beginTime");
		if(!ObjectUtil.isEmpty(beginTime)) po.setBeginTime(dateFormater.parse(beginTime));
		String endTime = request.getParameter("cmAttendance_endTime");
		if(!ObjectUtil.isEmpty(endTime)) po.setEndTime(dateFormater.parse(endTime));
		String departmentId = request.getParameter("cmAttendance_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) po.setDepartmentId(String.valueOf(departmentId));
		String userName = request.getParameter("cmAttendance_userName");
		if(!ObjectUtil.isEmpty(userName)) po.setUserName(String.valueOf(userName));
		String state = request.getParameter("cmAttendance_state");
		if(!ObjectUtil.isEmpty(state)) po.setState(String.valueOf(state));

		try {
			cmAttendanceService.addCmAttendance(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/openMeetingInfo")
	public ModelAndView openMeetingInfo(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("MeetingInfo");
		return mv;
	}
}





