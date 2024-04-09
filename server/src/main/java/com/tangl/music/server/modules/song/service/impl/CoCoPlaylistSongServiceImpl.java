package com.tangl.music.server.modules.song.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangl.music.server.modules.song.entity.CoCoPlaylistSong;
import com.tangl.music.server.modules.song.service.CoCoPlaylistSongService;
import com.tangl.music.server.modules.song.mapper.CoCoPlaylistSongMapper;
import org.springframework.stereotype.Service;

/**
 * 播放列表与歌曲业务层
 */
@Service
public class CoCoPlaylistSongServiceImpl extends ServiceImpl<CoCoPlaylistSongMapper, CoCoPlaylistSong> implements CoCoPlaylistSongService {

}
