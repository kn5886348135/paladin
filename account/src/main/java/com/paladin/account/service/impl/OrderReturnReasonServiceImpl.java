package com.paladin.account.service.impl;

import com.paladin.account.entity.OrderReturnReason;
import com.paladin.account.mapper.OrderReturnReasonMapper;
import com.paladin.account.service.IOrderReturnReasonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 退货原因表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class OrderReturnReasonServiceImpl extends ServiceImpl<OrderReturnReasonMapper, OrderReturnReason> implements IOrderReturnReasonService {

}
