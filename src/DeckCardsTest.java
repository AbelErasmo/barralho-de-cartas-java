
public class DeckCardsTest {

	public static void main(String[] args) {
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); // coloca Cards em ordem aleatoria
		
		// imprime todas as 52 cartas na ordem em que elas sao distribuidas
		for (int i = 1; i <= 52; i++) {
			// distribui e exibe uma Card
			System.out.printf("%-19s", myDeckOfCards.dealCard());
			
			if (i % 4 == 0) // gera uma nova linha apos cada quarta carta
				System.out.println();
		}
	}

}
