package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.SkuStock;
import com.paladin.account.service.ISkuStockService;
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
 * sku的库存 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/sku/stock")
public class SkuStockController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SkuStockController.class);

	private ISkuStockService skuStockService;

	public SkuStockController(ISkuStockService skuStockService) {
		this.skuStockService = skuStockService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加sku库存", notes = "添加sku库存")
	public void addSkuStock(@RequestBody SkuStock skuStock) {
		skuStockService.save(skuStock);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody SkuStock skuStock) {
		skuStockService.removeById(skuStock.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody SkuStock skuStock) {
		skuStockService.updateById(skuStock);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SkuStock findAccount(@RequestBody SkuStock skuStock) {
		return skuStockService.getById(skuStock);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询sku库存", notes = "批量查询sku库存", responseContainer = "List", response = SkuStock.class)
	public List<SkuStock> findAccountList(@RequestBody SkuStock skuStock) {
		return skuStockService.list(new QueryWrapper<>(skuStock));
	}
}
