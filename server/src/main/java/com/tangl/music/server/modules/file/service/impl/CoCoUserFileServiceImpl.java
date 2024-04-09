package com.tangl.music.server.modules.file.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangl.music.server.modules.file.entity.CoCoUserFile;
import com.tangl.music.server.modules.file.service.CoCoUserFileService;
import com.tangl.music.server.modules.file.mapper.CoCoUserFileMapper;
import org.springframework.stereotype.Service;

/**
 * 用户文件业务层
 */
@Service
public class CoCoUserFileServiceImpl extends ServiceImpl<CoCoUserFileMapper, CoCoUserFile> implements CoCoUserFileService {

}
