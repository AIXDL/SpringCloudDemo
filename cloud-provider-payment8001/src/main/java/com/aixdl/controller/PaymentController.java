package com.aixdl.controller;

import com.aixdl.entity.Payment;
import com.aixdl.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Payment)表控制层
 *
 * @author makejava
 * @since 2023-07-03 22:58:59
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    /**
     * 服务对象
     */
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 分页查询
     *
     * @param payment     筛选条件
     * @return 查询结果
     */
    @GetMapping("/queryAll")
    public ResponseEntity<List<Payment>> queryAll(Payment payment) {
        System.out.println("serverPort = " + serverPort);
        return ResponseEntity.ok(this.paymentService.queryAll(payment));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById/{id}")
    public ResponseEntity<Payment> queryById(@PathVariable("id") Integer id) {
        System.out.println("serverPort = " + serverPort);
        Payment payment = this.paymentService.queryById(id);
        payment.setPort(serverPort);
        return ResponseEntity.ok(payment);
    }

    /**
     * 新增数据
     *
     * @param payment 实体
     * @return 新增结果
     */
    @PostMapping(value = "/add")
    public ResponseEntity<Payment> add(@RequestBody Payment payment, @RequestParam("id") Integer id) {
        System.out.println("id = " + id);
        System.out.println("serverPort = " + serverPort);
        return ResponseEntity.ok(this.paymentService.insert(payment));
    }

    /**
     * 编辑数据
     *
     * @param payment 实体
     * @return 编辑结果
     */
    @PutMapping(value = "/edit")
    public ResponseEntity<Payment> edit(Payment payment) {
        return ResponseEntity.ok(this.paymentService.update(payment));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.paymentService.deleteById(id));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        log.error("系统异常", e);
        return ResponseEntity.ok(e.getMessage());
    }

    @RequestMapping("/discovery")
    public DiscoveryClient getDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        // 获取服务列表
        for (String service : services) {
            log.info("service = " + service);
            discoveryClient.getInstances(service).forEach(instance -> {
                // 获取服务实例 服务id、主机、端口、uri
                log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
            });
        }
        return discoveryClient;
    }

    @GetMapping("/timeout")
    public ResponseEntity<String> timeout() throws InterruptedException {
        Thread.sleep(3000);
        return ResponseEntity.ok(serverPort);
    }
}

