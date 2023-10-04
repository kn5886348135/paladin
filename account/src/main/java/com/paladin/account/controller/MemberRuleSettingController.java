package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.MemberRuleSetting;
import com.paladin.account.service.IMemberRuleSettingService;
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
 * 会员积分成长规则表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/member/rule/setting")
public class MemberRuleSettingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberRuleSettingController.class);

	private IMemberRuleSettingService memberRuleSettingService;

	public MemberRuleSettingController(IMemberRuleSettingService memberRuleSettingService) {
		this.memberRuleSettingService = memberRuleSettingService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加会员规则设置", notes = "添加会员规则设置")
	public void addCarItem(@RequestBody MemberRuleSetting memberRuleSetting) {
		memberRuleSettingService.save(memberRuleSetting);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody MemberRuleSetting memberRuleSetting) {
		memberRuleSettingService.removeById(memberRuleSetting.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody MemberRuleSetting memberRuleSetting) {
		memberRuleSettingService.updateById(memberRuleSetting);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public MemberRuleSetting findAccount(@RequestBody MemberRuleSetting memberRuleSetting) {
		return memberRuleSettingService.getById(memberRuleSetting);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询会员规则设置", notes = "批量查询会员规则设置", responseContainer = "List", response = MemberRuleSetting.class)
	public List<MemberRuleSetting> findAccountList(@RequestBody MemberRuleSetting memberRuleSetting) {
		return memberRuleSettingService.list(new QueryWrapper<>(memberRuleSetting));
	}
}
