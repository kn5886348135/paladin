package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.Merchant;
import com.paladin.account.service.IMerchantService;
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
 * 商家信息表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-09-25
 */
@RestController
@RequestMapping("/merchant")
public class MerchantController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MerchantController.class);

	private IMerchantService merchantService;

	public MerchantController(IMerchantService merchantService) {
		this.merchantService = merchantService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加商家", notes = "添加商家")
	public void registerMerchant(@RequestBody Merchant merchant) {
		merchantService.save(merchant);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody Merchant merchant) {
		merchantService.removeById(merchant.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody Merchant merchant) {
		merchantService.updateById(merchant);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Merchant findAccount(@RequestBody Merchant merchant) {
		return merchantService.getById(merchant);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询商家", notes = "批量查询商家", responseContainer = "List", response = Merchant.class)
	public List<Merchant> findAccountList(@RequestBody Merchant merchant) {
		return merchantService.list(new QueryWrapper<>(merchant));
	}
}
