//package com.laoma.xianChengChi.test.onLineTest;
//
//import lx.jave.*;
//
//import java.io.File;
//
///**
// * @author majinming@xiaomi.com
// * @description
// * @date 2021年 03月31日 15:38
// */
//public class VideoUtil {
//
//    /**
//     * 根据视频路径获取视频时长
//     */
//    public static void getVideoTime(String path) throws EncoderException {
//        // 编码器
//        Encoder encoder = new Encoder();
//        File file = new File(path);
//        // 多媒体信息
//        MultimediaInfo info = encoder.getInfo(file);
//        // 时长信息
//        double duration = info.getDuration();
//        String vidoTime = formatSecond(duration/1000);
//        System.out.println("视频时长为：" + vidoTime);
//        // 音频信息
//        AudioInfo audio = info.getAudio();
//        int bitRate = audio.getBitRate();  // 比特率
//        int channels = audio.getChannels();  // 声道
//        String decoder = audio.getDecoder();  // 解码器
//        int sRate = audio.getSamplingRate();  // 采样率
//        System.out.println("解码器：" + decoder + "，声道：" + channels + "，比特率：" + bitRate + "，采样率：" + sRate);
//        // 视频信息
//        VideoInfo video = info.getVideo();
//        int bitRate2 = video.getBitRate();
//        Float fRate = video.getFrameRate();  // 帧率
//        VideoSize videoSize = video.getSize();
//        int height = videoSize.getHeight();  // 视频高度
//        int width = videoSize.getWidth();  // 视频宽度
//        System.out.println("视频帧率：" + fRate + "，比特率：" + bitRate2 + "，视频高度：" + height + "，视频宽度：" + width);
//    }
//
//    /**
//     * 将秒转换成几时几分几秒（eg: 2:9′20″）
//     */
//    public static String formatSecond(Object second){
//        String  time="0秒";
//        if(second!=null){
//            Double s=(Double) second;
//            String format;
//            Object[] array;
//            Integer hours =(int) (s/(60*60));
//            Integer minutes = (int) (s/60-hours*60);
//            Integer seconds = (int) (s-minutes*60-hours*60*60);
//            if(hours>0){
//                format="%1$,d:%2$,d′%3$,d″";
//                array=new Object[]{hours,minutes,seconds};
//            }else if(minutes>0){
//                format="%1$,d′%2$,d″";
//                array=new Object[]{minutes,seconds};
//            }else{
//                format="%1$,d″";
//                array=new Object[]{seconds};
//            }
//            time= String.format(format, array);
//        }
//        return time;
//
//    }
//
//}
