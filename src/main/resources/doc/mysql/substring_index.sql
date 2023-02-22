-- https://blog.csdn.net/weixin_50853979/article/details/124669207
-- SQL的substring_index()用法——MySQL字符串截取

-- 语法：substring_index(string,sep,num)
-- 即substring_index(字符串,分隔符,序号)
--
-- 参数说明
--
-- string：用于截取目标字符串的字符串。可为字段，表达式等。
--
-- sep：分隔符，string存在且用于分割的字符，比如“，”、“.”等。
--
-- num：序号，为非0整数。若为整数则表示从左到右数，若为负数则从右到左数。比如“www.mysql.com”截取字符‘www’，分割符为“.”，从左到右序号为1，即substring_index("www.mysql.com",'.',1)；若从右开始获取“com”则为序号为-1即substring_index("www.mysql.com",'.',-1)
-- ————————————————
-- 版权声明：本文为CSDN博主「小白修炼晋级中」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
-- 原文链接：https://blog.csdn.net/weixin_50853979/article/details/124669207

select cast(substring_index(ctime,' ',1) as date) as dt,
offer_id,name
FROM data
WHERE substring_index(ctime,' ',1)>= '2022-03-04'