package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.Album;
import com.paladin.account.service.IAlbumService;
import io.swagger.annotations.Api;
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
 * 相册表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
@Api(value = "相册接口", tags = "相册接口")
@RestController
@RequestMapping("/album")
public class AlbumController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AlbumController.class);

	private IAlbumService albumService;

	public AlbumController(IAlbumService albumService) {
		this.albumService = albumService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加照片", notes = "添加照片")
	public void addAlbum(@RequestBody Album album) {
		albumService.save(album);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody Album album) {
		albumService.removeById(album.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody Album album) {
		albumService.updateById(album);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Album findAccount(@RequestBody Album album) {
		return albumService.getById(album);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询相片", notes = "批量查询相片", responseContainer = "List", response = Album.class)
	public List<Album> findAccountList(@RequestBody Album album) {
		return albumService.list(new QueryWrapper<>(album));
	}
}
