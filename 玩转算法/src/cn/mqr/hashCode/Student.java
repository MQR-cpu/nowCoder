package cn.mqr.hashCode;

public class Student {

    private String fistName;
    private int age;

    public Student(String fistName, int age) {
        this.fistName = fistName;
        this.age = age;
    }

    @Override
    public int hashCode() {

        int B = 31;
        int hash = 0;
        hash = hash * B + fistName.toLowerCase().hashCode();
        hash = hash * B + age;

        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Student other = (Student)obj;
        return this.fistName.equals(other.fistName) &&
                this.age == other.age;
    }
}
