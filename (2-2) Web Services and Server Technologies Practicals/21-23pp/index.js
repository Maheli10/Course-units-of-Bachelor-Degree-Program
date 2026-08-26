import express from 'express';
import mongoose from 'mongoose';
import dotenv from 'dotenv';
import bodyParser from 'body-parser';

import studentroute from './routers/studentRoute.js';
import borowingroute from './routers/borrowingRoute.js';

dotenv.config();

const app= express();

app.use(bodyParser.json());


const PORT = process.env.PORT || 5000;
const MONGOURL = process.env.MONGOURL;

mongoose
.connect(MONGOURL)
.then(()=>{
    console.log("Database connected successfully");

    app.listen(PORT, ()=>{
        console.log(`server is running on port ${PORT}`);
    });
})
.catch((error)=> console.log(error));


app.use("/student",studentroute);
app.use("/books", borowingroute);
