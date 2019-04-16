package mess.wkb.cm.code.ctrl;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mess.wkb.cm.code.po.CmUserPO;
import mess.wkb.cm.code.service.CmUserService;
import mess.wkb.cm.tool.util.ObjectUtil;
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
	
}
