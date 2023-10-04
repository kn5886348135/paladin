package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.AdminRoleRelation;
import com.paladin.account.service.IAdminRoleRelationService;
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
 * 后台用户和角色关系表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/admin/role/relation")
public class AdminRoleRelationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminRoleRelationController.class);

	private IAdminRoleRelationService adminRoleRelationService;

	public AdminRoleRelationController(IAdminRoleRelationService adminRoleRelationService) {
		this.adminRoleRelationService = adminRoleRelationService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加管理员角色关系", notes = "添加管理员角色关系")
	public void registerAdminRoleRelation(@RequestBody AdminRoleRelation adminRoleRelation) {
		adminRoleRelationService.save(adminRoleRelation);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody AdminRoleRelation adminRoleRelation) {
		adminRoleRelationService.removeById(adminRoleRelation.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody AdminRoleRelation adminRoleRelation) {
		adminRoleRelationService.updateById(adminRoleRelation);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AdminRoleRelation findAccount(@RequestBody AdminRoleRelation adminRoleRelation) {
		return adminRoleRelationService.getById(adminRoleRelation);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询管理员角色关系", notes = "批量查询管理员角色关系", responseContainer = "List", response = AdminRoleRelation.class)
	public List<AdminRoleRelation> findAccountList(@RequestBody AdminRoleRelation adminRoleRelation) {
		return adminRoleRelationService.list(new QueryWrapper<>(adminRoleRelation));
	}
}
