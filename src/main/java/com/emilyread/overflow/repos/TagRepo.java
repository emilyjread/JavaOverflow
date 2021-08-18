package com.emilyread.overflow.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emilyread.overflow.models.Question;
import com.emilyread.overflow.models.Tag;

@Repository
public interface TagRepo extends CrudRepository<Tag, Long>{
	List<Tag> findAll();
//	List<Tag> findByQuestion(Question q);
}
