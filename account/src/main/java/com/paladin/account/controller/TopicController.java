package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.Topic;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.ITopicService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 话题表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/topic")
public class TopicController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TopicController.class);

	@Resource
	private ITopicService topicService;

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
			@ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
			@ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加主题", notes = "添加主题", response = RespOk.class)
	public RespOk addTopic(@RequestBody Topic topic) {
		boolean result = topicService.save(topic);
		return result ? new RespOk(200, "添加成功") : new RespOk(200, "添加失败");
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	public RespOk deleteAccount(@RequestBody Topic topic) {
		boolean result = topicService.removeById(topic.getId());
		return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk modifyAccount(@RequestBody Topic topic) {
		boolean result = topicService.updateById(topic);
		return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk findAccount(@RequestBody Topic topic) {
		Topic result = topicService.getById(topic);
		return new RespOk(200, "查询成功", result);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询主题", notes = "批量查询主题", responseContainer = "List", response = RespOk.class)
	public RespOk findAccountList(@RequestBody Topic topic) {
		List<Topic> topicList = topicService.list(new QueryWrapper<>(topic));
		return new RespOk(200, "查询成功", topicList);
	}
}
