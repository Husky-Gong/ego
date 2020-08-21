package com.ego.manage.controller;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.manage.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 电商后台系统: 商品控制器
 */
@Controller
@ResponseBody
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 上架商品。是修改商品的状态为 1
     * @param ids 要上架的商品主键
     * @return
     */
    @PostMapping("/rest/item/reshelf")
    public EgoResult reshelfItemByIds(Long[] ids){
        return itemService.reshelfItemByIds(ids);
    }

    /**
     * 下架商品。是修改商品的状态为 2
     * @param ids 要下架的商品主键
     * @return
     */
    @PostMapping("/rest/item/instock")
    public EgoResult instockItemByIds(Long[] ids){
        return itemService.instockItemByIds(ids);
    }

    /**
     * 删除商品。是修改商品的状态为 3
     * @param ids 要删除的商品主键
     * @return
     */
    @PostMapping("/rest/item/delete")
    public EgoResult dropItemByIds(Long[] ids){
        return itemService.dropItemByIds(ids);
    }

    /**
     * 分页查询。
     * @param page 第几页
     * @param rows 多少条
     * @return { "total":总计数据行数, "rows":[ {一行数据},{},{} ] }
     *  定义一个commons中的数据类型。统一EasyUI中数据表格的返回值类型。
     */
    @GetMapping("/item/list")
    public EasyUIDatagrid getItemsByPage(@RequestParam(value = "page", defaultValue = "1") int page,
                                         @RequestParam(value = "rows", defaultValue = "30") int rows){
        return itemService.getItemsByPage(page, rows);
    }
}

