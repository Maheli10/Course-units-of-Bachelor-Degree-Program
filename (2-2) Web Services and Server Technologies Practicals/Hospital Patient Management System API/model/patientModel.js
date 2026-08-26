import mongoose from 'mongoose';

const patientSchema =  new mongoose.Schema({
    name:{
        type: String,
        required: true,
    },
    age:{
        type: Number,
        required: true,
    },
    disease: {
        type: String,
        required: true,
    },
    doctor:{
        type: String,
    },
    admittedDate:{
        type: Date,

    },
});
export default mongoose.model("patient",patientSchema);