angular.module('myApp', []).controller('articleCtrl', function ($location,$scope,$http) {
    //参数解析
    $scope.getParam=function(){
        var urlValue='';
        var href = location.href;
        urlValue = href.substr(href.indexOf("=") + 1);
        console.log("获取参数:"+urlValue);
        return urlValue;
    };

    //获取照片详情
    $scope.photoDetail=function (photoId){
        $http.get("/photo/detail?id="+photoId).then(function (response){
            $scope.photo=response.data;
            console.log($scope.photo);
        });
    }
    $scope.photoId=$scope.getParam();
    $scope.photoDetail($scope.photoId);


});