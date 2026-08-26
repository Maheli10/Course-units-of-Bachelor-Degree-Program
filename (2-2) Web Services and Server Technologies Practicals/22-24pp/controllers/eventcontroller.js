import event from '../models/eventmodel.js';

export const create = async(req ,res)=>{
    try{
        const eventdata = new event(req.body);
        const {id} = eventdata;

        const existevent = await event.findOne({id});
        if(existevent){
            return res.status(400).json({message: "event already exists"});

        }
        const savedevent = await existevent.save();
        res.status(200).json(savedevent);
    }
    catch(error){
        res.status(500).json({message:"Internal server error"});
    }
}

export const getAll = async(req ,res)=>{
    try{
        const exiistEvent = await event.find();
        if(exiistEvent.length ==0){
            return res.status(404).json({mesage: "Events not found"});

        }
        res.status(200).json(exiistEvent);
    }
    catch(error){
        res.status(500).json({message:"Internal server error"});
    }
}

export const getId = async(req ,res)=>{
    try{
        const id = req.params.id;
        const existev = await event.findOne({_id: id});
        if(!existev){
            return res.status(404).json({message: "event not found"});
        }
        res.status(200).json(existev);
    }
    catch(error){
        res.status(500).json({message:"Internal server error"});
    }
}