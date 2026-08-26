import express from 'express';
import mongoose from "mongoose";
import bodyParser from 'body-parser';
import dotenv from "dotenv";

import route from "./routes/patientRoutes.js";

const app= express();
app.use(bodyParser.json());

dotenv.config();
const PORT = process.env.PORT || 5000;
const MONGOURL = process.env.MONGOURL;

mongoose
.connect(MONGOURL)
.then(()=>{
    console.log("Database connected succssfully");
    app.listen(PORT,()=>{
        console.log(`server is runing on ${PORT}`);
    });
})
.catch((error)=> console.log(error));

app.use("/api/patient",route);

