package com.paladin.account.service.impl;

import com.paladin.account.entity.OrderItem;
import com.paladin.account.mapper.OrderItemMapper;
import com.paladin.account.service.IOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单中所包含的商品 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-09-25
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {

}
