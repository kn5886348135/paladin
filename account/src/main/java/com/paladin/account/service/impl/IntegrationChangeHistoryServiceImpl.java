package com.paladin.account.service.impl;

import com.paladin.account.entity.IntegrationChangeHistory;
import com.paladin.account.mapper.IntegrationChangeHistoryMapper;
import com.paladin.account.service.IIntegrationChangeHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 积分变化历史记录表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class IntegrationChangeHistoryServiceImpl extends ServiceImpl<IntegrationChangeHistoryMapper, IntegrationChangeHistory> implements IIntegrationChangeHistoryService {

}
