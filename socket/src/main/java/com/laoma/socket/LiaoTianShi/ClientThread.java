package com.laoma.socket.LiaoTianShi;

import java.io.BufferedReader;
import java.io.IOException;

/**
  * @description 客户端线程类
  * @author majinming@xiaomi.com
  * @date 2021年 03月17日 16:32
  */
 public class ClientThread extends Thread{

  /** 该客户端线程负责处理的输入流 */
  BufferedReader br = null;
  /** 使用一个网络输入流来创建客户端线程 */
  public ClientThread(BufferedReader br) {

   this.br = br;
  }
  @Override
  public void run(){

   try{
    String line = null;
    //不断地输入流中读取数据，并将这些数据打印 输出
    while((line = br.readLine()) != null){

     System.out.println(line);
     /*
      * 此处可以添加更多方法，例如显示聊天室人员的上线，下线
      */
    }
   }catch (IOException ex){
    ex.printStackTrace();
   }
   //使用finally块来关闭该线程对应的输入流
   finally{
    try{
     if (br != null){
      br.close();
     }
    }catch (IOException ex){
     ex.printStackTrace();
    }
   }
  }
 }