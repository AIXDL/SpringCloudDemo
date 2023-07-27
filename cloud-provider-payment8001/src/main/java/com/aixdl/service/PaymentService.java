package com.aixdl.service;





import com.aixdl.entity.Payment;

import java.util.List;

/**
 * (Payment)表服务接口
 *
 * @author makejava
 * @since 2023-07-03 22:58:59
 */
public interface PaymentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Payment queryById(Integer id);

    /**
     * 分页查询
     *
     * @param payment     筛选条件
     * @return 查询结果
     */
    List<Payment> queryAll(Payment payment);

    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    Payment insert(Payment payment);

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    Payment update(Payment payment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
