package com.tangl.music.server.modules.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangl.music.server.modules.user.entity.CoCoUser;
import com.tangl.music.server.modules.user.service.CoCoUserService;
import com.tangl.music.server.modules.user.mapper.CoCoUserMapper;
import org.springframework.stereotype.Service;

/**
 * 用户业务层
 */
@Service
public class CoCoUserServiceImpl extends ServiceImpl<CoCoUserMapper, CoCoUser> implements CoCoUserService {

}
