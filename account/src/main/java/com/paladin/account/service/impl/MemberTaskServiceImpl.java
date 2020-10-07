package com.paladin.account.service.impl;

import com.paladin.account.entity.MemberTask;
import com.paladin.account.mapper.MemberTaskMapper;
import com.paladin.account.service.IMemberTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员任务表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class MemberTaskServiceImpl extends ServiceImpl<MemberTaskMapper, MemberTask> implements IMemberTaskService {

}
