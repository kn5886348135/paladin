package com.paladin.account.mapper;

import com.paladin.account.entity.ProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.paladin.account.vo.ProductCategoryTreeVO;

import java.util.List;

/**
 * <p>
 * 产品分类 Mapper 接口
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {

	public List<ProductCategoryTreeVO> selectProductCategoryTree();

}
