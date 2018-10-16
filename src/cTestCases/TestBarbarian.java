package cTestCases;

import static org.junit.Assert.*;

import org.junit.Test;

import cPathfinderCharacterObjects.PathfinderCharacter;
import cPathfinderCharacterObjects.Barbarian;

public class TestBarbarian {

	@Test
	public void testBarbarian() {
		PathfinderCharacter Chad = new Barbarian();
		System.out.println(Chad.getCharacterSkills().toString()); 
	}

}
