var app=angular.module("myMap",[]);
app.controller("photoCtr",function ($scope,$http) {

    $scope.detail=function (photoId){
        var hre="/map/article.html?id="+photoId;
        location.href=hre;
    };
    $scope.$watch('cityname',function (newValue,OldValue){
        if(typeof newValue=="undefined") return;
        console.log("点击事件切换了新的城市"+newValue);
        $http.get("/photo/city?cityname="+newValue).then(function (response) {
            $scope.photos=response.data;
            for(var i=0;i<$scope.photos.length;i++){
                $scope.photos[i].simcon=$scope.contentchange($scope.photos[i].content)
            }
            console.log("切换城市数据:");
            console.log($scope.photos);
        })
    },true)

    $scope.contentchange=function (content){
        var s="";
        for(var i=0;i<content.length;i++){
            s+=content.charAt(i);
            if(i>=10){
                s+="...";
                break;
            }
        }
        return s;
    };
    $scope.getVisitCity=function (){
        $http.get("/photo/visitcity").then(function (response){
            $scope.citys=response.data;
            $scope.cityname=$scope.citys[0].city;
            console.log($scope.citys);
        });
    };
    $scope.getVisitCity();

    $scope.changeCity=function (cityname){
        $scope.cityname=cityname;
    }
})

