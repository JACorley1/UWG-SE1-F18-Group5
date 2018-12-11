package edu.westga.cs3211.time_management.model;

import java.util.ArrayList;
import java.util.List;

/** Store and manage a collection of events.
 * Code Coverage: 100%
 * @author Jonathan Corley, Lucas Carlson, Carson Bedrosian, Nolan Williams, Kevin Flynn, Victoria Jenkins, Laura Smedley, Jonathan Nicholl, Brandon Walker
 */
public class Calendar {
	
	private ArrayList<Event> events;
	public static final String EVENT_CANNOT_BE_NULL = "Event cannot be null";
	
	/** Return the collection of events in the calendar
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the collection of events in the calendar
	 */
	public ArrayList<Event> getEvents() {
		return this.events;
	}
	
	/** Create a new initially empty Calendar
	 * 
	 * @precondition none
	 * @postcondition getEvents().size() == 0
	 */
	public Calendar() {
		this.events = new ArrayList<Event>();
	}
	
	/** Add a new event to the calendar
	 * 
	 * @precondition event != null
	 * @postcondition getEvents().size() == getEvents().size()@pre + 1
	 * 
	 * @param event event to be added to the calendar
	 */
	public void addEvent(Event event) {
		if (event == null) {
			throw new IllegalArgumentException(EVENT_CANNOT_BE_NULL);
		}
		
		this.events.add(event);
	}
	
	/** Updates an event from the calendar
	 * 
	 * @precondition event != null
	 * @postcondition the given old event will be updated to the new event
	 * 
	 * @param oldEvent the event to be updated
	 * @param newEvent the updated event
	 */
	public void updateEvent(Event oldEvent, Event newEvent) {
		if (oldEvent == null || newEvent == null) {
			throw new IllegalArgumentException(EVENT_CANNOT_BE_NULL);
		}
		int oldEventIndex = this.findIndex(oldEvent);
		
		this.events.add(oldEventIndex, newEvent);
		this.events.remove(oldEventIndex + 1);
	}
	
	private int findIndex(Event event) {
		int finalIndex = 0;
		int index = 0;
		for (Event currentEvent : this.events) {
			if (currentEvent.equals(event)) {
				finalIndex = index;
			}
			index++;
		}
		return finalIndex;
	}
	
	/** Removes an event from the calendar
	 * 
	 * @precondition event != null
	 * @postcondition getEvents().size() == getEvents().size()@pre - 1
	 * 
	 * @param event event to be added to the calendar
	 * @return true if the event was removed false otherwise
	 */
	public boolean removeEvent(Event event) {
		if (event == null) {
			throw new IllegalArgumentException(EVENT_CANNOT_BE_NULL);
		}
		return this.events.remove(event);
	}
	
	/** Finds and returns the list of events in the calendar that would conflict with the specified event
	 * 
	 * @precondition event != null
	 * @postcondition none
	 * 
	 * @param event the event to check for conflicts
	 * 
	 * @return the list of events in the calendar that would conflict with the specified event
	 */
	public List<Event> declareConflicts(Event event) {
		if (event == null) {
			throw new IllegalArgumentException(EVENT_CANNOT_BE_NULL);
		}
		List<Event> conflicts = new ArrayList<Event>();
		
		for (Event current: this.events) {
			if (!event.getStartTime().isBefore(current.getStartTime()) && !event.getStartTime().isAfter(current.getEndTime())) {
				conflicts.add(current);
			}
			if (!event.getEndTime().isBefore(current.getStartTime()) && !event.getEndTime().isAfter(current.getEndTime())) {
				conflicts.add(current);
			}
		}
		
		return conflicts;
	}
	
	/**
	 * Provides a description of the calendar
	 * @precondition none
	 * @postcondition none
	 * @return a description of the calendar
	 */
	public String toString() {
		String output = "";
		for (Event currentEvent : this.events) {
			output += currentEvent.toStringFull();
		}
		return output;
	}
}
