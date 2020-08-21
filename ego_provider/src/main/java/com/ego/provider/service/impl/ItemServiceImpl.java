package com.ego.provider.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ego.commons.exception.dao.EgoItemDaoException;
import com.ego.dubbo.api.ItemService4Manage;
import com.ego.mapper.ItemMapper;
import com.ego.pojo.Item;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 商品服务提供者
 */
@Service
public class ItemServiceImpl implements ItemService4Manage {
    @Autowired
    private ItemMapper itemMapper;

    /**
     * 根据商品的主键，更新商品的状态。更新数据的时候，一定要更新updated字段。
     * updated字段是修改数据的时间戳。
     * @param ids 主键的集合
     * @param status 修改后的商品状态
     * @return
     * @throws EgoItemDaoException
     */
    @Override
    @Transactional(rollbackFor = {EgoItemDaoException.class})
    public int modifyItemStatusByIds(Long[] ids, Integer status) throws EgoItemDaoException {
        try {
            Date updated = new Date();
            // 更新数据的总行数
            int rows = 0;
            for (Long id : ids) {
                Item item = new Item();
                item.setId(id);
                item.setStatus(status);
                item.setUpdated(updated);
                // 每次更新返回的结果，累加。最终就是更新的总行数。
                rows += itemMapper.updateById(item);
            }
            // 商品状态更新返回结果累加和，一定与参数商品主键数组的长度一致。
            if (rows == ids.length) {
                return 1;
            }
            throw new EgoItemDaoException("更新商品状态发生异常！！");
        } catch (RuntimeException e){
            // Mapper访问数据库发生的异常，需要捕获，并处理，最终抛出自定义异常
            throw new EgoItemDaoException("更新商品状态发生异常！！", e);
        } catch (EgoItemDaoException e){
            throw e;
        } catch (Exception e){
            throw new EgoItemDaoException("更新商品状态发生异常！！", e);
        }
    }

    /**
     * 分页查询商品。 使用MyBatis-plus实现。PaginationInterceptor
     * 提供分页拦截器PaginationInterceptor对象。
     *
     * Provider只处理事务，不考虑业务。业务是Consumer需要考虑的问题。
     * Provider只处理数据、事务，尽可能提供一个通用的服务支撑就可以了。
     *
     * @param page 第几页
     * @param rows 多少条
     * @return
     */
    @Override
    public List<Item> findItemsByPage(int page, int rows) {
        // 设置分页逻辑
        Page<Item> pagination = new Page<>(page, rows);
        // 查询数据
        Page<Item> result = itemMapper.selectPage(pagination, null);
        // 返回查询的数据集合
        return result.getRecords();
    }

    /**
     * 查询数据行数
     * @return
     */
    @Override
    public long queryItemsCount() {
        return itemMapper.selectCount(null);
    }
}
