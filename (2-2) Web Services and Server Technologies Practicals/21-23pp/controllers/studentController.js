import Student from '../models/studentModel.js';

export const create = async(req, res)=>{
    try{
        const record = new Student(req.body);
                const {registrationNumber} = req.body;
        
                const existRecord = await Student.findOne({registrationNumber});
        
                if(existRecord){
                    return res.status(400).json({message: "Student already exists"});
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
         const record = await Student.find();
        if(record.length == 0){
            return res.status(404).json({message: "Student not found"});
        }

        res.status(200).json(record);
            
    }
    catch (error){
        res.status(500).json({message : "Internal server error"});
    }
}