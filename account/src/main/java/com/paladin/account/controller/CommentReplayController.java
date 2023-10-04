package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.CommentReplay;
import com.paladin.account.service.ICommentReplayService;
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
 * 产品评价回复表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/comment/replay")
public class CommentReplayController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommentReplayController.class);

	private ICommentReplayService commentReplayService;

	public CommentReplayController(ICommentReplayService commentReplayService) {
		this.commentReplayService = commentReplayService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加评价回复", notes = "添加评价回复")
	public void addCarItem(@RequestBody CommentReplay commentReplay) {
		commentReplayService.save(commentReplay);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody CommentReplay commentReplay) {
		commentReplayService.removeById(commentReplay.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody CommentReplay commentReplay) {
		commentReplayService.updateById(commentReplay);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CommentReplay findAccount(@RequestBody CommentReplay commentReplay) {
		return commentReplayService.getById(commentReplay);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询评价回复", notes = "批量查询评价回复", responseContainer = "List", response = CommentReplay.class)
	public List<CommentReplay> findAccountList(@RequestBody CommentReplay commentReplay) {
		return commentReplayService.list(new QueryWrapper<>(commentReplay));
	}
}
