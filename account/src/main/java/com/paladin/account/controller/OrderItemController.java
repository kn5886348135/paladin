package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.OrderItem;
import com.paladin.account.service.IOrderItemService;
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
 * 订单明细中所包含的商品 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-09-25
 */
@RestController
@RequestMapping("/order/item")
public class OrderItemController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderItemController.class);

	private IOrderItemService orderItemService;

	public OrderItemController(IOrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加订单明细", notes = "添加订单明细")
	public void generateOrderItem(@RequestBody OrderItem orderItem) {
		orderItemService.save(orderItem);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody OrderItem orderItem) {
		orderItemService.removeById(orderItem.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody OrderItem orderItem) {
		orderItemService.updateById(orderItem);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OrderItem findAccount(@RequestBody OrderItem orderItem) {
		return orderItemService.getById(orderItem);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询订单明细", notes = "批量查询订单明细", responseContainer = "List", response = OrderItem.class)
	public List<OrderItem> findAccountList(@RequestBody OrderItem orderItem) {
		return orderItemService.list(new QueryWrapper<>(orderItem));
	}
}
