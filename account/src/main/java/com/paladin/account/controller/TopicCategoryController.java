package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.TopicCategory;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.ITopicCategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

	public static final Logger LOGGER = LoggerFactory.getLogger(TopicCategoryController.class);

	@Resource
	private ITopicCategoryService topicCategoryService;

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
			@ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
			@ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加主题分类", notes = "添加主题分类", response = RespOk.class)
	public RespOk addTopicCategory(@RequestBody TopicCategory topicCategory) {
		boolean result = topicCategoryService.save(topicCategory);
		return result ? new RespOk(200, "添加成功") : new RespOk(200, "添加失败");
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	public RespOk deleteAccount(@RequestBody TopicCategory topicCategory) {
		boolean result = topicCategoryService.removeById(topicCategory.getId());
		return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk modifyAccount(@RequestBody TopicCategory topicCategory) {
		boolean result = topicCategoryService.updateById(topicCategory);
		return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk findAccount(@RequestBody TopicCategory topicCategory) {
		TopicCategory result = topicCategoryService.getById(topicCategory);
		return new RespOk(200, "查询成功", result);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询主题分类", notes = "批量查询主题分类", responseContainer = "List", response = RespOk.class)
	public RespOk findAccountList(@RequestBody TopicCategory topicCategory) {
		List<TopicCategory> topicCategoryList = topicCategoryService.list(new QueryWrapper<>(topicCategory));
		return new RespOk(200, "查询成功", topicCategoryList);
	}
}
