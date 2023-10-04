package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.OrderReturnApply;
import com.paladin.account.service.IOrderReturnApplyService;
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
 * 订单退货申请 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/order/return/apply")
public class OrderReturnApplyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderReturnApplyController.class);

	private IOrderReturnApplyService orderReturnApplyService;

	public OrderReturnApplyController(IOrderReturnApplyService orderReturnApplyService) {
		this.orderReturnApplyService = orderReturnApplyService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加订单退货申请", notes = "添加订单退货申请")
	public void addOrderReturnApply(@RequestBody OrderReturnApply orderReturnApply) {
		orderReturnApplyService.save(orderReturnApply);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody OrderReturnApply orderReturnApply) {
		orderReturnApplyService.removeById(orderReturnApply.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody OrderReturnApply orderReturnApply) {
		orderReturnApplyService.updateById(orderReturnApply);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OrderReturnApply findAccount(@RequestBody OrderReturnApply orderReturnApply) {
		return orderReturnApplyService.getById(orderReturnApply);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询订单退货申请", notes = "批量查询订单退货申请", responseContainer = "List", response = OrderReturnApply.class)
	public List<OrderReturnApply> findAccountList(@RequestBody OrderReturnApply orderReturnApply) {
		return orderReturnApplyService.list(new QueryWrapper<>(orderReturnApply));
	}
}
