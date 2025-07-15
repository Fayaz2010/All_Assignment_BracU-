//Assignment Task 03: Matrix Compression
class AssgnTask3{

    
    public static Integer[][] compressMatrix( Integer[][] matrix ){

       
       Integer [][] arr= new Integer[2][2];
           int row=matrix.length;
        int col= matrix[0].length;
        int sum=0;
        for (int i=0;i<row/2;i++){
            for (int j=0;j<col/2;j++){
                sum+=matrix[i][j];
                
        } 
        
}
arr[0][0]=sum;
        sum=0;
for (int i=0;i<row/2;i++){
            for (int j=col/2;j<col;j++){
                sum+=matrix[i][j];
                
        } 
        
}
arr[0][1]=sum;
        sum=0;

for (int i=row/2;i<row;i++){
            for (int j=0;j<col/2;j++){
                sum+=matrix[i][j];
                
        } 
        
}
arr[1][0]=sum;
        sum=0;
for (int i=row/2;i<row;i++){
            for (int j=col/2;j<col;j++){
                sum+=matrix[i][j];
                
        } 
        
}
arr[1][1]=sum;
        sum=0;

return arr;

        
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] matrix = {
            { 1 , 2 , 3 , 4 },
            { 5 , 6 , 7 , 8 },
            { 1 , 3 , 5 , 2 },
            {-2 , 0 , 6 ,-3 }
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);
        
        System.out.println("\nExpected Output:");
        System.out.print("| 14 | 22 |\n| 2  | 10 |\n");
        
        System.out.print("\nYour Output:\n");
        Integer[][] returnedArray = compressMatrix( matrix );
        Arr.print2D( returnedArray );
    }
}