package com.paladin.account.service.impl;

import com.paladin.account.entity.PayWxRefund;
import com.paladin.account.mapper.PayWxRefundMapper;
import com.paladin.account.service.IPayWxRefundService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信支付退款记录表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class PayWxRefundServiceImpl extends ServiceImpl<PayWxRefundMapper, PayWxRefund> implements IPayWxRefundService {

}
