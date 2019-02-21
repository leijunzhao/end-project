package com.baizhi.test.realm;

import com.baizhi.test.entity.Admin;
import com.baizhi.test.mapper.AdminMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    AdminMapper adminMapper;

    //授权数据
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证数据
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        Admin admin = new Admin();
        admin.setName(principal);
        Admin selectOne = adminMapper.selectOne(admin);
        System.out.println("-----" + selectOne);
        AuthenticationInfo authenticationInfo = null;
        if (selectOne != null) {
            authenticationInfo = new SimpleAuthenticationInfo(selectOne.getName(), selectOne.getPassword(), ByteSource.Util.bytes(selectOne.getSalt()), this.getName());

        }
        return authenticationInfo;
    }
}
