package com.greatlearning.dsa.skyscraper;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class ConstructionCompany {
	int floorsToBuild;
	LinkedList<Integer> dailyIncomingFloors, sortedFloors;
	Stack<Integer> storage;
	
	@SuppressWarnings("unchecked")
	public ConstructionCompany(LinkedList<Integer> incomingFloors) {
		this.floorsToBuild = incomingFloors.size();
		dailyIncomingFloors = incomingFloors;
		sortedFloors = (LinkedList<Integer>) dailyIncomingFloors.clone();
		Collections.sort(sortedFloors, Collections.reverseOrder());
		storage = new Stack<Integer>();
	}
	
	public void build() {
		
		int completedWork = 0;
		
		for (int day=1; day<= floorsToBuild; day++) {
			int dailyIncomingFloor = dailyIncomingFloors.removeFirst();
			
			System.out.println("\nDay: " + day);

			if(!sortedFloors.isEmpty()) {
				if(sortedFloors.getFirst() == dailyIncomingFloor) {
					
					System.out.print(sortedFloors.removeFirst() + "  ");
					completedWork++;
					
					while(!storage.isEmpty() && (storage.peek() == sortedFloors.peekFirst()) && (day - completedWork > 0)) {
						System.out.print(storage.pop() + "  ");
						completedWork++;
						sortedFloors.removeFirst();
					}
				}else {
					storage.push(dailyIncomingFloor);
					Collections.sort(storage);
				}
			}
		}
		
	}

}
