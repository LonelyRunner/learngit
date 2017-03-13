var myApp = angular.module("myApp",['ngGrid']);

myApp.controller("myController",["$scope","$http",function($scope,$http){
	var baseUri = "http://localhost:8080/easyJersey";
	
	$scope.selectedItems = [];
	$scope.showModal = showModal;
	
	//第一次加载页面是modal为隐藏
	$scope.showOrHidden = false;
	
	//保存新的User
	$scope.saveNewUser = saveNewUser;
	
	//关闭modal
	$scope.closeModal = closeModal;
	
	//删除指定User
	$scope.deleteUser = deleteUser;
	
	//需要在grid展示的数据
	$scope.dataList = [];
	
	//新添加的人员信息
	$scope.newUser = {
			name : '',
			age : '',
			gender : ''
	};
	
	//grid配置
	$scope.gridOption = {
			i18n: 'zh-cn',
	        data: 'dataList',
	        enableColumnResize: true,
	        columnDefs: 'colDefs',
	        selectedItems:$scope.selectedItems
	};
	
	$scope.colDefs = [
	                  {field:'name',displayName:'姓名'},
	                  {field:'age',displayName:'年龄'},
	                  {field:'gender',displayName:'性别'}
	            ];
	
	activate();
	
	//初始化grid中的数据
	function activate(){
		$http({
				url:baseUri+'/rest/userService/getUser',
				method:'GET'
			}).success(function(data,header,config,status){
			//响应成功
				$scope.dataList = data;
			}).error(function(data,header,config,status){
			//处理响应失败
				alert("获取数据失败...");
			});
	};
	
	//控制modal框的显示或者隐藏
	function showModal(){
		$scope.showOrHidden = true;
	}
	
	//保存新User
	function saveNewUser(){
		//先校验姓名是否为空  避免保存的数据主键为空
		if(!validateUserName($scope.newUser)){
			console.info("名字不能为空!");
		}else{
			console.info("通过了上层判断");
			$http({
				url:baseUri+"/rest/userService/saveUser",
				method:'post',
				data : $scope.newUser
			})
			.success(function(data){
				activate();
				$scope.newUser = {
						name : '',
						age : '',
						gender : ''
				};
				console.info("保存成功:"+data);
			})
			.error(function(err){
				console.info("保存失败:"+err);
			});
		}
	}
	
	//关闭modal
	function closeModal(){
		$scope.showOrHidden = false;
		$scope.newUser = {
				name : '',
				age : '',
				gender : ''
		};
	}
	
	//校验User的name是否为空
	function validateUserName(newUser){
		if(newUser.name.length === 0){
			alert("名字不能为空");
			return false;
		}
		return true;
	}
	
	//todo 判断user是否重复  这里有一些问题 (淡淡的忧伤)  
	function validateUser(newUser){
		var nameList = [];
		$scope.dataList.forEach(function(item){
			nameList.push(item.name);
		});
		
		if(nameList.indexOf(newUser.name)>0){
			return false;
		}else{
			return true;
		}
	}
	
	function deleteUser(){
		if($scope.selectedItems.length === 0){
			alert("请选中要删除的数据");
		}else{
			console.info($scope.selectedItems);
			$http({
				url:baseUri+'/rest/userService/deleteSelectedUser',
				method:'post',
				data:$scope.selectedItems[0]
			})
			.success(function(data){ console.info(data);})
			.error(function(err){ console.info(err);});
		}
	}
}]);