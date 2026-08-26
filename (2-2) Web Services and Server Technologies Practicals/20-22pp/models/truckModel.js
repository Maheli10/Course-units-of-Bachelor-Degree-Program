import mongoose from 'mongoose';
import customer from './customermodel';

const truckSchema= new mongoose.Schema({
    customerID :{
        type: Number,
        required: true,
    },
    truckID:{
        type:Number,
        required: true,
    },
    rentedOn:{
        type: Date,
        required: true,
    },
    numberOfDays:{
        type: Number,
    },
});

export default mongoose.models("trucks", truckSchema);