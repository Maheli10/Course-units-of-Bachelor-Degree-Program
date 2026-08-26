 arr1=[1,2,3,4,5,6,7];
 arr2=[4,5,6,7,8,9,0];

function mapping(arr){
    for(var i=0; i<arr1.length; i++){
        for(var j=0; j<=i; j++){
            console.log(arr1[i]+arr[j]);
        }
    }
}

function map(arr,callback){
    return callback(arr);
}

map(arr1,mapping);
map(arr2,mapping);

