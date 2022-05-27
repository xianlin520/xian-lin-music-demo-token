package xyz.xianlin.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("music_data") // 设置数据库表名
public class MusicData {
    @TableField("user_qq") // 设置数据库表的字段名
    private String userQQ; // 可重复
    private String musicId; // 可重复
    private String qId; // userQQ + musicId = qId  不可重复, 做唯一标识
    public MusicData() {
    }
    
    public MusicData(String userQQ, String musicId) {
        this.userQQ = userQQ;
        this.musicId = musicId;
    }
    
    @Override
    public String toString() {
        return "MusicData{" +
                "userQQ='" + userQQ + '\'' +
                ", musicId='" + musicId + '\'' +
                ", qId='" + qId + '\'' +
                '}';
    }
    
    public String getUserQQ() {
        return userQQ;
    }
    
    public void setUserQQ(String userQQ) {
        this.userQQ = userQQ;
    }
    
    public String getMusicId() {
        return musicId;
    }
    
    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }
    
    public String getqId() {
        return qId;
    }
    
    public void setqId(String qId) {
        this.qId = qId;
    }
}
