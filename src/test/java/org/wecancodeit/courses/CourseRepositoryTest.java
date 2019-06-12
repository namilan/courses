package org.wecancodeit.courses;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CourseRepositoryTest {
	
	private long firstCourseId = 1L;
	private Course FirstCourse = new Course(firstCourseId, "course name", "course description");
	
	private long secondCourseId = 2L;
	private Course secondCourse = new Course(secondCourseId, "course name", "course description");
	
	@Test
	public void shouldFindACourse() {
		CourseRepository underTest = new CourseRepository(FirstCourse);
		Course result = underTest.findOne(firstCourseId);
		assertThat(result, is(FirstCourse));		
	}
	
	@Test
	public void ShouldFindASecondCourse() {
		CourseRepository underTest = new CourseRepository(secondCourse);
		Course result = underTest.findOne(secondCourseId);
		assertThat(result, is(secondCourse));
	}

}
