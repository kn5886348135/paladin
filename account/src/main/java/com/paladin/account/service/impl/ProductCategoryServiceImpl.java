package com.paladin.account.service.impl;

import com.paladin.account.entity.ProductCategory;
import com.paladin.account.mapper.ProductCategoryMapper;
import com.paladin.account.service.IProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paladin.account.vo.ProductCategoryTreeVO;
import com.paladin.account.vo.ProductCategoryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements IProductCategoryService {

	public static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);

	@Autowired
	private ProductCategoryMapper productCategoryMapper;

	/**
	 * 查询产品分类树
	 *
	 * @return 产品分类树形结构
	 */
	@Override
	public List<ProductCategoryTreeVO> selectProductCategoryTree() {
		return productCategoryMapper.selectProductCategoryTree();
	}
}
