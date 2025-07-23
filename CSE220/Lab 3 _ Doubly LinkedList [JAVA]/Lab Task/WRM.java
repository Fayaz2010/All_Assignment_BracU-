public class WRM {
    Patient dh;

    //The constructor is already created for you
    public WRM() {
        dh = new Patient(null, null, null, null, null, null);
        dh.next = dh;
        dh.prev = dh;
    }

    public void registerPatient(int id, String name, int age, String bloodgroup) {
         Patient newPatient = new Patient(id, name, age, bloodgroup, null, null);
        Patient last = dh.prev;
        

       
        newPatient.next = dh;
        newPatient.prev = last;
        last.next = newPatient;
        dh.prev = newPatient;
        // To Do
    }

    public void servePatient() {
        
        if (dh.next == dh) {
           System.out.println("No patient to serve.");
            return;
        }
        Patient first = dh.next;
        System.out.println("Serving Patient:" +first.id+" " +first.name+ " " + first.age + " " + first.bloodGroup);
        dh.next = dh.next.next;
        dh.next.prev = dh;
        

        // To do
    }

    public void showAllPatient() {
          if (dh.next == dh) {
            System.out.println("No patients in the waiting room.");
            return;
        }
        Patient curr=dh.next;
        while(curr!=dh){  

            System.out.print(curr.id+" "); 
            curr = curr.next;
        }
        System.out.println();

        }

        // To Do
    

    public Boolean canDoctorGoHome() {
        if(dh.next==dh){
            return true;
            
        }
        else{
            return false;
        }
        // To Do
       
    }

    public void cancelAll() {
        dh.next=dh;
        dh.prev=dh;
        // To Do
    }


    public void reverseTheLine() {
            Patient curr = dh;
          while (curr!=dh) {
            Patient temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;
            curr = temp;
        } 

        // To Do
    }

}