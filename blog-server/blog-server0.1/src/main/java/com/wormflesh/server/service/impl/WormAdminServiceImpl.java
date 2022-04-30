package com.wormflesh.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wormflesh.server.mapper.WormAdminMapper;
import com.wormflesh.server.pojo.WormAdmin;
import com.wormflesh.server.service.IWormAdminService;
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
public class WormAdminServiceImpl extends ServiceImpl<WormAdminMapper, WormAdmin> implements IWormAdminService {

}
