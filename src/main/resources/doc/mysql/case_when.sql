-- https://blog.csdn.net/qq_41451303/article/details/124627783
-- MySQL CASE WHEN 多个判断条件

SELECT
CASE WHEN STATUS='1' THEN '状态1'
WHEN STATUS='2' THEN '状态2'
WHEN STATUS='3' THEN '状态3'
WHEN STATUS='0' THEN '状态4'
ELSE '状态5' END AS '状态'
FROM table;