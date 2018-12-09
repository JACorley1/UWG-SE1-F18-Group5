package edu.westga.cs3211.time_management.test.calendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.Calendar;
import edu.westga.cs3211.time_management.model.Event;
import edu.westga.cs3211.time_management.model.Visibility;

class TestRemoveEvent {

	@Test
	public void testRemovingdNullEvent() {
		Calendar myCalendar = new  Calendar();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myCalendar.removeEvent(null);
		});
	}
	
	@Test
	public void testRemoveFromEmptyCalendar() {
		Calendar myCalendar = new  Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		ArrayList<String> attendees = new ArrayList<String>();
		attendees.add("jack");
		Event myEvent = new Event("Name", start, end, "school", "homework", attendees, Visibility.PUBLIC);
		boolean actualRemove = myCalendar.removeEvent(myEvent);
		assertFalse(actualRemove);
	}
	
	@Test
	public void testCalendarSizeOne() {
		Calendar myCalendar = new  Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		ArrayList<String> attendees = new ArrayList<String>();
		attendees.add("jack");
		Event myEvent = new Event("Name", start, end, "school", "homework", attendees, Visibility.PUBLIC);
		
		myCalendar.addEvent(myEvent);
		boolean actualRemove = myCalendar.removeEvent(myEvent);
		assertTrue(actualRemove);
	}
	
	@Test
	public void testRemoveFirstEvent() {
		Calendar myCalendar = new  Calendar();
		LocalDateTime start0 = LocalDateTime.now().plusDays(1);
		LocalDateTime end0 = start0.plusDays(1);
		ArrayList<String> attendees0 = new ArrayList<String>();
		attendees0.add("jack");
		Event myEvent0 = new Event("First", start0, end0, "school", "homework", attendees0, Visibility.PUBLIC);
		
		LocalDateTime start1 = LocalDateTime.now().plusDays(2);
		LocalDateTime end1 = start1.plusDays(1);
		ArrayList<String> attendees1 = new ArrayList<String>();
		attendees1.add("jill");
		Event myEvent1 = new Event("Second", start1, end1, "school", "project", attendees1, Visibility.PUBLIC);
		
		LocalDateTime start2 = LocalDateTime.now().plusDays(3);
		LocalDateTime end2 = start2.plusDays(1);
		ArrayList<String> attendees2 = new ArrayList<String>();
		attendees2.add("lynn");
		Event myEvent2 = new Event("Third", start2, end2, "school", "project", attendees2, Visibility.PUBLIC);
		
		myCalendar.addEvent(myEvent0);
		myCalendar.addEvent(myEvent1);
		myCalendar.addEvent(myEvent2);
		boolean actualRemove = myCalendar.removeEvent(myEvent0);
		assertTrue(actualRemove);
	}
	
	@Test
	public void testRemovMiddleEvent() {
		Calendar myCalendar = new  Calendar();
		LocalDateTime start0 = LocalDateTime.now().plusDays(1);
		LocalDateTime end0 = start0.plusDays(1);
		ArrayList<String> attendees0 = new ArrayList<String>();
		attendees0.add("jack");
		Event myEvent0 = new Event("First", start0, end0, "school", "homework", attendees0, Visibility.PUBLIC);
		
		LocalDateTime start1 = LocalDateTime.now().plusDays(2);
		LocalDateTime end1 = start1.plusDays(1);
		ArrayList<String> attendees1 = new ArrayList<String>();
		attendees1.add("jill");
		Event myEvent1 = new Event("Second", start1, end1, "school", "project", attendees1, Visibility.PUBLIC);
		
		LocalDateTime start2 = LocalDateTime.now().plusDays(3);
		LocalDateTime end2 = start2.plusDays(1);
		ArrayList<String> attendees2 = new ArrayList<String>();
		attendees2.add("lynn");
		Event myEvent2 = new Event("Third", start2, end2, "school", "project", attendees2, Visibility.PUBLIC);
		
		myCalendar.addEvent(myEvent0);
		myCalendar.addEvent(myEvent1);
		myCalendar.addEvent(myEvent2);
		boolean actualRemove = myCalendar.removeEvent(myEvent2);
		assertTrue(actualRemove);
	}
	
	@Test
	public void testRemoveLastEvent() {
		Calendar myCalendar = new  Calendar();
		LocalDateTime start0 = LocalDateTime.now().plusDays(1);
		LocalDateTime end0 = start0.plusDays(1);
		ArrayList<String> attendees0 = new ArrayList<String>();
		attendees0.add("jack");
		Event myEvent0 = new Event("First", start0, end0, "school", "homework", attendees0, Visibility.PUBLIC);
		
		LocalDateTime start1 = LocalDateTime.now().plusDays(2);
		LocalDateTime end1 = start1.plusDays(1);
		ArrayList<String> attendees1 = new ArrayList<String>();
		attendees1.add("jill");
		Event myEvent1 = new Event("Second", start1, end1, "school", "project", attendees1, Visibility.PUBLIC);
		
		LocalDateTime start2 = LocalDateTime.now().plusDays(3);
		LocalDateTime end2 = start2.plusDays(1);
		ArrayList<String> attendees2 = new ArrayList<String>();
		attendees2.add("lynn");
		Event myEvent2 = new Event("Third", start2, end2, "school", "project", attendees2, Visibility.PUBLIC);
		
		myCalendar.addEvent(myEvent0);
		myCalendar.addEvent(myEvent1);
		myCalendar.addEvent(myEvent2);
		boolean actualRemove = myCalendar.removeEvent(myEvent2);
		assertTrue(actualRemove);
	}
	
	@Test
	public void testRemoveNonExistingEvent() {
		Calendar myCalendar = new  Calendar();
		LocalDateTime start0 = LocalDateTime.now().plusDays(1);
		LocalDateTime end0 = start0.plusDays(1);
		ArrayList<String> attendees0 = new ArrayList<String>();
		attendees0.add("jack");
		Event myEvent0 = new Event("First", start0, end0, "school", "homework", attendees0, Visibility.PUBLIC);
		
		LocalDateTime start1 = LocalDateTime.now().plusDays(2);
		LocalDateTime end1 = start1.plusDays(1);
		ArrayList<String> attendees1 = new ArrayList<String>();
		attendees1.add("jill");
		Event myEvent1 = new Event("Second", start1, end1, "school", "project", attendees1, Visibility.PUBLIC);
		
		LocalDateTime start2 = LocalDateTime.now().plusDays(3);
		LocalDateTime end2 = start2.plusDays(1);
		ArrayList<String> attendees2 = new ArrayList<String>();
		attendees2.add("lynn");
		Event myEvent2 = new Event("Third", start2, end2, "school", "project", attendees2, Visibility.PUBLIC);
		
		myCalendar.addEvent(myEvent0);
		myCalendar.addEvent(myEvent1);
		boolean actualRemove = myCalendar.removeEvent(myEvent2);
		assertFalse(actualRemove);
	}
}
