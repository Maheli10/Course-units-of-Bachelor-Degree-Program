import express from "express";

import { create, fetch, update, deletePatient } from "../controller/patientController.js" ;

const router = express.Router();

router.get("/getAll", fetch);
router.post("/create", create);
router.put("/update/:id", update);
router.delete("/delete/:id", deletePatient);


export default router;