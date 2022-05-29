package xyz.xianlin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.xianlin.dao.MusicDao;
import xyz.xianlin.domain.MusicData;
import xyz.xianlin.service.MusicService;

import java.util.ArrayList;
import java.util.List;
@Service // 标识为 Spring Bean
public class MusicServiceImpl{
    @Autowired
    private MusicDao musicDao;
    public List<String> getMusicListByUserQQ(String userQQ) {
        QueryWrapper<MusicData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_qq", userQQ);
        List<MusicData> musicData = musicDao.selectList(queryWrapper);
        List<String> retList = new ArrayList<>();
        for (MusicData musicDatum : musicData) {
            retList.add(musicDatum.getMusicId());
        }
        return retList;
    }
    
    public void addMusic(String userQQ, String musicId) {
        // 把QQ和音乐id拼成qId存入数据库, 做唯一认证
        String qId = userQQ + musicId + "";
        MusicData musicData = new MusicData(userQQ, musicId, qId);
        musicDao.insert(musicData);
    }
    
    public void deleteMusic(String userQQ, String musicId) {
        QueryWrapper<MusicData> queryWrapper = new QueryWrapper<>();
        String s = userQQ + musicId + "";
        queryWrapper.eq("q_id", s);
        musicDao.delete(queryWrapper);
    }
}
