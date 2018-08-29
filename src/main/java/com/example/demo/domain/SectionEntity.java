/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "section")
public class SectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "parent_id")
    private Integer parentId;

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

    @OneToMany(mappedBy = "sectionEntity", cascade = {CascadeType.DETACH, CascadeType.MERGE,
                                                        CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<TaskEntity> tasks;

    public SectionEntity() {
    }

    public SectionEntity(LocalDateTime createdDate, LocalDateTime updatedDate, int sectionLevel, String sectionKey, String sectionValue) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.sectionLevel = sectionLevel;
        this.sectionKey = sectionKey;
        this.sectionValue = sectionValue;
    }

    public SectionEntity(Integer parentId, LocalDateTime createdDate, LocalDateTime updatedDate, int sectionLevel, String sectionKey, String sectionValue) {
        this.parentId = parentId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.sectionLevel = sectionLevel;
        this.sectionKey = sectionKey;
        this.sectionValue = sectionValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
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

    public Set<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskEntity> tasks) {
        this.tasks = tasks;
    }

    // add convenience methods for bi-directional relationship

    public void add(TaskEntity task) {
        if (tasks == null){
            tasks = new HashSet<>();
        }
        tasks.add(task);
        task.setSectionEntity(this);
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