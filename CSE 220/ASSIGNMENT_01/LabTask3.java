//Lab Task 03: Decryption Process
class LabTask3{

    //Complete this method so that it gives the Expected Output
    public static Integer[] decryptMatrix( Integer[][] matrix ){


        Integer rows=matrix.length;
        Integer cols= matrix[0].length;

        int sum=0;
        Integer [] arr3 = new Integer[cols];
        Integer [] arr4 = new Integer[cols-1];
        for (int j=0;j<cols ;j++){
            for (int i=0; i<rows;i++){
                sum+=matrix[i][j];
                
            }
            arr3[j]=sum;
            sum=0; // reset sum for the next column
        }
        Integer i=0;
        while(i<cols){
           arr4[i]=arr3[i+1]-arr3[i];
           i++;

        }
        for (int k=0; k<arr4.length; k++){

            System.out.print("" + arr4[k]);
            
        }
        

    

        //For this task you'll need to create new arrays
        //we recommend you to use Integer type.
        //example:  Integer[] array = new Integer[5]

        //TO DO
        //DELETE the following return statement when you're ready to return the 2D array
        

    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] matrix = {
            {1,3,1},
            {6,4,2},
            {5,1,7},
            {9,3,3},
            {8,5,4}
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);
        System.out.println("\nExpected Output:\n[ -13 1 ]");
        Integer[] returned_val_1 = decryptMatrix( matrix );
        System.out.print("\nYour Output:\n");
        Arr.print(returned_val_1);

    }
}