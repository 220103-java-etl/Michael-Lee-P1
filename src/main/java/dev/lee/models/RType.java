package dev.lee.models;

public enum RType {

    UNIVERSITY_COURSE{
        @Override
        public String toString(){
            return "University Course";
        }
    },
    SEMINAR{
        @Override
        public String toString(){ return "Seminar";}
    },
    CPC{
        @Override
        public String toString() {return "CPC";}
    },
    CERTIFICATE{
        @Override
        public String toString() {return "Certificate";}
    },
    TRAINING{
        @Override
        public String toString() {return "Technical Training";}
    },
    OTHER{
        @Override
        public String toString () {return "Other/Misc";}
    }
}
