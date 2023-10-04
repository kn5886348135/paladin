package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.ProductAttribute;
import com.paladin.account.service.IProductAttributeService;
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
 * 商品属性参数表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/product/attribute")
public class ProductAttributeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductAttributeController.class);

	private IProductAttributeService productAttributeService;

	public ProductAttributeController(IProductAttributeService productAttributeService) {
		this.productAttributeService = productAttributeService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加产品属性", notes = "添加产品属性")
	public void addProductAttribute(@RequestBody ProductAttribute productAttribute) {
		productAttributeService.save(productAttribute);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody ProductAttribute productAttribute) {
		productAttributeService.removeById(productAttribute.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody ProductAttribute productAttribute) {
		productAttributeService.updateById(productAttribute);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductAttribute findAccount(@RequestBody ProductAttribute productAttribute) {
		return productAttributeService.getById(productAttribute);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询产品属性", notes = "批量查询产品属性", responseContainer = "List", response = ProductAttribute.class)
	public List<ProductAttribute> findAccountList(@RequestBody ProductAttribute productAttribute) {
		return productAttributeService.list(new QueryWrapper<>(productAttribute));
	}
}
