package com.paladin.account.service.impl;

import com.paladin.account.entity.TopicComment;
import com.paladin.account.mapper.TopicCommentMapper;
import com.paladin.account.service.ITopicCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 专题评论表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class TopicCommentServiceImpl extends ServiceImpl<TopicCommentMapper, TopicComment> implements ITopicCommentService {

}
