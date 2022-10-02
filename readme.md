# Getting Started
该项目主要用于个人测试
其中一些方法经过个人提炼，能够从一定程度上提升编程效率
主要内容如下
- 项目之初，原计划是写一个elasticsearch的demo的
- 后来又引入了jpa连接数据库
- 后来又引入了redis
- 又尝试了画UML图
- 日常测试
- 写程序的心得与总结

## Elasticsearch

[SpringBoot 整合 Elasticsearch](https://blog.csdn.net/wyf2017/article/details/125218036?spm=1001.2101.3001.6650.7&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-7-125218036-blog-108428430.pc_relevant_multi_platform_whitelistv3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-7-125218036-blog-108428430.pc_relevant_multi_platform_whitelistv3&utm_relevant_index=10)

[cloudgyb/es-spring-boot](https://github.com/cloudgyb/es-spring-boot/blob/main/src/main/java/com/github/cloudgyb/esspringboot/BookEntity.java)

## mac 重新安装本地mysql

[mac下mysql安装、卸载、基本操作](https://blog.csdn.net/fgdfgasd/article/details/80620135?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2)

```shell script
mysql.server start
```

[MySQL安全配置向导mysql_secure_installation详解](https://www.niwoxuexi.com/blog/php/article/1876)

## 继承redis

1、安装redis

[mac安装redis](https://blog.csdn.net/m290345792/article/details/123606716)

```shell script
redis-server /usr/local/etc/redis.conf
```
[MAC安装redis最简单的方法](https://blog.csdn.net/qq_41689620/article/details/85995880?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-85995880-blog-123606716.pc_relevant_multi_platform_whitelistv1&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-85995880-blog-123606716.pc_relevant_multi_platform_whitelistv1&utm_relevant_index=2)

2、springboot + redis

[springboot使用redis](https://blog.csdn.net/qq_49044908/article/details/121883374)

[SpringBoot 中使用Redis缓存](https://xcbeyond.blog.csdn.net/article/details/81116600?spm=1001.2101.3001.6650.2&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-2-81116600-blog-121883374.pc_relevant_multi_platform_whitelistv3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-2-81116600-blog-121883374.pc_relevant_multi_platform_whitelistv3&utm_relevant_index=5)

## 单元测试着重方法的使用，提炼

## github 提交代码的变化
```shell script

localhost:demoes jiangjianfei$ git push -u origin main
Username for 'https://github.com': 1078058570@qq.com
Password for 'https://1078058570@qq.com@github.com': 
remote: Support for password authentication was removed on August 13, 2021.
remote: Please see https://docs.github.com/en/get-started/getting-started-with-git/about-remote-repositories#cloning-with-https-urls for information on currently recommended modes of authentication.
fatal: Authentication failed for 'https://github.com/flyingJiang/JavaDemo.git/'

```
遇到上述问题 可以参考[这里](https://docs.github.com/cn/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)
```shell script

git remote set-url origin https://[Personal access tokens]@github.com/flyingJiang/JavaDemo.git
```
