import java.util.*;

public class InsertionSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
  
    // ***********************************************************
    // Here is where you'll do the "work" of InsertionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:

    // ***********************************************************
          
          //while hasprevious
          //if less, move
          //if more, iterate after

          //else
          //create iterator that goes backwards

    Card c = unsorted.getFirst();
    unsorted.removeFirst();
    sorted.add(c);

    //Record new state
    record.next();
    record.add(sorted);
    record.add(unsorted);
    
    while (unsorted.size() > 0) {
      // Remove the first element from unsorted and find the point where it should go in sorted
      // (the point where all previous elements are smaller than the removed element, and all
      // following elements are greater than or equal to it).
      // Insert the removed element into sorted at this point.
      c = unsorted.remove();
    
      if ((c.compareTo(sorted.getFirst())) < 0) {
        sorted.addFirst(c);
        //Record new state
        record.next();
        record.add(sorted);
        record.add(unsorted);
      }
      
      else {
        ListIterator<Card> pos = sorted.listIterator(sorted.size());
        Card lastCard = pos.previous();

        while (pos.hasPrevious() && c.compareTo((lastCard)) < 0) {
          lastCard = pos.previous();
        }        
        sorted.insertAfter(c, lastCard);
        
        //Record new state
        record.next();
        record.add(sorted);
        record.add(unsorted);

      }  
    }
    
    // return the sorted result here
    return sorted;
  }

  public static void main(String args[]) {
    // set up a class to record and display the sorting results
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // for debugging purposes, uncomment this to
    // work with a smaller number of cards:
    // cards = cards.split(cards.get(39));

    // mix up the cards
    Collections.shuffle(cards);
    System.out.println("cahhh");
    // if you want to sort in array form, use:
    Card[] card_arr = cards.toArray(new Card[0]);

    // in your program, this would be a call to a real sorting algorithm
    cards = InsertionSort.sort(cards, recorder);
    System.out.println("ddd");
    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: SelectionSort");
  }
}
  

