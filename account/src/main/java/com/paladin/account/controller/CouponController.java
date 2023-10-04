package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.Coupon;
import com.paladin.account.service.ICouponService;
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
 * 优惠卷表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/coupon")
public class CouponController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CouponController.class);

	private ICouponService couponService;

	public CouponController(ICouponService couponService) {
		this.couponService = couponService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加优惠券", notes = "添加优惠券")
	public void addCarItem(@RequestBody Coupon coupon) {
		couponService.save(coupon);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody Coupon coupon) {
		couponService.removeById(coupon.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody Coupon coupon) {
		couponService.updateById(coupon);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Coupon findAccount(@RequestBody Coupon coupon) {
		return couponService.getById(coupon);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询优惠券", notes = "批量查询优惠券", responseContainer = "List", response = void.class)
	public List<Coupon> findAccountList(@RequestBody Coupon coupon) {
		return couponService.list(new QueryWrapper<>(coupon));
	}

}
