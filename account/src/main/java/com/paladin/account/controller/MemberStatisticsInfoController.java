package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.MemberStatisticsInfo;
import com.paladin.account.service.IMemberStatisticsInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 会员统计信息 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/member/statistics/info")
public class MemberStatisticsInfoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberStatisticsInfoController.class);

	private IMemberStatisticsInfoService memberStatisticsInfoService;

	public MemberStatisticsInfoController(IMemberStatisticsInfoService memberStatisticsInfoService) {
		this.memberStatisticsInfoService = memberStatisticsInfoService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加会员统计信息", notes = "添加会员统计信息")
	public void addCarItem(@RequestBody MemberStatisticsInfo memberStatisticsInfo) {
		memberStatisticsInfoService.save(memberStatisticsInfo);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody MemberStatisticsInfo memberStatisticsInfo) {
		memberStatisticsInfoService.removeById(memberStatisticsInfo.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody MemberStatisticsInfo memberStatisticsInfo) {
		memberStatisticsInfoService.updateById(memberStatisticsInfo);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public MemberStatisticsInfo findAccount(@RequestBody MemberStatisticsInfo memberStatisticsInfo) {
		return memberStatisticsInfoService.getById(memberStatisticsInfo);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询会员统计信息", notes = "批量查询会员统计信息", responseContainer = "List", response = MemberStatisticsInfo.class)
	public List<MemberStatisticsInfo> findAccountList(@RequestBody MemberStatisticsInfo memberStatisticsInfo) {
		return memberStatisticsInfoService.list(new QueryWrapper<>(memberStatisticsInfo));
	}
}
