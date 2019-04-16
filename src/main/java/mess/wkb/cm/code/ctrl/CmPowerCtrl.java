package mess.wkb.cm.code.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mess.wkb.cm.code.dto.PowerDTO;
import mess.wkb.cm.code.po.CmPowerPO;
import mess.wkb.cm.code.service.CmPowerService;
import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.util.JSONUtil;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.util.UUIDUtil;
import mess.wkb.cm.tool.util.ajax.Response;
import mess.wkb.cm.tool.util.ajax.ResponseFactory;
import mess.wkb.cm.tool.web.MysqlDBException;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("/CmPower") 
public class CmPowerCtrl {

	@Autowired
	private CmPowerService cmPowerService;
	
	@RequestMapping(value ="/queryPageCmPower")
	@ResponseBody
	public Response<List<CmPowerPO>> queryPageCmPower(Integer page,Integer limit,HttpServletRequest request){
		Response<List<CmPowerPO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<CmPowerPO> cmPowers = null;
		
		CmPowerPO condition=new CmPowerPO();
        String id = request.getParameter("cmPower_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String name = request.getParameter("cmPower_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
        String parentId = request.getParameter("cmPower_parentId");
		if(!ObjectUtil.isEmpty(parentId)) condition.setParentId(String.valueOf(parentId));
        String content = request.getParameter("cmPower_content");
		if(!ObjectUtil.isEmpty(content)) condition.setContent(String.valueOf(content));
        String soft = request.getParameter("cmPower_soft");
		if(!ObjectUtil.isEmpty(soft)) condition.setSoft(String.valueOf(soft));
	
		try {
			cmPowers = cmPowerService.queryPageCmPower(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(cmPowers.getListData());
		response.setCount(cmPowers.getTotalHit());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	@RequestMapping(value="/delCmPower")
	@ResponseBody
	public Response<CmPowerPO> delCmPower(String id){
		Response<CmPowerPO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			cmPowerService.deleteCmPowerById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/findCmPowerById")
	@ResponseBody
	public Response<CmPowerPO> findCmPowerById(String id){
		Response<CmPowerPO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(cmPowerService.getCmPowerById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/updateCmPowerById")
	@ResponseBody
	public Response<CmPowerPO> updateCmPowerById(HttpServletRequest request){
		Response<CmPowerPO> response =ResponseFactory.getDefaultSuccessResponse();
		CmPowerPO condition=new CmPowerPO();
        String id = request.getParameter("cmPower_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String name = request.getParameter("cmPower_name");
		if(!ObjectUtil.isEmpty(name)) condition.setName(String.valueOf(name));
        String parentId = request.getParameter("cmPower_parentId");
		if(!ObjectUtil.isEmpty(parentId)) condition.setParentId(String.valueOf(parentId));
        String content = request.getParameter("cmPower_content");
		if(!ObjectUtil.isEmpty(content)) condition.setContent(String.valueOf(content));
        String soft = request.getParameter("cmPower_soft");
		if(!ObjectUtil.isEmpty(soft)) condition.setSoft(String.valueOf(soft));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			cmPowerService.updateCmPower(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/addCmPower")
	@ResponseBody
	public Response<CmPowerPO> addCmPower(HttpServletRequest request){
		Response<CmPowerPO> response =ResponseFactory.getDefaultSuccessResponse();
		
		CmPowerPO po=new CmPowerPO();
		po.setId(UUIDUtil.getUUID());
        String id = request.getParameter("cmPower_id");
		if(!ObjectUtil.isEmpty(id)) po.setId(String.valueOf(id));
        String name = request.getParameter("cmPower_name");
		if(!ObjectUtil.isEmpty(name)) po.setName(String.valueOf(name));
        String parentId = request.getParameter("cmPower_parentId");
		if(!ObjectUtil.isEmpty(parentId)) po.setParentId(String.valueOf(parentId));
        String content = request.getParameter("cmPower_content");
		if(!ObjectUtil.isEmpty(content)) po.setContent(String.valueOf(content));
        String soft = request.getParameter("cmPower_soft");
		if(!ObjectUtil.isEmpty(soft)) po.setSoft(String.valueOf(soft));
		
		try {
			cmPowerService.addCmPower(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	/**
	 * 根据角色id获取权限菜单
	 * @param userID
	 * @return
	 */
	@RequestMapping(value="/queryMenu")
	@ResponseBody
	public JSONObject queryMenu(HttpServletRequest request){
		
        String userID = request.getParameter("userID");
        if (ObjectUtil.isEmpty(userID)) {
			return null;
		}
        List<PowerDTO> menu;
		try {
			menu = cmPowerService.queryMenu(userID);
		} catch (MysqlDBException e) {
			return null;
		}
		return JSONUtil.toJsonMenu(menu);
	}
}
