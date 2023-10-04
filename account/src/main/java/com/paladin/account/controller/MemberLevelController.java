package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.MemberLevel;
import com.paladin.account.service.IMemberLevelService;
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
 * 会员等级表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/member/level")
public class MemberLevelController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberLevelController.class);

	private IMemberLevelService memberLevelService;

	public MemberLevelController(IMemberLevelService memberLevelService) {
		this.memberLevelService = memberLevelService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加会员等级", notes = "添加会员等级")
	public void addCarItem(@RequestBody MemberLevel memberLevel) {
		memberLevelService.save(memberLevel);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody MemberLevel memberLevel) {
		memberLevelService.removeById(memberLevel.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody MemberLevel memberLevel) {
		memberLevelService.updateById(memberLevel);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public MemberLevel findAccount(@RequestBody MemberLevel memberLevel) {
		return memberLevelService.getById(memberLevel);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询会员等级", notes = "批量查询会员等级", responseContainer = "List")
	public List<MemberLevel> findAccountList(@RequestBody MemberLevel memberLevel) {
		return memberLevelService.list(new QueryWrapper<>(memberLevel));
	}
}
