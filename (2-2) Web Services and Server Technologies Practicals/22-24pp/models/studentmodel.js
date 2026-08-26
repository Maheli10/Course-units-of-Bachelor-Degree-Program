import mongoose from 'mongoose';

const StudentSchema = new mongoose.Schema({
    registrationNo:{
        type:String,
        required: true,
    },
    degree:{
        type:String,
        required: true,
    },
    faculty:{
        type:String,
        required: true,
    },
    firstName:{
        type:String,
        required: true,
    },
    lastName:{
        type:String,
        required: true,
    },
});

export default mongoose.model("Students",StudentSchema);