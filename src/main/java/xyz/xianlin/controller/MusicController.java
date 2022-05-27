package xyz.xianlin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.xianlin.domain.MusicData;
import xyz.xianlin.service.impl.MusicServiceImpl;

import java.util.List;

@RestController // 标记为控制器
@CrossOrigin // 解决跨域问题
@RequestMapping("/musics") // 指定请求路径
public class MusicController {
    @Autowired
    private MusicServiceImpl musicService;
    
    @GetMapping("/{userQQ}") // 指定请求方式
    public Result getMusicListByUserQQ(@PathVariable String userQQ) {
        List<MusicData> musicList = musicService.getMusicListByUserQQ(userQQ);
        return new Result(Code.GET_OK, musicList);
    }
    
    @PutMapping // 指定请求方式为PUT, 用于插入新数据
    public Result insertUser(@RequestBody MusicData musicData) {
        try {
            musicService.addMusic(musicData);
            return new Result(Code.PUT_OK, musicData, "数据插入成功");
        } catch (Exception e) {
            return new Result(Code.PUT_ERR, musicData, "数据插入失败, 数据库内已存在该数据");
        }
    }
    @DeleteMapping
    public Result deleteUser(@RequestBody MusicData musicData) {
        try {
            musicService.deleteMusic(musicData);
            return new Result(Code.DELETE_OK, musicData, "数据删除成功");
        } catch (Exception e) {
            return new Result(Code.DELETE_ERR, musicData, "数据删除失败, 数据库内不存在该数据");
        }
    }
}
