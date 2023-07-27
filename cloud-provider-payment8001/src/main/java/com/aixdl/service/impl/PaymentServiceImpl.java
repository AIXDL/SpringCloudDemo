package com.aixdl.service.impl;

import com.aixdl.dao.PaymentDao;
import com.aixdl.entity.Payment;
import com.aixdl.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Payment)表服务实现类
 *
 * @author makejava
 * @since 2023-07-03 22:58:59
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Payment queryById(Integer id) {
        return this.paymentDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param payment     筛选条件
     * @return 查询结果
     */
    @Override
    public List<Payment> queryAll(Payment payment) {
        return this.paymentDao.queryAll(payment);
    }

    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public Payment insert(Payment payment) {
        this.paymentDao.insert(payment);
        return payment;
    }

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public Payment update(Payment payment) {
        this.paymentDao.update(payment);
        return this.queryById(payment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.paymentDao.deleteById(id) > 0;
    }
}
