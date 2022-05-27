package xyz.xianlin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz.xianlin.domain.MusicData;

@Mapper // 使用工厂创建代理对象, 继承BaseMapper
public interface MusicDao extends BaseMapper<MusicData> {
}
