import Truck from '../models/truckModel.js';

export const create = async(req,res)=>{
    try{
        const truckdata = new Truck(req.body);
        const {id} = truckdata;

        const truckExist = await Truck.findOne({id});

        if(truckExist){
            return res.status(400).json({mesage: "User already exists"});
        }

        const savedTruck = await Truck.save();
        return res.status(200).json(savedTruck);
    }
    catch(error){
        res.status(500).json({message : "internal server error"});
    }
}

export const fetch = async(req , res)=> {
    try{
        const existTruck = await Truck.find();

        if(existTruck.length == 0){
            return escape.status(404).json("trucks not found");
        }
        res.status(200).json(existTruck);
    }
    catch(error){
        res.status(500).json({message: "Internal server error"});

    }

}

export const updateTruck = async(req , res)=>{
    try{
        const id = req.param.id;

        const existTr = await Truck.findOne({_id: id});
        if(!existTr){
            return res.status(404).json({messsage: "Trucks not found !"});
        }

        const updateTruck = await Truck.findByIDAndUpdate(id, req.body, {new:true});
        res.status(201).json(updateTruck);
    }

    catch(error){
        res.status(500).json({message : "Internal sever error"});
    }
}


export const deleteTruck = async(req , res)=> {
    try{
        const id= req.params.id;

        const truckExist = await Truck.find({_id: id});
        if(!truckExist){
            return res.status(404).json({message: "Trucks does not founc"});

        }

        const deleteTr = await Truck.findByIdAndDelete(id);
        res.status(201).json({message: "Truck deleted successfully!"});

    }
    catch(error){
        res.status(500).json ({message: "Internal server error"});
    }
}