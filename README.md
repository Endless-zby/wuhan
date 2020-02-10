# wuhan
## 定时爬取夸克浏览器中的新冠病毒疫情数据
### 1、数据获取方式
> 方式一 （http）
* Fiddle抓取数据页面的请求，直接模拟请求来获取疫情数据
> 方式二 （jsoup）
* 使用jsoup直接对页面中的数据爬取
### 2、可作为多线程定时任务的框架使用
> 该项目主要是多线程定时任务的部分
* ScheduledTask包可以作为定时任务的模板来使用
## 2020.02.03
### 1、添加数据服务
> 保存爬虫结果至数据库
* 如下，数据库截图
![Image text](https://raw.githubusercontent.com/zby123456/Local_img/master/wuhan_data.png)
* 如下，控制台数据量截图
![Image text](https://raw.githubusercontent.com/zby123456/Local_img/master/wuhan_idea.png)
## 2020.02.10
### 1. 增加数据初始化任务（清空原表数据，重新导入），谨慎使用
> 清空原表数据，使用DataInit任务来重新注入数据
> 并在数据注入完成后自动添加省市编码不影响前端数据，该任务执行周期为`1 0 0 1/5 * ?`
* 建议暂时关闭该功能
* 改用爬虫模式后将自动放弃该任务
### 2、新增字段
> 未设置保留字段，后期如果有新的想法再补吧
* 添加省份编码，为前端查询做省市的选择器做准备
### 3、增加接口，对外提供数据查询接口（准备用vue做简单的前端工程）
> 新建InternetFront包，添加外部访问接口
* 目前提供全国数据查询和地市查询两种接口
![Image text](https://raw.githubusercontent.com/zby123456/Local_img/master/wuhan_swagger.png)
## 2020.02.10
### 建立前端（vue）框架
> 引入mand-mobile移动端滴滴组件
* 组件地址[点击此处](https://didi.github.io/mand-mobile/#/zh-CN/home)
* 前端应用地址[点击此处](https://github.com/zby123456/wuhan_vue)
