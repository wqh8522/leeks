# leeks
idea插件，查看基金，股票：支持A股，港股，美股  

## 安装  
leeks-1.4.2.zip 直接在IDEA里面安装  

## 使用  
设置里面找到Leeks选项，输入基金编码，股票编码，逗号分隔，apply。    
隐蔽模式默认开启，开启无着色，并且拼音显示，可以自行关闭。  
（股票编码建议用雪球看网页找，示例：sh600519,sz000001，基金编码zfb上面有，或者天天基金看  
double shift，连按两下shift，输入leeks，找到toolWindow，打开以后默认在下方，自行调节位置  
每次修改，添加基金,股票，都需要点refresh按钮(fund窗口的按钮，同时刷新股票和基金)或者重启IDEA。  
基金更新频率一分钟一次，股票10s一次

![da](https://github.com/huage2580/leeks/blob/master/TIM%E6%88%AA%E5%9B%BE20200715180137.jpg)
![dd](https://github.com/huage2580/leeks/blob/master/TIM%E6%88%AA%E5%9B%BE20200715180157.jpg)

## change  
- v1.1   
增加了股票的tab，采用腾讯的行情接口，股票轮询间隔10s  
- v1.2   
支持了港股和美股 示例代码：（sh000001,sh600519,sz000001,hk00700,usAAPL）代码一般可以在各网页端看得到  
- v1.3    
插件由小韭菜更名为Leeks
支持了IDEA 2020.1.3,兼容到`IDEA 2017.3`，修复macOS 行高问题（不确定  
- v1.4.1   
增加了隐蔽模式（全拼音和无色涨跌幅
- v1.4.2  
支持到IDEA 2020.2.*
