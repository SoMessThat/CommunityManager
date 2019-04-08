package mess.wkb.cm.code.ctrl;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mess.wkb.cm.code.po.CmUserPO;
import mess.wkb.cm.code.service.CmUserService;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.util.code.MD5;
import mess.wkb.cm.tool.web.MysqlDBException;
import mess.wkb.cm.tool.web.WebContext;

 
@Controller
@RequestMapping(value = "login")
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
	@RequestMapping(value = "/index")
	public ModelAndView login(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		String account = request.getParameter("TPL_username");
		String password = request.getParameter("TPL_password");
//		Long loginTime = Long.parseLong(request.getParameter("loginTime"));
		if (ObjectUtil.isEmpty(account)) {
			mv.addObject("erro", "账号不能为空");
			mv.setViewName("login");
			return mv;
		}
		if (ObjectUtil.isEmpty(password)) {
			mv.addObject("erro", "密码不能为空");
			mv.setViewName("login");
			return mv;
		}
//		if (ObjectUtil.isEmpty(loginTime)) {
//			mv.addObject("erro", "网络错误，请重新登录");
//			mv.setViewName("../login");
//			return mv;
//		}
		CmUserPO user = new CmUserPO();
		user.setPassword(MD5.MD5Encode(password));
		System.out.println(MD5.MD5Encode(password));
		user.setAccount(account);
		//对比密码
		try {
			CmUserPO TCmUserPO=TuserService.getCmUserByParam(user);
			if(!ObjectUtil.isEmpty(TCmUserPO)){
//				TCmUserPO.setLastTime(loginTime);
				TuserService.updateCmUser(TCmUserPO);
				if (TCmUserPO.getState()=="1") {
					mv.addObject("user", TCmUserPO);
					mv.setViewName("index");
				}
				else {
					mv.setViewName("usermain");
				}
				System.out.println(TCmUserPO);
				WebContext.setSessionAttribute("userInfo", TCmUserPO);
			}else{
				mv.addObject("erro", "账号或密码错误");
				mv.setViewName("login");
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
	
}
