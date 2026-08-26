import Book from '../models/borowingModel.js';

export const create = async(req, res)=>{
    try{
        const record = new Book(req.body);
        const {bookId} = req.body;

        const existRecord = await Book.findOne({bookId});

        if(existRecord){
            return res.status(400).json({message: "Record already exists"});
        }
        const savedRecord = await record.save();
        res.status(201).json(savedRecord);
    }
    catch (error){
        res.status(500).json({message : "Internal server error"});
    }
}

export const fetch = async(req, res)=>{
    try{
        const record = await Book.find();
        if(record.length == 0){
            return res.status(404).json({message: "Records not found"});
        }

        res.status(200).json(record);
    }
    catch (error){
        res.status(500).json({message : "Internal server error"});
    }
}

export const update = async(req, res)=>{
    try{
        const id= req.params.id;
        const existrec = await Book.findById({_id: id});

        if(!existrec){
            return res.status(404).json({message: "Record not found"});
        }
        const updatedRec = await Book.findByIdAndUpdate(id, req.body, {new: true});
        res.status(200).json(updatedRec);
    }
    catch (error){
        res.status(500).json({message : "Internal server error"});
    }
}

export const deleteBook = async(req, res)=>{
    try{
        const id= req.params.id;
        const existrec = await Book.findById({_id: id});

        if(!existrec){
            return res.status(404).json({message: "Record not found"});
        }
        await Book.findByIdAndDelete(id);
        res.status(200).json({message : " Record deleted successfully"});
    }
    catch (error){
        res.status(500).json({message : "Internal server error"});
    }
}