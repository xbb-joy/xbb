package com.ep.service;

import com.ep.model.entity.DataItem;
import com.ep.model.entity.Datas;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Date: 2020/4/8 16:01
 * @Description:
 **/
public interface DatasService {
    Datas selectById(String userId);

    int update(Datas datas);

    int delete(String userId);

    int insert(Datas datas);

    int insertItem(List<DataItem> items);

    int checkName(String username);

    List<Datas> dataList(String nameParam);

    List<DataItem> selectItemList(String dataId);

    DataItem selectDataItemById(String id);

    int updateDataItem(DataItem item);
}
