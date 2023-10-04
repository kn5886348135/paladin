package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.HomeNewProduct;
import com.paladin.account.service.IHomeNewProductService;
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
 * 新鲜好物表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/account/home-new-product")
public class HomeNewProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeNewProductController.class);

	private IHomeNewProductService homeNewProductService;

	public HomeNewProductController(IHomeNewProductService homeNewProductService) {
		this.homeNewProductService = homeNewProductService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加首页新产品", notes = "添加首页新产品")
	public void addCarItem(@RequestBody HomeNewProduct homeNewProduct) {
		homeNewProductService.save(homeNewProduct);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody HomeNewProduct homeNewProduct) {
		homeNewProductService.removeById(homeNewProduct.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody HomeNewProduct homeNewProduct) {
		homeNewProductService.updateById(homeNewProduct);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HomeNewProduct findAccount(@RequestBody HomeNewProduct homeNewProduct) {
		return homeNewProductService.getById(homeNewProduct);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询首页新产品", notes = "批量查询首页新产品", responseContainer = "List", response = HomeNewProduct.class)
	public List<HomeNewProduct> findAccountList(@RequestBody HomeNewProduct homeNewProduct) {
		return homeNewProductService.list(new QueryWrapper<>(homeNewProduct));
	}
}
