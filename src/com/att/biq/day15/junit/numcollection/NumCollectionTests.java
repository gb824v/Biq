package com.att.biq.day15.junit.numcollection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class NumCollectionTests
{
	@Test
	public void testSize()
	{
		NumCollectionStartegy1 numCollection = new NumCollectionStartegy1("10-100,-90-0");
	}
	
}