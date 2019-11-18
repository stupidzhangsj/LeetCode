package com.stupidzhang.springbootlearn.transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author :zhangshengjun
 * @create 2019-11-12 9:10
 **/
@Component
public class DemonServiceImpl implements DemonService {

    @Transactional
    @Override
    public void test1() {
        System.out.println("执行方法test1");
    }

    @Override
    public void test2() {
        System.out.println("执行方法test2");
        test1();
    }
}
