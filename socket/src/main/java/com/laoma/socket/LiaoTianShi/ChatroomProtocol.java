package com.laoma.socket.LiaoTianShi;

/**
 * @author majinming@xiaomi.com
 * @description 特殊字符类
 * @date 2021年 03月17日 16:28
 */
public interface ChatroomProtocol {

    /** 定义协议字符串的长度 */
    int PROTOCOL_LEN = 2;
    /** 下面是一些协议字符串，服务端和客户端交换的信息都应该在前、后添加这种特殊字符串 */
    /** 公聊 */
    String MSG_ROUND = "§γ"; 
    /** 用户登录标志 */
    String USER_ROUND = "∏∑";
    /** 用户名字无重复，创建成功 */
    String LOGIN_SUCCESS = "1";
    /** 用户名重复 */
    String NAME_REP = "-1";
    /** 私聊标志 */
    String PRIVATE_ROUND = "★【";
    /**分割消息内容 */
    String SPLIT_SIGN = "※";
}