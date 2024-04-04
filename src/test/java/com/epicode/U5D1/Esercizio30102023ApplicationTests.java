package com.epicode.U5D1;

import com.epicode.U5D1.entities.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class Esercizio30102023ApplicationTests {

	// Test 1 --- Controllo dell'ordine se è vuoto
	@Test
	void listItemVuoto() {
		System.out.println("Test 3");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5D1Application.class);
		Tavolo t1 = (Tavolo) ctx.getBean("Tavolo1");
		Ordine o1 = new Ordine(1, StatoOrdine.IN_CORSO, 1, t1);
		assertEquals(0, o1.getItems().size());
	}

	// Test 2 --- Prezzo giusto dell'ordine
	@Test
	void PriceOrderTest1() {
		System.out.println("Test 1");

			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5D1Application.class);
			Tavolo t1 = (Tavolo) ctx.getBean("Tavolo2");
		    Ordine o1 = new Ordine(1, StatoOrdine.IN_CORSO, 1, t1);
			o1.addItem(ctx.getBean("pizza_margherita", Pizza.class));
			o1.addItem(ctx.getBean("hawaiian_pizza", Pizza.class));
			o1.addItem(ctx.getBean("salami_pizza_xl", Pizza.class));
			o1.addItem(ctx.getBean("lemonade", Drink.class));
			o1.addItem(ctx.getBean("lemonade", Drink.class));
			o1.addItem(ctx.getBean("wine", Drink.class));
			assertEquals(31.408, o1.getTotal());
			ctx.close();
	}

	// Test 3 --- Controllo del giusot numero di prodotti nell'ordine
	    @Test
		void nuemeroProdottiGiusto() {
        System.out.println("Test 2");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5D1Application.class);
		Tavolo t1 = (Tavolo) ctx.getBean("Tavolo1");
		Ordine o1 = new Ordine(1, StatoOrdine.IN_CORSO, 1, t1);
		o1.addItem(ctx.getBean("pizza_margherita", Pizza.class));
		assertEquals(1, o1.getItems().size());
	}


	// Test 4 --- Controllo del numero massimo di coperti per tavolo / verifichiamo che se inseriamo un numero di coperti superiore al massimo l'app lancia un'eccezione
	@Test
	void numeroCopertiMassimo() {
		System.out.println("Test 3");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5D1Application.class);
		Tavolo t1 = (Tavolo) ctx.getBean("Tavolo1");
		assertThrows(RuntimeException.class, () -> {
			Ordine o1 = new Ordine(1, StatoOrdine.IN_CORSO, 6, t1);
		});
	}


	// Test Parametrizzato - Set di dati di input (ad esempio, un elenco di ordini con diversi item e coperti) e verifica che il metodo getTotal() restituisca il prezzo corretto per ogni ordine.

	@ParameterizedTest
		@CsvSource("")
	void PriceOrderTestParametrizzato(int idOrdine, StatoOrdine status, int covers, double total) {}



}
