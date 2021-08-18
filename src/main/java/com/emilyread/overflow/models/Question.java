package com.emilyread.overflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="questions")
public class Question {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
  
@NotNull
@Size(min=3, max=500)
private String question;

@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
}
@PreUpdate
protected void onUpdate(){
    this.updatedAt = new Date();
}

@OneToMany(mappedBy="question", fetch=FetchType.LAZY)
private List<Answer> answers;

private String tag;

public Question() {
	
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public List<Answer> getAnswers() {
	return answers;
}
public void setAnswers(List<Answer> answers) {
	this.answers = answers;
}


public String getTag() {
	return tag;
}

public void setTag(String tag) {
	this.tag = tag;
}

public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
public Date getUpdatedAt() {
	return updatedAt;
}
public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}



@Column(updatable=false)
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date createdAt;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date updatedAt;


}
