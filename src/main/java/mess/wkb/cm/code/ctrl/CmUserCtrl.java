package mess.wkb.cm.code.ctrl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import mess.wkb.cm.code.dto.UserInfoDTO;
import mess.wkb.cm.code.po.CmUserPO;
import mess.wkb.cm.code.service.CmUserService;
import mess.wkb.cm.code.vo.CmUser;
import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.util.UUIDUtil;
import mess.wkb.cm.tool.util.ajax.Response;
import mess.wkb.cm.tool.util.ajax.ResponseFactory;
import mess.wkb.cm.tool.web.MysqlDBException;

@Controller
@RequestMapping("/CmUser") 
public class CmUserCtrl {

	@Autowired
	private CmUserService cmUserService;
	
	/**
	 * 查看干事列表
	 */
	@RequestMapping(value ="/queryPageCmUser")
	@ResponseBody
	public Response<List<CmUserPO>> queryPageCmUser(Integer page,Integer limit,HttpServletRequest request){
		Response<List<CmUserPO>> response = ResponseFactory.getDefaultSuccessResponse();
		Paged<CmUserPO> cmUsers = null;
		
		CmUserPO condition=new CmUserPO();
        String id = request.getParameter("cmUser_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String account = request.getParameter("cmUser_account");
		if(!ObjectUtil.isEmpty(account)) condition.setAccount(String.valueOf(account));
        String username = request.getParameter("cmUser_username");
		if(!ObjectUtil.isEmpty(username)) condition.setUsername(String.valueOf(username));
        String password = request.getParameter("cmUser_password");
		if(!ObjectUtil.isEmpty(password)) condition.setPassword(String.valueOf(password));
        String avatar = request.getParameter("cmUser_avatar");
		if(!ObjectUtil.isEmpty(avatar)) condition.setAvatar(String.valueOf(avatar));
        String tel = request.getParameter("cmUser_tel");
		if(!ObjectUtil.isEmpty(tel)) condition.setTel(String.valueOf(tel));
        String creatTime = request.getParameter("cmUser_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) condition.setCreatTime(String.valueOf(creatTime));
        String state = request.getParameter("cmUser_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
        String departmentId = request.getParameter("cmUser_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) condition.setDepartmentId(String.valueOf(departmentId));
        String studentId = request.getParameter("cmUser_studentId");
		if(!ObjectUtil.isEmpty(studentId)) condition.setStudentId(String.valueOf(studentId));
        String role = request.getParameter("cmUser_role");
		if(!ObjectUtil.isEmpty(role)) condition.setRole(Long.valueOf(role));
	
		try {
			cmUsers = cmUserService.queryPageCmUser(page,limit,condition);
		} catch (MysqlDBException e) {
			e.printStackTrace();
			response.setError("网络连接失败，请检查网络");
		}
		response.setData(cmUsers.getListData());
		response.setCount(cmUsers.getTotalHit());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
		
	}
	
	/**
	 * 辞退干事
	 */
	@RequestMapping(value="/delCmUser")
	@ResponseBody
	public Response<CmUserPO> delCmUser(String id){
		Response<CmUserPO> response = ResponseFactory.getDefaultSuccessResponse();

		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		
		try {
			cmUserService.deleteCmUserById(id);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	/**
	 * 查看个人信息
	 * @param id
	 */
	@RequestMapping(value="/findCmUserById")
	@ResponseBody
	public Response<UserInfoDTO> findCmUserById(String id){
		Response<UserInfoDTO> response =ResponseFactory.getDefaultSuccessResponse();
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(cmUserService.getCmUserById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	/**
	 * 修改个人信息
	 * @param request
	 */
	@RequestMapping(value="/updateCmUserById")
	@ResponseBody
	public Response<CmUser> updateCmUserById(HttpServletRequest request){
		Response<CmUser> response =ResponseFactory.getDefaultSuccessResponse();
		CmUser condition=new CmUser();
        String id = request.getParameter("cmUser_id");
		if(!ObjectUtil.isEmpty(id)) condition.setId(String.valueOf(id));
        String account = request.getParameter("cmUser_account");
		if(!ObjectUtil.isEmpty(account)) condition.setAccount(String.valueOf(account));
        String username = request.getParameter("cmUser_username");
		if(!ObjectUtil.isEmpty(username)) condition.setUsername(String.valueOf(username));
        String password = request.getParameter("cmUser_password");
		if(!ObjectUtil.isEmpty(password)) condition.setPassword(String.valueOf(password));
        String avatar = request.getParameter("cmUser_avatar");
		if(!ObjectUtil.isEmpty(avatar)) condition.setAvatar(String.valueOf(avatar));
        String tel = request.getParameter("cmUser_tel");
		if(!ObjectUtil.isEmpty(tel)) condition.setTel(String.valueOf(tel));
        String state = request.getParameter("cmUser_state");
		if(!ObjectUtil.isEmpty(state)) condition.setState(String.valueOf(state));
        String role = request.getParameter("cmUser_role");
		if(!ObjectUtil.isEmpty(role)) condition.setRole(Long.valueOf(role));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			cmUserService.updateCmUser(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	@RequestMapping(value="/addCmUser")
	@ResponseBody
	public Response<CmUserPO> addCmUser(HttpServletRequest request){
		Response<CmUserPO> response =ResponseFactory.getDefaultSuccessResponse();
		
		CmUserPO po=new CmUserPO();
		po.setId(UUIDUtil.getUUID());
        String id = request.getParameter("cmUser_id");
		if(!ObjectUtil.isEmpty(id)) po.setId(String.valueOf(id));
        String account = request.getParameter("cmUser_account");
		if(!ObjectUtil.isEmpty(account)) po.setAccount(String.valueOf(account));
        String username = request.getParameter("cmUser_username");
		if(!ObjectUtil.isEmpty(username)) po.setUsername(String.valueOf(username));
        String password = request.getParameter("cmUser_password");
		if(!ObjectUtil.isEmpty(password)) po.setPassword(String.valueOf(password));
        String avatar = request.getParameter("cmUser_avatar");
		if(!ObjectUtil.isEmpty(avatar)) po.setAvatar(String.valueOf(avatar));
        String tel = request.getParameter("cmUser_tel");
		if(!ObjectUtil.isEmpty(tel)) po.setTel(String.valueOf(tel));
        String creatTime = request.getParameter("cmUser_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) po.setCreatTime(String.valueOf(creatTime));
        String state = request.getParameter("cmUser_state");
		if(!ObjectUtil.isEmpty(state)) po.setState(String.valueOf(state));
        String departmentId = request.getParameter("cmUser_departmentId");
		if(!ObjectUtil.isEmpty(departmentId)) po.setDepartmentId(String.valueOf(departmentId));
        String studentId = request.getParameter("cmUser_studentId");
		if(!ObjectUtil.isEmpty(studentId)) po.setStudentId(String.valueOf(studentId));
        String role = request.getParameter("cmUser_role");
		if(!ObjectUtil.isEmpty(role)) po.setRole(Long.valueOf(role));
		
		try {
			cmUserService.addCmUser(po);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	/**
	 * 查看个人信息
	 * @param id
	 */
	@RequestMapping(value="/findCmUser")
	@ResponseBody
	public Response<UserInfoDTO> findCmUser(HttpServletRequest request){
		Response<UserInfoDTO> response =ResponseFactory.getDefaultSuccessResponse();
//		HttpSession session = request.getSession();
//		CmUser userSession = (CmUser) session.getAttribute("user");
//		String id= userSession.getId();
		String id= "1";
		if (ObjectUtil.isEmpty(id)) {
			response.setError("id不能为空");
			return response;
		}
		try {
			response.setData(cmUserService.getCmUserById(id));
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		return response;
	}
	
	/**
	 * 上传图片
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Response<CmUserPO> uplpad(@RequestParam MultipartFile file, HttpServletRequest request) {
		Response<CmUserPO> response =ResponseFactory.getDefaultSuccessResponse();
		CmUserPO po = new CmUserPO();
		String desFilePath = "";
		String oriName = "";
		Map<String, String> dataMap = new HashMap<>();
		try {
			// 1.获取原文件名
			oriName = file.getOriginalFilename();
			// 2.获取原文件图片后缀，以最后的.作为截取(.jpg)
			String extName = oriName.substring(oriName.lastIndexOf("."));
			// 3.生成自定义的新文件名，这里以UUID.jpg|png|xxx作为格式（可选操作，也可以不自定义新文件名）
			String uuid = UUIDUtil.getUUID();
			String newName = uuid + extName;
			// 4.获取要保存的路径文件夹
			String realPath = "E:/images";
//			String realPath = "/CommunityImg";
			// 5.保存图片
			desFilePath = realPath + "/" + newName;
			File desFile = new File(desFilePath);
			file.transferTo(desFile);
			System.out.println(desFilePath);
			po.setAvatar("/" + newName);
			// 6.返回保存结果信息
			dataMap = new HashMap<>();
			dataMap.put("src", "resources/imgs/" + newName);
		} catch (IllegalStateException e) {
			System.out.println(desFilePath + "图片保存失败");
			return response;
		} catch (IOException e) {
			System.out.println(desFilePath + "图片保存失败--IO异常");
			return response;
		}
		response.setData(po);
		return response;
	}
	
	/**
	 * 修改个人信息
	 * @param request
	 */
	@RequestMapping(value="/updateCmUser")
	@ResponseBody
	public Response<CmUser> updateCmUser(HttpServletRequest request){
		Response<CmUser> response =ResponseFactory.getDefaultSuccessResponse();
		CmUser condition=new CmUser();
//		HttpSession session = request.getSession();
//		CmUser userSession = (CmUser) session.getAttribute("user");
//		String id= userSession.getId();
		String id= "1";
		condition.setId(id);
        String account = request.getParameter("cmUser_account");
		if(!ObjectUtil.isEmpty(account)) condition.setAccount(String.valueOf(account));
        String username = request.getParameter("cmUser_username");
		if(!ObjectUtil.isEmpty(username)) condition.setUsername(String.valueOf(username));
        String avatar = request.getParameter("cmUser_avatar");
		if(!ObjectUtil.isEmpty(avatar)) condition.setAvatar(String.valueOf(avatar));
        String tel = request.getParameter("cmUser_tel");
		if(!ObjectUtil.isEmpty(tel)) condition.setTel(String.valueOf(tel));
        String code = request.getParameter("cmUser_code");
		if(!ObjectUtil.isEmpty(code)) condition.setStudentId(String.valueOf(code));
		
		if (ObjectUtil.isEmpty(condition.getId())) {
			response.setError("id不能为空");
			return response;
		}

		try {
			cmUserService.updateUserInfo(condition);
		} catch (MysqlDBException e) {
			response.setError("网络连接失败，请检查网络");
			return response;
		}
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
	
	/**
	 * 查找部门的人员
	 * @param request
	 */
	@RequestMapping(value="/queryEmployee")
	@ResponseBody
	public Response<List<UserInfoDTO>> queryEmployee(Integer page,Integer limit,HttpServletRequest request){
		Response<List<UserInfoDTO>> response =ResponseFactory.getDefaultSuccessResponse();
//		HttpSession session = request.getSession();
//		CmUser userSession = (CmUser) session.getAttribute("user");
//		String id= userSession.getId();
		String departmentId= "1";
		
		if (ObjectUtil.isEmpty(departmentId)) {
			response.setError("id不能为空");
			return response;
		}

		Paged<UserInfoDTO> employees = cmUserService.queryEmployee(page,limit,departmentId);
		response.setData(employees.getListData());
		response.setCount(employees.getTotalHit());
		response.setResult(Response.RESULT_SUCCESS);
		return response;
	}
}
