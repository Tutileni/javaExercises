package com.test.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Java program for implementation of QuickSort
class QuickSort
{
	/* This function takes last element as pivot,
	places the pivot element at its correct
	position in sorted array, and places all
	smaller (smaller than pivot) to left of
	pivot and all greater elements to right
	of pivot */
	int partition(int arr[], int low, int high)
	{
		int pivot = arr[high]; 
		int i = (low-1); // index of smaller element
		for (int j=low; j<high; j++)
		{
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] <= pivot)
			{
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;

		return i+1;
	}


	/* The main function that implements QuickSort()
	arr[] --> Array to be sorted,
	low --> Starting index,
	high --> Ending index */
	void sort(int arr[], int low, int high)
	{
		if (low < high)
		{
			/* pi is partitioning index, arr[pi] is 
			now at right place */
			int pi = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	// Driver program
	public static void main(String args[])
	{
		int arr[] = {10, 7, 8, 9, 1, 5};
		int n = arr.length;

		QuickSort ob = new QuickSort();
		ob.sort(arr, 0, n-1);

		System.out.println("sorted array");
		printArray(arr);
	}
}
/*This code is contributed by Rajat Mishra */



//Java code​​​​​​​‌​‌​​‌‌‌‌​‌‌‌‌​​‌​​​‌​​‌ below

enum CardColor {
 Spade, Diamond, Club, Heart
}
enum CardValue {
 Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace
}

class GameException extends RuntimeException {
}

class Card {
 public final CardColor color;
 public final CardValue value;

 public Card(CardColor cardColor, CardValue cardValue) {
     color = cardColor;
     value = cardValue;
 }
}

class Deck {
 public ArrayList<Card> cards;
 public int getCardsCount() {
     return cards == null ? 0 : cards.size();
 }

 public Deck(int cardsCount) {
     if (cardsCount % 4 != 0)
         throw new GameException();
     cards = new ArrayList<>(cardsCount);
     addCards(cardsCount);
 }

 private void addCards(int cardsToAdd) {
     int cardsAdded  = 0;
     while (cardsAdded < cardsToAdd)
         for (CardColor cardColor : CardColor.values())
             for (CardValue cardValue : CardValue.values()) {
                 if (cardsAdded >= cardsToAdd)
                     break;
                 cards.add(new Card(cardColor, cardValue));
                 ++cardsAdded;
             }
 }

 public void shuffle() {
     Collections.shuffle(cards);
 }
}

class Player {
 private String _name;

 // TO DO : uncomment and choose your Collection type
 //public Collection<Card> cards;
 public int getCardsCount() {
     return cards == null ? 0 : cards.size();
 }

 public Player(String name) {
     _name = name;
 }

 public void addCard(Card card) {
     // TO DO
 }
}

class Game {
 private int         _cardsCount;
 private int         _playersCount;
 public Deck         deck;
 public List<Player> players;
 public int getPlayersCount() {
     return players == null ? 0 : players.size();
 }

 public Game(int playersCount, int cardsCount) {
     _playersCount = playersCount;
     _cardsCount   = cardsCount;
     players       = newListPlayer(playersCount);
     deck          = new Deck(cardsCount);
 }

 public void distributeCardsEvenlyToPlayers() {
     // TO DO
 }

 private List<Player> newListPlayer(int playersCount) {
     // TO DO
 }

 public void start() {
     deck.shuffle();
     distributeCardsEvenlyToPlayers();
 }
}

