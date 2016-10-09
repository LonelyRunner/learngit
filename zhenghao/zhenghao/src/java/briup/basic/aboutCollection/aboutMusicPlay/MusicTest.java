package java.briup.basic.aboutCollection.aboutMusicPlay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZH on 2015/11/23.
 */
public class MusicTest {
    /** 单曲循环 */
    public void singlePlay(Music music){
       System.out.println("-------------------单曲循环-------------------");
       for(int i=0;i<3;i++){
           System.out.println("正在播放:"+music.getMusicName()+"......");
       }
    }
    /** 顺序播放 */
    public void sortPlay(List<Music> list){
        if(list.size()>0){
            System.out.println("-------------------顺序播放-------------------");
            for(int i=0;i<list.size();i++){
                System.out.println("正在播放:"+list.get(i).getMusicName()+"......");
            }
        }else{
            System.out.println("没有可识别的文件");
        }

    }
    /** 随机播放 */
    public void radonPlay(List<Music> list){

    }
    /** 测试 */
    public static void main(String... args){
        Music music1 = new Music("浪人情歌","4分21秒","伍佰");
        Music music2 = new Music("如果你也听说","3分58秒","张惠妹");
        Music music3 = new Music("焚情","3分45秒","张信哲");
        List list1 = new ArrayList<Music>();
        list1.add(music1);
        list1.add(music2);
        list1.add(music3);

        MusicTest mt = new MusicTest();
        mt.sortPlay(list1);

        mt.singlePlay(music1);
    }
}
