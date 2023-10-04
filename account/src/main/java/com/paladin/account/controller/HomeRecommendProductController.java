package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.HomeRecommendProduct;
import com.paladin.account.service.IHomeRecommendProductService;
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
 * 人气推荐商品表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/home/recommend/product")
public class HomeRecommendProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeRecommendProductController.class);

	private IHomeRecommendProductService homeRecommendProductService;

	public HomeRecommendProductController(IHomeRecommendProductService homeRecommendProductService) {
		this.homeRecommendProductService = homeRecommendProductService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加首页推荐产品", notes = "添加首页推荐产品", response = void.class)
	public void addCarItem(@RequestBody HomeRecommendProduct homeRecommendProduct) {
		homeRecommendProductService.save(homeRecommendProduct);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody HomeRecommendProduct homeRecommendProduct) {
		homeRecommendProductService.removeById(homeRecommendProduct.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody HomeRecommendProduct homeRecommendProduct) {
		homeRecommendProductService.updateById(homeRecommendProduct);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HomeRecommendProduct findAccount(@RequestBody HomeRecommendProduct homeRecommendProduct) {
		return homeRecommendProductService.getById(homeRecommendProduct);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询首页推荐产品", notes = "批量查询首页推荐产品", responseContainer = "List", response = HomeRecommendProduct.class)
	public List<HomeRecommendProduct> findAccountList(@RequestBody HomeRecommendProduct homeRecommendProduct) {
		return homeRecommendProductService.list(new QueryWrapper<>(homeRecommendProduct));
	}
}
