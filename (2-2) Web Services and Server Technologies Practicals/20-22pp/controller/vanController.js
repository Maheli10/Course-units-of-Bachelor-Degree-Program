import Van from '../models/vanModel.js';

export const create = async(req , res)=>{
    try{
        const vanData = new Van(req.body);
        const {id} = vanData;

        const vanExist = await Van.findOne({id});
        if(vanExist){
            return res.status(400).json({message:"Van already exists"});

        }

        const savedvan = await vanData.save();
        res.status(200).json(savedvan);

    }
    catch(error){
        res.status(500).json({message: "Internal sever error"});
    }

}

export const fetch = async (req , res)=>{
    try{
        const vanExist = await Van.find();
        if(vanExist.length == 0){
            return res.status(404).json({mesage: "Van not found"});
        }
        
        res.status(200).json(vanExist);
    }
    catch(error){
        res.status(500).json({message: "Internal sever error"});

    }
}

export const update = async (req , res)=>{
    try{
        const id= req.params.id;

        const ExistVan = await Van.find({_id: id});
        if(!ExistVan){
            return res.status(404).json({message: "Vans not found"});
            
        }
        const updatedVan = await Van.findByIdAndUpdate(id, req.body, {new:true});
        res.status(200).json(updatedVan);
    }   
    catch(error){
        res.status(500).json({message: "Internal sever error"});
    }
}

export const deleteVan = async (req , res)=>{
    try{
        const id = req.params.id;
        const vanExist = await Van.ind({_id : id});

        if(!vanExist){
            return res.status(404).json({message: "Van not found"});

        }
        const delVan = await Van.findByIdAndDelete(id);

        res.status(200).json({message: "Van deleted successfully"});

    }
    catch(error){
        res.status(500).json({message: "Internal sever error"});

    }
}