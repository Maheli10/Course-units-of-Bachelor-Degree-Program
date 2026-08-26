import express from 'express';

const app= express();
app.use(express.json());

let students=[
    {
        id:1,
        name:"Maheli",
        roomNumber:3,
        course:"IT",
        checkInDate:"2026-04-05"
    },
    {
        id:2,
        name:"Madava",
        roomNumber:4,
        course:"IT",
        checkInDate:"2026-04-05"
    },
    {
        id:3,
        name:"Amara",
        roomNumber:3,
        course:"IT",
        checkInDate:"2026-04-05"
    }
];

app.post('/students',(req,res)=>{
    const newst= {
        id: students.length+ 1,
        name: req.body.name,
        roomNumber: req.body.roomNumber,
        course: req.body.course,
        checkInDate:req.body.checkInDate 
    };
    students.push(newst);
    res.status(201).json(newst);

});

app.get('/students',(req,res)=>{
    res.json(students);
});

app.get('/students/:id',(req,res)=>{
    const student= students.find(s=> s.id ==req.params.id);

    if(!student){
        return res.status(404).json({message:"Student not found"});
    }
    return res.json(student);
});

app.put('/students/:id',(req,res)=>{
    const student= students.find( s=> s.id == req.params.id);

    if(!student){
        return res.status(404).json({message: "Student not found"});
    }
    student.name = req.body.name || student.name;
    student.roomNumber = req.body.roomNumber || student.roomNumber;
    student.course = req.body.course || student.course;
    student.checkInDate = req.body.checkInDate || student.checkInDate;

    res.json(student);
});

app.delete('/students/:id',(req,res)=>{
    students = students.filter(s=> s.id != req.params.id);

    res.json({message: "Student deleted successfully"});
});

app.listen(3000,()=>{
    console.log("Server is running at port 3000");
});