package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.ProductAttributeCategory;
import com.paladin.account.service.IProductAttributeCategoryService;
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
 * 产品属性分类表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/product/attribute/category")
public class ProductAttributeCategoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductAttributeCategoryController.class);

	private IProductAttributeCategoryService productAttributeCategoryService;

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加产品属性分类", notes = "添加产品属性分类")
	public void addProductAttributeCategory(@RequestBody ProductAttributeCategory productAttributeCategory) {
		productAttributeCategoryService.save(productAttributeCategory);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody ProductAttributeCategory productAttributeCategory) {
		productAttributeCategoryService.removeById(productAttributeCategory.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody ProductAttributeCategory productAttributeCategory) {
		productAttributeCategoryService.updateById(productAttributeCategory);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductAttributeCategory findAccount(@RequestBody ProductAttributeCategory productAttributeCategory) {
		return productAttributeCategoryService.getById(productAttributeCategory);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询产品属性分类", notes = "批量查询产品属性分类", responseContainer = "List", response = ProductAttributeCategory.class)
	public List<ProductAttributeCategory> findAccountList(@RequestBody ProductAttributeCategory productAttributeCategory) {
		return productAttributeCategoryService.list(new QueryWrapper<>(productAttributeCategory));
	}
}
