package com.paladin.account.service.impl;

import com.paladin.account.entity.MemberReport;
import com.paladin.account.mapper.MemberReportMapper;
import com.paladin.account.service.IMemberReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户举报表 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class MemberReportServiceImpl extends ServiceImpl<MemberReportMapper, MemberReport> implements IMemberReportService {

}
