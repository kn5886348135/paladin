package com.paladin.account.service.impl;

import com.paladin.account.entity.CompanyAddress;
import com.paladin.account.mapper.CompanyAddressMapper;
import com.paladin.account.service.ICompanyAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公司收发货地址表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-12
 */
@Service
public class CompanyAddressServiceImpl extends ServiceImpl<CompanyAddressMapper, CompanyAddress> implements ICompanyAddressService {

}
