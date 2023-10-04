package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.HomeBrand;
import com.paladin.account.service.IHomeBrandService;
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
 * 首页推荐品牌表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/home/brand")
public class HomeBrandController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeBrandController.class);

	private IHomeBrandService homeBrandService;

	public HomeBrandController(IHomeBrandService homeBrandService) {
		this.homeBrandService = homeBrandService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加首页推荐品牌", notes = "添加首页推荐品牌")
	public void addCarItem(@RequestBody HomeBrand homeBrand) {
		homeBrandService.save(homeBrand);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody HomeBrand homeBrand) {
		homeBrandService.removeById(homeBrand.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody HomeBrand homeBrand) {
		homeBrandService.updateById(homeBrand);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HomeBrand findAccount(@RequestBody HomeBrand homeBrand) {
		return homeBrandService.getById(homeBrand);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询首页推荐品牌", notes = "批量查询首页推荐品牌", responseContainer = "List", response = HomeBrand.class)
	public List<HomeBrand> findAccountList(@RequestBody HomeBrand homeBrand) {
		return homeBrandService.list(new QueryWrapper<>(homeBrand));
	}
}
