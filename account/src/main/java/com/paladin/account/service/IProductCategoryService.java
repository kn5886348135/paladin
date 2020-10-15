package com.paladin.account.service;

import com.paladin.account.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.paladin.account.vo.ProductCategoryVO;

import java.util.List;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
public interface IProductCategoryService extends IService<ProductCategory> {

	/**
	 * 查询产品分类树
	 * @return 产品分类树形结构
	 */
	public List<ProductCategoryVO> selectProductCategoryTree();
}
