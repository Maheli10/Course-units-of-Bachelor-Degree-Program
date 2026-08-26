import User from "../model/patientModel.js";
export const create = async(req,res)=>{
    try{
        const patientData = new User(req.body);

        const { name, admittedDate } = patientData;

        const patientExist = await User.findOne({name, admittedDate});
        if(patientExist){
            return res.status(400).json({error: "User already exists! "})
        }

        const savedPatient = await patientData.save();

        res.status(200).json(savedPatient);
    }
    catch(error){
        res.status(500).json({error: "Internal server error"});
    }
}

export const fetch = async(req,res)=>{
    try{
        const users = await User.find();
        if(users.length === 0){
            return res.status(404).json({message: "User not found"});
        }
        res.status(200).json(users);
    }
    catch(error){
        res.status(500).json({error: "Internal server error"});
    }
}


export const update = async (req,res)=>{
    try{
        const id = req.params.id;
        const userExist = await User.findOne ({_id:id})
        if(!userExist){
            return res.status(404).json({message: "User not found."})
        }
        const updateUser = await User.findByIdAndUpdate(id,req.body,{new:true});
        res.status(201).json(updateUser);
    }
    catch(error){
        console.log(error);
        res.status(500).json({error: "Internal server error"});
    }
}


export const deletePatient = async(req,res)=>{
    try{
        const id = req.params.id;
        const userExist = await User.findOne({_id:id});

        await User.findByIdAndDelete(id);
        res.status(201).json({message: "User deleted successfully"});
    }
    catch(error){
        res.status(500).json({error: "Internal server error"});
    }
}