package com.wormflesh.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wormflesh.server.mapper.CategoryMapper;
import com.wormflesh.server.pojo.Category;
import com.wormflesh.server.service.ICategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wormflesh
 * @since 2022-04-28
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
