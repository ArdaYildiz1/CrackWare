package com.crackware.erasmus.data.model;

import com.crackware.erasmus.data.model.BaseEntity;
import com.crackware.erasmus.data.model.Department;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.swing.text.Document;
@Setter
@Getter
@Entity
public class Coordinator extends BaseEntity {
    @Enumerated
    private Department department;
    private String signature; // String is used instead of string type


    public void viewApplication() {
    }

    public void finalizePlacements() {
        // Sign the string
    }

    public void setWaitingBin() {
        // Sign the string
    }

    public void nominateStudents() {
        // Sign the string
    }

    public void viewCourseWishlist() {
        // Sign the string
    }

    public void processLearningAgreement() {
        // Sign the string
    }

    public void finalCourseTransferForm() {
        // Sign the string
    }

    public void sign(String document) {
        // Sign the document
    }
}
