var app=angular.module("myMap",[]);
app.controller("mapinit",function ($scope,$http) {
    $http.get("/map/map").then(function (response) {
        $scope.photos=response.data;
    })
})
app.controller("photoCtr",function ($scope,$http) {

    $scope.detail=function (a){
        console.log(a);
    };

    $scope.$watch('cityname',function (newValue,OldValue){
        if(typeof newValue=="undefined") return;
        console.log("点击事件切换了新的城市"+newValue);
        $http.get("/photo/city?cityname="+newValue).then(function (response) {
            $scope.photos=response.data;
            console.log("切换城市数据:");
            console.log($scope.photos);
        })
    },true)
})

