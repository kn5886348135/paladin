package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.ProductAttributeValue;
import com.paladin.account.service.IProductAttributeValueService;
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
 * 存储产品参数信息的表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/product/attribute/value")
public class ProductAttributeValueController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductAttributeValueController.class);

	private IProductAttributeValueService productAttributeValueService;

	public ProductAttributeValueController(IProductAttributeValueService productAttributeValueService) {
		this.productAttributeValueService = productAttributeValueService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加产品属性值", notes = "添加产品属性值")
	public void addProductAttributeValue(@RequestBody ProductAttributeValue productAttributeValue) {
		productAttributeValueService.save(productAttributeValue);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody ProductAttributeValue productAttributeValue) {
		productAttributeValueService.removeById(productAttributeValue.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody ProductAttributeValue productAttributeValue) {
		productAttributeValueService.updateById(productAttributeValue);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductAttributeValue findAccount(@RequestBody ProductAttributeValue productAttributeValue) {
		return productAttributeValueService.getById(productAttributeValue);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询产品属性值", notes = "批量查询产品属性值", responseContainer = "List", response = ProductAttributeValue.class)
	public List<ProductAttributeValue> findAccountList(@RequestBody ProductAttributeValue productAttributeValue) {
		return productAttributeValueService.list(new QueryWrapper<>(productAttributeValue));
	}
}
