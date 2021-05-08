package com.laoma.test.yanshirenwu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
  * @description 主启动类，会自动扫描延时任务
 * //TODO 因为是直接进行的复制，所以 此时无法直接 运行，原因是因为多模块服务，子模块与父模块的版本不同
  * @author majinming@xiaomi.com
  * @date 2021年 03月19日 10:50
  */
@SpringBootApplication
public class TestApplication {
 public static void main(String[] args){
  SpringApplication.run(TestApplication.class);
 }
}
