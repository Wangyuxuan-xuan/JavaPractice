package Collection;

public class Student implements Comparable<Student>{
    int age;
    int grade;
    String name ;

    public Student(int age, int grade, String name) {
        this.age = age;
        this.grade = grade;
        this.name = name;
    }

    @Override
    public int compareTo(Student student) {
        return student.name.compareTo(this.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                '}';
    }
}
