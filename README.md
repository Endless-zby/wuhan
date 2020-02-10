# wuhan
## 定时爬取夸克浏览器中的新冠病毒疫情数据（jsoup部分删除，保留了模拟请求部分）
### 1、删除爬虫部分的代码
### 2、Fiddle抓取数据页面的请求，直接模拟请求来获取疫情数据
### 3、可作为多线程定时任务的框架使用
## 2020.02.03
### 1、添加数据服务（保存爬虫结果至数据库）
![Image text](https://raw.githubusercontent.com/zby123456/Local_img/master/wuhan_data.png)
![Image text](https://raw.githubusercontent.com/zby123456/Local_img/master/wuhan_idea.png)
## 2020.02.10
### 1、增加数据初始化任务（清空原表数据，重新导入），谨慎使用
### 2、新增字段（省份编码）
### 3、增加接口，对外提供数据查询接口（准备用vue做简单的前端工程）
![Image text](https://raw.githubusercontent.com/zby123456/Local_img/master/wuhan_swagger.png)
