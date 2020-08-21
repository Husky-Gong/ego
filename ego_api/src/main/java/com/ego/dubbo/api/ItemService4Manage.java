package com.ego.dubbo.api;

import com.ego.commons.exception.dao.EgoItemDaoException;
import com.ego.pojo.Item;

import java.util.List;

/**
 * 服务标准接口。给后台系统manage使用
 */
public interface ItemService4Manage {
    /**
     * 除特殊情况外，所有的写逻辑（增删改），返回结果都使用int类型，
     * 0代表写失败；1代表写成功。
     * 写逻辑，需要管理事务。且事务需要在Provider中处理。
     * 使用Spring的@Transactionl注解，实现事务管理。需要抛出异常回滚事务。
     * 自定义一个异常，专门处理事务。
     * 根据商品的主键，修改商品的状态。
     * @param ids 主键的集合
     * @param status 修改后的商品状态
     * @return
     */
    int modifyItemStatusByIds(Long[] ids, Integer status) throws EgoItemDaoException;

    /**
     * 分页查询商品
     * @param page 第几页
     * @param rows 多少条
     * @return 查询结果集合
     */
    List<Item> findItemsByPage(int page, int rows);

    /**
     * 查询商品数量， 总计多少条。 count(id)
     * @return 数据行数
     */
    long queryItemsCount();
}
