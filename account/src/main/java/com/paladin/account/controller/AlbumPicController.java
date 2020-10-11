package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.AlbumPic;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.IAlbumPicService;
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
 * 画册图片表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
@RestController
@RequestMapping("/albumPicpic")
public class AlbumPicController {

	public static final Logger LOGGER = LoggerFactory.getLogger(AlbumPicController.class);

	@Resource
	private IAlbumPicService albumPicService;

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
			@ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
			@ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加照片", notes = "添加照片", response = RespOk.class)
	public RespOk addAlbumPic(@RequestBody AlbumPic albumPic) {
		boolean result = albumPicService.save(albumPic);
		return result ? new RespOk(200, "添加成功") : new RespOk(200, "添加失败");
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	public RespOk deleteAccount(@RequestBody AlbumPic albumPic) {
		boolean result = albumPicService.removeById(albumPic.getId());
		return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk modifyAccount(@RequestBody AlbumPic albumPic) {
		boolean result = albumPicService.updateById(albumPic);
		return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk findAccount(@RequestBody AlbumPic albumPic) {
		AlbumPic result = albumPicService.getById(albumPic);
		return new RespOk(200, "查询成功", result);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询相片", notes = "批量查询相片", responseContainer = "List", response = RespOk.class)
	public RespOk findAccountList(@RequestBody AlbumPic albumPic) {
		List<AlbumPic> albumPicList = albumPicService.list(new QueryWrapper<>(albumPic));
		return new RespOk(200, "查询成功", albumPicList);
	}
}
