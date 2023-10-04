package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.PayAli;
import com.paladin.account.service.IPayAliService;
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
@RequestMapping("/pay/ali")
public class PayAliController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PayAliController.class);

	private IPayAliService payAliService;

	public PayAliController(IPayAliService payAliService) {
		this.payAliService = payAliService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加支付宝支付记录", notes = "添加支付宝支付记录")
	public void addPayAli(@RequestBody PayAli payAli) {
		payAliService.save(payAli);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody PayAli payAli) {
		payAliService.removeById(payAli.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody PayAli payAli) {
		payAliService.updateById(payAli);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PayAli findAccount(@RequestBody PayAli payAli) {
		return payAliService.getById(payAli);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询支付宝支付记录", notes = "批量查询支付宝支付记录", responseContainer = "List", response = PayAli.class)
	public List<PayAli> findAccountList(@RequestBody PayAli payAli) {
		return payAliService.list(new QueryWrapper<>(payAli));
	}
}
