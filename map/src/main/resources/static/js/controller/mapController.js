var app=angular.module("myMap",[]);

app.controller("photoCtr",function ($scope,$http,$location) {
    $scope.starttime=0;
    $scope.endtime=0;
    $scope.cityname="无";
    $scope.getParam = function () {
        var urlValue='';
        var href = location.href;
        urlValue = href.substr(href.indexOf("=") + 1);
        var params = href.split("&");
        if(params.length==2) {
            $scope.starttime = params[0].substr(href.indexOf("=") + 1);
            $scope.endtime = params[1].substr(href.indexOf("=") + 1);
        } else {
            $scope.starttime = 0;
            $scope.endtime=999999999999999;
        }
    };
    $scope.getParam();
    $scope.detail=function (photoId){
        var hre="/map/article.html?id="+photoId;
        location.href=hre;
    };
    $scope.$watch('cityname',function (newValue,OldValue){
        if(typeof newValue=="undefined") return;
        console.log("点击事件切换了新的城市"+newValue);
        $http.get("/photo/city?cityname="+newValue).then(function (response) {
            $scope.photos=response.data;
            var cnt = 0;
            $scope.photos_temp=[];
            for(var i=$scope.photos.length-1;i>=0;i--){
                if(parseInt($scope.photos[i].time)>=parseInt($scope.starttime) && parseInt($scope.photos[i].time)<=parseInt($scope.endtime)){
                    $scope.photos_temp[cnt] = $scope.photos[i];
                    $scope.photos_temp[cnt].simcon=$scope.contentchange($scope.photos_temp[cnt].content);
                    cnt++;
                }

            }
            $scope.photos = $scope.photos_temp;
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

        })
    };
    $scope.getVisitCity();

    $scope.changeCity=function (cityname){
        $scope.cityname=cityname;
    }

    $scope.refresh = function () {
        var t1 = document.getElementById("start").value;
        var date = new Date(t1);
        var start = date.getTime();

        var t2 = document.getElementById("today").value
        var date2 = new Date(t2);
        var end = date2.getTime();
        window.location="/map/map.html?start="+start+"&end="+end;
    }
})

