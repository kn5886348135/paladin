package com.paladin.account.service.impl;

import com.paladin.account.entity.Help;
import com.paladin.account.mapper.HelpMapper;
import com.paladin.account.service.IHelpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 帮助表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class HelpServiceImpl extends ServiceImpl<HelpMapper, Help> implements IHelpService {

}
