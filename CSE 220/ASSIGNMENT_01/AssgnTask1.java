//Assignment Task 01: Container with Most Water
class AssgnTask1{

    
    public static void mostWater( Integer[] height ){

        //TO DO
        int area = 0; // Initialize area to 0
        int sum=0;
        for(int i=0; i<height.length; i++){
            for(int j=i+1; j<height.length; j++){
                if(height[i]<=height[j]){  
                     area= height[i]*(j-i);
                     if(area>sum){
                        sum=area;
                     }
                    }
                    else{
                    
                     area= height[j]*(j-i);
                     if(area>sum){
                        sum=area;
                     }

                    }
                    
                        
                     }

                     
                    }
                    
                System.out.print(sum);
                
                
            }
            
        

    

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println("Given Array: ");
        Arr.print(array);
        System.out.println("\nExpected Output:");
        System.out.print("49");
	System.out.print("\nYour Output:\n");
        mostWater( array );

    }
}
