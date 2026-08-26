import mongoose from 'mongoose';

const vanSchema = new mongoose.Schema({
    customerID: {
        type: Number,
        required: true,
        },
    vanID:{
        type: Number,
        required: true,
    },
    rentedOn: {
        type: Date,

    },
    numberOfDays: {
        type: Number,
    },
});

export default mongoose.models("Vans",vanSchema);