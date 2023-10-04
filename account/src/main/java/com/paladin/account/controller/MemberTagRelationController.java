package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.MemberTagRelation;
import com.paladin.account.service.IMemberTagRelationService;
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
 * 用户和标签关系表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/member/tag/relation")
public class MemberTagRelationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberTagRelationController.class);

	private IMemberTagRelationService memberTagRelationService;

	public MemberTagRelationController(IMemberTagRelationService memberTagRelationService) {
		this.memberTagRelationService = memberTagRelationService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加会员标签关系", notes = "添加会员标签关系")
	public void addCarItem(@RequestBody MemberTagRelation memberTagRelation) {
		memberTagRelationService.save(memberTagRelation);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody MemberTagRelation memberTagRelation) {
		memberTagRelationService.removeById(memberTagRelation.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody MemberTagRelation memberTagRelation) {
		memberTagRelationService.updateById(memberTagRelation);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public MemberTagRelation findAccount(@RequestBody MemberTagRelation memberTagRelation) {
		return memberTagRelationService.getById(memberTagRelation);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询会员标签关系", notes = "批量查询会员标签关系", responseContainer = "List", response = MemberTagRelation.class)
	public List<MemberTagRelation> findAccountList(@RequestBody MemberTagRelation memberTagRelation) {
		return memberTagRelationService.list(new QueryWrapper<>(memberTagRelation));
	}
}
