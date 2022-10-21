
package tarea2progra2;

import java.util.ArrayList;

abstract class Moneda{
    public Moneda(){
    }
    //public String getSerie(){
      //  return Moneda;
    //}
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
    public String beber(){
        return "sabor: ";
    }
}

class Sprite extends Bebida{
    public Sprite(int numSerie){
        super(numSerie);
    }
    @Override
    public String beber(){
        return super.beber() + "sprite";
    }
}

class CocaCola extends Bebida{
    public CocaCola(int numSerie){
        super(numSerie);
    }
    @Override
    public String beber(){
        return super.beber() + "cocacola";
    }
}
class Fanta extends Bebida{
    public Fanta(int numSerie){
        super(numSerie);
    }
    @Override
    public String beber(){
        return super.beber() + "cocacola";
    }
}

class Deposito{
    private final ArrayList<Bebida> var;
    public Deposito(){
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

class Expendedor{
    private Deposito coca;
    private Deposito sprite;
    private Deposito fanta;
    private int precioBebidas;
    public Expendedor(int cantidad,int precio){
        precioBebidas = precio;
        int numsc = 100;
        int numss = 200;
        int numsf = 300;
        coca = new Deposito();
        sprite = new Deposito();
        fanta = new Deposito();
        for(int i=0;i<cantidad;i=i+1){
            coca.addBebida(new CocaCola(numsc));
            numsc = numsc+1;
            sprite.addBebida(new Sprite(numss));
            numss = numss+1;
            sprite.addBebida(new Sprite(numss));
            numss = numss+1;
        }
    }
    public Bebida comprarBebida(Moneda a,int selec ){
        if(selec == 1){
            return coca.getBebida();
        }else if(selec ==2){
            return sprite.getBebida();
        }
        return null;
    }
}
  
public class Tarea2Progra2 {
    public static void main(String[] args) {
    }
}
