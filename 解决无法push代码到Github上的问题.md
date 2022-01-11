当我配置好了Github账号，准备将自己的项目分享到Github上的时候，报了如下错误：
> 15:37	Can't finish GitHub sharing process 
> Successfully created project 'git' on GitHub, but initial push failed;
> unable to access 'https://github.com/fau152/git.git/': Failed to connect to github.com port 443 after 21061 ms: Timed out

该错误出现的原因是：访问超时，就是网络不好。

# 解决过程
## 一、 取消勾选clone git repostiries use ssh
![img.png](image/%20mdImg2/img.png)
检查之后发现并发生此错误的时候并没有勾选该选项，所以排除这个可能

## 二、取消http/https代理
如果之前有在git的配置文件中配置过http/https代理的话，可以执行该语句取消该配置
```gitexclude
#取消http代理
git config --global --unset http.proxy
#取消https代理 
git config --global --unset https.proxy
```
也可以打开 用户目录下的.gitconfig配置文件，手动删除proxy相关的配置即可
需要注意的是，上面说的用户目录下的.gitconfig配置文件时全局作用域的配置文件，我们项目的局部配置文件的位置是.git/config文件，局部配置文件的优先级大于全局配置文件，所以这两个文件的配置都要检查

但是我的配置文件很干净，没有多余的东西：
全局配置文件.gitconfig配置如下：
```gitexclude
[user]
	name = wanglong
	email = long20q19@163.com
[core]
	excludesfile = C:/Users/wangl/git.ignore
```
局部配置文件.git/config配置如下：
```gitexclude
[core]
	repositoryformatversion = 0
	filemode = false
	bare = false
	logallrefupdates = true
	symlinks = false
	ignorecase = true
```
所以也不是这个原因
## 三、网络问题，访问不到
一开始，我没有怀疑是这个问题，因为我使用了dev-sidecar，浏览器访问github官网是可以正常访问的。
但是我在git-bash和命令行中分别执行`ping github.com`都是超时，ping不通的，所以我就确定了应该是网络问题导致无法push

参考https://blog.csdn.net/qq_34817440/article/details/106420689的博客
1. 首先使用https://www.ipaddress.com/查询`github.com`和`github.global.ssl.fastly.net`的ip地址
2. 直接ping他们的ip地址是可以ping的通的。
3. 然后在C:\Windows\System32\drivers\etc\hosts的文件中配置了这两个ip地址
```gitexclude
# Copyright (c) 1993-2009 Microsoft Corp.
#
# This is a sample HOSTS file used by Microsoft TCP/IP for Windows.
#
# This file contains the mappings of IP addresses to host names. Each
# entry should be kept on an individual line. The IP address should
# be placed in the first column followed by the corresponding host name.
# The IP address and the host name should be separated by at least one
# space.
#
# Additionally, comments (such as these) may be inserted on individual
# lines or following the machine name denoted by a '#' symbol.
#
# For example:
#
#      102.54.94.97     rhino.acme.com          # source server
#       38.25.63.10     x.acme.com              # x client host

# localhost name resolution is handled within DNS itself.
#	127.0.0.1       localhost
#	::1             localhost
127.0.0.1       activate.navicat.com

# Github Start
140.82.112.4    github.com
199.232.69.194  github.global.ssl.fastly.net
```
注意：只有最后三行是自己添加的，前面的都不要改
4. 配置完hosts文件之后，`ping github.com`就能ping通了，之后再进行push等操作就可以执行成功了。