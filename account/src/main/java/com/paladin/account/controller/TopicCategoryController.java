package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.TopicCategory;
import com.paladin.account.service.ITopicCategoryService;
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
 * 话题分类表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/topic/category")
public class TopicCategoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TopicCategoryController.class);

	private ITopicCategoryService topicCategoryService;

	public TopicCategoryController(ITopicCategoryService topicCategoryService) {
		this.topicCategoryService = topicCategoryService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加主题分类", notes = "添加主题分类")
	public void addTopicCategory(@RequestBody TopicCategory topicCategory) {
		topicCategoryService.save(topicCategory);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody TopicCategory topicCategory) {
		topicCategoryService.removeById(topicCategory.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody TopicCategory topicCategory) {
		topicCategoryService.updateById(topicCategory);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TopicCategory findAccount(@RequestBody TopicCategory topicCategory) {
		return topicCategoryService.getById(topicCategory);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询主题分类", notes = "批量查询主题分类", responseContainer = "List", response = TopicCategory.class)
	public List<TopicCategory> findAccountList(@RequestBody TopicCategory topicCategory) {
		return topicCategoryService.list(new QueryWrapper<>(topicCategory));
	}
}
