import certi from '../models/certificatemodel.js';

export const create = async(req ,res)=>{
    try{
        const certdata = new certi(req.body);
        const {id}= certdata;

        const existcert = await certi.findOne({id});
        if(existcert){
            return res.status(400).json({message: "User already exists"});

        }
        const savedcert = await certdata.save();
        res.status(200).json(savedcert);
    }
    catch(error){
        res.status(500).json({message:"Internal server error"});
    }
}

export const getAll = async(req ,res)=>{
    try{
        const certis= await certi.find();
        
        if(certis.length ==0){
            return res.status(404).json({message: "Users not found"});
        }
        res.status(200).json(certis);
    }
    catch(error){
        res.status(500).json({message:"Internal server error"});
    }
}

export const getId = async(req ,res)=>{
    try{
        const id= req.params.id;
        const certiId = await certi.findOne({_id: id});

        if(!certiId){
            return res.status(404).json({message: "Certiicate not found"});
        }
    }
    catch(error){
        res.status(500).json({message:"Internal server error"});
    }
}