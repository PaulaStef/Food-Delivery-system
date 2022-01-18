package business;

import java.util.LinkedList;

public interface IDeliveryServiceProcessing {
    /** Adauga un nou produs "product" de tip MenuItem campului menuItems, care retine toate produsele
     * @pre product != null
     * @pre isWellFormed()
     * @post isWellFormed()
     *
     */
    void createNewMenuItem(MenuItem product);

    /**
     * Cauta un produs dupa nume, dupa care il sterge din lista
     * @pre name != null
     * @pre isWellFormed()
     * @post products != null
     * @post isWellFormed()
     *
     */
    void deleteMenuItem(String name);

    /**
     * Editeaza un produs ,pe care il cutam dupa nume, si il inlocuim cu noul produs
     * @pre name != null && oldItem != null
     * @pre isWellFormed()
     * @post products != null
     * @post isWellFormed()
     *
     */
    void editMenuItem(String name, MenuItem oldItem);

    /**
     * Creeaza o noua comanda cu produsele descrise in items si facute de clientul cu nume clientName
     * @pre clientName != null && items != null
     * @pre isWellFormed()
     * @post products != null
     * @post isWellFormed()
     *
     */
    Order createNewOrder(String clientName, String items);

    /**
     * Creeaza un nou meniu (CompositeProduct) cu numele name si care contine o lista de produse (items)
     * @pre name != null & !items.isEmpty()
     * @pre isWellFormed()
     * @post isWellFormed()
     */
    void createDailyMenu(String name, LinkedList<MenuItem> items);
    /**
     * Calculeaza pretul total al produselor din lista items
     * @pre items != null
     * @pre isWellFormed()
     * @post isWellFormed()
     */
    float computePrice(LinkedList<MenuItem> items);

    /**
     * Creeaza un fisier.txt in care vom scrie date despre comanda order
     * @pre order != null
     * @pre isWellFormed()
     * @post orders != null
     * @post isWellFormed()
     */
    void generateBill(Order order);
}
