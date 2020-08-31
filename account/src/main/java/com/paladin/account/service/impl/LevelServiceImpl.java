package com.paladin.account.service.impl;

import com.paladin.account.entity.Level;
import com.paladin.account.mapper.LevelMapper;
import com.paladin.account.service.ILevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员等级表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
@Service
public class LevelServiceImpl extends ServiceImpl<LevelMapper, Level> implements ILevelService {

}
