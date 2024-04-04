package com.epicode.U5D1;

import com.epicode.U5D1.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class OrderRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5D1Application.class);
        try {
            // Stampiamo il menu
            Menu m = (Menu) ctx.getBean("menu");
            m.printMenu();

            // Creiamo un oggetto di tipo Tavolo
            Tavolo t1 = (Tavolo) ctx.getBean("Tavolo2");

            // Creiamo un oggetto di tipo Ordine
            Ordine o1 = new Ordine(1, StatoOrdine.IN_CORSO, 1, t1);

            // Aggiungiamo prodotti dal menu all'ordine o1
            o1.addItem(ctx.getBean("pizza_margherita", Pizza.class));
            o1.addItem(ctx.getBean("hawaiian_pizza", Pizza.class));
            o1.addItem(ctx.getBean("salami_pizza_xl", Pizza.class));
            o1.addItem(ctx.getBean("lemonade", Drink.class));
            o1.addItem(ctx.getBean("lemonade", Drink.class));
            o1.addItem(ctx.getBean("wine", Drink.class));

            //Stampiamo i dettagli dell'ordine
            System.out.println("DETTAGLI TAVOLO 1:");
            o1.print();

            //Facciamo il conto del tavolo, aggiungendo al prezzo totale dei prodotti, anche il prezzo dei coperti
            System.out.println("CONTO TAVOLO 1");
            System.out.println(o1.getTotal());

        }catch (Exception e) {
            System.err.println(e.getMessage());
        }finally {
            ctx.close();
        }
    }
}
