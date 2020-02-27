

function function1(){
    console.log("pressed");
}
function hover(){
    let x = document.getElementById("div1");
    let y = document.getElelementById("div2");
    x.style.backgroundColor = "white";
    y.style.color = "transparent";
    
}
// -- Object Literal {} -- 
let person = {
    name: 'Edward',
    age: 24
}

//Dot notation
person.name = "John";

// Bracket notation
person['name'] = 'Mary';

// -- Arrays length is dynamic and can change
//      types can change and so can size

let selectedColors = ["red" , "blue"];

// -- Functions

function Main(){
    
}

function greet(name){
    return name;
}

//<script src="index.js"></script>

Main();