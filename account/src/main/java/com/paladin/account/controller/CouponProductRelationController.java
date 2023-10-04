package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.CouponProductRelation;
import com.paladin.account.service.ICouponProductRelationService;
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
 * 优惠券和产品的关系表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/coupon/product/relation")
public class CouponProductRelationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CouponProductRelationController.class);

	private ICouponProductRelationService couponProductRelationService;

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加优惠券产品关系", notes = "添加优惠券产品关系")
	public void addCarItem(@RequestBody CouponProductRelation couponProductRelation) {
		couponProductRelationService.save(couponProductRelation);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody CouponProductRelation couponProductRelation) {
		couponProductRelationService.removeById(couponProductRelation.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody CouponProductRelation couponProductRelation) {
		couponProductRelationService.updateById(couponProductRelation);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CouponProductRelation findAccount(@RequestBody CouponProductRelation couponProductRelation) {
		return couponProductRelationService.getById(couponProductRelation);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询优惠券产品关系", notes = "批量查询优惠券产品关系", responseContainer = "List", response = CouponProductRelation.class)
	public List<CouponProductRelation> findAccountList(@RequestBody CouponProductRelation couponProductRelation) {
		return couponProductRelationService.list(new QueryWrapper<>(couponProductRelation));
	}

}
