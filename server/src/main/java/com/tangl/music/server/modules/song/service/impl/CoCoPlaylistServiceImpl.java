package com.tangl.music.server.modules.song.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangl.music.server.modules.song.entity.CoCoPlaylist;
import com.tangl.music.server.modules.song.service.CoCoPlaylistService;
import com.tangl.music.server.modules.song.mapper.CoCoPlaylistMapper;
import org.springframework.stereotype.Service;

/**
 * 播放列表业务层
 */
@Service
public class CoCoPlaylistServiceImpl extends ServiceImpl<CoCoPlaylistMapper, CoCoPlaylist> implements CoCoPlaylistService {

}
