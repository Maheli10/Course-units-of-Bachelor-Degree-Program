import express from "express";

import {create, fetch,update, deleteBook} from "../controllers/borowingController.js";

const borrowingroute = express.Router();

borrowingroute.post("/create",create);
borrowingroute.get("/get",fetch);
borrowingroute.put("/update/:id",update);
borrowingroute.delete("/delete/:id",deleteBook);

export default borrowingroute;