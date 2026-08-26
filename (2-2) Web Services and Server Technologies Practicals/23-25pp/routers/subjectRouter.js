import express from 'express';

import {create, getAll,getID, update, deleteOne } from '../controllers/subjectController.js';

const route = express.Router();

route.get('/getSub',getAll);
route.get('/getaSub/:id',getID);
route.post('/create',create);
route.put('/update/:id',update);
route.delete('/deleteOne/:id',deleteOne);

export default route;
