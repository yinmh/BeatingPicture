package org.game.beatingpicture.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.game.beatingpicture.util.PasswordHash;

/**
 * 自定义密码比较规则
 * @author Administrator
 *
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
    	UsernamePasswordToken uToken =(UsernamePasswordToken) token;
        //获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
        String inPassword = new String(uToken.getPassword());

        //获得数据库中的密码
        String dbPassword = (String) info.getCredentials();

        System.err.println("inPassword:" + inPassword);
        System.err.println("dbPassword:" + dbPassword);
        //进行密码的比对
        boolean flag = PasswordHash.validatePassword(inPassword,dbPassword);
        return flag;
    }
}
