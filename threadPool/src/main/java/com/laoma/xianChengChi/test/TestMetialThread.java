package com.laoma.xianChengChi.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author majinming@xiaomi.com
 * @description 测试类 chuan can shu
 * @date 2021年 03月30日 17:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestMetialThread extends Thread{

    private Object object;

    @Override
    public void run() {
        System.out.println(object);
    }
}
