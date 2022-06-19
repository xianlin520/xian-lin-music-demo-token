package xyz.xianlin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.xianlin.domain.MusicData;
import xyz.xianlin.service.impl.MusicServiceImpl;
import xyz.xianlin.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController // 标记为控制器
@CrossOrigin // 解决跨域问题
@RequestMapping("/musics") // 指定请求路径
@Slf4j // 启用日志
public class MusicController {
    @Autowired
    private MusicServiceImpl musicService;
    
    @GetMapping("/{userQQ}") // 指定请求方式
    public Result getMusicListByUserQQ(@PathVariable String userQQ) {
        List<String> musicList = musicService.getMusicListByUserQQ(userQQ);
        log.info("返回用户 [{}] 收藏的音乐列表", userQQ);
        return new Result(Code.GET_OK, musicList, "获取成功");
    }
    
    @PutMapping({"/{musicID}"}) // 指定请求方式为PUT, 用于插入新数据
    public Result insertUser(@PathVariable String musicID, HttpServletRequest res) {
        try {
            String userQQ = JwtUtil.getInfo(res.getHeader("Authorization")).get("userQQ").toString();
            musicService.addMusic(userQQ, musicID);
            log.info("用户 [{}] 添加了音乐 [{}]", userQQ, musicID);
            return new Result(Code.PUT_OK, Code.POST_OK, "添加成功");
        } catch (Exception e) {
            log.warn("用户添加音乐失败, 可能是音乐已存在, 或者JWT解密失败, 用户JWT包含的信息为: {}", JwtUtil.getInfo(res.getHeader("Authorization")));
            return new Result(Code.POST_ERR, Code.POST_ERR, "插入数据失败");
        }
    }
    @DeleteMapping("/{musicID}")
    public Result deleteUser(@PathVariable String musicID, HttpServletRequest res) {
        try {
            // 通过Token获取用户QQ
            String userQQ = JwtUtil.getInfo(res.getHeader("Authorization")).get("userQQ").toString();
            musicService.deleteMusic(userQQ, musicID);
            log.info("用户 [{}] 删除了音乐 [{}]", userQQ, musicID);
            return new Result(Code.DELETE_OK, Code.DELETE_OK , "数据删除成功");
        } catch (Exception e) {
            log.warn("用户删除音乐失败, 可能是音乐不存在, 或者JWT解密失败, 用户JWT包含的信息为: {}", JwtUtil.getInfo(res.getHeader("Authorization")));
            return new Result(Code.DELETE_ERR, Code.DELETE_ERR, "数据删除失败");
        }
    }
}
