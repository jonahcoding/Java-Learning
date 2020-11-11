- 创建用户： adduser username

- 设置密码： passwd username

- 授权sudo权限：vim /etc/sudoers

  ```
  文件内容改变如下：
  root ALL=(ALL) ALL 已有行
  username ALL=(ALL) ALL 新增行
  ```



