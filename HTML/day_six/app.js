// declaration
// function add(x,y){
//     return x + y;
// }


// expression
// const add = function(x,y){
//     return x + y
// }


// //arrow
// const add = (x,y) => x + y

// function customMessage(message, times) {
//     for (let i = 0; i < times; i++) {
//     console.log(i, message) ;
//     }
//    }
//    customMessage("Hello!", 3);
   

//    function add(a, b) {
//     let c = a + b;
//     return c;
//    }
//    let result = add(3, 5);
//    console.log(result);


// const scope = "global"; // Declare scope global
// function checkscope() {
//  let scope = "local"; // Declare scope local
//  return scope; // Return local value
// }
// const result = checkscope();
// console.log(result); 







// const scope = "global scope"; // A global variable


// function checkscope() {

//  let scope = "local scope"; // A local variable

//  function nested() {

//  let scope = "nested scope"; // A nested local variable
//  return scope; // Return the value in this scope

//  }

//  return nested();
// }
// const result = checkscope();
// console.log(result);


// const x = 1;

// hoist();

// function hoist() { 
//     const x = 2;
//  console.log(x);
//  // ReferenceError
// }

// const err = new Error('Custom Error made by the developer.');
// console.log(err);


// const customerError = new Error('CustomError made by the developer.');

// function someFunc(a) {
//  if (a === 4) {
//  throw customerError; 
//  }
// }
// try {
//  someFunc(4);
// } catch (e) {
//  console.log("Logging Customer Error:")
//  console.log(e)
// }


// let person = {
//     firstName: "John",
//     lastName: "Doe",
//     age: 50,
//     eyeColor: "blue"
//     };

// person.hairColor = "green"
// person.age = 99;

// console.log(person.firstName + " is " + person["age"] + " years old.");


//keys
// const objectKeys = Object.keys(person);
// console.log(objectKeys); 


//values
// const objectValues = Object.values(person);
// console.log(objectValues); 



//entries
// const objectEntries = Object.entries(person);
// console.log(objectEntries);


// const arr1 = [1,2,3,4]

// const arr2 = [ "jim","sam","Lisa"]

// const arr3 = [ "Jim",3, "lisa",true,null]

// console.log(arr3[3])



