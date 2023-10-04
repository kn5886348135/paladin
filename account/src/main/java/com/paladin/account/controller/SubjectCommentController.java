package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.SubjectComment;
import com.paladin.account.service.ISubjectCommentService;
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
@RequestMapping("/subject/comment")
public class SubjectCommentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubjectCommentController.class);

	private ISubjectCommentService subjectCommentService;

	public SubjectCommentController(ISubjectCommentService subjectCommentService) {
		this.subjectCommentService = subjectCommentService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加专题评论", notes = "添加专题评论")
	public void addSubjectComment(@RequestBody SubjectComment subjectComment) {
		subjectCommentService.save(subjectComment);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody SubjectComment subjectComment) {
		subjectCommentService.removeById(subjectComment.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody SubjectComment subjectComment) {
		subjectCommentService.updateById(subjectComment);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SubjectComment findAccount(@RequestBody SubjectComment subjectComment) {
		return subjectCommentService.getById(subjectComment);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询专题评论", notes = "批量查询专题评论", responseContainer = "List")
	public List<SubjectComment> findAccountList(@RequestBody SubjectComment subjectComment) {
		return subjectCommentService.list(new QueryWrapper<>(subjectComment));
	}
}
