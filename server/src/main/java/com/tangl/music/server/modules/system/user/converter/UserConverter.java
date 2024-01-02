package com.tangl.music.server.modules.system.user.converter;

import com.tangl.music.server.modules.system.user.context.*;
import com.tangl.music.server.modules.system.user.entity.TMusicUser;
import com.tangl.music.server.modules.system.user.po.*;
import com.tangl.music.server.modules.system.user.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author tangl
 * @description 用户模块实体转换工具类
 * @create 2023-12-23 10:42
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

    @Mapping(target = "roleNameList", ignore = true)
    RegisterUserContext registerUserPO2RegisterUserContext(RegisterUserPO registerUserPO);

    @Mapping(target = "password", ignore = true)
    TMusicUser registerUserContext2TMusicUser(RegisterUserContext registerUserContext);

    @Mapping(target = "userId", expression = "java(com.tangl.music.core.utils.IdUtil.decrypt(deleteUserPO.getUserId()))")
    DeleteUserContext deleteUserPO2DeleteUserContext(DeleteUserPO deleteUserPO);

    @Mapping(target = "userId", expression = "java(com.tangl.music.core.utils.IdUtil.decrypt(updateUserPO.getUserId()))")
    UpdateUserContext updateUserPO2UpdateUserContext(UpdateUserPO updateUserPO);

    TMusicUser updateUserContext2TMusicUser(UpdateUserContext context);

    QueryUserContext queryUserPO2QueryUserContext(QueryUserPO queryUserPO);

    List<UserVO> userList2UserVOList(List<TMusicUser> userList);

    UserVO user2UserVO(TMusicUser user);

    UserLoginContext userLoginPO2UserLoginContext(UserLoginPO userLoginPO);
}
