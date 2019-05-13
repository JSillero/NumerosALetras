/**
 * 
 * @author d18sisaj
 *
 */
public class Digitos {
  /**
   * Digito almacena un valor
   * Posicion almacena la posicion en un trio, (0,1 o 2)
   * Orden da el valor del trio( 0 si nada, 1 si mil, 2 si millon 3 si mil millones 4 si billon);
   */
  private int digito;
  private int posicion;
  private int orden;
  public Digitos( String digit,int pos, int ord) {
    
    
    this.digito=Integer.parseInt(digit);
    this.posicion=pos;
    this.orden=ord;
  }
  
  public int getDigit() {
    return this.digito;
  }
  public int getPos() {
    return this.posicion;
  }
  public int getOrd() {
    return this.orden;
  }
  
  
  public String toString() {
    String cadena="";
    
    cadena+=("Valor: "+Integer.toString(digito)+" Posicion: "+ Integer.toString(posicion)+" Orden:"+Integer.toString(orden)+"\n" );
    
    return cadena;
  }
  
  
  
}
