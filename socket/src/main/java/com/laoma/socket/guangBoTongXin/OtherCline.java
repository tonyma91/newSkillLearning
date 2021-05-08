package com.laoma.socket.guangBoTongXin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
  * @description 接受来自另一个客户端的消息(只收不发)
  * @author majinming@xiaomi.com
  * @date 2021年 03月17日 15:53
  */
public class OtherCline {
 public static void main(String[] args) throws Exception{

  Socket s = new Socket("127.0.0.1", 30001);
  /**
   * @des: 只收不发
   * TODO 等价于　//  new Thread(new ClientThread(s)).start();
   */
 /**
   BufferedReader bufferedReader = new BufferedReader(
             new InputStreamReader(s.getInputStream()));
   try{
   String content = null;
   //不断地读取Socket输入流中的内容，并将这些内容打印输出
   while ((content = bufferedReader.readLine()) != null){
    System.out.println("来自另一个客户端的消息：" +content);
   }
  }catch (Exception e){
   e.printStackTrace();
  }*/

  /**
   * @des: 实现收发
   */
  //客户端启动ClientThread线程不断地读取来自服务器的数据
  new Thread(new ClientThread(s)).start();
  //获取该Socket对应的输出流
  PrintStream ps = new PrintStream(s.getOutputStream());
  String line = null;
  //不断地读取键盘输入
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  while ((line = br.readLine()) != null){
   //将用户的键盘输入内容写入Socket对应的输出流
   ps.println(line);
  }
 }
}
