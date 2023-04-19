# ForeginBankSystem
 基于Java+Vue，SSM框架实现的外汇交易银行系统

 

### 6.1.1 客户撮合交易工作台

当从登录页面使用用户（stk_user表）标识和密码成功登录后，进入客户撮合交易工作台。

![img](file:///C:\Users\lulu\AppData\Local\Temp\OICE_600798B9-312E-4565-8173-A908F5A99B22.0\msohtmlclip1\01\clip_image002.gif)

图6-4-1 撮合交易客户主界面

#### （1）交易工作台布局

该页面提供用户进行外汇竞价委托交易操作和信息显示。其实例和布局如下：![img](file:///C:\Users\lulu\AppData\Local\Temp\OICE_600798B9-312E-4565-8173-A908F5A99B22.0\msohtmlclip1\01\clip_image004.gif)

 

图6-4-2 撮合交易工作台

交易工作分成几个功能区域如下图。

![img](file:///C:\Users\lulu\AppData\Local\Temp\OICE_600798B9-312E-4565-8173-A908F5A99B22.0\msohtmlclip1\01\clip_image005.gif)

 

图6-4-4 交易工作台页面设计

### 6.1.2 买入和卖出交易委托提交

系统根据外汇当前参考和结算价格，设置委托提交的报价范围（如-10~+10%）和委托数量限制，并显示在报价框内。

（1）客户首先选择买入或卖出委托，输入委托价格和委托数量，提交委托；

（2）SubmitOrder（）方法验证客户提交的委托信息，如果符合报价和数量限制要求，则插入委托到表stk_order,更新交易撮合队列；

（3）当客户委托信息不符合要求，则提示客户检查委托数据。

成功提交的委托写入fex_order数据表，状态为“等待”撮合，并显示在买卖队列中。

图6-4-5 交易买卖委托

### 6.1.3 货币牌价、交易委托、成交记录和客户账户信息

客户除了进行外汇交易委托，还可以查看外汇牌价、委托记录、撮合成交和账户信息，分别通过stk_value_cli.aspx、stk_trans_cli.aspx、stk_order_cli.aspx和stk_account_cli.aspx和程序来实现，采用Reapeter控件和ADO数据操作控件来获取数据。

1、stk_value.aspx 查看当前外汇参考牌价

![img](file:///C:\Users\lulu\AppData\Local\Temp\OICE_600798B9-312E-4565-8173-A908F5A99B22.0\msohtmlclip1\01\clip_image007.gif)

图6-4-6 外汇牌价信息查看

2、stk_order_cli.aspx 查看客户所有撮合交易委托![img](file:///C:\Users\lulu\AppData\Local\Temp\OICE_600798B9-312E-4565-8173-A908F5A99B22.0\msohtmlclip1\01\clip_image009.gif)

 

图6-4-7 客户交易委托信息

对于已经成交的订单，可以查看成交对手委托（单号，客户）的信息。![img](file:///C:\Users\lulu\AppData\Local\Temp\OICE_600798B9-312E-4565-8173-A908F5A99B22.0\msohtmlclip1\01\clip_image011.gif)

 

图6-4-8 客户交易委托状态和关联信息

3、stk_trans.aspx 查看客户所有撮合成交记录![img](file:///C:\Users\lulu\AppData\Local\Temp\OICE_600798B9-312E-4565-8173-A908F5A99B22.0\msohtmlclip1\01\clip_image013.gif)

 

图6-4-9 客户交易成交信息

账户信息显示stk_account.aspx同时显示客户货币头寸和成本信息，金额计价以人民币为基础。

 

图6-4-10 客户账户信息

可以查看该客户某一种货币的交易情况（stk_trans_view）。

 

图6-4-11 客户特定货币交易信息

## 6.2. 后台管理功能开发

通过统一的系统登录页面和管理员登录标识，进入外汇撮合交易系统信息管理页面，对交易货币及价格、用户、账户、委托、撮合和系统配置信息进行管理和维护。信息管理初始登录/密码为2013/2013，通过管理员信息（stk_adm）操作，可以添加新的管理员和登录标识。![img](file:///C:\Users\lulu\AppData\Local\Temp\OICE_600798B9-312E-4565-8173-A908F5A99B22.0\msohtmlclip1\01\clip_image015.gif)![img](file:///C:\Users\lulu\AppData\Local\Temp\OICE_600798B9-312E-4565-8173-A908F5A99B22.0\msohtmlclip1\01\clip_image017.gif)

### 6.2.1 后台信息管理动态页面和程序文件

![img](file:///C:\Users\lulu\AppData\Local\Temp\OICE_600798B9-312E-4565-8173-A908F5A99B22.0\msohtmlclip1\01\clip_image018.gif)

图6-5-1 交易委托撮合处理逻辑

 

### 6.2.2 交易货币及汇率

![img](file:///C:\Users\lulu\AppData\Local\Temp\OICE_600798B9-312E-4565-8173-A908F5A99B22.0\msohtmlclip1\01\clip_image020.gif)

 

图6-5-2 货币及汇率信息维护

### 6.2.3 客户账户及头寸

客户账户和头寸包括账户stk_account和交易头寸stk_account_stk信息，当客户买进某种货币时，头寸中该货币的数量相应增加，买入成本（数量*价格）也相应增加（负数，可理解为支出），而交易对手卖出客户的账户该货币的数量减少，成本为正数（可以理解为收入）。多次不同价格和数量多次买卖后，形成头寸和成本。如客户甲第一次委托买入以价格6.18买入100美元，账户美元头寸为100，成本为-618元人民币，第二次以价格6.12买入200美元，成本为-1224元，账户美元头寸为300美元，成本为-1842元，第三次以价格6.14卖出150美元，成本本为912元。经过三次交易后，账户的美元头寸为150（300-150）美元，成本为-930.

| 交易 | 交易类型 | 交易价格 | 交易数量 | 交易成本 | 持有头寸 | 持有成本 |      |
| ---- | -------- | -------- | -------- | -------- | -------- | -------- | ---- |
| 1    | 买入     | 6.18     | 100      | -618     | 100      | -618     |      |
| 2    | 买入     | 6.12     | 200      | -1224    | 300      | -1842    |      |
| 3    | 卖出     | 6.14     | 150      | 912      | 150      | -930     |      |
|      |          |          |          |          |          |          |      |

 

图6-5-3 客户账户和持仓维护

(1) 在账户头寸页面stk_account_mng.aspx中，采用了嵌入Repeate1r控件来实现上述信息分类显示效果，先查询对应每个客户的stk_account表，处理每个用户时，查询该用户账户的头寸信息stk_account_stk，并绑定到Repeater2控件上，获得了上述分项显示效果。

![img](file:///C:\Users\lulu\AppData\Local\Temp\OICE_600798B9-312E-4565-8173-A908F5A99B22.0\msohtmlclip1\01\clip_image022.gif)

### 6.2.4 账户清算、平仓和初始化

（1）清算指根据当前货币参考价格和客户头寸信息，计算出客户交易的盈亏情况，如某个客户USD美元头寸为3500，成本21595元，当前汇率参考价为6.11，则盈亏为6.11*3500-21595=-210，说明该用户在美元交易中亏损了210元。全部货币头寸的计算形成客户账户的总盈亏信息，存放到数据表stk_account中；

（2）平仓操作指的是根据账户清算的盈亏结果，重新计算保证金余额，当保证金低于规定阀值时，要求增加保证金，或取消交易资格，同时清空账户头寸。

（交易委托

stk_order.aspx交易委托列出所有客户和所有货币的交易委托信息，以及成交委托的详细信息(stk_order_view.aspx)。

![img](file:///C:\Users\lulu\AppData\Local\Temp\OICE_600798B9-312E-4565-8173-A908F5A99B22.0\msohtmlclip1\01\clip_image024.gif)

 

图6-5-4 客户委托信息监控

### 6.2.5 撮合记录

stk_trans.aspx列出所有的委托撮合成交记录，信息来至数据表stk_trans。

![img](file:///C:\Users\lulu\AppData\Local\Temp\OICE_600798B9-312E-4565-8173-A908F5A99B22.0\msohtmlclip1\01\clip_image026.gif)

 

图6-5-5 撮合成功记录和监控

### 6.2.6 交易统计

![img](file:///C:\Users\lulu\AppData\Local\Temp\OICE_600798B9-312E-4565-8173-A908F5A99B22.0\msohtmlclip1\01\clip_image028.gif)

 
