package com.paladin.account.controller;

import com.paladin.account.entity.ProductCategory;
import com.paladin.account.service.IProductCategoryService;
import com.paladin.account.vo.ProductCategoryTreeVO;
import io.swagger.annotations.Api;
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
 * 产品分类 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Api("分类操作")
@RestController
@RequestMapping("/product/category")
public class ProductCategoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryController.class);

	private IProductCategoryService productCategoryService;

	public ProductCategoryController(IProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}

	@PostMapping(value = "/新增产品分类", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({@ApiImplicitParam(name = "")})
	@ApiOperation(value = "添加产品分类", notes = "添加产品分类", response = void.class)
	public void addProductCategory(@RequestBody ProductCategory productCategory) {
		productCategoryService.save(productCategory);
	}

	@ApiOperation(value = "删除产品分类", notes = "删除产品分类", response = void.class)
	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	public void deleteProductCategory(@RequestBody ProductCategory productCategory) {
		productCategoryService.removeById(productCategory.getId());
	}

	@ApiOperation(value = "修改产品分类", notes = "修改产品分类", response = void.class)
	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyProductCategory(@RequestBody ProductCategory productCategory) {
		productCategoryService.updateById(productCategory);
	}

	@ApiOperation(value = "查询产品分类详情", notes = "查询产品分类详情", response = void.class)
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductCategory findProductCategory(@RequestBody ProductCategory productCategory) {
		return productCategoryService.getById(productCategory);
	}

	@GetMapping(value = "/tree", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "查询产品分类树", notes = "查询产品分类树", responseContainer = "List", response = ProductCategory.class)
	public List<ProductCategoryTreeVO> findProductCategoryTree() {
		return productCategoryService.selectProductCategoryTree();
	}
}
