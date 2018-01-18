package com.liotw.springboot.mybatis.service.impl;

import com.liotw.springboot.mybatis.mapper.MdAdministrativeRegionMapper;
import com.liotw.springboot.mybatis.domain.MdAdministrativeRegion;
import com.liotw.springboot.mybatis.service.MdAdministrativeRegionService;
import com.liotw.springboot.mybatis.dto.MdAdministrativeRegionDTO;
import com.liotw.springboot.mybatis.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.lang.Integer;

import javax.annotation.Resource;

/**
 * 行政区划-ServiceImpl接口实现类
 * @author jiangjialiang on 2018/01/18
 * @version 1.1.0
 */
@Service
@Transactional
public class MdAdministrativeRegionServiceImpl extends AbstractService<MdAdministrativeRegion, MdAdministrativeRegionDTO, Integer> implements MdAdministrativeRegionService {
    @Resource
    private MdAdministrativeRegionMapper mdAdministrativeRegionMapper;

}
