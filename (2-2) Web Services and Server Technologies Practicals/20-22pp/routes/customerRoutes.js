import express from 'express';

import{ create, fetch, updateCus, deleteCus} from '../controller/customerController.js';

const route = express.Router();

route.get("/getallcustomers", fetch);
route.post("/create",create);
route.put("/update/:id",update);
route.delete("/delete/:id",deleteCus);

export default route ;  