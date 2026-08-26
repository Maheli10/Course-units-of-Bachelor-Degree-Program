const http = require('http');
const querystring = require("querystring"); 
const url = require("url"); 

var arr= [
    ['23','Saduni',3.6],
    ['24','Sarani',3.7],
    ['25','Amal',2.6],
    ['26','Saman',3.3],
    ['27','Kamal',3.5]
] ;

function searchStudent(id){
    let flag = false;
    let student = null;
    
    for(let i=0; i<arr.length; i++){
        student= arr[i];

        if(student[0]==id){
            flag=true;
            break;
        }
    }
    if(flag== true){
        return "Student found. Student name is "+ student[1];
    }
    else{
        return "404,Student not found";
    }
}

http.createServer(function(request,response){
    let parseUrl = url.parse(request.url);
    let parseQs = querystring.parse(parseUrl.query);

    let std = parseQs['id'];
    response.writeHead(200,{'content-type' : 'text/html'});

    response.write(searchStudent(std));
    response.end();
    
}).listen(8000);

console.log("Server is running in port 8000")