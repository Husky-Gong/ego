package com.ego.manage.service.impl;

import com.ego.commons.ItemConst;
import com.ego.commons.exception.service.EgoServiceException;
import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.dubbo.api.ItemService4Manage;
import com.ego.manage.service.ItemService;
import com.ego.pojo.Item;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台系统服务实现 - 商品相关服务
 */
@Service
public class ItemServiceImpl implements ItemService {
    // 远程服务。
    @Reference
    private ItemService4Manage itemService4Manage;

    /**
     * 上架
     * @param ids 要上架的商品主键数组
     * @return
     */
    @Override
    public EgoResult reshelfItemByIds(Long[] ids) {
        try{
            return modifyItemStatusByIds(ids, ItemConst.STATUS_RESHELF);
        }catch (Exception e){
            e.printStackTrace();
            return EgoResult.error();
        }
    }

    /**
     * 下架
     * @param ids 要下架的商品主键数组
     * @return
     */
    @Override
    public EgoResult instockItemByIds(Long[] ids) {
        try{
            return modifyItemStatusByIds(ids, ItemConst.STATUS_INSTOCK);
        }catch (Exception e){
            e.printStackTrace();
            return EgoResult.error();
        }
    }

    /**
     * 删除
     * @param ids 要删除的商品主键数组
     * @return
     */
    @Override
    public EgoResult dropItemByIds(Long[] ids) {
        try{
            return modifyItemStatusByIds(ids, ItemConst.STATUS_DROPPED);
        }catch (Exception e){
            e.printStackTrace();
            return EgoResult.error();
        }
    }

    /**
     * 私有方法，修改商品状态方法。调用远程逻辑，实现商品状态的变更。
     * @param ids 要修改状态的商品主键数组
     * @param status 修改后的商品状态
     * @return { "status":200 } 成功。  { "status":非200 } 失败。
     */
    private EgoResult modifyItemStatusByIds(Long[] ids, Integer status) throws EgoServiceException{
        try{
            int flag = itemService4Manage.modifyItemStatusByIds(ids, status);
            if(flag == 0){
                // 更新失败
                throw new EgoServiceException("修改商品状态异常");
            }
            return EgoResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            throw new EgoServiceException("修改商品状态异常", e);
            // 发生异常了，更新失败。
            // return EgoResult.error();
        }
    }

    /**
     * 分页查询商品
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EasyUIDatagrid getItemsByPage(int page, int rows) {
        // 调用远程服务，分页查询商品集合
        List<Item> itemList = itemService4Manage.findItemsByPage(page, rows);
        // 查询商品的总计数量
        long total = itemService4Manage.queryItemsCount();
        // 返回分页结果。
        return new EasyUIDatagrid(total, itemList);
    }
}
