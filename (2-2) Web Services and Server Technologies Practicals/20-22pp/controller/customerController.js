import Customer from '../models/customermodel.js';

export const create = async(req,res)=>{
    try{
        const cusData = new Customer(req.body);
        const {id} = cusData;
        
        const cusExist = await Customer.findOne({id});
        if(cusData){
            return res.status(400).json({message: "User already exists"});

            const savedCustomer = await cusData.save();
            req.status(200).json(savedCustomer);
        }

    }
    catch(error){
        res.status(500).json({error:"Internal server error"});
    }
}

export const fetch = async(req,res)=>{
    try{
        const customers = await Customer.find();

        if(customers.length == 0){
            return res.status(404).json({mesage: "Customers not found"});

        }
        return res.status(200).json(customers);
    }
    catch(error){
        res.status(500).json({error: "Internal server error"});
    }
}

export const update = async(req,res)=>{
    try{
        const id = req.params.id;

        const cusExist= await Customer.findOne({_id:id});

        if(!cusExist){
            return res.status(404).json({mesage: "customer notfound"});
        }

        const updateCus = await Customer.findByIdAndUpdate(id,req.body, {new : true});
        res.status(201).json(updateCus);
    }
    catch(error){
        res.status(500).json({error: "Internal server error"});
    }
}

export const deleteCustomer = async(req,res)=>{
    try{
        const id= req.params.id;

        const cusExist = await Customer.findOne({_id: id});
        if(!cusExist){
            return res.status(404).json({message: "customer not found"});
        }
        const deleteCus = await Customer.findByIdAndDelete(id);
        return res.status(201).json({message: "Customer deleted successfully"});
    
    }
    catch(error){
        res.status(500).json({error: "Internal server error"});
    }
}