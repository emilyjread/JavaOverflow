package com.emilyread.overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emilyread.overflow.models.Question;
import com.emilyread.overflow.models.Tag;
import com.emilyread.overflow.repos.TagRepo;

@Service
public class TagService {

	private TagRepo tagRepo;
	
	public TagService(TagRepo tagRepo) {
		this.tagRepo= tagRepo;
	}
	
	public List<Tag> allTags() {
	    return tagRepo.findAll();
	}
	
	public Tag createTag(Tag t) {
	    return tagRepo.save(t);
	}
	
	public Tag findTag(Long id) {
	    Optional<Tag> optionalTag = tagRepo.findById(id);
	    if(optionalTag.isPresent()) {
	        return optionalTag.get();
	    } else {
	        return null;
	    }
	}
	
//	public List<Tag> TagsByQuestion(Question q) {
//        return tagRepo.findByQuestion(q);
//    }
//	
}
