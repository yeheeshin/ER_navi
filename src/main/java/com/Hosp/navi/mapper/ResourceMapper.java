package com.Hosp.navi.mapper;

import com.Hosp.navi.domain.Resources;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResourceMapper {
    void save(Resources resource);
}
