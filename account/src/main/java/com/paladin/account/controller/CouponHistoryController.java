package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.CouponHistory;
import com.paladin.account.service.ICouponHistoryService;
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
 * 优惠券使用、领取历史表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/coupon/history")
public class CouponHistoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CouponHistoryController.class);

	private ICouponHistoryService couponHistoryService;

	public CouponHistoryController(ICouponHistoryService couponHistoryService) {
		this.couponHistoryService = couponHistoryService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加优惠券历史", notes = "添加优惠券历史")
	public void addCarItem(@RequestBody CouponHistory couponHistory) {
		couponHistoryService.save(couponHistory);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody CouponHistory couponHistory) {
		couponHistoryService.removeById(couponHistory.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody CouponHistory couponHistory) {
		couponHistoryService.updateById(couponHistory);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CouponHistory findAccount(@RequestBody CouponHistory couponHistory) {
		return couponHistoryService.getById(couponHistory);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询优惠券历史", notes = "批量查询优惠券历史", responseContainer = "List", response = CouponHistory.class)
	public List<CouponHistory> findAccountList(@RequestBody CouponHistory couponHistory) {
		return couponHistoryService.list(new QueryWrapper<>(couponHistory));
	}

}
