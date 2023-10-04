package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.MemberProductCategoryRelation;
import com.paladin.account.service.IMemberProductCategoryRelationService;
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
 * 会员与产品分类关系表（用户喜欢的分类） 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/member/product/category/relation")
public class MemberProductCategoryRelationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberProductCategoryRelationController.class);

	private IMemberProductCategoryRelationService memberProductCategoryRelationService;

	public MemberProductCategoryRelationController(IMemberProductCategoryRelationService memberProductCategoryRelationService) {
		this.memberProductCategoryRelationService = memberProductCategoryRelationService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加会员产品分类关系", notes = "添加会员产品分类关系")
	public void addCarItem(@RequestBody MemberProductCategoryRelation memberProductCategoryRelation) {
		memberProductCategoryRelationService.save(memberProductCategoryRelation);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody MemberProductCategoryRelation memberProductCategoryRelation) {
		memberProductCategoryRelationService.removeById(memberProductCategoryRelation.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody MemberProductCategoryRelation memberProductCategoryRelation) {
		memberProductCategoryRelationService.updateById(memberProductCategoryRelation);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public MemberProductCategoryRelation findAccount(@RequestBody MemberProductCategoryRelation memberProductCategoryRelation) {
		return memberProductCategoryRelationService.getById(memberProductCategoryRelation);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询会员产品分类关系", notes = "批量查询会员产品分类关系", responseContainer = "List", response = MemberProductCategoryRelation.class)
	public List<MemberProductCategoryRelation> findAccountList(@RequestBody MemberProductCategoryRelation memberProductCategoryRelation) {
		return memberProductCategoryRelationService.list(new QueryWrapper<>(memberProductCategoryRelation));
	}
}
