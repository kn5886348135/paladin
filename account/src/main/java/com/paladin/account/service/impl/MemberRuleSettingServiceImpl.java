package com.paladin.account.service.impl;

import com.paladin.account.entity.MemberRuleSetting;
import com.paladin.account.mapper.MemberRuleSettingMapper;
import com.paladin.account.service.IMemberRuleSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员积分成长规则表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class MemberRuleSettingServiceImpl extends ServiceImpl<MemberRuleSettingMapper, MemberRuleSetting> implements IMemberRuleSettingService {

}
