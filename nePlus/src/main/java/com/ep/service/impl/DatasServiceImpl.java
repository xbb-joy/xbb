package com.ep.service.impl;

import com.ep.mapper.DataItemMapper;
import com.ep.model.entity.DataItem;
import com.ep.model.entity.Datas;
import com.ep.mapper.DatasMapper;
import com.ep.mapper.UserMapper;
import com.ep.service.DatasService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Date: 2020/4/8 16:01
 * @Description:
 **/
@Service
public class DatasServiceImpl implements DatasService {

    @Resource
    private DatasMapper datasMapper;

    @Resource
    private DataItemMapper dataItemMapper;

    /**
     * 根据id查询
     *
     * @param userId
     * @return
     */
    @Override
    public Datas selectById(String userId) {
        return datasMapper.selectByPrimaryKey(userId);
    }

    /**
     * 更新数据
     *
     * @param datas
     */
    @Override
    public int update(Datas datas) {
        return datasMapper.updateByPrimaryKeySelective(datas);
    }

    /**
     * 删除数据
     *
     * @param userId
     */
    @Override
    public int delete(String userId) {
        return datasMapper.deleteByPrimaryKey(userId);
    }

    /**
     * 新增数据
     *
     * @param datas
     */
    @Override
    public int insert(Datas datas) {
        return datasMapper.insertSelective(datas);
    }

    /**
     * 新增数据列表
     *
     * @param items
     */
    @Override
    public int insertItem(List<DataItem> items) {
        return datasMapper.insertItem(items);
    }

    /**
     * 查询数据
     *
     * @param nameParam
     * @return
     */
    @Override
    public List<Datas> dataList(String nameParam) {
        return datasMapper.dataList();
    }

    /**
     * 查询详细数据
     *
     * @param dataId
     * @return
     */
    @Override
    public List<DataItem> selectItemList(String dataId) {
        List<DataItem> items = datasMapper.selectItemList(dataId);
        String typeName = null;
        for (DataItem item : items) {
            //1-实际液高，2-标准液高，3-实际压力，4-标准压力
            switch (item.getType()) {
                case 1:
                    typeName = "实际液高";
                    break;
                case 2:
                    typeName = "标准液高";
                    break;
                case 3:
                    typeName = "实际压力";
                    break;
                case 4:
                    typeName = "标准压力";
                    break;
            }
            item.setTypeName(typeName);
        }
        return items;
    }

    @Override
    public DataItem selectDataItemById(String id) {
        return dataItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateDataItem(DataItem item) {
        return dataItemMapper.updateByPrimaryKeySelective(item);
    }

    @Override
    public int checkName(String username) {
        return datasMapper.checkName(username);
    }
}
