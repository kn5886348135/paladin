package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.MemberTag;
import com.paladin.account.service.IMemberTagService;
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
 * 用户标签表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/member/tag")
public class MemberTagController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberTagController.class);

	private IMemberTagService memberTagService;

	public MemberTagController(IMemberTagService memberTagService) {
		this.memberTagService = memberTagService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加会员标签", notes = "添加会员标签")
	public void addCarItem(@RequestBody MemberTag memberTag) {
		memberTagService.save(memberTag);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody MemberTag memberTag) {
		memberTagService.removeById(memberTag.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody MemberTag memberTag) {
		memberTagService.updateById(memberTag);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public MemberTag findAccount(@RequestBody MemberTag memberTag) {
		return memberTagService.getById(memberTag);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询会员标签", notes = "批量查询会员标签", responseContainer = "List", response = MemberTag.class)
	public List<MemberTag> findAccountList(@RequestBody MemberTag memberTag) {
		return memberTagService.list(new QueryWrapper<>(memberTag));
	}
}
