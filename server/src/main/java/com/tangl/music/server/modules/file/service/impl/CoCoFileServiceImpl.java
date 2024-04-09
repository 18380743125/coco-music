package com.tangl.music.server.modules.file.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangl.music.server.modules.file.entity.CoCoFile;
import com.tangl.music.server.modules.file.service.CoCoFileService;
import com.tangl.music.server.modules.file.mapper.CoCoFileMapper;
import org.springframework.stereotype.Service;

/**
 * 文件业务层
 */
@Service
public class CoCoFileServiceImpl extends ServiceImpl<CoCoFileMapper, CoCoFile> implements CoCoFileService {

}
