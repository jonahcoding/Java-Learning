HTML：超文本标记语言（Hyper Text Markup Language）

# 一、HTML

## 1.1 W3C

W3C：World Wide Web Consortium（万维网联盟）

W3C标准：

- 结构化标准语言（HTML、XML）
- 表现标准语言（CSS）
- 行为标准（DOM、ECMAScript）

## 1.2 基本结构

```html
<!--  DOCTYPE：声明规范  -->
<!DOCTYPE html>

<html lang="en">
<!-- head标签代表网页头部 -->
<head>
    <!--  meta描述性标签，描述网站信息  -->
    <!--  meta一般用作SEO  -->
    <meta name="keywords" content="Hello World!">
    <meta name="description" content="Hello Java!">
    <meta charset="UTF-8">

    <!--  title网页标题  -->
    <title>Hello World!</title>
</head>

<!--  body标签代表网页主体  -->
<body>
Hello World!
</body>
</html>
```

- head
- meta
- body

# 二、基本标签

- 标题
- 段落
- 水平线
- 换行
- 粗体、斜体
- 特殊符号

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>基本标签</title>
</head>
<body>

<!--标题标签-->
<h1>一级标签</h1>
<h2>二级标签</h2>
<h3>三级标签</h3>
<h4>四级标签</h4>
<h5>五级标签</h5>
<h6>六级标签</h6>

<!--段落标签（p Tab键补全）-->
<p>落花时节又逢君</p>
<p>负琴匣仆仆行</p>
<p>江南风光柔客心</p>
<p>不见意情</p>
<p>去年海棠玉殿听</p>
<p>弦绝拨动至如今</p>
<p>良宵引良宵引</p>

<!--水平线标签-->
<hr/>

<!--换行标签-->
落花时节又逢君<br/>
负琴匣仆仆行<br/>
江南风光柔客心<br/>
不见意情<br/>
去年海棠玉殿听<br/>
弦绝拨动至如今<br/>
良宵引良宵引<br/>

<!--粗体，斜体-->
<h1>字体样式标签</h1>
粗体：<strong>青瓦长忆旧时雨</strong><br/>
斜体：<em>朱伞深巷无故人</em><br/>

<!--特殊符号-->
空格：空&nbsp;格<br/>
大于符号：&gt;<br/>
小于符号：&lt;<br/>
版权符号：&copy;<br/>

</body>
</html>
```

# 三、图像

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图像标签</title>
</head>
<body>
<!--
1.src：路径（优先使用相对路径）（必选）
2.alt：图片名称（加载失败显示内容）（必选）
3.title：悬停文字
4.width：宽度
5.height：高度
-->
<img src="../resources/image/avatar.jpg" alt="Avatar" title="头像" width="300" height="300">
</body>
</html>
```

# 四、超链接

- 超链接
- 锚链接
- 功能性链接

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>超链接</title>
</head>
<body>

<!--顶部标记-->
<a name="top">顶部</a>

<!--a标签
href：跳转页面的地址（必选）
target：新页面打开位置
    1._blank：新标签页打开
    2._self：当前页打开
-->
<a href="01_HelloWorld.html" target="_blank">Hello World</a><br/>
<a href="https://www.google.com" target="_self">Google</a><br/>

<a href="01_HelloWorld.html">
    <img src="../resources/image/avatar.jpg" alt="Avatar" title="Hello World" width="100" height="100">
</a><br/>

<!--功能性链接
邮件链接：mailto
QQ链接：
-->
<a href="mailto:2548860066@qq.com">Email to me</a><br/>
<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=2548860066&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:2548860066:52" alt="QQ联系" title="QQ联系"/></a><br/>

<!--锚链接
1.锚标记
2.跳转至锚标记（目标页的指定位置）
-->
<a href="#top">回到顶部</a><br/>
<!--底部标记-->
<a name="down">down</a><br/>

</body>
</html>
```

- 块元素：元素独占一行
- 行内元素：

# 五、列表

- 有序列表
- 无序列表
- 自定义列表

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>列表</title>
</head>
<body>
<!--有序列表
应用：试卷、问答。
-->
<ol>
    <li>高等数学</li>
    <li>线性代数</li>
    <li>大学语文</li>
    <li>数据结构</li>
    <li>大学物理</li>
</ol>

<hr/>

<!--无序列表
应用：导航、侧边栏。
-->
<ul>
    <li>高等数学</li>
    <li>线性代数</li>
    <li>大学语文</li>
    <li>数据结构</li>
    <li>大学物理</li>
</ul>

<hr/>

<!--自定义列表
dl：标签
dt：列表名称
dd：列表内容
应用：网站底部
-->
<dl>
    <dt>学科</dt>
    <dd>高等数学</dd>
    <dd>线性代数</dd>
    <dd>大学语文</dd>
    <dd>数据结构</dd>
    <dd>大学物理</dd>

    <dt>位置</dt>
    <dd>东京</dd>
    <dd>成都</dd>
    <dd>都柏林</dd>
</dl>

</body>
</html>
```

