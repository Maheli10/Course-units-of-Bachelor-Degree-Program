import e from 'express';
import student from '../models/studentmodel.js';

export const create = async(req ,res)=>{
    try{
        const stdata = new student(req.body);
        const {id} = stdata;

        const existst = await student.findOne({id});
        if(existst){
            return res.status(400).json({mesage: "User already exists"});
        }

        const savedst = await stdata.save();
        res.status(200).json(savedst);
    }
    catch(error){
        res.status(500).json({message:"Internal server error"});
    }
}

export const getAll = async(req ,res)=>{
    try{
        const existstu = await student.find();
        if(existstu.length== 0){
            return res.status(404).json({message: "Users not found"});

        }
        res.status(200).json(existstu);
    }
    catch(error){
        res.status(500).json({message:"Internal server error"});
    }
}

export const getId = async(req ,res)=>{
    try{
        const id = req.params.id;
        const existst= await student.findOne({_id :id});
        if(!existst){
            return res.status(404).json({Messsage: "Student not found."})
        }
        return res.status(200).json(existst);
    }
    catch(error){
        res.status(500).json({message:"Internal server error"});
    }
}