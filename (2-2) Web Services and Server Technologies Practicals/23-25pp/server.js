import expres from 'express';
import mongoose from 'mongoose';
import dotenv from 'dotenv';
import bodyParser from 'body-parser';

import Suroute from './routers/subjectRouter.js';
import lecroute from './routers/lecturerRouter.js';
import { error } from 'node:console';

const app = expres();

app.use(bodyParser.json());

dotenv.config();

const PORT = process.env.PORT || 3000;
const MONGO_URL = process.env.MONGO_URL;

mongoose
.connect(MONGO_URL)

.then(()=>{
    console.log("Database connected successfully");

    app.listen(PORT,()=>{
        console.log(`Server is running on ${PORT}`);
    })
})

.catch((error)=>console.log(error));

app.use("/subject",Suroute);
app.use("/lecturer",lecroute);