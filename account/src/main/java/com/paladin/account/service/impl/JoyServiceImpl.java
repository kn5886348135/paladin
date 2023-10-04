package com.paladin.account.service.impl;

import com.paladin.account.entity.Joy;
import com.paladin.account.mapper.JoyMapper;
import com.paladin.account.service.IJoyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 秒杀商品 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2022-04-25
 */
@Service
public class JoyServiceImpl extends ServiceImpl<JoyMapper, Joy> implements IJoyService {

}
