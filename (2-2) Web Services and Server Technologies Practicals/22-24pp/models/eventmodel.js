import mongoose from 'mongoose';

const eventSchema = new mongoose.Schema({
    id:{
        type:String,
        required: true,
    },
    date:{
        type:Date,
        required: true,
    },
    description:{
        type:String,
        required: true,
    },
    name:{
        type:String,
        required: true,
    },
    organizer:{
        type:String,
        required: true,
    },
});

export default mongoose.model("events",eventSchema);