import express from 'express';

import { create, fetch, updateTruck, deleteTruck } from '../controller/truckController.js';

const route = express.Router();

route.post("/create",create);
route.get("/getall", fetch);
route.put("/update", updateTruck);
route.delete("/delete", deleteTruck);

export default route;