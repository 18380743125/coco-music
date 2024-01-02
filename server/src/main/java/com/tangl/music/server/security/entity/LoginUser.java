package com.tangl.music.server.security.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.tangl.music.server.modules.system.user.vo.UserVO;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * @author tangl
 * @description 登录用户身份权限
 * @create 2023-12-25 22:01
 */
@Data
public class LoginUser implements UserDetails, Serializable {

    private static final long serialVersionUID = -8425597520089698626L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户唯一标识
     */
    private String token;

    /**
     * 登录时间
     */
    private Long loginTime;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地点
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 该用户拥有的权限列表
     */
    private Set<String> permissions;

    /**
     * 用户信息
     */
    private UserVO user;

    public LoginUser(Long userId, UserVO user, Set<String> permissions) {
        this.userId = userId;
        this.user = user;
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    @JSONField(serialize = false)
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return null;
    }

    /**
     * 账户是否未过期，过期无法验证
     */
    @Override
    @JSONField(serialize = false)
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户是否解锁， 锁定的用户无法进行身份验证
     */
    @Override
    @JSONField(serialize = false)
    public boolean isAccountNonLocked() {
        return true;
    }


    /**
     * 用户凭证是否未过期，过期的凭证防止认证
     */
    @Override
    @JSONField(serialize = false)
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用，禁用的用户不能身份验证
     */
    @Override
    @JSONField(serialize = false)
    public boolean isEnabled() {
        return true;
    }
}
