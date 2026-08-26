import express from 'express';

import {create, getAll, getId} from '../controllers/eventcontroller.js';

const eventroute = express.Router();

eventroute.post("/create",create);
eventroute.get("/getId/:id",getId);
eventroute.get("/getAll",getAll);

export default eventroute;

