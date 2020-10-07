package com.paladin.account.service.impl;

import com.paladin.account.entity.PayWx;
import com.paladin.account.mapper.PayWxMapper;
import com.paladin.account.service.IPayWxService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信支付记录表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class PayWxServiceImpl extends ServiceImpl<PayWxMapper, PayWx> implements IPayWxService {

}
