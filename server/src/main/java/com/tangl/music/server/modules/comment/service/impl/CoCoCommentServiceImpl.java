package com.tangl.music.server.modules.comment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangl.music.server.modules.comment.entity.CoCoComment;
import com.tangl.music.server.modules.comment.service.CoCoCommentService;
import com.tangl.music.server.modules.comment.mapper.CoCoCommentMapper;
import org.springframework.stereotype.Service;

/**
 * 评论业务层
 */
@Service
public class CoCoCommentServiceImpl extends ServiceImpl<CoCoCommentMapper, CoCoComment> implements CoCoCommentService {

}