# 六、表格

## 6.1 表格的特点

- 简单通用
- 结构稳定

## 6.2 基本结构

- 单元格
- 行
- 列
- 跨行
- 跨列

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表格</title>
</head>
<body>

<!--表格table
行：tr
列：td
跨行：rowspan
跨列：colspan
-->
<table border="1px">
    <tr>
        <!--colspan跨列（独占4列）-->
        <td colspan="4">1-1</td>
    </tr>
    <tr>
        <!--rowspan跨行（独占2行）-->
        <td rowspan="2">2-1</td>
        <td>2-2</td>
        <td>2-3</td>
        <td>2-4</td>
    </tr>
    <tr>
        <td>3-2</td>
        <td>3-3</td>
        <td>3-4</td>
    </tr>
</table>
</body>
</html>
```

# 七、媒体元素

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>媒体元素</title>
</head>
<body>
<!--音频和视频
src：资源路径
controls：控制播放
autoplay：自动播放
-->
<video src="../resources/video/iu.mp4" controls autoplay></video>
<br/>
<audio src="../resources/audio/Love%20Story.mp3" controls></audio>
<br/>
</body>
</html>
```

# 八、页面结构分析

元素：

- header：标题头部区域内容
- footer：标记脚部区域内容
- section：web页面中的一块独立区域
- article：独立的文章内容
- aside：相关内容或应用（侧边栏）
- nav：导航类辅助内容

 ```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>页面结构</title>
</head>
<body>

<header>
    <h2>网页头部</h2>
</header>

<section>
    <h2>网页主体</h2>
</section>

<footer>
    <h2>网页脚部</h2>
</footer>

</body>
</html>
 ```

# 九、内联框架

```
<iframe src="path" name="mainFrame"></iframe>
path：引用页面地址
mainFrame：框架标识名
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>内联框架</title>
</head>
<body>

<!--iframe内联框架（嵌入网页、拼装）
src：地址
width：宽度
height：宽度
-->
<iframe src="https://www.baidu.com/" name="hello" frameborder="0" width="800" height="800"></iframe>
<br/>
<a href="https://weibo.com/" target="hello">点击跳转</a>

</body>
</html>
```

# 十、表单与输入选择框

- get与post区别是什么？

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表单（登录、注册）</title>
</head>
<body>

<h1>注册</h1>

<!--表单form
action：表单提交位置，网站或请求处理地址。
method：post，get提交方式。
    get方式提交：url可以看见密码信息，不安全。
    post方式提交：安全，可传输大文件。
-->
<form action="01_HelloWorld.html" method="post">
    <!--文本输入框：input type=“text”
    value=“默认初始值”   默认初始值
    maxlength=“8”       最多允许输入字符数
    size=“30”           文本框长度
    -->
    <p>名字：<input type="text" name="username"></p>
    <!--密码框：input type="password"-->
    <p>密码：<input type="password" name="pwd"></p>

    <!--单选框标签
    input type="radio"
    value：单选框的值。
    name：组名（一组只能有一个处于被选中状态）
    -->
    <p>性别：
        <input type="radio" value="boy" name="sex"/>男
        <input type="radio" value="girl" name="sex"/>女
    </p>

    <!--多选框
    input type="checkbox"
    -->
    <p>爱好：
        <input type="checkbox" value="打游戏" name="hobby">打游戏
        <input type="checkbox" value="睡觉" name="hobby">睡觉
        <input type="checkbox" value="码代码" name="hobby">码代码
        <input type="checkbox" value="发呆" name="hobby">发呆
    </p>

    <!--按钮
    input type="button" 普通按钮
    input type="image"  图片按钮（点击可提交）
    input type="submit" 提交按钮
    input type="reset"  重置按钮
    -->
    <p>
        <input type="button" name="btn1" value="点击试一试！">
    <!--可提交-->
        <input type="image" src="../resources/image/avatar.jpg" width="50" height="50">
    </p>
    <p>
        <input type="submit">
        <input type="reset" value="清空表单">
    </p>
</form>

</body>
</html>
```

# 





# 五、表单及应用

# 六、表单初级验证

