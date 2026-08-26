function execute(a,b,cb){
    var result= a+b;
    setTimeout(function(){cb(result);},3000)
}

execute(5,10,function(resultData){console.log(resultData/2);});