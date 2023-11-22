//TASK 1 BOX
// const readline = require('readline');

// // Create interface for reading input
// const rl = readline.createInterface({
//   input: process.stdin,
//   output: process.stdout
// });

// // Function to create a solid rectangular box
// function createBox(width, height) {
//   // Initialize an empty string to store the box shape
//   var boxShape = '';

//   // Loop through each row (height)
//   for (var i = 0; i < height; i++) {
//     // Append a row of asterisks to the boxShape string
//     boxShape += '*'.repeat(width) + '\n';
//   }

//   // Print the box shape
//   console.log('Shape:\n' + boxShape);
// }

// // Get user input for width and height
// rl.question('Input width: ', function (userInputWidth) {
//   rl.question('Input height: ', function (userInputHeight) {
//     // Parse user input as integers
//     var width = parseInt(userInputWidth);
//     var height = parseInt(userInputHeight);

//     // Check if the input is valid (non-negative integers)
//     if (!isNaN(width) && !isNaN(height) && width > 0 && height > 0) {
//       // Print a line to separate input from output
//       console.log('------------------------');

//       // Call the function to create and print the box
//       createBox(width, height);
//     } else {
//       // Print an error message for invalid input
//       console.log('Invalid input. Please enter positive integers for width and height.');
//     }

//     // Close the interface
//     rl.close();
//   });
// });





//--------------------------------------------------------------------------------------------------------------------------------------------------------------------

// TASK 2 CHECKBOARD
// const readline = require('readline');

//     // Create interface for reading input
//     const rl = readline.createInterface({
//       input: process.stdin,
//       output: process.stdout
//     });

//     // Function to create a rectangular checkerboard
//     function createCheckerboard(width, height) {
//       // Initialize an empty string to store the checkerboard pattern
//       var checkerboardPattern = '';

//       // Loop through each row (height)
//       for (var row = 0; row < height; row++) {
//         // Loop through each column (width)
//         for (var col = 0; col < width; col++) {
//           // Use an if statement to conditionally print '*' or ' '
//           if ((row + col) % 2 === 0) {
//             checkerboardPattern += '* ';
//           } else {
//             checkerboardPattern += ' ';
//           }
//         }
//         // Add a new line after each row
//         checkerboardPattern += '\n';
//       }

//       // Print the checkerboard pattern
//       console.log('Shape:\n' + checkerboardPattern);
//     }

//     // Get user input for width and height
//     rl.question('Input width: ', function (userInputWidth) {
//       rl.question('Input height: ', function (userInputHeight) {
//         // Parse user input as integers
//         var width = parseInt(userInputWidth);
//         var height = parseInt(userInputHeight);

//         // Check if the input is valid (non-negative integers)
//         if (!isNaN(width) && !isNaN(height) && width > 0 && height > 0) {
//           // Print a line to separate input from output
//           console.log('------------------------');

//           // Call the function to create and print the checkerboard
//           createCheckerboard(width, height);
//         } else {
//           // Print an error message for invalid input
//           console.log('Invalid input. Please enter positive integers for width and height.');
//         }

//         // Close the interface
//         rl.close();
//       });
//     });

//------------------------------------------------------------------------------------------------------------------------------------------------------------

//TASK 3 CROSS
// const readline = require('readline');

// // Create interface for reading input
// const rl = readline.createInterface({
//   input: process.stdin,
//   output: process.stdout
// });

// // Function to create a diagonal cross
// function createCross(size) {
//   // Initialize an empty string to store the cross pattern
//   var crossPattern = '';

//   // Loop through each row
//   for (var row = 0; row < size; row++) {
//     // Loop through each column
//     for (var col = 0; col < size; col++) {
//       // Check if the current position is part of the diagonal cross
//       if (row === col || row + col === size - 1) {
//         crossPattern += '*';
//       } else {
//         crossPattern += ' ';
//       }
//     }
//     // Add a new line after each row
//     crossPattern += '\n';
//   }

//   // Print the cross pattern
//   console.log('Shape:\n' + crossPattern);
// }

// // Get user input for the size
// rl.question('Input size: ', function (userInputSize) {
//   // Parse user input as an integer
//   var size = parseInt(userInputSize);

//   // Check if the input is valid (a positive integer)
//   if (!isNaN(size) && size > 0) {
//     // Print a line to separate input from output
//     console.log('------------------------');

