package org.wecancodeit.courses;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;


@Repository
public class CourseRepository {
	
	private Map<Long, Course> courseList = new HashMap<>();
	
	public CourseRepository(Course...courses) {
		for(Course course: courses) {
		courseList.put(course.getId(), course);
		}
	}

	public Course findOne(long id) {
		return courseList.get(id);
	}

	public Collection<Course> findAll() {
		return courseList.values();
	}
}
