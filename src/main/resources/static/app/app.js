var app = angular.module('learn', ['ui.router']);
var url = 'http://localhost/learning/le-admin/';
app.config(['$urlRouterProvider', '$stateProvider', function ($urlRouterProvider, $stateProvider) {
    $urlRouterProvider.otherwise('/');

    $stateProvider
        .state('home', {
            url: '/',
            templateUrl: 'template/home.html'

        })
    $stateProvider
        .state('features', {
            url: '/features',
            templateUrl: 'template/features.html'

        })
    $stateProvider
        .state('why', {
            url: '/why',
            templateUrl: 'template/why.html'

        })
    $stateProvider
        .state('support', {
            url: '/support',
            templateUrl: 'template/support.html'

        })
    $stateProvider
        .state('contact', {
            url: '/contact',
            templateUrl: 'template/contact.html'

        })
    $stateProvider
        .state('buy', {
            url: '/buy',
            templateUrl: 'template/buy.html'

        })

    $stateProvider
        .state('buy1', {
            url: '/buy1',
            templateUrl: 'template/buy1.html'

        })
    $stateProvider
        .state('payment', {
            url: '/payment',
            templateUrl: 'template/payment.html'

        })
}])


app.controller('homeCtrl', function ($scope, $http) {

    setTimeout(function () {
        $('#da-slider').cslider({
            autoplay: true,

            interval: 3000
        });
        $.material.init();
    }, 300)

})


function emailCheck(id) {
    var x = $("#" + id).val();
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    $("#" + id).css("background-color", "#fff");
    if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
        $("#" + id).addClass('serr');
        $("#" + id).val('');
    } else {
        $("#" + id).removeClass('serr');
    }
}


function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode;

    if (charCode > 31 && (charCode < 48 || charCode > 57) || charCode.length > 10)
        return false;
    return true;
}




