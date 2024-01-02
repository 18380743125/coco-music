package com.tangl.music.server.modules.system.role.converter;

import com.tangl.music.server.modules.system.role.context.*;
import com.tangl.music.server.modules.system.role.entity.TMusicRole;
import com.tangl.music.server.modules.system.role.po.*;
import com.tangl.music.server.modules.system.role.vo.RoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author tangl
 * @description 角色模块实体转换工具类
 * @create 2023-12-22 10:36
 */
@Mapper(componentModel = "spring")
public interface RoleConverter {

    AddRoleContext addRolePO2AddRoleContext(AddRolePO addRolePO);

    TMusicRole addRoleContext2TMusicRole(AddRoleContext addRoleContext);

    @Mapping(target = "roleId", expression = "java(com.tangl.music.core.utils.IdUtil.decrypt(deleteRolePO.getRoleId()))")
    DeleteRoleContext deleteRolePO2DeleteRoleContext(DeleteRolePO deleteRolePO);

    @Mapping(target = "roleId", expression = "java(com.tangl.music.core.utils.IdUtil.decrypt(updateRolePO.getRoleId()))")
    UpdateRoleContext updateRolePO2UpdateRoleContext(UpdateRolePO updateRolePO);

    TMusicRole updateRoleContext2Role(UpdateRoleContext context);

    QueryRoleContext queryRolePO2QueryRoleContext(QueryRolePO queryRolePO);

    List<RoleVO> roleList2RoleVOList(List<TMusicRole> roleList);

    @Mapping(target = "menuIds", ignore = true)
    @Mapping(target = "roleId", expression = "java(com.tangl.music.core.utils.IdUtil.decrypt(assignPermissionsPO.getRoleId()))")
    AssignPermissionsContext assignPermissionsPO2AssignPermissionsContext(AssignPermissionsPO assignPermissionsPO);
}
