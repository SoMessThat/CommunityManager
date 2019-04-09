package mess.wkb.cm.code.ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mess.wkb.cm.code.po.CmPaymentRecordPO;
import mess.wkb.cm.code.service.CmPaymentRecordService;
import mess.wkb.cm.code.vo.CmPaymentRecord;
import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.util.ajax.Response;
import mess.wkb.cm.tool.util.ajax.ResponseFactory;
import mess.wkb.cm.tool.web.MysqlDBException;


@Controller
@RequestMapping("/CmPaymentRecord") 
public class CmPaymentRecordCtrl {

	@Autowired
	private CmPaymentRecordService cmPaymentRecordService;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@RequestMapping(value ="/queryPageCmPaymentRecord")
	@ResponseBody
	public Response<List<CmPaymentRecordPO>> queryPageCmPaymentRecord(Integer page,Integer limit,HttpServletRequest request) throws ParseException{
		Response<List<CmPaymentRecordPO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<CmPaymentRecordPO> cmPaymentRecords = null;
		
		
		CmPaymentRecordPO condition=new CmPaymentRecordPO();
        String id = request.getParameter("cmPaymentRecord_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Long.valueOf(id));
        String payTime = request.getParameter("cmPaymentRecord_payTime");
		if(!ObjectUtil.isEmpty(payTime)) condition.setPayTime(dateFormat.parse(payTime));
        String departmentId = request.getParameter("cmPaymentRecord_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) condition.setDepartmentId(String.valueOf(departmentId));
        String userName = request.getParameter("cmPaymentRecord_userName");
		if(!ObjectUtil.isEmpty(userName)) condition.setUserName(String.valueOf(userName));
        String state = request.getParameter("cmPaymentRecord_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
        String paymentId = request.getParameter("cmPaymentRecord_paymentId");
		if(!ObjectUtil.isEmpty(paymentId)) condition.setPaymentId(Long.valueOf(paymentId));
	
		try {
			cmPaymentRecords = cmPaymentRecordService.queryPageCmPaymentRecord(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(cmPaymentRecords.getListData());
		response.setCount(cmPaymentRecords.getTotalHit());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	@RequestMapping(value="/delCmPaymentRecord")
	@ResponseBody
	public Response<CmPaymentRecordPO> delCmPaymentRecord(String id){
		Response<CmPaymentRecordPO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			cmPaymentRecordService.deleteCmPaymentRecordById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findCmPaymentRecordById")
	@ResponseBody
	public Response<CmPaymentRecordPO> findCmPaymentRecordById(String id){
		Response<CmPaymentRecordPO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(cmPaymentRecordService.getCmPaymentRecordById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/updateCmPaymentRecordById")
	@ResponseBody
	public Response<CmPaymentRecordPO> updateCmPaymentRecordById(HttpServletRequest request) throws ParseException{
		Response<CmPaymentRecordPO> response =ResponseFactory.getDefaultSuccessResponse();
		CmPaymentRecordPO condition=new CmPaymentRecordPO();
        String id = request.getParameter("cmPaymentRecord_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(Long.valueOf(id));
        String payTime = request.getParameter("cmPaymentRecord_payTime");
		if(!ObjectUtil.isEmpty(payTime)) condition.setPayTime(dateFormat.parse(payTime));
        String departmentId = request.getParameter("cmPaymentRecord_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) condition.setDepartmentId(String.valueOf(departmentId));
        String userName = request.getParameter("cmPaymentRecord_userName");
		if(!ObjectUtil.isEmpty(userName)) condition.setUserName(String.valueOf(userName));
        String state = request.getParameter("cmPaymentRecord_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
        String paymentId = request.getParameter("cmPaymentRecord_paymentId");
		if(!ObjectUtil.isEmpty(paymentId)) condition.setPaymentId(Long.valueOf(paymentId));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			cmPaymentRecordService.updateCmPaymentRecord(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	/**
	 * 缴费
	 * @param request
	 */
	@RequestMapping(value="/addCmPaymentRecord")
	@ResponseBody
	public Response<CmPaymentRecord> addCmPaymentRecord(HttpServletRequest request) throws ParseException{
		Response<CmPaymentRecord> response =ResponseFactory.getDefaultSuccessResponse();
		
		CmPaymentRecord po=new CmPaymentRecord();
        String payTime = request.getParameter("cmPaymentRecord_payTime");
		if(!ObjectUtil.isEmpty(payTime)) po.setPayTime(dateFormat.parse(payTime));
        String departmentId = request.getParameter("cmPaymentRecord_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) po.setDepartmentId(String.valueOf(departmentId));
        String userName = request.getParameter("cmPaymentRecord_userName");
		if(!ObjectUtil.isEmpty(userName)) po.setUserName(String.valueOf(userName));
        String state = request.getParameter("cmPaymentRecord_state");
		if(!ObjectUtil.isEmpty(state)) po.setState(String.valueOf(state));
        String paymentId = request.getParameter("cmPaymentRecord_paymentId");
		if(!ObjectUtil.isEmpty(paymentId)) po.setPaymentId(Long.valueOf(paymentId));
		
		try {
			cmPaymentRecordService.addCmPaymentRecord(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
}
