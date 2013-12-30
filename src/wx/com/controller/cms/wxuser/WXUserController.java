package wx.com.controller.cms.wxuser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="protected")
public class WXUserController {
	
	@RequestMapping(value="/wx_user",method = RequestMethod.GET)
	public String  getwxUser(){
	

		return "/protected/wxuser/wx_user";
	}
	
	@RequestMapping(value="/wx_user_group",method = RequestMethod.GET)
	public String  getwxUser_group(){
	

		return "/protected/wxuser/wx_user_group";
	}
	
	@RequestMapping(value="/wx_user_custom",method = RequestMethod.GET)
	public String  getwxUser_custom(){
	

		return "/protected/wxuser/wx_user_custom";
	}

}
