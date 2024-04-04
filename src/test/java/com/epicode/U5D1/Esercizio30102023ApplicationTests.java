package com.epicode.U5D1;

import com.epicode.U5D1.entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Esercizio30102023ApplicationTests {

	// Test 1 --- Prezzo giusto dell'ordine
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

	// Test 2 --- Controllo del giusot numero di prodotti nell'ordine
	    @Test
		void nuemeroProdottiGiusto() {
        System.out.println("Test 2");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5D1Application.class);
		Tavolo t1 = (Tavolo) ctx.getBean("Tavolo1");
		Ordine o1 = new Ordine(1, StatoOrdine.IN_CORSO, 1, t1);
		o1.addItem(ctx.getBean("pizza_margherita", Pizza.class));
		assertEquals(1, o1.getItems().size());
	}


    // Test 3 --- Controllo del numero massimo di coperti per tavolo



}
