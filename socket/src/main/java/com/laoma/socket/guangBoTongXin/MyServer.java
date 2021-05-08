package com.laoma.socket.guangBoTongXin;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
  * @description 监听主类：
  * @author majinming@xiaomi.com
  * @date 2021年 03月17日 11:56
  */
 public class MyServer {

  /**定义保存所有Socket的ArrayList，并将其包装为线层安全的 */
  public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());
  public static void main(String[] args) throws IOException {

   ServerSocket ss = new ServerSocket(30001);
   while (true){
    //此行代码会阻塞，将一直等待别人的连接
    Socket s = ss.accept();
    socketList.add(s);
    //每当客户端连接后启动一个ServerThread线程为该客户端服务
    new Thread(new ServerThread(s)).start();
   }
  }
 }
