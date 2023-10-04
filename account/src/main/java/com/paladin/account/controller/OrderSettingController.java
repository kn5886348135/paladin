package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.OrderSetting;
import com.paladin.account.service.IOrderSettingService;
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
 * 订单设置表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/order/setting")
public class OrderSettingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderSettingController.class);

	private IOrderSettingService orderSettingService;

	public OrderSettingController(IOrderSettingService orderSettingService) {
		this.orderSettingService = orderSettingService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加订单设置", notes = "添加订单设置")
	public void addOrderSetting(@RequestBody OrderSetting orderSetting) {
		orderSettingService.save(orderSetting);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody OrderSetting orderSetting) {
		orderSettingService.removeById(orderSetting.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody OrderSetting orderSetting) {
		orderSettingService.updateById(orderSetting);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OrderSetting findAccount(@RequestBody OrderSetting orderSetting) {
		return orderSettingService.getById(orderSetting);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询订单设置", notes = "批量查询订单设置", responseContainer = "List", response = OrderSetting.class)
	public List<OrderSetting> findAccountList(@RequestBody OrderSetting orderSetting) {
		return orderSettingService.list(new QueryWrapper<>(orderSetting));
	}
}
