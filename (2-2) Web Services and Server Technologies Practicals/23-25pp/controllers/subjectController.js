import express from 'express';
import Subject from '../models/subjectModel.js';

export const create = async(req ,res)=>{
    try{
        const subdata = new Subject(req.body);
        const {id} = subdata;

        const exists = await Subject.findOne({id});
        if(exists){
            return res.status(400).json({message:"User already exists"});

        }
        const saveddata = await subdata.save();
        res.status(200).json(saveddata);
    }

    catch(error){
        res.status(500).json({message:"Internal server error"});
    }
}

export const getAll = async(req , res)=>{
    try{
        const existsub = await Subject.find();

        if(existsub.length ==0){
            return res.status(404).json({message: "Users not found"});
        }   
        res.status(200).json(existsub);
     }

    catch(error){
        res.status(500).json({message: "Internal server errror"});
    }
}

export const getID = async(req, res)=>{
    try{
        const id= req.param.id;
        const exist= await Subject.findOne({_id:id});
        if(!exist){
            return res.status(404).json({message: "Student not found"});
        }
        res.status(200).json(exist);

    }

    catch(error){
        res.status(500).json({message: "Internal server error"});
    }
}

export const update = async(req ,res)=>{
    try{
        const id= req.param.id;

        const exist = await Subject.findOne({_id: id});

        if(!exist){
            return res.status(404).json({message: "Sub not found"});
        }

        const updatesub = await Subject.findByIdAndUpdate(id, req.body, {new:true});
        res.status(200).json(updatesub);
    }

    catch(error){
        res.status(500).json({message: "Internal server error"});
    }
}

export const deleteOne = async(req , res)=>{
    try{
        const id= req.param.id;
        const exist = await Subject.findOne({_id:id});

        if(!exist){
            res.status(404).json({mesage: "Subject does nott found"});
        }
        await Subject.findByIdAndDelete(id);
        res.status(200).json();
    }

    catch(eror){
        res.status(500).json({message: "Internal sever error"});
    }
}