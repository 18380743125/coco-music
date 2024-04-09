package com.tangl.music.server.modules.lyric.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangl.music.server.modules.lyric.entity.CoCoLyric;
import com.tangl.music.server.modules.lyric.service.CoCoLyricService;
import com.tangl.music.server.modules.lyric.mapper.CoCoLyricMapper;
import org.springframework.stereotype.Service;

/**
 * 歌词业务层
 */
@Service
public class CoCoLyricServiceImpl extends ServiceImpl<CoCoLyricMapper, CoCoLyric> implements CoCoLyricService {

}
