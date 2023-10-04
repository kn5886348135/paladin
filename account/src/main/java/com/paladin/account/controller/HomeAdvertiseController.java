package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.HomeAdvertise;
import com.paladin.account.service.IHomeAdvertiseService;
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
 * 首页轮播广告表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/home/advertise")
public class HomeAdvertiseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeAdvertiseController.class);

	private IHomeAdvertiseService homeAdvertiseService;

	public HomeAdvertiseController(IHomeAdvertiseService homeAdvertiseService) {
		this.homeAdvertiseService = homeAdvertiseService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加首页轮播广告", notes = "添加首页轮播广告", response = void.class)
	public void addCarItem(@RequestBody HomeAdvertise homeAdvertise) {
		homeAdvertiseService.save(homeAdvertise);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody HomeAdvertise homeAdvertise) {
		homeAdvertiseService.removeById(homeAdvertise.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody HomeAdvertise homeAdvertise) {
		homeAdvertiseService.updateById(homeAdvertise);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HomeAdvertise findAccount(@RequestBody HomeAdvertise homeAdvertise) {
		return homeAdvertiseService.getById(homeAdvertise);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询首页轮播广告", notes = "批量查询首页轮播广告", responseContainer = "List", response = HomeAdvertise.class)
	public List<HomeAdvertise> findAccountList(@RequestBody HomeAdvertise homeAdvertise) {
		return homeAdvertiseService.list(new QueryWrapper<>(homeAdvertise));
	}

}
