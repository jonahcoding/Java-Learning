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

