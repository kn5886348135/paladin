package com.paladin.account.service.impl;

import com.paladin.account.entity.TopicCategory;
import com.paladin.account.mapper.TopicCategoryMapper;
import com.paladin.account.service.ITopicCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 话题分类表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class TopicCategoryServiceImpl extends ServiceImpl<TopicCategoryMapper, TopicCategory> implements ITopicCategoryService {

}
