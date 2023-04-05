package com.bakalarka.StudentAttendanceApp.Exception;

public class LessonNotFoundException extends RuntimeException{

    public LessonNotFoundException(String message) {
        super(message);
    }
}
