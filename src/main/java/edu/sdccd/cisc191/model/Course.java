package edu.sdccd.cisc191.model;

public class Course {
    private int id;
    private String title;
    private int studentId;

    public Course(int id, String title, int studentId) {
        // TODO validate fields and assign them
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid course id");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Invalid title");
        }

        if (studentId <= 0) {
            throw new IllegalArgumentException("Invalid student id");
        }

            this.id = id;
            this.title = title;
            this.studentId = studentId;
        }

        public int getId () {
            return id;
        }

        public String getTitle () {
            return title;
        }

        public int getStudentId () {
            return studentId;
        }

        @Override
        public String toString () {
            return "Course{id=" + id + ", title='" + title + '\'' + ", studentId=" + studentId + '}';
        }
    }
