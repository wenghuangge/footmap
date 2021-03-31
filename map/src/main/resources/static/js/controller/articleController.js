angular.module('myApp', ['ui.bootstrap', 'ngAnimate']).controller('articleCtrl', function ($location,$scope,$http) {
    //图片轮播
    $scope.myInterval = 2000;
    $scope.noWrapSlides = false;
    var slides = $scope.slides = [];
/*    $scope.addSlide = function () {
        var newWidth = 600 + slides.length + 1;
        slides.push({
            imaage: 'http://steamcommunity-a.akamaihd.net/economy/image/U8721VM9p9C2v1o6cKJ4qEnGqnE7IoTQgZI-VTdwyTBeimAcIoxXpgK8bPeslY9pPJIvB5IWW2-452kaM8heLSRgleGArrBBwe94OfEh0bOlAlopvOVPAWe3GEKAgj6ULuupkVhtYZ0pIxzzk5gY59xSWJ95SOIxsbCuJg/1280x800',
            text: 'Chocola & Vanilla',
        });
        slides.push({
            image: 'http://steamcommunity-a.akamaihd.net/economy/image/U8721VM9p9C2v1o6cKJ4qEnGqnE7IoTQgZI-VTdwyTBeimAcIoxXpgK8bPeslY9pPJIvB5IWW2-452kaM8heLSRgleGArrBBwe94PqYvguSpXFVwv-URAD3mGBHRgzaceuqqk1BlN5IrcUvxlp8d5t8BX595SOKdq0CMpw/1280x800',
            text: 'Chocola & Vanilla',
        });
        slides.push({
            image: 'http://cdn.steamcommunity.com/economy/image/U8721VM9p9C2v1o6cKJ4qEnGqnE7IoTQgZI-VTdwyTBeimAcIoxXpgK8bPeslY9pPJIvB5IWW2-452kaM8heLSRgleGArrBBwe94PqUrgrStA1tw6OZBXGTgH0fQ1j-WeOeskQUxYcYuI02hkpgYuNZRW595SOLioa6j6w/1280x800',
            text: 'Chocola & Vanilla',
        });
        slides.push({
            image: 'http://steamcommunity-a.akamaihd.net/economy/image/U8721VM9p9C2v1o6cKJ4qEnGqnE7IoTQgZI-VTdwyTBeimAcIoxXpgK8bPeslY9pPJIvB5IWW2-452kaM8heLSRgleGArrBBwe94aqAq0-T4CVtyvLEUV2C1F0jU3mOTfrqqwlM0McZ9cBv0yckdvNxTUJ95SOId8xoS5w/1280x800',
            text: 'Chocola & Vanilla',
        });
    };
    $scope.addSlide();*/
    //参数解析
    $scope.getParam=function(){
        var urlValue='';
        var href = location.href;
        urlValue = href.substr(href.indexOf("=") + 1);
        console.log("获取参数:"+urlValue);
        return urlValue;
    };
    $scope.photoId=$scope.getParam();

    //获取照片详情
    $scope.photoDetail=function (photoId){
        $http.get("/photo/detail?id="+photoId).then(function (response){
            $scope.photo=response.data;
            $scope.slides=[];
            console.log($scope.photo);
            for(var i=0;i<$scope.photo.imgList.length;i++){

                $scope.slides.push({
                    image: $scope.photo.imgList[i]
                });
            }


        });
    }


});