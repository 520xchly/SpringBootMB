package com.vsofo.cspapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vsofo.cspapi.service.IAppUpdateService;
import com.vsofo.csprepository.entitys.AppUpdate;
import com.vsofo.csprepository.mapper.AppUpdateMapper;

import org.springframework.stereotype.Service;

/**
 * <p>
 * APK版本更新 服务实现类
 * </p>
 *
 * @author liuyan
 * @since 2021-02-26
 */
@Service
public class AppUpdateServiceImpl extends ServiceImpl<AppUpdateMapper, AppUpdate> implements IAppUpdateService {

}
