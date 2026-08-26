import express from 'express';
import {create, geAll, getOne} from '../controllers/lecturerControler.js';

const route = express.Router();

route.post("/create",create);
route.get("/getAllUsers",getAll);
route.get("/getAllUsers/:id",getAll);

export default route;