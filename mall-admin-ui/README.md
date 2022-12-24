https://nodejs.org/en/
https://vuejs.org/
https://unpkg.com/browse/axios@1.1.2/

```javascript
// 配置国内镜像
npm config set registry https://registry.npm.taobao.org
npm config list

// 初始化
npm init
npm init -y 

// 安装包
npm install packge_name // 安装指定类库
npm install // 安装配置文件的类库

// 全局安装
npm install --global package_name
npm install -g package_name 

// 开发安装
npm install --save-dev package_name 
npm install -D package_name 

// 更新
npm update package_name
npm update -g package_name

// 卸载
npm uninstall package_name
npm uninstall -g package_name
```

##### 转码babel

```javascript
// nodejs 无法直接执行模块化的代码，需要转换为es5，使用babel转换
npm install -g babel-cli
babel --version

// 编写.babelrc, 放置在项目的根目录下
{
    "presets": ["es2015"],
    "plugins": []
}

// 安装转码器
npm install -D babel-preset-es2015

// 转码
babel src -d dist
```

##### webpack打包
```javascript
// 安装工具
npm install -g webpack webpack-cli

webpack --mode=development

// 安装css打包工具
npm install -D style-loader css-loader

webpack --mode=development

```