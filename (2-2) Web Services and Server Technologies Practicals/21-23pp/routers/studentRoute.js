import express from "express";

import {create, fetch} from "../controllers/studentController.js";

const studentroute = express.Router();

studentroute.post("/create",create);
studentroute.get("/get",fetch);

export default studentroute;