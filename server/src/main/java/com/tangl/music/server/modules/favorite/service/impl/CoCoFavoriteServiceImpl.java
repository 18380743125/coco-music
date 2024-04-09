package com.tangl.music.server.modules.favorite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangl.music.server.modules.favorite.entity.CoCoFavorite;
import com.tangl.music.server.modules.favorite.service.CoCoFavoriteService;
import com.tangl.music.server.modules.favorite.mapper.CoCoFavoriteMapper;
import org.springframework.stereotype.Service;

/**
 * 收藏业务层
 */
@Service
public class CoCoFavoriteServiceImpl extends ServiceImpl<CoCoFavoriteMapper, CoCoFavorite> implements CoCoFavoriteService {

}
