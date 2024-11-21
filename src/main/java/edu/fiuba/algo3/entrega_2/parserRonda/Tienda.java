package edu.fiuba.algo3.entrega_2.parserRonda;
import java.util.List;

public class Tienda {
    private List<ComodinF> comodines;
    private List<TarotF> tarots;
    private CartaF carta;

    public List<ComodinF> getComodines() {
        return comodines;
    }

    public void setComodines(List<ComodinF> comodines) {
        this.comodines = comodines;
    }

    public List<TarotF> getTarots() {
        return tarots;
    }

    public void setTarots(List<TarotF> tarots) {
        this.tarots = tarots;
    }

    public CartaF getCarta() {
        return carta;
    }

    public void setCarta(CartaF carta) {
        this.carta = carta;
    }
}
