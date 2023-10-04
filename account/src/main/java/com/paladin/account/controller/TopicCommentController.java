package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.TopicComment;
import com.paladin.account.service.ITopicCommentService;
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
 * 专题评论表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/topic/comment")
public class TopicCommentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TopicCommentController.class);

	private ITopicCommentService topicCommentService;

	public TopicCommentController(ITopicCommentService topicCommentService) {
		this.topicCommentService = topicCommentService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加主题评论", notes = "添加主题评论")
	public void addTopicComment(@RequestBody TopicComment topicComment) {
		topicCommentService.save(topicComment);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody TopicComment topicComment) {
		topicCommentService.removeById(topicComment.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody TopicComment topicComment) {
		topicCommentService.updateById(topicComment);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TopicComment findAccount(@RequestBody TopicComment topicComment) {
		return topicCommentService.getById(topicComment);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询主题评论", notes = "批量查询主题评论", responseContainer = "List", response = TopicComment.class)
	public List<TopicComment> findAccountList(@RequestBody TopicComment topicComment) {
		return topicCommentService.list(new QueryWrapper<>(topicComment));
	}
}
