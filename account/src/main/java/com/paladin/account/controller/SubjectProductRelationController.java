package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.SubjectProductRelation;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.ISubjectProductRelationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

	public static final Logger LOGGER = LoggerFactory.getLogger(SubjectProductRelationController.class);

	@Resource
	private ISubjectProductRelationService subjectProductRelationService;

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
			@ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
			@ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加专题产品关系", notes = "添加专题产品关系", response = RespOk.class)
	public RespOk addSubjectProductRelation(@RequestBody SubjectProductRelation subjectProductRelation) {
		boolean result = subjectProductRelationService.save(subjectProductRelation);
		return result ? new RespOk(200, "添加成功") : new RespOk(200, "添加失败");
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	public RespOk deleteAccount(@RequestBody SubjectProductRelation subjectProductRelation) {
		boolean result = subjectProductRelationService.removeById(subjectProductRelation.getId());
		return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk modifyAccount(@RequestBody SubjectProductRelation subjectProductRelation) {
		boolean result = subjectProductRelationService.updateById(subjectProductRelation);
		return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk findAccount(@RequestBody SubjectProductRelation subjectProductRelation) {
		SubjectProductRelation result = subjectProductRelationService.getById(subjectProductRelation);
		return new RespOk(200, "查询成功", result);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询专题产品关系", notes = "批量查询专题产品关系", responseContainer = "List", response = RespOk.class)
	public RespOk findAccountList(@RequestBody SubjectProductRelation subjectProductRelation) {
		List<SubjectProductRelation> subjectProductRelationList =
				subjectProductRelationService.list(new QueryWrapper<>(subjectProductRelation));
		return new RespOk(200, "查询成功", subjectProductRelationList);
	}
}
