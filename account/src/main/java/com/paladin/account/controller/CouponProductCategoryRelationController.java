package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.CouponProductCategoryRelation;
import com.paladin.account.service.ICouponProductCategoryRelationService;
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
 * 优惠券和产品分类关系表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/coupon/product/category/relation")
public class CouponProductCategoryRelationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CouponProductCategoryRelationController.class);

	private ICouponProductCategoryRelationService couponProductCategoryRelationService;

	public CouponProductCategoryRelationController(ICouponProductCategoryRelationService couponProductCategoryRelationService) {
		this.couponProductCategoryRelationService = couponProductCategoryRelationService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam()})
	@ApiOperation(value = "添加优惠券产品分类关系", notes = "添加优惠券产品分类关系")
	public void addCarItem(@RequestBody CouponProductCategoryRelation couponProductCategoryRelation) {
		couponProductCategoryRelationService.save(couponProductCategoryRelation);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody CouponProductCategoryRelation couponProductCategoryRelation) {
		couponProductCategoryRelationService.removeById(couponProductCategoryRelation.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody CouponProductCategoryRelation couponProductCategoryRelation) {
		couponProductCategoryRelationService.updateById(couponProductCategoryRelation);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CouponProductCategoryRelation findAccount(@RequestBody CouponProductCategoryRelation couponProductCategoryRelation) {
		return couponProductCategoryRelationService.getById(couponProductCategoryRelation);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询优惠券产品分类关系", notes = "批量查询优惠券产品分类关系", responseContainer = "List", response = CouponProductCategoryRelation.class)
	public List<CouponProductCategoryRelation> findAccountList(@RequestBody CouponProductCategoryRelation couponProductCategoryRelation) {
		return couponProductCategoryRelationService.list(new QueryWrapper<>(couponProductCategoryRelation));
	}

}
