function square(a,result){
    area=a*a;
    result(area);
}

square(5,function result(area){
    console.log("area of the square:"+area);
});