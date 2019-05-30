package mess.wkb.cm.code.ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mess.wkb.cm.code.po.CmPaymentPO;
import mess.wkb.cm.code.service.CmPaymentService;
import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.util.ajax.Response;
import mess.wkb.cm.tool.util.ajax.ResponseFactory;
import mess.wkb.cm.tool.web.MysqlDBException;


@Controller
@RequestMapping("/CmPayment") 
public class CmPaymentCtrl {

	@Autowired
	private CmPaymentService cmPaymentService;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping(value ="/queryPageCmPayment")
	@ResponseBody
	public Response<List<CmPaymentPO>> queryPageCmPayment(Integer page,Integer limit,HttpServletRequest request) throws ParseException{
		Response<List<CmPaymentPO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<CmPaymentPO> cmPayments = null;
		
		
		CmPaymentPO condition=new CmPaymentPO();
        String id = request.getParameter("cmPayment_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Long.valueOf(id));
        String name = request.getParameter("cmPayment_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
        String creatTime = request.getParameter("cmPayment_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) condition.setCreatTime(dateFormat.parse(creatTime));
        String departmentId = request.getParameter("cmPayment_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) condition.setDepartmentId(String.valueOf(departmentId));
        String userName = request.getParameter("cmPayment_userName");
		if(!ObjectUtil.isEmpty(userName)) condition.setUserName(String.valueOf(userName));
        String state = request.getParameter("cmPayment_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
	
		try {
			cmPayments = cmPaymentService.queryPageCmPayment(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(cmPayments.getListData());
		response.setCount(cmPayments.getTotalHit());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	@RequestMapping(value="/delCmPayment")
	@ResponseBody
	public Response<CmPaymentPO> delCmPayment(String id){
		Response<CmPaymentPO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			cmPaymentService.deleteCmPaymentById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findCmPaymentById")
	@ResponseBody
	public Response<CmPaymentPO> findCmPaymentById(String id){
		Response<CmPaymentPO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(cmPaymentService.getCmPaymentById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/updateCmPaymentById")
	@ResponseBody
	public Response<CmPaymentPO> updateCmPaymentById(HttpServletRequest request) throws ParseException{
		Response<CmPaymentPO> response =ResponseFactory.getDefaultSuccessResponse();
		CmPaymentPO condition=new CmPaymentPO();
        String id = request.getParameter("cmPayment_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Long.valueOf(id));
        String name = request.getParameter("cmPayment_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
        String creatTime = request.getParameter("cmPayment_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) condition.setCreatTime(dateFormat.parse(creatTime));
        String departmentId = request.getParameter("cmPayment_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) condition.setDepartmentId(String.valueOf(departmentId));
        String userName = request.getParameter("cmPayment_userName");
		if(!ObjectUtil.isEmpty(userName)) condition.setUserName(String.valueOf(userName));
        String state = request.getParameter("cmPayment_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			cmPaymentService.updateCmPayment(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/addCmPayment")
	@ResponseBody
	public Response<CmPaymentPO> addCmPayment(HttpServletRequest request) throws ParseException{
		Response<CmPaymentPO> response =ResponseFactory.getDefaultSuccessResponse();
		
		CmPaymentPO po=new CmPaymentPO();
        String name = request.getParameter("cmPayment_name");
		if(!ObjectUtil.isEmpty(name)) po.setName(String.valueOf(name));
        String creatTime = request.getParameter("cmPayment_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) po.setCreatTime(dateFormat.parse(creatTime));
        String departmentId = request.getParameter("cmPayment_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) po.setDepartmentId(String.valueOf(departmentId));
        String userName = request.getParameter("cmPayment_userName");
		if(!ObjectUtil.isEmpty(userName)) po.setUserName(String.valueOf(userName));
        String state = request.getParameter("cmPayment_state");
		if(!ObjectUtil.isEmpty(state)) po.setState(String.valueOf(state));
		
		try {
			cmPaymentService.addCmPayment(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/getEmplayee")
	@ResponseBody
	public Response<List<Map<String, String>>> getEmplayee(HttpServletRequest request) throws ParseException{
		Response<List<Map<String, String>>> response =ResponseFactory.getDefaultSuccessResponse();
		
//		HttpSession session = request.getSession();
//		CmUserPO userSession = (CmUserPO) session.getAttribute("user");
		String departmentId = "1";
		List<Map<String, String>>map = cmPaymentService.getEmplayee(departmentId);
		System.out.println(map.toString());
		response.setData(map);
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
}
