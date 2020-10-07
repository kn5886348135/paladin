package com.paladin.account.service.impl;

import com.paladin.account.entity.Comment;
import com.paladin.account.mapper.CommentMapper;
import com.paladin.account.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评价表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
