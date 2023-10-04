package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.PrefrenceAreaProductRelation;
import com.paladin.account.service.IPrefrenceAreaProductRelationService;
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
 * 优选专区和产品关系表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/prefrence/area/product/relation")
public class PrefrenceAreaProductRelationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PrefrenceAreaProductRelationController.class);

	private IPrefrenceAreaProductRelationService prefrenceAreaProductRelationService;

	public PrefrenceAreaProductRelationController(IPrefrenceAreaProductRelationService prefrenceAreaProductRelationService) {
		this.prefrenceAreaProductRelationService = prefrenceAreaProductRelationService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加优选专区产品关系", notes = "添加优选专区产品关系", response = void.class)
	public void addPrefrenceAreaProductRelation(@RequestBody PrefrenceAreaProductRelation prefrenceAreaProductRelation) {
		prefrenceAreaProductRelationService.save(prefrenceAreaProductRelation);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody PrefrenceAreaProductRelation prefrenceAreaProductRelation) {
		prefrenceAreaProductRelationService.removeById(prefrenceAreaProductRelation.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody PrefrenceAreaProductRelation prefrenceAreaProductRelation) {
		prefrenceAreaProductRelationService.updateById(prefrenceAreaProductRelation);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PrefrenceAreaProductRelation findAccount(@RequestBody PrefrenceAreaProductRelation prefrenceAreaProductRelation) {
		return prefrenceAreaProductRelationService.getById(prefrenceAreaProductRelation);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询优选专区产品关系", notes = "批量查询优选专区产品关系", responseContainer = "List", response = PrefrenceAreaProductRelation.class)
	public List<PrefrenceAreaProductRelation> findAccountList(@RequestBody PrefrenceAreaProductRelation prefrenceAreaProductRelation) {
		return prefrenceAreaProductRelationService.list(new QueryWrapper<>(prefrenceAreaProductRelation));
	}
}
