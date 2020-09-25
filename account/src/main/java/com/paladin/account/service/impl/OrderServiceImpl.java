package com.paladin.account.service.impl;

import com.paladin.account.entity.Order;
import com.paladin.account.mapper.OrderMapper;
import com.paladin.account.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-09-25
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