//     // Call the function to create and print the cross
//     createCross(size);
//   } else {
//     // Print an error message for invalid input
//     console.log('Invalid input. Please enter a positive integer for the size.');
//   }

//   // Close the interface
//   rl.close();
// });

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
//TASK 4 LOWER TRIANGLE
// const readline = require('readline');

// // Create interface for reading input
// const rl = readline.createInterface({
//   input: process.stdin,
//   output: process.stdout
// });

// // Function to create the bottom-left half of a square
// function createLowerTriangle(sideLength) {
//   // Initialize an empty string to store the triangle pattern
//   var trianglePattern = '';

//   // Loop through each row
//   for (var row = 1; row <= sideLength; row++) {
//     // Loop through each column
//     for (var col = 1; col <= row; col++) {
//       trianglePattern += '*';
//     }
//     // Add a new line after each row
//     trianglePattern += '\n';
//   }

//   // Print the triangle pattern
//   console.log('Shape:\n' + trianglePattern);
// }

// // Get user input for the side length
// rl.question('Input side length: ', function (userInputLength) {
//   // Parse user input as an integer
//   var sideLength = parseInt(userInputLength);

//   // Check if the input is valid (a positive integer)
//   if (!isNaN(sideLength) && sideLength > 0) {
//     // Print a line to separate input from output
//     console.log('------------------------');

//     // Call the function to create and print the lower triangle
//     createLowerTriangle(sideLength);
//   } else {
//     // Print an error message for invalid input
//     console.log('Invalid input. Please enter a positive integer for the side length.');
//   }

//   // Close the interface
//   rl.close();
// });


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------
//TASK 5 uper triangle
// const readline = require('readline');

// // Create interface for reading input
// const rl = readline.createInterface({
//   input: process.stdin,
//   output: process.stdout
// });

// // Function to create the top-right half of a square
// function createUpperTriangle(sideLength) {
//   // Initialize an empty string to store the triangle pattern
//   var trianglePattern = '';

//   // Loop through each row
//   for (var row = 1; row <= sideLength; row++) {
//     // Add spaces for indentation
//     for (var space = 1; space < row; space++) {
//       trianglePattern += ' ';
//     }

//     // Loop through each column
//     for (var col = row; col <= sideLength; col++) {
//       trianglePattern += '*';
//     }

//     // Add a new line after each row
//     trianglePattern += '\n';
//   }

//   // Print the triangle pattern
//   console.log('Shape:\n' + trianglePattern);
// }

// // Get user input for the side length
// rl.question('Input side length: ', function (userInputLength) {
//   // Parse user input as an integer
//   var sideLength = parseInt(userInputLength);

//   // Check if the input is valid (a positive integer)
//   if (!isNaN(sideLength) && sideLength > 0) {
//     // Print a line to separate input from output
//     console.log('------------------------');

//     // Call the function to create and print the upper triangle
//     createUpperTriangle(sideLength);
//   } else {
//     // Print an error message for invalid input
//     console.log('Invalid input. Please enter a positive integer for the side length.');
//   }

//   // Close the interface
//   rl.close();
// });



//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//TASK6 upside-down trapezoid
const readline = require('readline');

// Create interface for reading input
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Function to create an upside-down trapezoid
function createUpsideDownTrapezoid(width, height) {
  // Check if the height is possible for the given width
  if (height * 2 - 1 > width) {
    console.log('Impossible shape!');
    return;
  }

  // Initialize variables for spaces and stars
  var spaces = 0;
  var stars = width;

  // Loop through each line
  for (var i = 0; i < height; i++) {
    // Print spaces
    console.log(' '.repeat(spaces) + '*'.repeat(stars));

    // Increment spaces and decrement stars
    spaces += 1;
    stars -= 2;
  }
}

// Get user input for width and height
rl.question('Input width: ', function (userInputWidth) {
  rl.question('Input height: ', function (userInputHeight) {
    // Parse user input as integers
    var width = parseInt(userInputWidth);
    var height = parseInt(userInputHeight);

    // Check if the input is valid (positive integers)
    if (!isNaN(width) && !isNaN(height) && width > 0 && height > 0) {
      // Print a line to separate input from output
      console.log('------------------------');

      // Call the function to create and print the upside-down trapezoid
      createUpsideDownTrapezoid(width, height);
    } else {
      // Print an error message for invalid input
      console.log('Invalid input. Please enter positive integers for width and height.');
    }

    // Close the interface
    rl.close();
  });
});
