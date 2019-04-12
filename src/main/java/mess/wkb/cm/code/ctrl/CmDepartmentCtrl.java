package mess.wkb.cm.code.ctrl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mess.wkb.cm.code.po.CmDepartmentPO;
import mess.wkb.cm.code.service.CmDepartmentService;
import mess.wkb.cm.code.vo.CmDepartment;
import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.util.UUIDUtil;
import mess.wkb.cm.tool.util.ajax.Response;
import mess.wkb.cm.tool.util.ajax.ResponseFactory;
import mess.wkb.cm.tool.web.MysqlDBException;


@Controller
@RequestMapping("/CmDepartment") 
public class CmDepartmentCtrl {

	@Autowired
	private CmDepartmentService cmDepartmentService;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@RequestMapping(value ="/queryPageCmDepartment")
	@ResponseBody
	public Response<List<CmDepartmentPO>> queryPageCmDepartment(Integer page,Integer limit,HttpServletRequest request){
		Response<List<CmDepartmentPO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<CmDepartmentPO> cmDepartments = null;
		
		
		CmDepartmentPO condition=new CmDepartmentPO();
        String id = request.getParameter("cmDepartment_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String name = request.getParameter("cmDepartment_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
        String info = request.getParameter("cmDepartment_info");
		if(!ObjectUtil.isEmpty(info)) condition.setInfo(String.valueOf(info));
        String duty = request.getParameter("cmDepartment_duty");
		if(!ObjectUtil.isEmpty(duty)) condition.setDuty(String.valueOf(duty));
        String characters = request.getParameter("cmDepartment_characters");
		if(!ObjectUtil.isEmpty(characters)) condition.setCharacters(String.valueOf(characters));
        String masterName = request.getParameter("cmDepartment_masterName");
		if(!ObjectUtil.isEmpty(masterName)) condition.setMasterName(String.valueOf(masterName));
        String masterTel = request.getParameter("cmDepartment_masterTel");
		if(!ObjectUtil.isEmpty(masterTel)) condition.setMasterTel(String.valueOf(masterTel));
        String leadOrganize = request.getParameter("cmDepartment_leadOrganize");
		if(!ObjectUtil.isEmpty(leadOrganize)) condition.setLeadOrganize(String.valueOf(leadOrganize));
        String registrationTime = request.getParameter("cmDepartment_registrationTime");
		if(!ObjectUtil.isEmpty(registrationTime)) condition.setRegistrationTime(String.valueOf(registrationTime));
        String registrationName = request.getParameter("cmDepartment_registrationName");
		if(!ObjectUtil.isEmpty(registrationName)) condition.setRegistrationName(String.valueOf(registrationName));
        String num = request.getParameter("cmDepartment_num");
		if(!ObjectUtil.isEmpty(num)) condition.setNum(Integer.valueOf(num));
        String generalRules = request.getParameter("cmDepartment_generalRules");
		if(!ObjectUtil.isEmpty(generalRules)) condition.setGeneralRules(String.valueOf(generalRules));
        String purpose = request.getParameter("cmDepartment_purpose");
		if(!ObjectUtil.isEmpty(purpose)) condition.setPurpose(String.valueOf(purpose));
        String droit = request.getParameter("cmDepartment_droit");
		if(!ObjectUtil.isEmpty(droit)) condition.setDroit(String.valueOf(droit));
        String obligation = request.getParameter("cmDepartment_obligation");
		if(!ObjectUtil.isEmpty(obligation)) condition.setObligation(String.valueOf(obligation));
        String requirement = request.getParameter("cmDepartment_requirement");
		if(!ObjectUtil.isEmpty(requirement)) condition.setRequirement(String.valueOf(requirement));
        String other = request.getParameter("cmDepartment_other");
		if(!ObjectUtil.isEmpty(other)) condition.setOther(String.valueOf(other));
	
		try {
			cmDepartments = cmDepartmentService.queryPageCmDepartment(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(cmDepartments.getListData());
		response.setCount(cmDepartments.getTotalHit());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	@RequestMapping(value="/delCmDepartment")
	@ResponseBody
	public Response<CmDepartmentPO> delCmDepartment(String id){
		Response<CmDepartmentPO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			cmDepartmentService.deleteCmDepartmentById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findCmDepartmentById")
	@ResponseBody
	public Response<CmDepartmentPO> findCmDepartmentById(String id){
		Response<CmDepartmentPO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(cmDepartmentService.getCmDepartmentById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	/**
	 * 修改部门信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateCmDepartmentById")
	@ResponseBody
	public Response<CmDepartmentPO> updateCmDepartmentById(HttpServletRequest request){
		Response<CmDepartmentPO> response =ResponseFactory.getDefaultSuccessResponse();
		CmDepartmentPO condition=new CmDepartmentPO();
		String id = request.getParameter("cmDepartment_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String name = request.getParameter("cmDepartment_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
        String info = request.getParameter("cmDepartment_info");
		if(!ObjectUtil.isEmpty(info)) condition.setInfo(String.valueOf(info));
        String duty = request.getParameter("cmDepartment_duty");
		if(!ObjectUtil.isEmpty(duty)) condition.setDuty(String.valueOf(duty));
        String characters = request.getParameter("cmDepartment_characters");
		if(!ObjectUtil.isEmpty(characters)) condition.setCharacters(String.valueOf(characters));
        String masterName = request.getParameter("cmDepartment_masterName");
		if(!ObjectUtil.isEmpty(masterName)) condition.setMasterName(String.valueOf(masterName));
        String masterTel = request.getParameter("cmDepartment_masterTel");
		if(!ObjectUtil.isEmpty(masterTel)) condition.setMasterTel(String.valueOf(masterTel));
        String leadOrganize = request.getParameter("cmDepartment_leadOrganize");
		if(!ObjectUtil.isEmpty(leadOrganize)) condition.setLeadOrganize(String.valueOf(leadOrganize));
        String registrationTime = request.getParameter("cmDepartment_registrationTime");
		if(!ObjectUtil.isEmpty(registrationTime)) condition.setRegistrationTime(String.valueOf(registrationTime));
        String registrationName = request.getParameter("cmDepartment_registrationName");
		if(!ObjectUtil.isEmpty(registrationName)) condition.setRegistrationName(String.valueOf(registrationName));
        String num = request.getParameter("cmDepartment_num");
		if(!ObjectUtil.isEmpty(num)) condition.setNum(Integer.valueOf(num));
        String generalRules = request.getParameter("cmDepartment_generalRules");
		if(!ObjectUtil.isEmpty(generalRules)) condition.setGeneralRules(String.valueOf(generalRules));
        String purpose = request.getParameter("cmDepartment_purpose");
		if(!ObjectUtil.isEmpty(purpose)) condition.setPurpose(String.valueOf(purpose));
        String droit = request.getParameter("cmDepartment_droit");
		if(!ObjectUtil.isEmpty(droit)) condition.setDroit(String.valueOf(droit));
        String obligation = request.getParameter("cmDepartment_obligation");
		if(!ObjectUtil.isEmpty(obligation)) condition.setObligation(String.valueOf(obligation));
        String requirement = request.getParameter("cmDepartment_requirement");
		if(!ObjectUtil.isEmpty(requirement)) condition.setRequirement(String.valueOf(requirement));
        String other = request.getParameter("cmDepartment_other");
		if(!ObjectUtil.isEmpty(other)) condition.setOther(String.valueOf(other));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			cmDepartmentService.updateCmDepartment(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/addCmDepartment")
	@ResponseBody
	public Response<CmDepartment> addCmDepartment(HttpServletRequest request){
		Response<CmDepartment> response =ResponseFactory.getDefaultSuccessResponse();
		
		CmDepartment po=new CmDepartment();
		po.setId(UUIDUtil.getUUID());
        String id = request.getParameter("cmDepartment_id");
		if(!ObjectUtil.isEmpty(id)) po.setId(String.valueOf(id));
        String name = request.getParameter("cmDepartment_name");
		if(!ObjectUtil.isEmpty(name)) po.setName(String.valueOf(name));
        String info = request.getParameter("cmDepartment_info");
		if(!ObjectUtil.isEmpty(info)) po.setInfo(String.valueOf(info));
        String duty = request.getParameter("cmDepartment_duty");
		if(!ObjectUtil.isEmpty(duty)) po.setDuty(String.valueOf(duty));
        String characters = request.getParameter("cmDepartment_characters");
		if(!ObjectUtil.isEmpty(characters)) po.setCharacters(String.valueOf(characters));
        String masterName = request.getParameter("cmDepartment_masterName");
		if(!ObjectUtil.isEmpty(masterName)) po.setMasterName(String.valueOf(masterName));
        String masterTel = request.getParameter("cmDepartment_masterTel");
		if(!ObjectUtil.isEmpty(masterTel)) po.setMasterTel(String.valueOf(masterTel));
        String leadOrganize = request.getParameter("cmDepartment_leadOrganize");
		if(!ObjectUtil.isEmpty(leadOrganize)) po.setLeadOrganize(String.valueOf(leadOrganize));
        String registrationTime = request.getParameter("cmDepartment_registrationTime");
		if(!ObjectUtil.isEmpty(registrationTime)) po.setRegistrationTime(String.valueOf(registrationTime));
        String registrationName = request.getParameter("cmDepartment_registrationName");
		if(!ObjectUtil.isEmpty(registrationName)) po.setRegistrationName(String.valueOf(registrationName));
        String num = request.getParameter("cmDepartment_num");
		if(!ObjectUtil.isEmpty(num)) po.setNum(Integer.valueOf(num));
        String generalRules = request.getParameter("cmDepartment_generalRules");
		if(!ObjectUtil.isEmpty(generalRules)) po.setGeneralRules(String.valueOf(generalRules));
        String purpose = request.getParameter("cmDepartment_purpose");
		if(!ObjectUtil.isEmpty(purpose)) po.setPurpose(String.valueOf(purpose));
        String droit = request.getParameter("cmDepartment_droit");
		if(!ObjectUtil.isEmpty(droit)) po.setDroit(String.valueOf(droit));
        String obligation = request.getParameter("cmDepartment_obligation");
		if(!ObjectUtil.isEmpty(obligation)) po.setObligation(String.valueOf(obligation));
        String requirement = request.getParameter("cmDepartment_requirement");
		if(!ObjectUtil.isEmpty(requirement)) po.setRequirement(String.valueOf(requirement));
        String other = request.getParameter("cmDepartment_other");
		if(!ObjectUtil.isEmpty(other)) po.setOther(String.valueOf(other));
		
		try {
			cmDepartmentService.addCmDepartment(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
}
