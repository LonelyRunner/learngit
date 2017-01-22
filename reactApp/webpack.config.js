var config = {
	//ָ�����������ļ�main.js
	entry: './main.js',
	//���ô�����,path������������ļ���,filename�����˴������ļ�������
	output:{
		path:'./',
		filename:'index.js'
	},
	//���÷������˿ں�Ϊ7777
	devServer:{
		inline:true,
		port:7777
	},
	//�����˶�ģ��Ĵ����߼�
	//loaders������һϵ�еļ�����������Ҫ���ص��ļ�ƥ��test����ʱ��
	//�ͻ���ú���loader���ļ����д���
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

//��cofig����¶��ȥ
module.exports = config;