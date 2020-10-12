# 一、CSS

## 1.1 CSS定义

CSS 指层叠样式表 (**C**ascading **S**tyle **S**heets)

## 1.2 CSS优势

1. 内容与表现分离。
2. 网页结构表现统一，可复用。
3. 样式丰富。
4. 利用SEO，容易被搜索引擎收录。

## 1.3 CSS导入方式

- 行内样式
- 内部样式
- 外部样式

> **优先级：就近原则**

**index.html**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>tittle</title>

    <!--内部样式-->
    <style>
        h1{
            color: aquamarine;
        }
    </style>

    <!--外部样式-->
    <link rel="stylesheet" href="css/style.css">
</head>
    
<body>
<!--优先级：就近原则-->
<!--行内样式：在标签元素中编写style属性-->
<h1 style="color: coral">标题</h1>

</body>
</html>
```

**style.css**

```css
h1{
    color: darksalmon;
}
```

扩展：外部样式的两种写法

- 链接式：

  ```html
  <!--外部样式-->
  <link rel="stylesheet" href="css/style.css">
  ```

- 导入式（CSS2.1特有）：

  ```html
  <!--导入式-->
  <style>
  	@import url("css/style.css");
  </style>
  ```



# 二、选择器（重要）

作用：选择页面上的某一个或某一类元素。

## 2.1 基本选择器（重要）

1. 标签选择器：选择一类标签  标签{}
2. 类选择器 class：选择所有class属性一致的标签，夸标签  .类名{}
3. ID选择器：全局唯一！  #id名{}

> **优先级：id选择器 > class选择器 > 标签选择器**

标签选择器：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        /*标签选择器，默认选择该类标签的所有元素*/
        h1{
            color: coral;
            background: aquamarine;
            border-radius: 24px;
        }
        p{
            font-size: 20px;
        }
    </style>

</head>
<body>

<h1>听雨</h1>
<h1>听雨</h1>
<h1>听雨</h1>
<p>观山</p>

</body>
</html>
```

类选择器：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
    /*类选择器的格式   .class的名称{}
    优点：多个标签归类（同一个class，复用）
    */
        .class1{
            color: coral;
        }
        .class2{
            color: cornflowerblue;
        }
    </style>

</head>
<body>

<h1 class="class1">标题1</h1>
<h1 class="class2">标题2</h1>
<h1 class="class1">标题3</h1>
<!--不同类型的标签也可使用-->
<p class="class2">标签</p>

</body>
</html>
```

ID选择器：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        /*  id选择器：全局唯一
            #id名称{}
            优先级：
                不遵循就近原则。
                id选择器 > class选择器 > 标签选择器
        */
        #ID{
            color: cornflowerblue;
        }
        .style1{
            color: coral;
        }
        .style2{
            color: aquamarine;
        }
    </style>

</head>
<body>

<h1 id="ID">标题1</h1>
<h1 class="style1">标题2</h1>
<h1 class="style2">标题3</h1>
<h1>标题4</h1>
<h1>标题5</h1>

</body>
</html>
```

## 2.2 层次选择器

1. 后代选择器：
2. 子选择器：一代
3. 相邻兄弟选择器：仅一个，相邻（向下）
4. 通用选择器：当前元素向下的所有同级元素

```html
<style>
    /*后代选择器*/
    body p{
        background: coral;
    }
    /*子选择器：一代*/
    body >p{
        background: aquamarine;
    }
    /*相邻兄弟选择器：仅一个，相邻（向下）*/
    .active +p{
        background: cornflowerblue;
    }
    /*通用选择器：当前元素向下的所有同级元素*/
    .active ~p{
        background: darkcyan;
    }
</style>
```

## 2.3 伪类选择器

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        /*ul的第一个元素*/
        u1 li:first-child{
            background: darkcyan;
        }
        /*ul的最后一个元素*/
        u1 li:last-child{
            background: green;
        }
        /*选中p1：
        选择当前元素的父级元素的第n个子元素，n为索引位置。
        */
        p:nth-child(1){
            background: coral;
        }
        /*选择当前元素的父元素的第n个该类子元素，n为索引位置*/
        p:nth-of-type(2){
            background: yellow;
        }

        /*悬浮动作*/
        a:hover{
            background: greenyellow;
        }
    </style>

