package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.OrderOperateHistory;
import com.paladin.account.service.IOrderOperateHistoryService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 订单操作历史记录 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/order-operate-history")
public class OrderOperateHistoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderOperateHistoryController.class);

	private IOrderOperateHistoryService orderOperateHistoryService;

	public OrderOperateHistoryController(IOrderOperateHistoryService orderOperateHistoryService) {
		this.orderOperateHistoryService = orderOperateHistoryService;
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody OrderOperateHistory orderOperateHistory) {
		orderOperateHistoryService.removeById(orderOperateHistory.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody OrderOperateHistory orderOperateHistory) {
		orderOperateHistoryService.updateById(orderOperateHistory);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OrderOperateHistory findAccount(@RequestBody OrderOperateHistory orderOperateHistory) {
		return orderOperateHistoryService.getById(orderOperateHistory);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询订单操作历史记录", notes = "批量查询订单操作历史记录", responseContainer = "List", response = OrderOperateHistory.class)
	public List<OrderOperateHistory> findAccountList(@RequestBody OrderOperateHistory orderOperateHistory) {
		return orderOperateHistoryService.list(new QueryWrapper<>(orderOperateHistory));
	}
}
