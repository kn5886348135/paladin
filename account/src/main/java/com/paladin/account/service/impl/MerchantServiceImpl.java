package com.paladin.account.service.impl;

import com.paladin.account.entity.Merchant;
import com.paladin.account.mapper.MerchantMapper;
import com.paladin.account.service.IMerchantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商家信息表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-09-25
 */
@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant> implements IMerchantService {

}
