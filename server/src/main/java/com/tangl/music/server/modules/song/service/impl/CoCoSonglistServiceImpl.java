package com.tangl.music.server.modules.song.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangl.music.server.modules.song.entity.CoCoSonglist;
import com.tangl.music.server.modules.song.service.CoCoSonglistService;
import com.tangl.music.server.modules.song.mapper.CoCoSonglistMapper;
import org.springframework.stereotype.Service;

/**
 * 歌单业务层
 */
@Service
public class CoCoSonglistServiceImpl extends ServiceImpl<CoCoSonglistMapper, CoCoSonglist> implements CoCoSonglistService {

}
