import mongoose from 'mongoose';
import { type } from 'node:os';

const subjectSchema = new mongoose.Schema({
    _id:{
        type:String,
        required: true,
    },
    name: {
        type : String,
        required: true,
    },
    description: {
        type: String,
    },
    credits:{
        type:Number,
    },
    lecturer:{
        type: mongoose.Schema.Types.ObjectId,
        ref: 'Lecturer'
    },

});

export default mongoose.model("subjects",subjectSchema);