</head>
<body>

    <a href="">123</a>
    <p>p1</p>
    <p>p2</p>
    <p>p3</p>
    <u1>
        <li>li1</li>
        <li>li2</li>
        <li>li3</li>
    </u1>

</body>
</html>
```

## 2.4 属性选择器（重要）
属性选择器：
    属性名 = 属性值（正则）

| =    | 绝对等于     |
| ---- | ------------ |
| *=   | 包含这个元素 |
| ^=   | 以...开头    |
| $=   | 以...结尾    |



```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        .demo a{
            float: left;
            display: block;
            height: 50px;
            width: 50px;
            border-radius: 10px;
            background: cadetblue;
            text-align: center;
            color: gainsboro;
            text-decoration: none;
            margin-right: 5px;
            font: bold 20px/50px Arial;
        }

        /*属性名 = 属性值（正则）
        =   绝对等于
        *=  包含这个元素
        ^=  以...开头
        $=  以...结尾
        */

        /*存在id属性的元素     a[]{}*/
        /*a[id]{*/
        /*    background: yellow;*/
        /*}*/

        /*id=first 的元素*/
        /*a[id=first]{*/
        /*    background: yellowgreen;*/
        /*}*/

        /*class 中含有links的元素*/
        a[class*="links"]{
            background: yellow;
        }

        /*href 中以http开头的元素*/
        a[href^="http"]{
            background: cadetblue;
        }

        /*href 中以pdf结尾的元素*/
        a[href$="pdf"]{
            background: palevioletred;
        }

    </style>

</head>
<body>

<p class="demo">
    <a href="http://www.baidu.com" class="links item first" id="first">1</a>
    <a href="" class="links item active" target="_blank" title="test">2</a>
    <a href="images/123.html" class="links item">3</a>
    <a href="images/123.png" class="links item">4</a>
    <a href="images/123.jpg" class="links item">5</a>
    <a href="abc" class="links item">6</a>
    <a href="/a.pdf" class="links item">7</a>
    <a href="/abc.pdf" class="links item">8</a>
    <a href="abc.doc" class="links item">9</a>
    <a href="abcd.doc" class="links item last">10</a>
</p>

</body>
</html>
```

# 三、美化网页元素

## 3.1 美化元素必要性

1. 有效的传递页面信息
2. 美化网页，吸引用户。
3. 凸显网页主题。
4. 提高用户体验。

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        #title1{
            font-size: 50px;
        }
    </style>

</head>
<body>
踏雪寻梅 <span id="title1">Java</span>

</body>
</html>
```

## 3.2 字体样式

font：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--
    font-family: 字体
    font-size:字体大小
    font-weight: 粗体
    color:颜色
    -->
    <style>
        body{
            font-family: 楷体,"Cascadia Code";
            color: cornflowerblue;
        }
        h1{
            font-size: 20px;
        }
        .p1{
            font-weight: bold;
        }
        .p2{
            font-weight: lighter;
        }
    </style>

</head>
<body>

<h1>花非花</h1>
<p class="p1">
    花非花，雾非雾，
    夜半来，天明去。
</p>
<p class="p2">
    来如春梦不多时，
    去似朝云无觅处。
</p>

<p>
    Have a nice day!
</p>

</body>
</html>
```

## 3.3 文本样式

1. 颜色：color、rgb、rgba
2. **文本对齐方式：text-align=center**
3. **首行缩进：text-indent: 2em;**
4. **行高：line-height: 300px;**
5. 装饰：text-decoration: underline/line-through/overline/none（超链接去下划线）
6. 文本图片水平对齐：vertical-align: middle

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--
    颜色：
        单词
        RGB   0~F
        RGBA  A 0~1
    text-align:排版，左中右
    text-indent:缩进
    line-height：行高
    text-decoration:下划线、中划线、上划线
    行高与块的高度一致时，可以实现上下居中。
    -->
    <style>
        h1{
            color: rgba(0,255,255,0.9);//颜色RGBA
            text-align: center;//水平居中
        }
        .p1{
            text-indent: 2em;//缩进
        }
        .p2{
            text-align: center;
        }
        .p3{
            color: greenyellow;//颜色
            background: black;//背景色
            height: 300px;//高度
            line-height: 300px;//行高
            text-align: center;
        }
        .p4{
            text-decoration: underline;//下划线
        }
        .p5{
            text-decoration: line-through;//中划线
        }
        .p6{
            text-decoration: overline;//上划线
        }
        img,span{
            vertical-align: middle;//垂直居中
        }

    </style>

</head>
<body>

    <h1>花非花</h1>
    <p class="p1">
        花非花，雾非雾，
        夜半来，天明去。
    </p>
    <p class="p2">
        来如春梦不多时，
        去似朝云无觅处。
    </p>

    <p  class="p3">
        Have a nice day!
    </p>

    <p  class="p4">
        Have a nice day!
    </p>

    <p  class="p5">
        Have a nice day!
    </p>

    <p  class="p6">
        Have a nice day!
    </p>

    <img src="image/avatar.jpg" width="50" height="50" alt="">
    <span>应似飞鸿踏雪泥</span>

</body>
</html>
```

