package mess.wkb.cm.code.ctrl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mess.wkb.cm.code.po.CmDepartmentPO;
import mess.wkb.cm.code.po.CmUserPO;
import mess.wkb.cm.code.service.CmUserService;
import mess.wkb.cm.code.vo.CmUser;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.util.UUIDUtil;
import mess.wkb.cm.tool.util.ajax.Response;
import mess.wkb.cm.tool.util.ajax.ResponseFactory;
import mess.wkb.cm.tool.util.creatdata.ChineseName;
import mess.wkb.cm.tool.web.MysqlDBException;

 
@Controller
public class BackCtrl{

	@Autowired
	CmUserService TuserService;
	
	/**
	 * 登陆	
	 * @createTime: 2018年10月10日 上午9:29:48
	 * @author: wu.kaibin
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		String account = request.getParameter("userinp");
		String password = request.getParameter("password");
//		Long loginTime = Long.parseLong(request.getParameter("loginTime"));
		if (ObjectUtil.isEmpty(account)) {
			mv.addObject("erro", "账号不能为空");
			mv.setViewName("redirect:html/login.html");
			return mv;
		}
		if (ObjectUtil.isEmpty(password)) {
			mv.addObject("erro", "密码不能为空");
			mv.setViewName("redirect:html/login.html");
			return mv;
		}
		CmUserPO user = new CmUserPO();
		user.setPassword(password);
		user.setAccount(account);
		//对比密码
		try {
			CmUserPO TCmUserPO=TuserService.getCmUserByParam(user);
			if(!ObjectUtil.isEmpty(TCmUserPO)){
				mv.addObject("user", TCmUserPO);
				HttpSession session = request.getSession();
				session.setAttribute("user", TCmUserPO);
				mv.setViewName("redirect:html/index.html");
				System.out.println(TCmUserPO);
			}else{
				mv.addObject("erro", "账号或密码错误");
				mv.setViewName("redirect:html/login.html");
			}
		} catch (MysqlDBException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 登陆界面路口
	 * @createTime: 2018年10月10日 上午9:29:57
	 * @author: wu.kaibin
	 * @return
	 */
	@RequestMapping(value = "/main")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	/**
	 * 发送短信
	 * @param num2
	 * @return
	 */
	@RequestMapping(value ="/sendMessage")
	@ResponseBody
	public Response<List<CmDepartmentPO>> LoginBySMS(HttpServletRequest request){
		Response<List<CmDepartmentPO>> response = ResponseFactory.getDefaultSuccessResponse();
		String phoneNum = request.getParameter("phone");
		if (ObjectUtil.isEmpty(phoneNum)) {
			response.setResult(Response.RESULT_ERROR);
			response.setError("手机号不能为空");
		}
		String type = request.getParameter("type");
		if (!ObjectUtil.isEmpty(type)&&"register".equalsIgnoreCase(type)) {
			CmUserPO user= new CmUserPO();
			user.setTel(phoneNum);
			List<CmUserPO> userPO = new ArrayList<CmUserPO>();
			try {
				userPO = TuserService.queryListCmUserByParam(user);
			} catch (MysqlDBException e) {
				e.printStackTrace();
			}
			if (userPO.size()>0) {
				response.setError("该手机号已被注册");
				response.setResult(Response.RESULT_ERROR);
				return response;
			}
		}
		String code = ChineseName.get6Code();
		System.out.println("验证码："+code);
//		JuheDemo.mobileQuery(phoneNum,code);
		HttpSession session = request.getSession();
		session.setAttribute("code", code);
		session.setAttribute("phone", phoneNum);
		response.setStatus(200);
		return response;
		
	}
	
