import java.util.ArrayDeque;

public class MergeSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
  
    // ***********************************************************
    // Here is where you'll do the "work" of MergeSort:
    //   - Use queue to store the intermediate piles
    //   - Don't forget to register the new state with the
    //     recorder after each merge step:
    //        record.next();        // tell it this is a new step
    //        for (CardPile pile: queue) { // add all piles
    //           record.add(pile);
    //        }
    // ***********************************************************
    while (unsorted.size() > 0) {
      Card c = unsorted.remove();
      CardPile isolatedCard = new CardPile();
      isolatedCard.addFirst(c);
      queue.add(isolatedCard);
    }
    
// While more than one list remains on the queue:
// Remove the first two lists from the queue and merge them, preserving their sorted order.
// Put the result back at the end of the queue.

    while (queue.size() > 0) {
      CardPile isolatedCard1 = queue.poll();
      CardPile isolatedCard2 = queue.poll();

      
    }

    // return the sorted result here
    return queue.remove();
  }
}
