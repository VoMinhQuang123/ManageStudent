public class ListStudent {
    private final ArrayListBuild<Student> listStudent;
    public ListStudent(){
        this.listStudent = new ArrayListBuild<>();
    }
    public void addNewStudent(Student student) {
        this.listStudent.add(student);
    }
    public boolean deleteStudent(Student student){
        return this.listStudent.remove((student));
    }
    public void printListStudent(){
        listStudent.forEach(new ArrayListBuild.CustomAction<Student>() {
            @Override
            public void execute(Student student) {
                System.out.println(student.getName() + " - " + student.getId() + " - " + student.getScore() + " - " + student.getRank());
            }
        });
    }
    public boolean searchStudentByID(String id) {
        final boolean[] found = {false};
        listStudent.forEach(new ArrayListBuild.CustomAction<Student>() {
            @Override
            public void execute(Student student) {
                if (student.getId().equals(id)) {
                    System.out.println(student);
                    found[0] = true;
                }
            }
        });
        return found[0];
    }
    public boolean searchStudentByName(String name) {
        final boolean[] found = {false};
        listStudent.forEach(new ArrayListBuild.CustomAction<Student>() {
            @Override
            public void execute(Student student) {
                if (student.getName().indexOf(name) >= 0) {
                    System.out.println(student);
                    found[0] = true;
                }
            }
        });
        return found[0];
    }
    public boolean searchStudentByPoint(int point) {
        final boolean[] found = {false};
        listStudent.forEach(new ArrayListBuild.CustomAction<Student>() {
            @Override
            public void execute(Student student) {
                if (student.getScore() == point) {
                    System.out.println(student);
                    found[0] = true;
                }
            }
        });
        return found[0];
    }
    public boolean checkID(String id) {
        final boolean[] found = {false};
        listStudent.forEach(new ArrayListBuild.CustomAction<Student>() {
            @Override
            public void execute(Student student) {
                if (student.getId().equals(id)) {
                    System.out.println(student);
                    found[0] = true;
                }
            }
        });
        return found[0];
    }
    public void sortStudentsByScoreHighToLow(){
        ArrayListBuild<Student> scoreHighToLow = new ArrayListBuild<>();
        for (int i = 0; i < listStudent.size(); i++){
            scoreHighToLow.add(listStudent.get(i));
        }
        int n = scoreHighToLow.size();
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                // So sánh điểm số của hai sinh viên
                if (scoreHighToLow.get(i).getScore() < scoreHighToLow.get(j).getScore()) {
                    // Hoán đổi nếu điểm của sinh viên thứ j nhỏ hơn sinh viên thứ j+1
                    Student temp = scoreHighToLow.get(i);
                    scoreHighToLow.set(i, scoreHighToLow.get(j));
                    scoreHighToLow.set(j, temp);
                }
            }
        }
        scoreHighToLow.forEach(new ArrayListBuild.CustomAction<Student>() {
            @Override
            public void execute(Student student) {
                System.out.println(student.getId() + " - " + student.getName() + " - " + student.getScore() + " - " + student.getRank());
            }
        });
    }
    public void sortStudentsByScoreLowToHigh(){
        ArrayListBuild<Student> scoreHighToLow = new ArrayListBuild<>();
        for (int i = 0; i < listStudent.size(); i++){
            scoreHighToLow.add(listStudent.get(i));
        }
        int n = scoreHighToLow.size();
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                // So sánh điểm số của hai sinh viên
                if (scoreHighToLow.get(i).getScore() > scoreHighToLow.get(j).getScore()) {
                    // Hoán đổi nếu điểm của sinh viên thứ j nhỏ hơn sinh viên thứ j+1
                    Student temp = scoreHighToLow.get(i);
                    scoreHighToLow.set(i, scoreHighToLow.get(j));
                    scoreHighToLow.set(j, temp);
                }
            }
        }
        scoreHighToLow.forEach(new ArrayListBuild.CustomAction<Student>() {
            @Override
            public void execute(Student student) {
                System.out.println(student.getId() + " - " + student.getName() + " - " + student.getScore() + " - " + student.getRank());
            }
        });
    }
}
