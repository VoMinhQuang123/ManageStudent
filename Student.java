public class Student {
    private String id;
    private String name;
    private float score;
    private String rank;
    //
    //
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getScore() {
        return score;
    }
    public void setScore(float score) {
        this.score = score;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    //
    //
    public Student(String id, String name, float score, String rank) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.rank = rank;
    }
    @Override
    public String toString() {
        return "Student{" +
                " ID='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Score=" + score +
                ", Rank=" + rank +
                '}';
    }
    public Student(String id){
        this.id = id;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}