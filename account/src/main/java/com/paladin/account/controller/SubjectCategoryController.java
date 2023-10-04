package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.SubjectCategory;
import com.paladin.account.service.ISubjectCategoryService;
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
 * 专题分类表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/account/subject-category")
public class SubjectCategoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubjectCategoryController.class);

	private ISubjectCategoryService subjectCategoryService;

	public SubjectCategoryController(ISubjectCategoryService subjectCategoryService) {
		this.subjectCategoryService = subjectCategoryService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加专题分类", notes = "添加专题分类")
	public void addSubjectCategory(@RequestBody SubjectCategory subjectCategory) {
		subjectCategoryService.save(subjectCategory);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody SubjectCategory subjectCategory) {
		subjectCategoryService.removeById(subjectCategory.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody SubjectCategory subjectCategory) {
		subjectCategoryService.updateById(subjectCategory);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SubjectCategory findAccount(@RequestBody SubjectCategory subjectCategory) {
		return subjectCategoryService.getById(subjectCategory);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询专题分类", notes = "批量查询专题分类", responseContainer = "List")
	public List<SubjectCategory> findAccountList(@RequestBody SubjectCategory subjectCategory) {
		return subjectCategoryService.list(new QueryWrapper<>(subjectCategory));
	}
}
