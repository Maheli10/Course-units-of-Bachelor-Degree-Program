
import java.util.*;

abstract class Person {
    private String name;
    private String city;

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() { return name; }
    public String getCity() { return city; }

    public abstract void displayInfo();
    public abstract int getTotalMarks();
}

class Student extends Person {
    private int age;
    private String gender;
    private String[] subjects;
    private int[] marks;

    public Student(String name, String city, int age, String gender, String[] subjects, int[] marks) {
        super(name, city);
        this.age = age;
        this.gender = gender;
        this.subjects = subjects;
        this.marks = marks;
    }

    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String[] getSubjects() { return subjects; }
    public int[] getMarks() { return marks; }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("City: " + getCity());
        System.out.println("Marks:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(" " + subjects[i] + ": " + marks[i]);
        }
    }

    @Override
    public int getTotalMarks() {
        int total = 0;
        for (int mark : marks) total += mark;
        return total;
    }
}

class Teacher extends Person {
    private int age;
    private String gender;
    private String subject;

    public Teacher(String name, String city, int age, String gender, String subject) {
        super(name, city);
        this.age = age;
        this.gender = gender;
        this.subject = subject;
    }

    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getSubject() { return subject; }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("City: " + getCity());
        System.out.println("Subject: " + subject);
    }

    @Override
    public int getTotalMarks() {
        return 0; // Not applicable for Teacher
    }
}


public class Main2 {
    public static void main(String[] args) {
        // Subjects
        String[] subjects = {"Mathematics", "Physics", "Chemistry", "English"};

        // Create Students
        Student[] students = {
            new Student("Harry", "Gryffindor", 15, "Male", subjects, new int[]{85, 90, 80, 75}),
            new Student("Hermione", "Gryffindor", 14, "Female", subjects, new int[]{92, 98, 96, 88}),
            new Student("Draco", "Slytherin", 14, "Male", subjects, new int[]{88, 90, 82, 85}),
            new Student("Luna", "Ravenclaw", 16, "Female", subjects, new int[]{90, 85, 92, 88}),
            new Student("Cedric", "Hufflepuff", 17, "Male", subjects, new int[]{80, 88, 85, 90}),
            new Student("Cho", "Ravenclaw", 16, "Female", subjects, new int[]{90, 85, 92, 88}),
            new Student("Gregory", "Slytherin", 15, "Male", subjects, new int[]{70, 80, 78, 67}),
            new Student("Wayne", "Hufflepuff", 17, "Male", subjects, new int[]{78, 75, 79, 86})
        };

        // Create Teachers
        Teacher[] teachers = {
            new Teacher("McGonagall", "Gryffindor", 54, "Female", "Chemistry"),
            new Teacher("Snape", "Slytherin", 45, "Male", "English"),
            new Teacher("Sprout", "Hufflepuff", 50, "Female", "Biology"),
            new Teacher("Flitwick", "Ravenclaw", 40, "Male", "Mathematics")
        };

        System.out.println("=== Triwizard Tournament Eligible Students (Male, Age >= 17) ===");
        for (Student s : students) {
            if (s.getGender().equalsIgnoreCase("Male") && s.getAge() >= 17) {
                s.displayInfo();
                System.out.println();
            }
        }

        System.out.println("=== Students Scoring >85 in Physics ===");
        for (Student s : students) {
            int physicsIndex = Arrays.asList(subjects).indexOf("Physics");
            if (s.getMarks()[physicsIndex] > 85) {
                s.displayInfo();
                System.out.println();
            }
        }

        System.out.println("=== Best Performing Student (Total Marks) ===");
        Student topStudent = null;
        int maxMarks = -1;
        for (Student s : students) {
            int total = s.getTotalMarks();
            if (total > maxMarks) {
                maxMarks = total;
                topStudent = s;
            }
        }
        if (topStudent != null) {
            topStudent.displayInfo();
        }

        System.out.println("\n=== Teacher Who Teaches Mathematics ===");
        for (Teacher t : teachers) {
            if (t.getSubject().equalsIgnoreCase("Mathematics")) {
                t.displayInfo();
                break;
            }
        }

        System.out.println("\n=== Winning City Based on Total Marks ===");
        Map<String, Integer> cityMarks = new HashMap<>();
        for (Student s : students) {
            String city = s.getCity();
            cityMarks.put(city, cityMarks.getOrDefault(city, 0) + s.getTotalMarks());
        }

        String winningCity = null;
        int highestCityTotal = -1;
        for (Map.Entry<String, Integer> entry : cityMarks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            if (entry.getValue() > highestCityTotal) {
                highestCityTotal = entry.getValue();
                winningCity = entry.getKey();
            }
        }
        System.out.println("Winning City of the Year: " + winningCity);
    }
}