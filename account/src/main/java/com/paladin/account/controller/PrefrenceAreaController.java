package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.PrefrenceArea;
import com.paladin.account.service.IPrefrenceAreaService;
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
 * 优选专区 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/prefrence/area")
public class PrefrenceAreaController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PrefrenceAreaController.class);

	private IPrefrenceAreaService prefrenceAreaService;

	public PrefrenceAreaController(IPrefrenceAreaService prefrenceAreaService) {
		this.prefrenceAreaService = prefrenceAreaService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加优选专区", notes = "添加优选专区")
	public void addPrefrenceArea(@RequestBody PrefrenceArea prefrenceArea) {
		prefrenceAreaService.save(prefrenceArea);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody PrefrenceArea prefrenceArea) {
		prefrenceAreaService.removeById(prefrenceArea.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody PrefrenceArea prefrenceArea) {
		prefrenceAreaService.updateById(prefrenceArea);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PrefrenceArea findAccount(@RequestBody PrefrenceArea prefrenceArea) {
		return prefrenceAreaService.getById(prefrenceArea);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询优选专区", notes = "批量查询优选专区", responseContainer = "List", response = PrefrenceArea.class)
	public List<PrefrenceArea> findAccountList(@RequestBody PrefrenceArea prefrenceArea) {
		return prefrenceAreaService.list(new QueryWrapper<>(prefrenceArea));
	}
}
