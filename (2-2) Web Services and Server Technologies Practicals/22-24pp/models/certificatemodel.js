import mongooose from 'mongoose';

const certificateSchema = new mongooose.Schema({
    id:{
        type:String,
        required: true,
    },
    detail:{
        type:String,
        required: true,
    },
    eventId:{
        type:String,
        required: true,
    },
    studentId:{
        type:String,
        required: true,
    },
    isssuedDate:{
        type:Date,
        required: true,
    },
});

export default mongooose.model("cetificates",certificateSchema);