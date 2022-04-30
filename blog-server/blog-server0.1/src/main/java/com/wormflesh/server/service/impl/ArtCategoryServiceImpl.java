package com.wormflesh.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wormflesh.server.mapper.ArtCategoryMapper;
import com.wormflesh.server.pojo.ArtCategory;
import com.wormflesh.server.service.IArtCategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章分类设置表 服务实现类
 * </p>
 *
 * @author wormflesh
 * @since 2022-04-28
 */
@Service
public class ArtCategoryServiceImpl extends ServiceImpl<ArtCategoryMapper, ArtCategory> implements IArtCategoryService {

}
