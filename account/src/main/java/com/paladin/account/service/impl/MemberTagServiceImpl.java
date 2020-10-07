package com.paladin.account.service.impl;

import com.paladin.account.entity.MemberTag;
import com.paladin.account.mapper.MemberTagMapper;
import com.paladin.account.service.IMemberTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户标签表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class MemberTagServiceImpl extends ServiceImpl<MemberTagMapper, MemberTag> implements IMemberTagService {

}
