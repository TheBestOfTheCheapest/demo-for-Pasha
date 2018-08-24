/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "section")
public class SectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "parent_id")
    private int parentId;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "section_level")
    private int sectionLevel;

    @Column(name = "section_key")
    private String sectionKey;

    @Column(name = "section_value")
    private String sectionValue;

    public SectionEntity() {
    }

    public SectionEntity(LocalDateTime createdDate, LocalDateTime updatedDate, int sectionLevel, String sectionKey, String sectionValue) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.sectionLevel = sectionLevel;
        this.sectionKey = sectionKey;
        this.sectionValue = sectionValue;
    }

    public SectionEntity(int parentId, LocalDateTime createdDate, LocalDateTime updatedDate, int sectionLevel, String sectionKey, String sectionValue) {
        this.parentId = parentId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.sectionLevel = sectionLevel;
        this.sectionKey = sectionKey;
        this.sectionValue = sectionValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getSectionLevel() {
        return sectionLevel;
    }

    public void setSectionLevel(int sectionLevel) {
        this.sectionLevel = sectionLevel;
    }

    public String getSectionKey() {
        return sectionKey;
    }

    public void setSectionKey(String sectionKey) {
        this.sectionKey = sectionKey;
    }

    public String getSectionValue() {
        return sectionValue;
    }

    public void setSectionValue(String sectionValue) {
        this.sectionValue = sectionValue;
    }

    @Override
    public String toString() {
        return "SectionEntity{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", sectionLevel=" + sectionLevel +
                ", sectionKey='" + sectionKey + '\'' +
                ", sectionValue='" + sectionValue + '\'' +
                '}';
    }
}