import mongoose from 'mongoose';

const customerSchema = new mongoose.Schema({

    id:{
        type: Number,
        required: true,
    },
    name:{
        type: String,
        required: true,
    },
    address:{
        type: String,
        required: true,
    },
    nmberOfVans:{
        type: Number,
        required: true,
    },
    numberOfTrucs:{
        type: Number,
        required: true,
    },
    totalRent:{
        type: Number,
        required: true,
    },

}); 

export default mongoose.models("customers", customerSchema);