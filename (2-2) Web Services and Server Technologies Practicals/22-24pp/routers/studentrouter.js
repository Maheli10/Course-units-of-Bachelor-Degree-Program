import express from 'express';

import {create, getAll, getId} from '../controllers/studentcontroller.js';

const studentroute = express.Router();

studentroute.post("/create",create);
studentroute.get("/getId/:id",getId);
studentroute.get("/getAll",getAll);

export default studentroute;

