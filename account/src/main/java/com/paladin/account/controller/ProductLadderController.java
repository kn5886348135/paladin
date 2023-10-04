package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.ProductLadder;
import com.paladin.account.service.IProductLadderService;
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
 * 产品阶梯价格表(只针对同商品) 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/product/ladder")
public class ProductLadderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductLadderController.class);

	private IProductLadderService productLadderService;

	public ProductLadderController(IProductLadderService productLadderService) {
		this.productLadderService = productLadderService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加产品阶梯价格", notes = "添加产品阶梯价格")
	public void addProductLadder(@RequestBody ProductLadder productLadder) {
		productLadderService.save(productLadder);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody ProductLadder productLadder) {
		productLadderService.removeById(productLadder.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody ProductLadder productLadder) {
		productLadderService.updateById(productLadder);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductLadder findAccount(@RequestBody ProductLadder productLadder) {
		return productLadderService.getById(productLadder);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询产品阶梯价格", notes = "批量查询产品阶梯价格", responseContainer = "List", response = ProductLadder.class)
	public List<ProductLadder> findAccountList(@RequestBody ProductLadder productLadder) {
		return productLadderService.list(new QueryWrapper<>(productLadder));
	}
}
