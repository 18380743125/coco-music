package com.tangl.music.server.modules.file.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangl.music.server.modules.file.entity.CoCoFileChunk;
import com.tangl.music.server.modules.file.service.CoCoFileChunkService;
import com.tangl.music.server.modules.file.mapper.CoCoFileChunkMapper;
import org.springframework.stereotype.Service;

/**
 * 文件分片业务层
 */
@Service
public class CoCoFileChunkServiceImpl extends ServiceImpl<CoCoFileChunkMapper, CoCoFileChunk> implements CoCoFileChunkService {

}
