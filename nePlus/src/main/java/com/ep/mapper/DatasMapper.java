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
public interface DatasMapper extends tk.mybatis.mapper.common.Mapper<Datas> {
    List<Datas> dataList();

    int checkName(String name);

    List<DataItem> selectItemList(@Param("dataId") String dataId);

    DataItem selectDataItemById(String id);

    int insertItem(List<DataItem> list);
}
