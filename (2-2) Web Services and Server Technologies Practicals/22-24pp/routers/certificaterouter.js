import express from 'express';

import {create, getAll, getId} from '../controllers/certificatecontroller.js';

const certificateroute = express.Router();

certificateroute.post("/create",create);
certificateroute.get("/getId/:id",getId);
certificateroute.get("/getAll",getAll);

export default certificateroute;

