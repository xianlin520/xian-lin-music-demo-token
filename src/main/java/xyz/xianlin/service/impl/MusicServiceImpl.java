package xyz.xianlin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.xianlin.dao.MusicDao;
import xyz.xianlin.domain.MusicData;
import xyz.xianlin.service.MusicService;

import java.util.List;
@Service // 标识为 Spring Bean
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicDao musicDao;
    @Override
    public List<MusicData> getMusicListByUserQQ(String userQQ) {
        QueryWrapper<MusicData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_qq", userQQ);
        List<MusicData> musicData = musicDao.selectList(queryWrapper);
        return musicData;
    }
    
    @Override
    public void addMusic(MusicData musicData) {
        // 把QQ和音乐id拼成qId存入数据库, 做唯一认证
        String s = musicData.getUserQQ() + musicData.getMusicId() + "";
        musicData.setqId(s);
        musicDao.insert(musicData);
    }
    
    @Override
    public void deleteMusic(MusicData musicData) {
        QueryWrapper<MusicData> queryWrapper = new QueryWrapper<>();
        String s = musicData.getUserQQ() + musicData.getMusicId() + "";
        queryWrapper.eq("q_id", s);
        musicDao.delete(queryWrapper);
    }
}
