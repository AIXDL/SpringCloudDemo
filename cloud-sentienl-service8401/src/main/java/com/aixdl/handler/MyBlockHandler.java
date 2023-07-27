package com.aixdl.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-24 14:26
 * @version: 1.0
 */
public class MyBlockHandler {
    //必须是static，必须要有BlockException exception，如果有多个参数,那么最后一个参数必须是BlockException exception
    public static String dealTestD(BlockException exception) {
        return "dealTestD";
    }
}
