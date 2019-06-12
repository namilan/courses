package org.wecancodeit.courses;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CourseRepositoryTest {
	
	private long id = 1L;
	private Course course = new Course(id, "course name", "course description");
	
	@Test
	public void shouldFindACourse() {
		CourseRepository underTest = new CourseRepository(course);
		Course result = underTest.findOne(id);
		assertThat(result, is(course));		
	}

}
