package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void blah(){

	}

	@Test
	public void findWhiskyByYear(){
		List<Whisky> found = whiskyRepository.getWhiskyFromDistilleryOfCertainAge(15, "Glendronach");
		assertEquals("The Glendronach Revival", found.get(0).getName());
	}

	@Test
	public void findWhiskyByRegion(){
		List<Whisky> found = whiskyRepository.getWhiskyByRegion("Highland");
		assertEquals("The Glendronach Revival", found.get(0).getName());
	}

	@Test
	public void findDistilleryByWhiskyAge(){
		List<Distillery> found = distilleryRepository.getDistilleryByWhiskyAge(15);
		assertEquals("Glendronach", found.get(0).getName());
	}


}
