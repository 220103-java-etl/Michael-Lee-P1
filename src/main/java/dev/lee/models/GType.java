package dev.lee.models;

public enum GType {

    LETTER_GRADE{
        @Override
        public String toString(){
            return "Letter Grade";
        }
    },
    PRESENTATION{
        @Override
        public String toString(){ return "Presentation";}
    },
    PASS_FAIL{
        @Override
        public String toString() {return "Pass_Fail";}
    }
}

