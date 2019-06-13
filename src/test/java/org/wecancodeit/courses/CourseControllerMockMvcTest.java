package org.wecancodeit.courses;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Collection;
import static java.util.Arrays.asList;


@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class CourseControllerMockMvcTest {
	
	@Resource
	private MockMvc mvc;
	
	@Mock
	private Course firstCourse;
	
	@Mock 
	private Course secondCourse;
	
	@MockBean
	private CourseRepository repository;
	
	@Test
	public void shouldBeOkForAllCourses() throws Exception{
		mvc.perform(get("/show-courses")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToAllCoursesView() throws Exception{
		mvc.perform(get("/show-courses")).andExpect(view().name(is("courses")));
	}
	
	@Test
	public void shouldPutAllCoursesIntoModel() throws Exception{
		Collection<Course>allCourses = asList(firstCourse, secondCourse);
		when(repository.findAll()).thenReturn(allCourses);
		mvc.perform(get("/show-courses")).andExpect(model().attribute("courses", is(allCourses)));
	}

}
