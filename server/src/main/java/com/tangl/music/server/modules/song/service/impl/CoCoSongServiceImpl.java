package com.tangl.music.server.modules.song.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangl.music.server.modules.song.entity.CoCoSong;
import com.tangl.music.server.modules.song.service.CoCoSongService;
import com.tangl.music.server.modules.song.mapper.CoCoSongMapper;
import org.springframework.stereotype.Service;

/**
 * 歌曲业务层
 */
@Service
public class CoCoSongServiceImpl extends ServiceImpl<CoCoSongMapper, CoCoSong> implements CoCoSongService {

}
