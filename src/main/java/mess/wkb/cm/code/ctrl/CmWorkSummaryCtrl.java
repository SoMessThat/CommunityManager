package mess.wkb.cm.code.ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mess.wkb.cm.code.po.CmWorkSummaryPO;
import mess.wkb.cm.code.service.CmWorkSummaryService;
import mess.wkb.cm.code.vo.CmWorkSummary;
import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.util.ajax.Response;
import mess.wkb.cm.tool.util.ajax.ResponseFactory;
import mess.wkb.cm.tool.web.MysqlDBException;


@Controller
@RequestMapping("/CmWorkSummary") 
public class CmWorkSummaryCtrl {

	@Autowired
	private CmWorkSummaryService cmWorkSummaryService;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@RequestMapping(value ="/queryPageCmWorkSummary")
	@ResponseBody
	public Response<List<CmWorkSummaryPO>> queryPageCmWorkSummary(Integer page,Integer limit,HttpServletRequest request) throws ParseException{
		Response<List<CmWorkSummaryPO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<CmWorkSummaryPO> cmWorkSummarys = null;
		
		
		CmWorkSummaryPO condition=new CmWorkSummaryPO();
        String id = request.getParameter("cmWorkSummary_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Long.valueOf(id));
        String name = request.getParameter("cmWorkSummary_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
        String title = request.getParameter("cmWorkSummary_title");
		if(!ObjectUtil.isEmpty(title)) condition.setTitle(String.valueOf(title));
        String content = request.getParameter("cmWorkSummary_content");
		if(!ObjectUtil.isEmpty(content)) condition.setContent(String.valueOf(content));
        String creatTime = request.getParameter("cmWorkSummary_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) condition.setCreatTime(dateFormat.parse(creatTime));
        String departmentId = request.getParameter("cmWorkSummary_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) condition.setDepartmentId(String.valueOf(departmentId));
        String userName = request.getParameter("cmWorkSummary_userName");
		if(!ObjectUtil.isEmpty(userName)) condition.setUserName(String.valueOf(userName));
        String state = request.getParameter("cmWorkSummary_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
	
		try {
			cmWorkSummarys = cmWorkSummaryService.queryPageCmWorkSummary(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(cmWorkSummarys.getListData());
		response.setCount(cmWorkSummarys.getTotalHit());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	@RequestMapping(value="/delCmWorkSummary")
	@ResponseBody
	public Response<CmWorkSummaryPO> delCmWorkSummary(String id){
		Response<CmWorkSummaryPO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			cmWorkSummaryService.deleteCmWorkSummaryById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findCmWorkSummaryById")
	@ResponseBody
	public Response<CmWorkSummaryPO> findCmWorkSummaryById(String id){
		Response<CmWorkSummaryPO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(cmWorkSummaryService.getCmWorkSummaryById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/updateCmWorkSummaryById")
	@ResponseBody
	public Response<CmWorkSummary> updateCmWorkSummaryById(HttpServletRequest request) throws ParseException{
		Response<CmWorkSummary> response =ResponseFactory.getDefaultSuccessResponse();
		CmWorkSummary condition=new CmWorkSummary();
        String id = request.getParameter("cmWorkSummary_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Long.valueOf(id));
        String name = request.getParameter("cmWorkSummary_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
        String title = request.getParameter("cmWorkSummary_title");
		if(!ObjectUtil.isEmpty(title)) condition.setTitle(String.valueOf(title));
        String content = request.getParameter("cmWorkSummary_content");
		if(!ObjectUtil.isEmpty(content)) condition.setContent(String.valueOf(content));
        String creatTime = request.getParameter("cmWorkSummary_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) condition.setCreatTime(dateFormat.parse(creatTime));
        String departmentId = request.getParameter("cmWorkSummary_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) condition.setDepartmentId(String.valueOf(departmentId));
        String userName = request.getParameter("cmWorkSummary_userName");
		if(!ObjectUtil.isEmpty(userName)) condition.setUserName(String.valueOf(userName));
        String state = request.getParameter("cmWorkSummary_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			cmWorkSummaryService.updateCmWorkSummary(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	/**
	 * 添加工作总结
	 * @param request
	 */
	@RequestMapping(value="/addCmWorkSummary")
	@ResponseBody
	public Response<CmWorkSummary> addCmWorkSummary(HttpServletRequest request) throws ParseException{
		Response<CmWorkSummary> response =ResponseFactory.getDefaultSuccessResponse();
		
		CmWorkSummary po=new CmWorkSummary();
        String name = request.getParameter("cmWorkSummary_name");
		if(!ObjectUtil.isEmpty(name)) po.setName(String.valueOf(name));
        String title = request.getParameter("cmWorkSummary_title");
		if(!ObjectUtil.isEmpty(title)) po.setTitle(String.valueOf(title));
        String content = request.getParameter("cmWorkSummary_content");
		if(!ObjectUtil.isEmpty(content)) po.setContent(String.valueOf(content));
        String creatTime = request.getParameter("cmWorkSummary_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) po.setCreatTime(dateFormat.parse(creatTime));
        String departmentId = request.getParameter("cmWorkSummary_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) po.setDepartmentId(String.valueOf(departmentId));
        String userName = request.getParameter("cmWorkSummary_userName");
		if(!ObjectUtil.isEmpty(userName)) po.setUserName(String.valueOf(userName));
        String state = request.getParameter("cmWorkSummary_state");
		if(!ObjectUtil.isEmpty(state)) po.setState(String.valueOf(state));
		
		try {
			cmWorkSummaryService.addCmWorkSummary(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	/**
	 * 干部审核工作总结
	 */
	@RequestMapping(value="/inspectCmWorkSummaryByCadre")
	@ResponseBody
	public Response<CmWorkSummary> inspectCmWorkSummaryByCadre(HttpServletRequest request) throws ParseException{
		Response<CmWorkSummary> response =ResponseFactory.getDefaultSuccessResponse();
		CmWorkSummary condition=new CmWorkSummary();
        String id = request.getParameter("cmWorkSummary_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Long.valueOf(id));
		String state = request.getParameter("cmWorkSummary_state");
		if(!ObjectUtil.isEmpty(state)&&(state.equals("审核通过")||state.equals("审核未通过")))
			condition.setState(String.valueOf(state));
		else{
			response.setError("审核出错，请重新刷新界面");
			return response;
		}
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("页面已过期，请重新刷新界面");
			return response;
		}

		try {
			cmWorkSummaryService.updateCmWorkSummary(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	/**
	 * 领导审核工作总结
	 */
	@RequestMapping(value="/inspectCmWorkSummaryByLead")
	@ResponseBody
	public Response<CmWorkSummary> inspectCmWorkSummaryByLead(HttpServletRequest request) throws ParseException{
		Response<CmWorkSummary> response =ResponseFactory.getDefaultSuccessResponse();
		CmWorkSummary condition=new CmWorkSummary();
        String id = request.getParameter("cmWorkSummary_id");
        if(!ObjectUtil.isEmpty(id)) condition.setId(Long.valueOf(id));
		String state = request.getParameter("cmWorkSummary_state");
		if(!ObjectUtil.isEmpty(state)&&(state.equals("完成")||state.equals("审核未通过")))
			condition.setState(String.valueOf(state));
		else{
			response.setError("审核出错，请重新刷新界面");
			return response;
		}
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("页面已过期，请重新刷新界面");
			return response;
		}

		try {
			cmWorkSummaryService.updateCmWorkSummary(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
}
