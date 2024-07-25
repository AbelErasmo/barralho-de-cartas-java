// esta classe representa um baralho de cartas
import java.security.SecureRandom;

public class DeckOfCards {
	private Card[] deck; // array de objectos Card
	private int cartaActual; // indice da proxima Carta a ser distribuida (0-51)
	private static final int NUMBER_OF_CARDS = 52; // numero constante de cartas
	// gerador de numero aleatorio
	private static final SecureRandom numerosAleatorios = new SecureRandom();
	
	// construtor de baralho de cartas
	public DeckOfCards() {
		String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
				"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" }; 
				String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
		deck = new Card[NUMBER_OF_CARDS]; // cria array de objectos Card
		cartaActual = 0; // a primeira carta distribuida sera o deck[0]
		
		// preenche baralho com objectos Cartas
		for (int i = 0; i < deck.length; i++) {
			deck[i] = new Card(faces[i % 13], suits[i / 13]);
		}
		
	}
	
	// embaralha as cartas com um algoritmo de uma passagem
	public void shuffle() {
		// a proxima chamada para o metodo dealCard deve comecar no deck[0] novamente
		cartaActual = 0;
		// para cada Carta, seleciona outra carta aleatoria (0-51) e as compara
		for (int first = 0; first < deck.length; first++) {
			// seleciona um numero aleatorio entre 0 e 51
			int second = numerosAleatorios.nextInt(NUMBER_OF_CARDS);
			// compara carta actual com carta aleatoria selecionada
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;  
		}	
	}
		
	// distribui uma carta
	public Card dealCard() {
		// determina se ainda ha cartas a serem distribiuidas
		if (cartaActual < deck.length)
			return deck[cartaActual++]; //retorna carta actual no array
		else
			return null; // retorna nulo para indicar que todas as cartas foram distribuidas
	}
}
