package com.paladin.account.service.impl;

import com.paladin.account.entity.OrderSetting;
import com.paladin.account.mapper.OrderSettingMapper;
import com.paladin.account.service.IOrderSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单设置表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OrderSetting> implements IOrderSettingService {

}
