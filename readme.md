# 一、导入git
1. 设置->Version Control->Git
2. 选择Path to Git excutable，选择自己本地安装的git.exe程序

# 二、初始化本地库
1. vcs->Create Git Reposity
2. 选择文件夹，就选择本项目的根目录就行
3. 创建完成之后就会发现pom.xml文件变红了，这个和git中的红色文件是一样的，表示未添加到暂存区的文件

# 三、将pom.xml文件添加到暂存区 
## 将单个文件添加到暂存区
点击文件，右键->git->add即添加
## 将整个项目添加到暂存区
选中项目文件夹，右键->git->add
这个时候会弹出提醒：本项目包含git.ignore中配置的忽略文件，问要不要强制add到暂存区？选择canel不强制添加，即可

# 四、将修改后的项目提交到本地库
![img.png](mdImg/img.png)
