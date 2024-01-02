package com.tangl.music.server.security.utils;

import com.tangl.music.core.exception.TMusicBusinessException;
import com.tangl.music.server.common.enums.RoleKeyEnum;
import com.tangl.music.server.modules.system.role.vo.RoleVO;
import com.tangl.music.server.security.entity.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 安全服务工具类
 */
public class SecurityUtils {

    /**
     * 获取用户
     */
    public static LoginUser getLoginUser() {
        try {
            return (LoginUser) getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new TMusicBusinessException("获取用户信息异常");
        }
    }

    /**
     * 用户ID
     */
    public static Long getUserId() {
        try {
            return getLoginUser().getUserId();
        } catch (Exception e) {
            throw new TMusicBusinessException("获取用户ID异常");
        }
    }

    /**
     * 获取用户账户
     */
    public static String getUsername() {
        try {
            return getLoginUser().getUsername();
        } catch (Exception e) {
            throw new TMusicBusinessException("获取用户名异常");
        }
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 加密密码
     *
     * @param inputPassword 密码
     * @return 密文
     */
    public static String encryptPassword(String inputPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(inputPassword);
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword     真实密码
     * @param encodedPassword 输入密码
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 是否为管理员
     *
     * @param roleList 用户ID
     * @return 结果
     */
    public static boolean isSuperAdmin(List<RoleVO> roleList) {
        Set<String> roleKeySet = roleList.stream().map(RoleVO::getRoleKey).collect(Collectors.toSet());
        return roleKeySet.contains(RoleKeyEnum.SUPER_ADMIN.getKey());
    }
}
