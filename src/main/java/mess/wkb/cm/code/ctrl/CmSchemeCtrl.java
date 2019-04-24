package mess.wkb.cm.code.ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mess.wkb.cm.code.po.CmSchemePO;
import mess.wkb.cm.code.service.CmSchemeService;
import mess.wkb.cm.code.vo.CmScheme;
import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.util.UUIDUtil;
import mess.wkb.cm.tool.util.ajax.Response;
import mess.wkb.cm.tool.util.ajax.ResponseFactory;
import mess.wkb.cm.tool.web.MysqlDBException;


@Controller
@RequestMapping("/CmScheme") 
public class CmSchemeCtrl {

	@Autowired
	private CmSchemeService cmSchemeService;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	@RequestMapping(value ="/queryPageCmScheme")
	@ResponseBody
	public Response<List<CmSchemePO>> queryPageCmScheme(Integer page,Integer limit,HttpServletRequest request) throws ParseException{
		Response<List<CmSchemePO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<CmSchemePO> cmSchemes = null;
		
		
		CmSchemePO condition=new CmSchemePO();
        String id = request.getParameter("cmScheme_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Long.valueOf(id));
        String code = request.getParameter("cmScheme_code");
		if(!ObjectUtil.isEmpty(code)) condition.setCode(String.valueOf(code));
        String name = request.getParameter("cmScheme_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
        String description = request.getParameter("cmScheme_description");
		if(!ObjectUtil.isEmpty(description)) condition.setDescription(String.valueOf(description));
        String theme = request.getParameter("cmScheme_theme");
		if(!ObjectUtil.isEmpty(theme)) condition.setTheme(String.valueOf(theme));
        String goal = request.getParameter("cmScheme_goal");
		if(!ObjectUtil.isEmpty(goal)) condition.setGoal(String.valueOf(goal));
        String beginTime = request.getParameter("cmScheme_beginTime");
		if(!ObjectUtil.isEmpty(beginTime)) condition.setBeginTime(String.valueOf(beginTime));
        String place = request.getParameter("cmScheme_place");
		if(!ObjectUtil.isEmpty(place)) condition.setPlace(String.valueOf(place));
        String person = request.getParameter("cmScheme_person");
		if(!ObjectUtil.isEmpty(person)) condition.setPerson(String.valueOf(person));
        String form = request.getParameter("cmScheme_form");
		if(!ObjectUtil.isEmpty(form)) condition.setForm(String.valueOf(form));
        String arrangements = request.getParameter("cmScheme_arrangements");
		if(!ObjectUtil.isEmpty(arrangements)) condition.setArrangements(String.valueOf(arrangements));
        String flow = request.getParameter("cmScheme_flow");
		if(!ObjectUtil.isEmpty(flow)) condition.setFlow(String.valueOf(flow));
        String content = request.getParameter("cmScheme_content");
		if(!ObjectUtil.isEmpty(content)) condition.setContent(String.valueOf(content));
        String budget = request.getParameter("cmScheme_budget");
		if(!ObjectUtil.isEmpty(budget)) condition.setBudget(String.valueOf(budget));
        String award = request.getParameter("cmScheme_award");
		if(!ObjectUtil.isEmpty(award)) condition.setAward(String.valueOf(award));
        String creatTime = request.getParameter("cmScheme_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) condition.setCreatTime(dateFormat.parse(creatTime));
        String creatPerson = request.getParameter("cmScheme_creatPerson");
		if(!ObjectUtil.isEmpty(creatPerson)) condition.setCreatPerson(String.valueOf(creatPerson));
        String department = request.getParameter("cmScheme_department");
		if(!ObjectUtil.isEmpty(department)) condition.setDepartment(String.valueOf(department));
        String state = request.getParameter("cmScheme_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
	
		try {
			cmSchemes = cmSchemeService.queryPageCmScheme(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(cmSchemes.getListData());
		response.setCount(cmSchemes.getTotalHit());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	@RequestMapping(value="/delCmScheme")
	@ResponseBody
	public Response<CmSchemePO> delCmScheme(String id){
		Response<CmSchemePO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			cmSchemeService.deleteCmSchemeById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findCmSchemeById")
	@ResponseBody
	public Response<CmScheme> findCmSchemeById(String id){
		Response<CmScheme> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(cmSchemeService.getCmSchemeById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/updateCmSchemeById")
	@ResponseBody
	public Response<CmScheme> updateCmSchemeById(HttpServletRequest request) throws ParseException{
		Response<CmScheme> response =ResponseFactory.getDefaultSuccessResponse();
		CmScheme condition=new CmScheme();
        String id = request.getParameter("cmScheme_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Long.valueOf(id));
        String code = request.getParameter("cmScheme_code");
		if(!ObjectUtil.isEmpty(code)) condition.setCode(String.valueOf(code));
        String name = request.getParameter("cmScheme_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
        String description = request.getParameter("cmScheme_description");
		if(!ObjectUtil.isEmpty(description)) condition.setDescription(String.valueOf(description));
        String theme = request.getParameter("cmScheme_theme");
		if(!ObjectUtil.isEmpty(theme)) condition.setTheme(String.valueOf(theme));
        String goal = request.getParameter("cmScheme_goal");
		if(!ObjectUtil.isEmpty(goal)) condition.setGoal(String.valueOf(goal));
        String beginTime = request.getParameter("cmScheme_beginTime");
		if(!ObjectUtil.isEmpty(beginTime)) condition.setBeginTime(String.valueOf(beginTime));
        String place = request.getParameter("cmScheme_place");
		if(!ObjectUtil.isEmpty(place)) condition.setPlace(String.valueOf(place));
        String person = request.getParameter("cmScheme_person");
		if(!ObjectUtil.isEmpty(person)) condition.setPerson(String.valueOf(person));
        String form = request.getParameter("cmScheme_form");
		if(!ObjectUtil.isEmpty(form)) condition.setForm(String.valueOf(form));
        String arrangements = request.getParameter("cmScheme_arrangements");
		if(!ObjectUtil.isEmpty(arrangements)) condition.setArrangements(String.valueOf(arrangements));
        String flow = request.getParameter("cmScheme_flow");
		if(!ObjectUtil.isEmpty(flow)) condition.setFlow(String.valueOf(flow));
        String content = request.getParameter("cmScheme_content");
		if(!ObjectUtil.isEmpty(content)) condition.setContent(String.valueOf(content));
        String budget = request.getParameter("cmScheme_budget");
		if(!ObjectUtil.isEmpty(budget)) condition.setBudget(String.valueOf(budget));
        String award = request.getParameter("cmScheme_award");
		if(!ObjectUtil.isEmpty(award)) condition.setAward(String.valueOf(award));
        String creatTime = request.getParameter("cmScheme_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) condition.setCreatTime(dateFormat.parse(creatTime));
        String creatPerson = request.getParameter("cmScheme_creatPerson");
		if(!ObjectUtil.isEmpty(creatPerson)) condition.setCreatPerson(String.valueOf(creatPerson));
        String department = request.getParameter("cmScheme_department");
		if(!ObjectUtil.isEmpty(department)) condition.setDepartment(String.valueOf(department));
        String state = request.getParameter("cmScheme_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			cmSchemeService.updateCmScheme(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/addCmScheme")
	@ResponseBody
	public Response<CmScheme> addCmScheme(HttpServletRequest request) throws ParseException{
		Response<CmScheme> response =ResponseFactory.getDefaultSuccessResponse();
		
		CmScheme po=new CmScheme();
		po.setCode(UUIDUtil.getSortUUID());
        String name = request.getParameter("cmScheme_name");
		if(!ObjectUtil.isEmpty(name)) po.setName(String.valueOf(name));
        String description = request.getParameter("cmScheme_description");
		if(!ObjectUtil.isEmpty(description)) po.setDescription(String.valueOf(description));
        String theme = request.getParameter("cmScheme_theme");
		if(!ObjectUtil.isEmpty(theme)) po.setTheme(String.valueOf(theme));
        String goal = request.getParameter("cmScheme_goal");
		if(!ObjectUtil.isEmpty(goal)) po.setGoal(String.valueOf(goal));
        String beginTime = request.getParameter("cmScheme_beginTime");
		if(!ObjectUtil.isEmpty(beginTime)) po.setBeginTime(String.valueOf(beginTime));
        String place = request.getParameter("cmScheme_place");
		if(!ObjectUtil.isEmpty(place)) po.setPlace(String.valueOf(place));
        String person = request.getParameter("cmScheme_person");
		if(!ObjectUtil.isEmpty(person)) po.setPerson(String.valueOf(person));
        String form = request.getParameter("cmScheme_form");
		if(!ObjectUtil.isEmpty(form)) po.setForm(String.valueOf(form));
        String arrangements = request.getParameter("cmScheme_arrangements");
		if(!ObjectUtil.isEmpty(arrangements)) po.setArrangements(String.valueOf(arrangements));
        String flow = request.getParameter("cmScheme_flow");
		if(!ObjectUtil.isEmpty(flow)) po.setFlow(String.valueOf(flow));
        String content = request.getParameter("cmScheme_content");
		if(!ObjectUtil.isEmpty(content)) po.setContent(String.valueOf(content));
        String budget = request.getParameter("cmScheme_budget");
		if(!ObjectUtil.isEmpty(budget)) po.setBudget(String.valueOf(budget));
        String award = request.getParameter("cmScheme_award");
		if(!ObjectUtil.isEmpty(award)) po.setAward(String.valueOf(award));
        String creatTime = request.getParameter("cmScheme_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) po.setCreatTime(dateFormat.parse(creatTime));
        String creatPerson = request.getParameter("cmScheme_creatPerson");
		if(!ObjectUtil.isEmpty(creatPerson)) po.setCreatPerson(String.valueOf(creatPerson));
        String department = request.getParameter("cmScheme_department");
		if(!ObjectUtil.isEmpty(department)) po.setDepartment(String.valueOf(department));
        String state = request.getParameter("cmScheme_state");
		if(!ObjectUtil.isEmpty(state)) po.setState(String.valueOf(state));
		
		try {
			cmSchemeService.addCmScheme(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	/**
	 * 领导审核策划
	 */
	@RequestMapping(value="/inspectCmSchemeByLead")
	@ResponseBody
	public Response<CmScheme> inspectCmSchemeByLead(HttpServletRequest request) throws ParseException{
		Response<CmScheme> response =ResponseFactory.getDefaultSuccessResponse();
		CmScheme condition=new CmScheme();
        String id = request.getParameter("cmScheme_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Long.valueOf(id));
        String state = request.getParameter("cmScheme_state");
        if(!ObjectUtil.isEmpty(state)&&(state.equals("审核通过")||state.equals("审核未通过")))
			condition.setState(String.valueOf(state));
		else{
			response.setError("审核出错，请重新刷新界面");
			return response;
		}
        
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			cmSchemeService.updateCmScheme(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
}
