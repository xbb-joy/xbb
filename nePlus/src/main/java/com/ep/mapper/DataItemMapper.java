package com.ep.mapper;

import com.ep.model.entity.DataItem;
import com.ep.model.entity.Datas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Date: 2020/4/7 23:13
 * @Description:
 **/
@Mapper
public interface DataItemMapper extends tk.mybatis.mapper.common.Mapper<DataItem> {
}
