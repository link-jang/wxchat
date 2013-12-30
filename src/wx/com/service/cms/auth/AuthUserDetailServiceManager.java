package wx.com.service.cms.auth;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.User;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import wx.com.entity.cms.auth.AuthRole;
import wx.com.entity.cms.auth.Authorities;

import javax.annotation.Resource;

import wx.com.service.cms.auth.ILoginManager;


/** 
* @ClassName: AuthUserDetailServiceManager   Service
* @Description: TODO(微信公众平台) 
* 处理登陆号码的验证问题，通过 用户名 和数据库里面的数据对比，并返回数据权限
* @author jiang 
* @date 2013-12-12 上午8:52:39 
*  
*/ 
@Service
public class AuthUserDetailServiceManager implements UserDetailsService {
	
	@Resource(name="loginManager") 
    public ILoginManager loginManager; 

	public ILoginManager getLoginManager() {
		return loginManager;
	}

	public void setLoginManager(ILoginManager loginManager) {
		this.loginManager = loginManager;
	}

	//username
	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		
		GrantedAuthority[] authorities = {new AuthRole("ROLE_HEAD_OF_ENGINEERING")};
		//User user = new User("alice", "123", true, true, true, true, authorities);
		
		Authorities authuser=null;
		User user = null;
		try{
			authuser=loginManager.getAuthUserDetail(arg0);
			//loginManager.SaveAuthUserDetail(null);
			user = new User(arg0, authuser.getPassword(), true, true, true, true, authorities);
			
		}catch(Exception ex ){
			ex.printStackTrace();
		}
		
		
		return user;
		
	}

}
