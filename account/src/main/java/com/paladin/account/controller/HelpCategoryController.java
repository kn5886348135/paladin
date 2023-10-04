package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.HelpCategory;
import com.paladin.account.service.IHelpCategoryService;
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
 * 帮助分类表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/help/category")
public class HelpCategoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelpCategoryController.class);

	private IHelpCategoryService helpCategoryService;

	public HelpCategoryController(IHelpCategoryService helpCategoryService) {
		this.helpCategoryService = helpCategoryService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加帮助分类", notes = "添加帮助分类")
	public void addHelpCategory(@RequestBody HelpCategory helpCategory) {
		helpCategoryService.save(helpCategory);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody HelpCategory helpCategory) {
		helpCategoryService.removeById(helpCategory.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody HelpCategory helpCategory) {
		helpCategoryService.updateById(helpCategory);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HelpCategory findAccount(@RequestBody HelpCategory helpCategory) {
		return helpCategoryService.getById(helpCategory);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询帮助分类", notes = "批量查询帮助分类", responseContainer = "List", response = HelpCategory.class)
	public List<HelpCategory> findAccountList(@RequestBody HelpCategory helpCategory) {
		return helpCategoryService.list(new QueryWrapper<>(helpCategory));
	}

}
