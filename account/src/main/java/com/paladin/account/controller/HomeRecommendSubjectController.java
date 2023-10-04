package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.HomeRecommendSubject;
import com.paladin.account.service.IHomeRecommendSubjectService;
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
 * 首页推荐专题表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/home/recommend/subject")
public class HomeRecommendSubjectController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeRecommendSubjectController.class);

	private IHomeRecommendSubjectService homeRecommendSubjectService;

	public HomeRecommendSubjectController(IHomeRecommendSubjectService homeRecommendSubjectService) {
		this.homeRecommendSubjectService = homeRecommendSubjectService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加首页推荐专题", notes = "添加首页推荐专题")
	public void addCarItem(@RequestBody HomeRecommendSubject homeRecommendSubject) {
		boolean result = homeRecommendSubjectService.save(homeRecommendSubject);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody HomeRecommendSubject homeRecommendSubject) {
		homeRecommendSubjectService.removeById(homeRecommendSubject.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody HomeRecommendSubject homeRecommendSubject) {
		homeRecommendSubjectService.updateById(homeRecommendSubject);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HomeRecommendSubject findAccount(@RequestBody HomeRecommendSubject homeRecommendSubject) {
		return homeRecommendSubjectService.getById(homeRecommendSubject);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询首页推荐专题", notes = "批量查询首页推荐专题", responseContainer = "List", response = HomeRecommendSubject.class)
	public List<HomeRecommendSubject> findAccountList(@RequestBody HomeRecommendSubject homeRecommendSubject) {
		return homeRecommendSubjectService.list(new QueryWrapper<>(homeRecommendSubject));
	}
}
