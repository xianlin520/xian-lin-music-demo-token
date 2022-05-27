package xyz.xianlin.service;

import xyz.xianlin.domain.MusicData;

import java.util.List;

public interface MusicService {
    /**
     * 查询用户收藏的音乐
     * @param userQQ 待查询用户QQ
     * @return 收藏的音乐列表
     */
    List<MusicData> getMusicListByUserQQ(String userQQ);
    
    /**
     * 为用户添加音乐
     * @param musicData 用户QQ和音乐ID
     */
    void addMusic(MusicData musicData);
    
    /**
     * 删除用户收藏的音乐
     * @param musicData 用户QQ和音乐ID
     */
    void deleteMusic(MusicData musicData);
}
