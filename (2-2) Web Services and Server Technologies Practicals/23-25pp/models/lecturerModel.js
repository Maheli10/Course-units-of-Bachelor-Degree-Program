import mongoose from 'mongoose';

const lecSchema = new mongoose.Schema({
    id:{
        type: String,
        required: true,
    },
    name:{
        type:String,
        required:true,
    },
    username:{
        type:String,
        required: true,
    },
    password:{
        type:String,
        required:true,
    },
});

export default mongoose.model("lecturer",lecSchema);