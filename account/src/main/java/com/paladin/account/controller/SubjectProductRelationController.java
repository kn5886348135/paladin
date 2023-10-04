package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.SubjectProductRelation;
import com.paladin.account.service.ISubjectProductRelationService;
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
 * 专题商品关系表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/subject/product/relation")
public class SubjectProductRelationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubjectProductRelationController.class);

	private ISubjectProductRelationService subjectProductRelationService;

	public SubjectProductRelationController(ISubjectProductRelationService subjectProductRelationService) {
		this.subjectProductRelationService = subjectProductRelationService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加专题产品关系", notes = "添加专题产品关系")
	public void addSubjectProductRelation(@RequestBody SubjectProductRelation subjectProductRelation) {
		subjectProductRelationService.save(subjectProductRelation);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody SubjectProductRelation subjectProductRelation) {
		subjectProductRelationService.removeById(subjectProductRelation.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody SubjectProductRelation subjectProductRelation) {
		subjectProductRelationService.updateById(subjectProductRelation);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SubjectProductRelation findAccount(@RequestBody SubjectProductRelation subjectProductRelation) {
		return subjectProductRelationService.getById(subjectProductRelation);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询专题产品关系", notes = "批量查询专题产品关系", responseContainer = "List", response = SubjectProductRelation.class)
	public List<SubjectProductRelation> findAccountList(@RequestBody SubjectProductRelation subjectProductRelation) {
		return subjectProductRelationService.list(new QueryWrapper<>(subjectProductRelation));
	}
}
