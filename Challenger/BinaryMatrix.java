


 // had to comment out because I do not have the BinaryMatrix interface



// package Challenger;

// import java.util.ArrayList;
// import java.util.List;

// public class BinaryMatrix {

   
//     public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
//         int result = -1;
//         List<Integer> dimensions = binaryMatrix.dimensions();

//         int rows = dimensions.get(0);
//         int cols = dimensions.get(1);

//         if (rows == 0 || cols == 0) {
//             return -1;
//         }

//         int rowCurrentPosition = 0;
//         int colCurrentPosition = cols - 1;

//         while (rowCurrentPosition < rows && colCurrentPosition >= 0) {
//             if (binaryMatrix.get(rowCurrentPosition, colCurrentPosition) == 1) {
//                 result = colCurrentPosition;
//                 colCurrentPosition--;
//             } else {
//                 r++;
//             }
//         }
//         return result;
//     }

//     public static void main(String[] args) {
        
//     }
// }

