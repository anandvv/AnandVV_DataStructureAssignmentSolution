package com.greatlearning.dsa.skyscraper;

import java.util.LinkedList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> dailyIncomingFloors = new LinkedList<Integer>();
		
		System.out.println("Enter the total number of floors in the building: ");
		int numberOfFloors = sc.nextInt();
		
		for(int i = 0; i< numberOfFloors; i++) {
			System.out.println("enter the floor size on day " + (i + 1));
			dailyIncomingFloors.add(sc.nextInt());
		}
		
		ConstructionCompany cc = new ConstructionCompany(dailyIncomingFloors);
		cc.build();
		
		sc.close();
	}

}
