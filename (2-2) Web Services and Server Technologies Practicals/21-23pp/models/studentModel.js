import mongoose from 'mongoose';

const studentSchema = new mongoose.Schema({
    registrationNumber: {
        type:String,
        required: true,
    },
    name: {
        type:String,
        required: true,
    },
    age : {type:Number,
        required: true,
    },
    major : {
        type:String,
        required: true,
    },
})

export default mongoose.model("student", studentSchema);