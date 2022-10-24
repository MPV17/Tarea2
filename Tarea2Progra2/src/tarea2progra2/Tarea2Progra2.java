
package tarea2progra2;

import java.util.ArrayList;

abstract class Moneda{
    public Moneda(){
    }
    public String getSerie(){
        String s = Integer.toString(System.out.hashCode());
        return s;
    }
    public abstract int getValor();
}
class Moneda1000 extends Moneda{
    @Override
    public int getValor(){
        return 1000;
    }
}
class Moneda500 extends Moneda{
    @Override
    public int getValor(){
        return 500;
    }
}
class Moneda100 extends Moneda{
    @Override
    public int getValor(){
        return 100;
    }
}

abstract class Bebida{
    private final int serie;
    public Bebida(int numSerie){
        serie = numSerie;
    }
    public int getSerie(){
        return serie;
    }
    public String toString(){
        return "sabor: ";
    }
}

class Sprite extends Bebida{
    public Sprite(int numSerie){
        super(numSerie);
    }
    @Override
    public String toString(){
        return super.toString() + "sprite";
    }
}

class CocaCola extends Bebida{
    public CocaCola(int numSerie){
        super(numSerie);
    }
    @Override
    public String toString(){
        return super.toString() + "cocacola";
    }
}
class Fanta extends Bebida{
    public Fanta(int numSerie){
        super(numSerie);
    }
    @Override
    public String toString(){
        return super.toString() + "cocacola";
    }
}

class DepositoBebidas{
    private final ArrayList<Bebida> var;
    public DepositoBebidas(){
        var = new ArrayList();
    }
    public void addBebida(Bebida b){
        var.add(b);
    }
    public Bebida getBebida(){
        if(var.size()<1){
            return null;
        }else{ 
            return var.remove(0);
        }
    }
}

class DepositoMonedas{
    private final ArrayList<Moneda> var;
    public DepositoMonedas(){
        var = new ArrayList();
    }
    public void addMoneda(Moneda b){
        var.add(b);
    }
    public Moneda getMoneda(){
        if(var.size()<1){
            return null;
        }else{ 
            return var.remove(0);
        }
    }
    public int size(){
        return var.size();
    }
}

class Expendedor{
    private DepositoBebidas coca;
    private DepositoBebidas sprite;
    private DepositoBebidas fanta;
    private DepositoMonedas DepoMonedas; 
    private int precioBebidas;
    public Expendedor(int cantidad,int precio){
        DepoMonedas = new DepositoMonedas();
        precioBebidas = precio;
        int numsc = 100;
        int numss = 200;
        int numsf = 300;
        coca = new DepositoBebidas();
        sprite = new DepositoBebidas();
        fanta = new DepositoBebidas();
        for(int i=0;i<cantidad;i=i+1){
            coca.addBebida(new CocaCola(numsc));
            numsc = numsc+1;
            sprite.addBebida(new Sprite(numss));
            numss = numss+1;
            fanta.addBebida(new Fanta(numsf));
            numss = numsf+1;
        }
    }
    public Bebida comprarBebida(Moneda a,int selec ){
        switch (selec) {
            case 1 -> {
                return coca.getBebida();
            }
            case 2 -> {
                return sprite.getBebida();
            }
            case 3 -> {
                return fanta.getBebida();
            }
            default -> {
                return null;
            }
        }
    }
    public void setDeposito(Moneda m){
        int valorVuelto = m.getValor() - precioBebidas;
        for(int i=0;i<valorVuelto/100;i=i+1){
            Moneda monedaTemp = new Moneda100();
            DepoMonedas.addMoneda(monedaTemp);
        }
    }
    public Moneda getVuelto(){
        if(DepoMonedas.size()>0){
            return DepoMonedas.getMoneda();
        }else 
            return null;
    }
    
}

class Comprador{
    private Moneda monedaComprador;
    private int queBebida;
    private int sumatoriaVuelto;
    private String sabor;
    public Comprador(Moneda m, int cualBebida, Expendedor exp){
        monedaComprador = m;
        queBebida = cualBebida;
        sumatoriaVuelto = 0;
    }
    public Moneda getMoneda(){
        return monedaComprador;
    }
    public int getQueBebida(){
        return queBebida;
    }
    public void setSabor(Bebida b){
        sabor = b.toString();
    }
    public void setVuelto(Moneda m){
        if(m!=null){
            sumatoriaVuelto = sumatoriaVuelto + m.getValor();
        }
    }
    public int cuantoVuelto(){
        return sumatoriaVuelto;
    }
    public String queBebiste(){
        return sabor;
    }
}
  
public class Tarea2Progra2 {
    public static void main(String[] args) {
        Moneda moneda1 = new Moneda1000();
        Moneda moneda2 = new Moneda100();
        Expendedor expendedor1 = new Expendedor(12,400);
        Comprador Comprador1 = new Comprador(moneda1,2,expendedor1);
        System.out.println(expendedor1.comprarBebida(Comprador1.getMoneda(),Comprador1.getQueBebida()));
        expendedor1.setDeposito(moneda1);
        Comprador1.setVuelto(expendedor1.getVuelto());
        Comprador1.setVuelto(expendedor1.getVuelto());
        Comprador1.setVuelto(expendedor1.getVuelto());
        Comprador1.setVuelto(expendedor1.getVuelto());
        Comprador1.setVuelto(expendedor1.getVuelto());
        Comprador1.setVuelto(expendedor1.getVuelto());
        Comprador1.setVuelto(expendedor1.getVuelto());
        System.out.println(Comprador1.cuantoVuelto());
        System.out.println(moneda1.getSerie());
        System.out.println(moneda2.getSerie());
        System.out.println(moneda1);
    }
}
