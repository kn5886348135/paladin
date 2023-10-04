package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.ProductCategoryAttributeRelation;
import com.paladin.account.service.IProductCategoryAttributeRelationService;
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
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/product/category/attribute/relation")
public class ProductCategoryAttributeRelationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryAttributeRelationController.class);

	private IProductCategoryAttributeRelationService productCategoryAttributeRelationService;

	public ProductCategoryAttributeRelationController(IProductCategoryAttributeRelationService productCategoryAttributeRelationService) {
		this.productCategoryAttributeRelationService = productCategoryAttributeRelationService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加产品分类和属性的关系", notes = "添加产品分类和属性的关系")
	public void addProductCategoryAttributeRelation(@RequestBody ProductCategoryAttributeRelation productCategoryAttributeRelation) {
		productCategoryAttributeRelationService.save(productCategoryAttributeRelation);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody ProductCategoryAttributeRelation productCategoryAttributeRelation) {
		productCategoryAttributeRelationService.removeById(productCategoryAttributeRelation.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody ProductCategoryAttributeRelation productCategoryAttributeRelation) {
		productCategoryAttributeRelationService.updateById(productCategoryAttributeRelation);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductCategoryAttributeRelation findAccount(@RequestBody ProductCategoryAttributeRelation productCategoryAttributeRelation) {
		return productCategoryAttributeRelationService.getById(productCategoryAttributeRelation);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询产品分类和属性的关系", notes = "批量查询产品分类和属性的关系", responseContainer = "List", response = ProductCategoryAttributeRelation.class)
	public List<ProductCategoryAttributeRelation> findAccountList(@RequestBody ProductCategoryAttributeRelation productCategoryAttributeRelation) {
		return productCategoryAttributeRelationService.list(new QueryWrapper<>(productCategoryAttributeRelation));
	}
}
