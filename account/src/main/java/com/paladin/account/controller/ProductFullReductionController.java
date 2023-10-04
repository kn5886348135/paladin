package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.ProductFullReduction;
import com.paladin.account.service.IProductFullReductionService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.asm.Advice;
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
 * 产品满减表(只针对同商品) 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/product/full/reduction")
public class ProductFullReductionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductFullReductionController.class);

	private IProductFullReductionService productFullReductionService;

	public ProductFullReductionController(IProductFullReductionService productFullReductionService) {
		this.productFullReductionService = productFullReductionService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加产品满减", notes = "添加产品满减")
	public void addProductFullReduction(@RequestBody ProductFullReduction productFullReduction) {
		productFullReductionService.save(productFullReduction);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody ProductFullReduction productFullReduction) {
		productFullReductionService.removeById(productFullReduction.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody ProductFullReduction productFullReduction) {
		productFullReductionService.updateById(productFullReduction);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductFullReduction findAccount(@RequestBody ProductFullReduction productFullReduction) {
		return productFullReductionService.getById(productFullReduction);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询产品满减", notes = "批量查询产品满减", responseContainer = "List", response = ProductFullReduction.class)
	public List<ProductFullReduction> findAccountList(@RequestBody ProductFullReduction productFullReduction) {
		return productFullReductionService.list(new QueryWrapper<>(productFullReduction));
	}
}
