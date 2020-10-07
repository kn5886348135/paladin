package com.paladin.account.service.impl;

import com.paladin.account.entity.OrderOperateHistory;
import com.paladin.account.mapper.OrderOperateHistoryMapper;
import com.paladin.account.service.IOrderOperateHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单操作历史记录 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class OrderOperateHistoryServiceImpl extends ServiceImpl<OrderOperateHistoryMapper, OrderOperateHistory> implements IOrderOperateHistoryService {

}
