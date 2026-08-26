import mongoose from 'mongoose';

const bookSchema = new mongoose.Schema({
    registrationNumber: {
        type:String,
        required: true,
    },
    bookId: {
        type:String,
        required: true,
    },
    loanDate : {
        type: Date,
        required: true,
    },
    returnDate : {
        type: Date,
        required: true,
    },
    return : {
        type: Boolean,
        required: true,
    },
})

export default mongoose.model("bookBorowing", bookSchema);