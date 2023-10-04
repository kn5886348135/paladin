package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.PayWxRefund;
import com.paladin.account.service.IPayWxRefundService;
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
 * 微信支付退款记录表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/pay/wx/refund")
public class PayWxRefundController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PayWxRefundController.class);

	private IPayWxRefundService payWxRefundService;

	public PayWxRefundController(IPayWxRefundService payWxRefundService) {
		this.payWxRefundService = payWxRefundService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加微信退款记录", notes = "添加微信退款记录")
	public void addPayWxRefund(@RequestBody PayWxRefund payWxRefund) {
		payWxRefundService.save(payWxRefund);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody PayWxRefund payWxRefund) {
		payWxRefundService.removeById(payWxRefund.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody PayWxRefund payWxRefund) {
		payWxRefundService.updateById(payWxRefund);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PayWxRefund findAccount(@RequestBody PayWxRefund payWxRefund) {
		return payWxRefundService.getById(payWxRefund);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询微信退款记录", notes = "批量查询微信退款记录", responseContainer = "List", response = PayWxRefund.class)
	public List<PayWxRefund> findAccountList(@RequestBody PayWxRefund payWxRefund) {
		return payWxRefundService.list(new QueryWrapper<>(payWxRefund));
	}
}
