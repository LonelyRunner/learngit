var config = {
	//指定打包的入口文件main.js
	entry: './main.js',
	//配置打包结果,path定义了输出的文件夹,filename定义了打包结果文件的名称
	output:{
		path:'./',
		filename:'index.js'
	},
	//设置服务器端口号为7777
	devServer:{
		inline:true,
		port:7777
	},
	//定义了对模块的处理逻辑
	//loaders定义了一系列的加载器。当需要加载的文件匹配test正则时，
	//就会调用后面loader对文件进行处理
	module:{
		loaders:[
			{
				test: /\.jsx?$/,
				exclude: /node_modules/,
				loader: 'babel',
				query:{
					presets:['es2015','react']
				}
			}
		]
	}
};

//将cofig对象暴露出去
module.exports = config;