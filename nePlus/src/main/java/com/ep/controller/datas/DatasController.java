package com.ep.controller.datas;

import com.alibaba.fastjson.JSON;
import com.ep.model.entity.DataItem;
import com.ep.model.entity.Datas;
import com.ep.model.entity.User;
import com.ep.service.DatasService;
import com.ep.utils.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Date: 2020/4/8 23:51
 * @Description:
 **/
@Controller
public class DatasController {

    @Resource
    private DatasService datasService;

    @Resource
    private HttpSession httpSession;

    @GetMapping("data/list")
    public String dataList(Model model, String nameParam) {
        //查询列表数据
        List<Datas> dataList = datasService.dataList(nameParam);

        model.addAttribute("dataList", dataList);
        User user = (User) httpSession.getAttribute("user");
        boolean userType = user.getType().equals("admin");
        model.addAttribute("userType", userType);
        return "datas/dataList";
    }

    /**
     * 新增或修改数据页面
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("data/edit")
    public String userEdit(Model model, String id) {
        Datas datas = new Datas();
        String add = null;
        if (StringUtils.isNotEmpty(id)) {
            //查询列表数据
            datas = datasService.selectById(id);
        }
        //模糊查询参数
        model.addAttribute("datas", datas);
        return "datas/dataEdit";
    }

    /**
     * 新增或修改数据请求
     *
     * @param model
     * @param datas
     * @return
     */
    @PostMapping("data/edit")
    public String userEditOrAnd(Model model, Datas datas) {
        //判断新增还是修改
        if (StringUtils.isEmpty(datas.getId())) {
            //新增
            //判断用户名不能重复
            int userNum = datasService.checkName(datas.getName());
            if (userNum > 0) {
                model.addAttribute("msg", "药名不能重复");
                return "datas/dataEdit";
            }
            datas.setId(UUIDUtils.getUuId());
            datas.setCreateTime(new Date());
            datas.setUpdateTime(new Date());

            //添加数据内容
            //1-实际液高，2-标准液高，3-实际压力，4-标准压力
            List<DataItem> items = new ArrayList<>();
            for (int i = 1; i <= 4; i++) {
                DataItem item = new DataItem();
                item.setId(UUIDUtils.getUuId());
                item.setDataId(datas.getId());
                item.setType(i);

                items.add(item);
            }
            datasService.insert(datas);
            datasService.insertItem(items);
            model.addAttribute("msg", "添加成功");
        } else {
            //修改
            datas.setUpdateTime(new Date());
            datasService.update(datas);
            model.addAttribute("msg", "修改成功");
        }
        model.addAttribute("datas", datas);
        return "datas/dataEdit";
    }

    /**
     * 删除数据
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("data/delete")
    public String delete(Model model, String id) {
        model.addAttribute("msg", "删除成功");
        datasService.delete(id);
        return "redirect:/data/list";
    }

    /**
     * 数据录入
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("data/item")
    public String dataItem(Model model, String id, String name) {
        //分别查询液高属性和压力属性
        model.addAttribute("itemName", name);
        model.addAttribute("itemId", id);
        //获取液高、压力值列表
        List<DataItem> itemList = datasService.selectItemList(id);
        model.addAttribute("itemList", itemList);
        User user = (User) httpSession.getAttribute("user");
        boolean userType = user.getType().equals("admin");
        model.addAttribute("userType", userType);
        return "datas/dataItem";
    }

    /**
     * 各项数据录入页面
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("data/item/edit")
    public String dataItemEdit(Model model, String id, String itemId, String itemName, String typeName) {
        //查询数据
        DataItem item = datasService.selectDataItemById(id);
        model.addAttribute("typeName", typeName);
        model.addAttribute("itemId", itemId);
        model.addAttribute("itemName", itemName);
        model.addAttribute("item", item);
        return "datas/dataItemEdit";
    }

    /**
     * 各项数据录入请求
     *
     * @param model
     * @return
     */
    @PostMapping("data/item/edit")
    public String dataItemEdit(Model model, String itemId, String itemName, String typeName, DataItem item) {
        model.addAttribute("typeName", typeName);
        model.addAttribute("itemId", itemId);
        model.addAttribute("itemName", itemName);
        model.addAttribute("item", item);
        int i = datasService.updateDataItem(item);
        return "datas/dataItemEdit";
    }

    /**
     * 数据分析
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("data/analysis")
    public String dataAnalysis(Model model, String id, String name) {
        //分别查询液高属性和压力属性
        model.addAttribute("itemName", name);
        model.addAttribute("itemId", id);
        //封装线图数据
        //1-实际液高，2-标准液高，3-实际压力，4-标准压力
        List<DataItem> items = datasService.selectItemList(id);
        for (DataItem item : items) {
            //将数据转换为list数组
            List<Double> list = Arrays.asList(item.getZero(), item.getOne(), item.getTwo()
                    , item.getThree(), item.getFour(), item.getFive(), item.getSix(), item.getSeven()
                    , item.getEight(), item.getNine(), item.getTen());
            if (item.getType() == 1) {
                model.addAttribute("actualPressure", list);
            } else if (item.getType() == 2) {
                model.addAttribute("standardPressure", list);
            } else if (item.getType() == 3) {
                model.addAttribute("actualLiquid", list);
            } else if (item.getType() == 4) {
                model.addAttribute("standardLiquid", list);
            }

        }
        //计算差值


        return "datas/dataAnalysis";
    }
}
