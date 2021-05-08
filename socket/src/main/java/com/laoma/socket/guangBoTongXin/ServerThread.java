package com.laoma.socket.guangBoTongXin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
  * @description 负责处理Socket通信的线程类
  * @author majinming@xiaomi.com
  * @date 2021年 03月17日 11:57
  */
 public class ServerThread implements Runnable{

  /**
   * 定义当前线程所处理的Socket */
  Socket s = null;
 /**
  * @des: 该线程所处理的Socket对应的输入流
 */
  BufferedReader br = null;
  public ServerThread(Socket s) throws IOException {

   this.s = s;
   //初始化该Socket对应的输入流
   br = new BufferedReader(new InputStreamReader(s.getInputStream()));
  }
  @Override
  public void run(){
   try{
    String content = null;
    //采用循环不断地从Socket中读取客户端发送过来的数据
    while ((content = readFromClient()) != null){

     //遍历socketList中的每个socket
     //将读到的内容向每个Socket广播发送
     for(Socket s : MyServer.socketList){
      PrintStream ps = new PrintStream(s.getOutputStream());
      ps.println(content);
     }
    }
   }catch (IOException e){
    e.printStackTrace();
   }
  }
 /**
  * @date 2021/3/17
  * @des:  定义读取客户端数据的方法
  * @author majinming@xiaomi.com
  */
  private String readFromClient(){
   try{
    return br.readLine();
   }
   //如果捕获异常，则表明该Socket对应的客户端已经关闭
   catch (IOException e){
    //删除该Socket
    MyServer.socketList.remove(s);
   }
   return null;
  }
 }
