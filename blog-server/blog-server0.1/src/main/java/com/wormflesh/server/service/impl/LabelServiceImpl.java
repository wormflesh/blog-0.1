package com.wormflesh.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wormflesh.server.mapper.LabelMapper;
import com.wormflesh.server.pojo.Label;
import com.wormflesh.server.service.ILabelService;
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
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label> implements ILabelService {

}
