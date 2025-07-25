//Lab Task 02: Zigzag Walk
class LabTask2{

    //Complete this method so that it gives the Expected Output
    //NO NEED TO SUBMIT LAB TASKS
    public static void walkZigzag( Integer[][] matrix ){
       
        int rows = matrix.length;

        int cols = matrix[0].length;
        for (int j = 0; j < cols; j++) {
             // even row index
             if (j % 2 == 0) {
                for (int i = 0; i < rows; i++) {
                    
                        if(i%2 == 0) { // even row index
                            System.out.print(matrix[i][j] + " ");
                        }
                   
                }
                System.out.println();
               
                   
                }
                 else{
                for (int i = rows - 1; i >= 0; i--) {
                    
                        if(i%2 != 0) { // odd row index
                            System.out.print(matrix[i][j] + " ");
                        }

                 }

            }
           System.out.println();
            
             // move to the next line after each row
        }


        //For this task you don't need to create new arrays

        //TO DO

    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] floor1 = {
            {3 , 8 , 4 , 6 , 1},
            {7 , 2 , 1 , 9 , 3},
            {9 , 0 , 7 , 5 , 8},
            {2 , 1 , 3 , 4 , 0},
            {1 , 4 , 2 , 8 , 6}
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(floor1);
        System.out.println("\nExpected Output:");
        System.out.print("3 9 1\n1 2\n4 7 2\n4 9\n1 8 6\n");
        System.out.print("\nYour Output:\n");
        walkZigzag( floor1 );

        System.out.print("\n======================\n");

        Integer[][] floor2 = {
            {3 , 8 , 4 , 6 , 1},
            {7 , 2 , 1 , 9 , 3},
            {9 , 0 , 7 , 5 , 8},
            {2 , 1 , 3 , 4 , 0},
        };
        System.out.println("\nGiven Matrix: ");
        Arr.print2D(floor2);
        System.out.println("\nExpected Output:");
        System.out.print("3 9\n1 2\n4 7\n4 9\n1 8\n");
        System.out.print("\nYour Output:\n");
        walkZigzag( floor2 );

    }
}