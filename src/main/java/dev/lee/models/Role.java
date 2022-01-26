package dev.lee.models;

/*Enums are special kind of class where variables inside that class are known to not change.
since the only two variables inside this class are the types of employees that can interact with
the application, it benefits us to set them as enum-final values.
 */

public enum Role {

    EMPLOYEE{
        @Override
        public String toString(){
            return "Employee";
        }
    },

    FINANCE_MANAGER {
        @Override
        public String toString () {
            return "Finance Manager";
        }
    }
}

