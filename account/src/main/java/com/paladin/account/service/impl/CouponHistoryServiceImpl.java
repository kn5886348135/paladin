package com.paladin.account.service.impl;

import com.paladin.account.entity.CouponHistory;
import com.paladin.account.mapper.CouponHistoryMapper;
import com.paladin.account.service.ICouponHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券使用、领取历史表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class CouponHistoryServiceImpl extends ServiceImpl<CouponHistoryMapper, CouponHistory> implements ICouponHistoryService {

}
