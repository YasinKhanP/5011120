// MVCPatternExample.java

public class MVCPatternExample {

    // Step 2: Define Model Class
    static class Student {
        private String name;
        private int id;
        private String grade;

        public Student(String name, int id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    // Step 3: Define View Class
    static class StudentView {
        public void displayStudentDetails(String studentName, int studentId, String studentGrade) {
            System.out.println("Student: ");
            System.out.println("Name: " + studentName);
            System.out.println("ID: " + studentId);
            System.out.println("Grade: " + studentGrade);
        }
    }

    // Step 4: Define Controller Class
    static class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public String getStudentName() {
            return model.getName();
        }

        public void setStudentId(int id) {
            model.setId(id);
        }

        public int getStudentId() {
            return model.getId();
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public String getStudentGrade() {
            return model.getGrade();
        }

        public void updateView() {
            view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
        }
    }

    // Step 5: Test the MVC Implementation
    public static void main(String[] args) {
        // Creating the model
        Student student = new Student("yasin", 1, "A");

        // Creating the view
        StudentView view = new StudentView();

        // Creating the controller
        StudentController controller = new StudentController(student, view);

        // Displaying initial student details
        controller.updateView();

        // Updating student details
        controller.setStudentName("manogna");
        controller.setStudentId(2);
        controller.setStudentGrade("B");

        // Displaying updated student details
        controller.updateView();
    }
}