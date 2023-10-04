package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.AlbumPic;
import com.paladin.account.service.IAlbumPicService;
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
 * 画册图片表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
@RestController
@RequestMapping("/albumPicpic")
public class AlbumPicController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AlbumPicController.class);

	private IAlbumPicService albumPicService;

	public AlbumPicController(IAlbumPicService albumPicService) {
		this.albumPicService = albumPicService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({@ApiImplicitParam(name = "pic", defaultValue = "", required = true)})
	@ApiOperation(value = "添加照片", notes = "添加照片")
	public void addAlbumPic(@RequestBody AlbumPic albumPic) {
		albumPicService.save(albumPic);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody AlbumPic albumPic) {
		albumPicService.removeById(albumPic.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody AlbumPic albumPic) {
		albumPicService.updateById(albumPic);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void findAccount(@RequestBody AlbumPic albumPic) {
		AlbumPic result = albumPicService.getById(albumPic);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询相片", notes = "批量查询相片", responseContainer = "List", response = AlbumPic.class)
	public List<AlbumPic> findAccountList(@RequestBody AlbumPic albumPic) {
		return albumPicService.list(new QueryWrapper<>(albumPic));
	}
}
