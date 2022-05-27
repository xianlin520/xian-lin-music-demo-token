# 网站开发日志([XianLin.xyz](https://www.xianlin.xyz))

> 2022年4月15日项目启动 -- 网站上线日期: 未定
>### 开发环境
> - 前端框架: [Vue](https://cn.vuejs.org/) 页面元素框架: [Element-UI](https://element.eleme.cn/)
> - 后端语言: [Java](https://www.java.com/)  - JDK1.8
    | 框架: [Spring Boot](https://spring.io/projects/spring-boot) | [Mybatis-Plus](https://baomidou.com)
> - 前后端交互框架: [Axios](https://www.axios-http.cn/)
> - 数据库: [MySQL](https://www.mysql.com/)
> - 部署环境: [Tomcat](https://www.apache.org/tomcat/), [腾讯云](https://cloud.tencent.com/)
> - 前端代码托管: [GitHub - Vue2](https://github.com/xianlin520/xian-lin-web-demo-vue2)
> - 后端代码托管: [GitHub - SpringBoot](https://github.com/xianlin520/xian-lin-music-demo-token)
---
> ### 2022年5月27日 更新代码托管仓库-更新逻辑
> - 更新后端代码托管仓库: [GitHub](https://github.com/xianlin520/xian-lin-music-demo-token)
| [Gitee](https://gitee.com/xianlin-i/xian-lin-music-demo-token) (暂不可访问)
> - 将后端会话权限管理改为Token(JWT)
> - 将前端分离 - 单独部署前端项目 前端项目地址: [Github](https://github.com/xianlin520/xian-lin-web-demo-vue2)

> ### 2022年5月25日 - 优化前端页面
> - Gitee项目托管失效, 不可访问
> - 继续摆烂, 学习Vue!

> ### 2022年5月5日 - 更新音乐收藏功能, 和个人主页
> - 在原音乐播放页面上, 添加收藏功能, 并在个人主页上展现收藏的音乐
> - Music接口: 查询, 添加, 删除
> - 暂停后端开发, 着手前后端分离开发


> ### 2022年5月4日 - 升级交互逻辑
> - 添加后端Session支持, 实现登录状态检测(拦截器)
> - 前端登录后, 后端获取用户信息, 并存入Session
> - 前端登录后, 从后端获取用户信息, 并存入LocalStorage本地存储
> - 优点: 可完成动态网页部署, 为以后的网站构建提供支持

> ### 2022年5月3日 - 将Mybatis改为MybatisPlus
> - 原因: MybatisPlus相对于传统的Mybatis, 更加快捷,方便
> - 将SpringBoot项目内代码逻辑升级为MybatisPlus
> - [Mybatis-Plus](https://baomidou.com)

> ### 2022年4月29日 - 更新后端框架&代码托管
> - 原后端框架: Spring, SpringMVC, Mybatis
> - 更新后端框架: [SpringBoot](https://www.spring.io/projects/spring-boot/) | [Mybatis](https://www.mybatis.org/)
> - 原代码托管: [GitHub](https://github.com/xianlin520/Web-MusicDemo/) And [Gitee](https://gitee.com/xianlin-i/web-music-demo)
> - 更新代码托管: [GitHub](https://github.com/xianlin520/XianLinWebDemo_SpringBoot) And [Gitee](https://gitee.com/xianlin-i/xian-lin-web-demo_-spring-boot)


> ### 2022年4月25日 - 更新后端框架
> - 原后端框架: Servlet, Mybatis
> - 更新后端框架: [Spring](https://www.spring.io/) |[SpringMVC](https://www.spring.io/projects/spring-framework/)
    |[Mybatis](https://www.mybatis.org/)
> - 代码托管: [GitHub](https://github.com/xianlin520/Web-MusicDemo/) And [Gitee](https://gitee.com/xianlin-i/web-music-demo)
> - 后端逻辑更换为SSM框架, 前端页面与后端通过Ajax交互逻辑完成
> - 暂无其他内容更新, 计划上线个人信息页面

> ### 2022年4月21日-前端music-player音乐搜索页面上线
>- 纯第三方接口: [一句话](http://ovooa.com/?action=doc&id=2) And [歌曲搜索](http://ovooa.com/?action=doc&id=9)
>- 完成歌曲歌手搜索功能, 完成歌曲播放功能
>- 优化文件结构, css,js分离html

> ### 2022年4月19日
>> 网站源码资源同步到GitHub和Gitee
>> - [GitHub](https://github.com/xianlin520/Web-MusicDemo/)
>> - [Gitee](https://gitee.com/xianlin-i/web-music-demo)

> ### 2022年4月17日-18日
> - 前端enroll注册页面上线
> > 前端注册页面, 前端校验用户注册逻辑, 并发送与后端交互数据
> - 后端开发enroll编写完成
> > 完善数据请求逻辑, 完善数据库逻辑
> > 编写Enroll接口, 实现用户注册逻辑

> ### 2022年4月16日
>2022年4月15日项目启动 -- 网站上线日期: 未定
> - 前端login登录页面上线
> > 前端登录页面, 请求处理编写完成
> - 后端登录逻辑, 编写完成
> > 编写Login接口, 实现登录信息查询
> > 链接数据库, 查询用户信息
>### 开发环境
> - 前端框架: [Vue](https://cn.vuejs.org/) 页面元素框架: [Element-UI](https://element.eleme.cn/)
> - 后端语言: [Java](https://www.java.com/)  - JDK1.8
    | 框架: [Axios](https://www.npmjs.com/package/axios), [Mybatis](https://www.npmjs.com/package/mybatis-plus)
    | 数据库: [MySQL](https://www.mysql.com/)
    | 部署环境: [Tomcat](https://www.apache.org/tomcat/), [腾讯云](https://cloud.tencent.com/)
> - 代码托管: [GitHub](https://github.com/xianlin520/Web-MusicDemo/) And [Gitee](https://gitee.com/xianlin-i/web-music-demo)
---