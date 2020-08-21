package com.ego.manage.service;

import com.ego.commons.pojo.EasyUIDatagrid;
import com.ego.commons.pojo.EgoResult;

/**
 * 后台系统本地服务接口 - 处理商品相关业务
 */
public interface ItemService {
    /**
     * 上架方法
     * @param ids 要上架的商品主键数组
     * @return
     */
    EgoResult reshelfItemByIds(Long[] ids);

    /**
     * 下架方法
     * @param ids 要下架的商品主键数组
     * @return
     */
    EgoResult instockItemByIds(Long[] ids);

    /**
     * 删除方法
     * @param ids 要删除的商品主键数组
     * @return
     */
    EgoResult dropItemByIds(Long[] ids);

    // 只提供一个修改商品状态的服务方法。
    // EgoResult modifyItemStatusByIds(Long[] ids);

    /**
     * 分页查询商品， 服务逻辑要实现业务需求的所有服务功能。
     * 返回给控制器的应该是最终结果，避免控制器中定义业务相关代码逻辑。
     * @param page
     * @param rows
     * @return
     */
    EasyUIDatagrid getItemsByPage(int page, int rows);
}
