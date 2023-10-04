package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.PayWx;
import com.paladin.account.service.IPayWxService;
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
 * 微信支付记录表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/pay/wx")
public class PayWxController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PayWxController.class);

	private IPayWxService payWxService;

	public PayWxController(IPayWxService payWxService) {
		this.payWxService = payWxService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加微信支付记录", notes = "添加微信支付记录")
	public void addPayWx(@RequestBody PayWx payWx) {
		payWxService.save(payWx);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody PayWx payWx) {
		payWxService.removeById(payWx.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody PayWx payWx) {
		payWxService.updateById(payWx);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PayWx findAccount(@RequestBody PayWx payWx) {
		return payWxService.getById(payWx);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询微信支付记录", notes = "批量查询微信支付记录", responseContainer = "List", response = PayWx.class)
	public List<PayWx> findAccountList(@RequestBody PayWx payWx) {
		return payWxService.list(new QueryWrapper<>(payWx));
	}
}
