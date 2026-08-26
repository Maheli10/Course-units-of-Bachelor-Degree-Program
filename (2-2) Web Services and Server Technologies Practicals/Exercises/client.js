const http = require('http');

const options={
    host: 'localhost',
    port:8000,
    path: '/student?id=25'
};

var callback = function(response){
    var body= "";

    response.on('data',function(data){
        body+= data;
    });

    response.on('end',function(){
        console.log("Server responsed");
        console.log(body);
        
    });
    response.on('err',function(err){
        console.log(err);
    })
};

var req = http.request(options,callback);
req.end();