## 3.4 阴影

text-shadow: 阴影颜色 水平偏移 垂直偏移 阴影半径;

```html
<style>
    /*text-shadow: 阴影颜色 水平偏移 垂直偏移 阴影半径;*/
    #happy{
    	text-shadow: orangered 10px -10px 2px;
    }
</style>
```

## 3.5 超链接伪类

- 默认颜色
- 鼠标悬停颜色
- 鼠标未释放颜色

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        /*默认的颜色*/
        a{
            color: black;
            text-decoration: none;
        }
        /*鼠标悬浮颜色*/
        a:hover{
            color: coral;
        }
        /*鼠标未释放的颜色*/
        a:active{
            color: limegreen;
        }
        /*text-shadow: 阴影颜色 水平偏移 垂直偏移 阴影半径;*/
        #happy{
            text-shadow: orangered 10px -10px 2px;
        }
    </style>

</head>
<body>

<a href="#">
    <img src="image/avatar.jpg" width="100" height="100" alt="">
</a>
<p>
    <a href="#">QQ头像</a>
</p>
<p>
    <a href="#">用户：jonah</a>
</p>
<p id="happy">
    快乐！
</p>

</body>
</html>
```

## 3.6 列表

**index.html**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="css/style.css" type="text/css">
    
</head>
<body>

<div id="nav">
    <h2 class="title">分类测试</h2>
    <ul>
        <li><a href="#">A</a>&nbsp;&nbsp;<a href="#">B</a>&nbsp;&nbsp;<a href="#">C</a></li>
        <li><a href="#">D</a>&nbsp;&nbsp;<a href="#">E</a>&nbsp;&nbsp;<a href="#">F</a></li>
        <li><a href="#">G</a>&nbsp;&nbsp;<a href="#">H</a>&nbsp;&nbsp;<a href="#">I</a></li>
        <li><a href="#">J</a>&nbsp;&nbsp;<a href="#">K</a>&nbsp;&nbsp;<a href="#">L</a></li>
        <li><a href="#">M</a>&nbsp;&nbsp;<a href="#">N</a>&nbsp;&nbsp;<a href="#">O</a></li>
        <li><a href="#">P</a>&nbsp;&nbsp;<a href="#">Q</a>&nbsp;&nbsp;<a href="#">R</a></li>
        <li><a href="#">S</a>&nbsp;&nbsp;<a href="#">T</a>&nbsp;&nbsp;<a href="#">U</a></li>
        <li><a href="#">V</a>&nbsp;&nbsp;<a href="#">W</a>&nbsp;&nbsp;<a href="#">X</a></li>
    </ul>
</div>

</body>
</html>
```

**style.css**

```css
/*
list-style:
    none：去原点。
    circle：空心圆。
    decimal：数字。
    square：正方形。
*/
#nav{
    width: 300px;
    background: greenyellow;
}

.title{
    font-size: 18px;
    font-weight: bold;
    text-indent: 1em;
    line-height: 35px;
    background: #ff0b2f;
}

ul li{
    height: 30px;
    list-style: none;
    text-indent: 1em;
}

a{
    text-decoration: none;
    font-size: 14px;
    color: black;
}

a:hover{
    color: orange;
    text-decoration: underline;
}
```

## 3.7 背景

背景图片：

```html
<style>
    div{
        width: 1000px;
        height: 700px;
        border: 1px solid red;/*边框*/
        background-image: url("image/0.png");
    }
    .div1{
    	background-repeat: repeat-x;/*水平平铺*/
    }
    .div2{
    	background-repeat: repeat-y;/*竖直平铺*/
    }
    .div3{
    	background-repeat: no-repeat;/*不平铺*/
    }
</style>
```

## 3.8 渐变

径向渐变 

