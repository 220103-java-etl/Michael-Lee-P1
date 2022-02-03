package dev.lee.models;

public enum GType {

    LETTER_GRADE{
        @Override
        public String toString(){
            return "University Course";
        }
    },
    PRESENTATION{
        @Override
        public String toString(){ return "Seminar";}
    },
    PASS_FAIL{
        @Override
        public String toString() {return "CPC";}
    }
}