	/**
	 * 短信登录	
	 * @createTime: 2018年10月10日 上午9:29:48
	 * @author: wu.kaibin
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/loginBySMS")
	public ModelAndView loginBySMS(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		String phone = request.getParameter("phone");
		String code = request.getParameter("code");
		if (ObjectUtil.isEmpty(phone)) {
			mv.addObject("erro", "手机不能为空");
			mv.setViewName("redirect:html/login.html");
			return mv;
		}
		if (ObjectUtil.isEmpty(code)) {
			mv.addObject("erro", "验证码不能为空");
			mv.setViewName("redirect:html/login.html");
			return mv;
		}
		CmUserPO user = new CmUserPO();
		user.setTel(phone);
		HttpSession session = request.getSession();
		String codeSession = (String) session.getAttribute("code");
		String phoneNum = (String) session.getAttribute("phone");
		if (!code.equalsIgnoreCase(codeSession)) {
			mv.addObject("erro", "验证码错误");
			mv.setViewName("redirect:html/login.html");
			return mv;
		}
		if (!phone.equalsIgnoreCase(phoneNum)) {
			mv.addObject("erro", "验证码错误");
			mv.setViewName("redirect:html/login.html");
			return mv;
		}
		//对比密码
		try {
			CmUserPO TCmUserPO=TuserService.getCmUserByParam(user);
			if(!ObjectUtil.isEmpty(TCmUserPO)){
				mv.addObject("user", TCmUserPO);
				session.setAttribute("user", TCmUserPO);
				mv.setViewName("redirect:html/index.html");
				System.out.println(TCmUserPO);
			}else{
				mv.addObject("erro", "用户不存在");
				mv.setViewName("redirect:html/login.html");
			}
		} catch (MysqlDBException e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 注册验证	
	 * @createTime: 2018年10月10日 上午9:29:48
	 * @author: wu.kaibin
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/registerVri")
	@ResponseBody
	public Response<CmDepartmentPO> registerVri(HttpServletRequest request){
		Response<CmDepartmentPO> response = ResponseFactory.getDefaultSuccessResponse();
		String phone = request.getParameter("phone");
		String code = request.getParameter("code");
		if (ObjectUtil.isEmpty(phone)) {
			response.setError( "手机不能为空");
			response.setResult(Response.RESULT_ERROR);
			return response;
		}
		if (ObjectUtil.isEmpty(code)) {
			response.setError( "手机不能为空");
			response.setResult(Response.RESULT_ERROR);
			return response;
		}
		CmUserPO user = new CmUserPO();
		user.setTel(phone);
		HttpSession session = request.getSession();
		String codeSession = "1111";//(String) session.getAttribute("code");
		String phoneNum = (String) session.getAttribute("phone");
		if (!code.equalsIgnoreCase(codeSession)) {
			response.setError( "手机不能为空");
			response.setResult(Response.RESULT_ERROR);
			return response;
		}
		if (!phone.equalsIgnoreCase(phoneNum)) {
			response.setError("手机不能为空");
			response.setResult(Response.RESULT_ERROR);
			return response;
		}
		List<CmUserPO> userPO = new ArrayList<CmUserPO>();
		try {
			userPO = TuserService.queryListCmUserByParam(user);
		} catch (MysqlDBException e) {
			e.printStackTrace();
		}
		if (userPO.size()>0) {
			response.setError("该手机号已被注册");
			response.setResult(Response.RESULT_ERROR);
			return response;
		}
		return response;
	}
	
	/**
	 * 验证	
	 * @createTime: 2018年10月10日 上午9:29:48
	 * @author: wu.kaibin
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/register")
	@ResponseBody
	public Response<String> register(HttpServletRequest request){
		Response<String> response = ResponseFactory.getDefaultSuccessResponse();
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();
		String phoneNum = (String) session.getAttribute("phone");
		CmUser user = new CmUser();
		user.setTel(phoneNum);
		user.setPassword(pass);
		user.setAccount(phoneNum);
		SimpleDateFormat  df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		user.setCreatTime(df.format(System.currentTimeMillis()));
		user.setId(UUIDUtil.getUUID());
		user.setState("正常");
		user.setRole(0l);
		TuserService.insertSelective(user);
		session.setAttribute("user", user);
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		response.setData(basePath+"/html/index.html#/userInfo");
		return response;
	}
}