圆形渐变
http://grabient.com/

```html
<style>
    body{
        background-color: #4158D0;
        background-image: linear-gradient(43deg, #4158D0 0%, #C850C0 46%, #FFCC70 100%);
    }
</style>
```

# 四、盒子模型

## 4.1盒子模型

margin：外边距

padding：内边距

border：边框

## 4.2 边框

1. 边框的粗细
2. 边框的样式
3. 边框的颜色

```html
<style>
    #box{
        width: 300px;
        border: 1px solid red;
    }
    h2{
        font-size: 16px;
        background: coral;
        line-height: 30px;
        color: white;
    }
    form{
    	background: cadetblue;
    }
    div:nth-of-type(1) input{
    	border: 3px solid black;/*实线*/
    }
    div:nth-of-type(2) input{
    	border: 1px dashed limegreen;/*虚线*/
    }
    div:nth-of-type(3) input{
    	border: 1px dashed orange;
    }
</style>
```

## 4.3 内外边距

**盒子的计算方式：margin+border+padding+内容宽度**

```html
<style>
    #box{
        width: 300px;
        border: 1px solid red;
        margin: 0 auto;
    }
    h2{
        font-size: 16px;
        background: coral;
        line-height: 30px;
        color: white;
        margin-top: 0;//上外边距
        margin-bottom: 0;//下外边距
        /*
        margin: 0 1px 2px 3px;//上右下左（顺时针）
        */
    }
    form{
        background: cadetblue;
    }
    div:nth-of-type(1) input{
        border: 3px solid black;/*实线*/
        padding: 10px 2px;//上下内边距10，左右内边距2
    }
    div:nth-of-type(2) input{
        border: 1px dashed limegreen;/*虚线*/
    }
    div:nth-of-type(3) input{
        border: 1px dashed orange;
    }
</style>
```

## 4.4 圆角边框

```html
<style>
    /*扇形*/
    div{
        width: 100px;
        height: 50px;
        margin: 30px;
        border: 10px solid orangered;
        background: orange;
        border-radius: 100px 100px 0 0;
    }
    /*圆形头像*/
    img{
        border-radius: 320px;
    }
</style>
```

## 4.5 阴影

https://element.eleme.cn/#/zh-CN

https://ice.work/

```html
<!--
 margin：0 auto;居中要求：外面是一个块元素，块元素有固定的宽度，body有无限宽度
 一般和text-align：center 配合使用
-->
<style>

    div{
        width: 1000px;
        height: 500px;
        text-align: center;
    }
    img{
        border-radius: 100px;
        box-shadow: 10px 10px 100px yellow;
        margin: 0 auto;
        text-align: center;
    }
</style>
```

# 五、浮动

## 5.1 标准文档流

块级元素：独占一行

```
h1~h6 p div 列表
```

行内元素：不独占一行

```
span a img strong...
```

行内元素可以包含在块级元素中。

## 5.2 display

**实现行内元素排列的一种方式**，但更多使用float。

```html
<!--display:
            block;块元素
            inline;行内元素
            inline-block;是块元素，但是可以内联，在同一行
            none;不显示
-->
<style>
    div{
        width: 100px;
        height: 100px;
        border: red solid 1px;
        display: inline;
    }
    span{
        width: 100px;
        height: 100px;
        border: red solid 1px;
        display: inline-block;
    }
</style>
```

## 5.3 float

左右浮动

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        div{
            margin: 10px;
            padding: 5px;
        }
        #father{
            border: 1px solid red;
        }

        .layer01{
            border: 1px dashed black;
            display: inline-block;
            float: left;
        }

        .layer02{
            border: 1px dashed green;
            display: inline-block;
            float: left;
        }

        .layer03{
            border: 1px dashed blue;
            display: inline-block;
            float: left;
        }

        .layer04{
            border: 1px dashed paleturquoise;
            font-size: 12px;
            line-height: 23px;
            display: inline-block;
            float: left;
            /*清除浮动*/
            clear: both;
        }
    </style>

</head>
<body>
<div id="father">
    <div class="layer01"><img src="image/0.png" alt=""></div>
    <div class="layer02"><img src="image/0.png" alt=""></div>
    <div class="layer03"><img src="image/0.png" alt=""></div>
    <div class="layer04"><img src="image/0.png" alt=""></div>
