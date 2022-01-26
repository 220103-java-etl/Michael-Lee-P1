package dev.lee.models;

/*Enums are special kind of class where variables inside that class are known to not change.
since the only  variables inside this class are the pending statuses that can interact with the application
They will always be the within the same 3 and the status cannot be changed once an application is processed.
Therefore, to change these variables inside this class a new instance or reimbursement must be submitted.
 */

public enum Status {

    APPROVED{
        @Override
        public String toString(){
            return "Approved";
        }
},
    PENDING{
        @Override
        public String toString(){
            return "Pending";
        }
    },
    DENIED{
        @Override
        public String toString(){
            return "Denied";
        }

    }

}
