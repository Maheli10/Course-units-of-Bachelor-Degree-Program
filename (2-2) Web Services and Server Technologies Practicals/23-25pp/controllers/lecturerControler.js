import express from 'express';

import Lec from '../models/lecturerModel.js';

export const create = async(req , res)=>{
    try{
        const lecturer = new Lec(req.body);
        const {id} = lecturer;

        const exist = await Lec.findOne({id});
        if(exist){
            return res.status(400).json({})
        }

        const savedLec = await lecturer.save();

        res.status(200).json(savedLec);

    }

    catch(error){
        res.status(500).json({message: "Internal server errror"});
    }
}

export const getAll = async (req , res)=>{
    const exist =await Lec.find();

    if(exist.length ==0){
        return res.status(404).json();
    }
    res.status(200).json(exist);
}

export const getOne = async (req , res)=>{
    try{
        
    const id= req.param.id;
    const exist =await Lec.find({_id:id});

    if(!exist){
        return res.status(404).json();
    }
    res.status(200).json(exist);
    }

    catch(error){
        res.status(500).json({message: "Internal server error"});
    }

}