</div>
</body>
</html>
```

## 5.4 父集元素塌陷

clear

```html
clear:right;右侧不允许有浮动元素
clear:left;左侧不允许有浮动元素
clear:both;两侧不允许有浮动元素
clear:none;
```

解决方案：

1. 增加父级元素高度

```html
/*方法一：增加父级元素高度*/
#father{
    border: 1px solid red;
    height: 800px;
}
```

2. 增加空的div标签，清除浮动。

```html
<div class="clear"></div>

.clear{
    clear: both;
    margin: 0;
    padding: 0;
}
```

3. overflow

```html
在父级元素中增加一个overflow属性
overflow:hidden;
```

4. 伪类

```
/*最优解：同2（增加空div）*/
#father:after{
	content:'';
	dispaly:block;
	clear:both;
}
```

总结（重点）：

 	1.	浮动元素后面增加空div
     - 简单，但代码中应尽量避免空div
	2.	设置父元素高度
    - 简单，但元素假设了固定高度，将被限制。
	3.	overflow
    - 简单，但应避免在下拉场景使用。
	4.	父类增加伪类：after（最优解）
    - 无需修改源码。

## 5.5 对比

- display：方向不可控
- float：将脱离标准文档流，需要解决父级边框塌陷问题。

# 六、定位

## 6.1 相对定位

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        body{
            padding: 20px;
        }
        div{
            margin: 10px;
            padding: 5px;
            font-size: 12px;
            line-height: 25px;
        }
        #father{
            border: 1px solid limegreen;
            padding: 5px;
        }
        #first{
            background-color: #FFCC70;
            border: 1px solid green;
            position: relative;/*相对定位：上下左右*/
            top: -20px;
            left: 20px;

        }
        #second{
            background-color: deepskyblue;
            border: 1px solid deepskyblue;
        }
        #third{
            background-color: bisque;
            border: 1px solid orange;
        }

    </style>

</head>
<body>

<div id="father">
    <div id="first">盒子一</div>
    <div id="second">盒子二</div>
    <div id="third">盒子三</div>
</div>

</body>
</html>
```

相对定位：position:relative

相对原来的位置，进行指定的偏移，原来的文档流中仍然会保留原来的位置。

```
top:-20px;
left:20px;
bottom:-10px;
right:20px;
```



## 6.2 绝对定位

定位：基于xxx定位，上下左右

1. 没有父级元素定位的前提下，相对于浏览器定位。
2. 假设父级元素定位，相对于父级元素进行偏移。

3. 在父级元素范围内移动，相对于父级或浏览器的位置，进行指定的偏移，绝对定位不在标准文档流中，原来的位置会被覆盖。

```html
<style>
    body{
        padding: 20px;
    }
    div{
        margin: 10px;
        padding: 5px;
        font-size: 12px;
        line-height: 25px;
    }
    #father{
        border: 1px solid limegreen;
        padding: 5px;
        position: relative;
    }
    #first{
        background-color: #FFCC70;
        border: 1px solid green;
    }
    #second{
        background-color: deepskyblue;
        border: 1px solid deepskyblue;
        position: absolute;
        left: 300px;
    }
    #third{
        background-color: bisque;
        border: 1px solid orange;
    }

</style>
```

## 6.3 固定定位

```html
<style>
    body{
        height: 1000px;
    }
    div:nth-of-type(1){/*绝对定位：相对于浏览器*/
        width: 100px;
        height: 100px;
        background: orangered;
        position: absolute;
        right: 0;
        bottom: 0;
    }
    div:nth-of-type(2){/*fixed，固定定位*/
        width: 50px;
        height: 50px;
        background: orange;
        position: fixed;
        right: 0;
        bottom: 0;
    }
</style>
```

应用：网页中的返回顶部。

## 6.4 zindex

z-index：默认为0，最高999（只针对浮动元素）

```css
#content{
    width: 378px;
    padding: 0px;
    margin: 0px;
    overflow: hidden;
    font-size: 12px;
    line-height: 25px;
    border: 1px solid orange;
}
ul,li{
    padding: 0px;
    margin: 0px;
    list-style: none;
}
/*父级元素相对定位*/
#content ul{
    position: relative;
}
.tipText,.tipBg{
    position: absolute;
    width: 378px;
    top: 195px;
    height: 25px;
}
.tipText{
    color: white;
    z-index: 999;
}
.tipBg{
    background: darksalmon;
    opacity: 0.5;
}
```

# 七、动画与视野扩展

runoob.com