import java.util.ArrayList;
/**
 * 
 * Hay problemas con la implementacion de las variaciones del valor 1( en el caso de mil y mil millones 1 no se expresa
 * en el caso de millon, es un millon y en el resto de casos es uno, ademas de en las variedades de millon/millones;
 * por restricciones de tiempo no puedo arreglar estos problemas.
 * 
 * Algo como llenar el array que almacena el numero hasta arriba con 0 cada vez que se almacenase y simplemente comprobar
 * que esten los dos valores anteriores en 0 bastaría.
 * @author d18sisaj
 *
 */
public class numerosAletras {
  
  static ArrayList<Digitos> digitos = new ArrayList<Digitos>();
  
  static String Ejecucion(int secuencia) {
    String numeros =Integer.toString(secuencia);
    /**
     * El orden indica  0 nada, 1 mil, 2 millon, 3 mil millones, 4 billones
     */
    int orden=0;
    int contador=0;
    String cadenaFinal="";
    for(int i=0; i< numeros.length() ; i++  ) {
    
      
     
      digitos.add(new Digitos(numeros.substring((numeros.length()-i-1),(numeros.length()-i)),contador+1,orden));
      
      
      if(contador==2) {
        orden+=1;
        contador=0;
      }else
        contador+=1;
      
     // System.out.println(digitos.get(i));    
    }
    /**
     * Aqui viene lo gordo del programa, ir sumando valores a la cadena final que se mostrara por pantalla.
     * 
     */
    boolean evaluarpos1=true;//si se usa once o trece veintiuno, esta variable se usa como puerta para evitar la evaluacion de posiciones 1
    boolean llave1=true; //cuando se intruduce algo como 10000000, con esta llave se impide que se añada otro mil o millon aparte del primero
    for(int i=0; i<digitos.size();i++) {
      
      
      if(digitos.get(digitos.size()-i-1).getPos()==3 && digitos.get(digitos.size()-i-1).getDigit()>0) {
        

        //en caso de valor en posicion 3 y valor 1 y 2 vacios.
        // pues si solo es 100 se lee cien, pero si es 1XX es ciento
        if(digitos.get(digitos.size()-i-1).getDigit()==1 && digitos.get(digitos.size
            ()-i-2).getDigit()==0 && digitos.get(digitos.size()-i-3).getDigit()==0) {
          //aumentar i hace que ignore  los dos siguientes valores vacios
          cadenaFinal+="cien ";
          i+=1;
        }else {
          
          int e=digitos.get(digitos.size()-i-1).getDigit();
          switch (e) {
            case 1:
              cadenaFinal+="ciento ";
              
              break;
            case 2:
              cadenaFinal+="doscientos ";
              break;
            case 3:
              cadenaFinal+="trescientos ";
              break;
            case 4:
              cadenaFinal+="cuatrocientos ";
              break;
            case 5:
              cadenaFinal+="quinientos ";
              break;
            case 6:
              cadenaFinal+="seiscientos ";
              break;
            case 7:
              cadenaFinal+="setecientos ";
            break;
            case 8:
              cadenaFinal+="ochocientos ";
              break;
            case 9:
              cadenaFinal+="novecientos ";
              break;
            default:
              
              break;
          }
        } 
        llave1=true;
      }
      
      if(digitos.get(digitos.size()-i-1).getPos()==2 &&digitos.get(digitos.size()-i-1).getDigit()>0) {
        int e=digitos.get(digitos.size()-i-1).getDigit();
        switch(e) {
        case(1):
          int f=digitos.get(digitos.size()-i-2).getDigit();
          
          switch(f) {
          case(1):
            cadenaFinal+="once ";
          evaluarpos1=false;            
            break;
          case(2):
            cadenaFinal+="doce ";
          evaluarpos1=false;            
            break;
          case(3):
            cadenaFinal+="trece ";
          evaluarpos1=false;
            break;
          case(4):
            cadenaFinal+="catorce ";
          evaluarpos1=false;
            break;
          case(5):
            cadenaFinal+="quince ";
          evaluarpos1=false;
            break;
          case(6):
            cadenaFinal+="dieciseis ";
          evaluarpos1=false;
            break;
          case(7):
            cadenaFinal+="diecisiete ";
          evaluarpos1=false;
            break;
          case(8):
            cadenaFinal+="dieciocho ";
          evaluarpos1=false;
            break;
          case(9):
            cadenaFinal+="diecinueve ";
          evaluarpos1=false;
            break;
          default:
            cadenaFinal+="diez ";
            
            break;
          }
          break;
        case(2):
          int g=digitos.get(digitos.size()-i-2).getDigit();
          
          switch(g) {
            case(1):
              cadenaFinal+="veintiuno ";
            evaluarpos1=false; 
            break;
            case(2):
              cadenaFinal+="veintidos ";
            evaluarpos1=false;
            break;
            case(3):
              cadenaFinal+="veintitres ";
            evaluarpos1=false;
            break;
            case(4):
              cadenaFinal+="veinticuatro ";
            evaluarpos1=false;
            break;
            case(5):
              cadenaFinal+="veinticinco ";
            evaluarpos1=false;
            break;
            case(6):
              cadenaFinal+="veintiseis ";
            evaluarpos1=false;
            break;
            case(7):
              cadenaFinal+="veintisiete ";
            evaluarpos1=false;
            break;
            case(8):
              cadenaFinal+="veintiocho ";
            evaluarpos1=false;
            break;
            case(9):
              cadenaFinal+="veintinueve ";
            evaluarpos1=false;
            break;
          }
        break;
        case(3):
          if(digitos.get(digitos.size()-i-2).getDigit()==0) {
            
            cadenaFinal+="treinta ";
          }else {
            cadenaFinal+="treinta y ";
          }
        break;
        case(4):
          if(digitos.get(digitos.size()-i-2).getDigit()==0) {
            
            cadenaFinal+="cuarenta ";
          }else {
            cadenaFinal+="cuarenta y ";
          }
        break;
        case(5):
          if(digitos.get(digitos.size()-i-2).getDigit()==0) {
            
            cadenaFinal+="cincuenta ";
          }else {
            cadenaFinal+="cincuenta y ";
          }
        break;
        case(6):
          if(digitos.get(digitos.size()-i-2).getDigit()==0) {
            
            cadenaFinal+="sesenta ";
          }else {
            cadenaFinal+="sesenta y ";
          }
        break;
        case(7):
          if(digitos.get(digitos.size()-i-2).getDigit()==0) {
            
            cadenaFinal+="setenta ";
          }else {
            cadenaFinal+="setenta y ";
          }
        break;
        case(8):
          if(digitos.get(digitos.size()-i-2).getDigit()==0) {
            
            cadenaFinal+="ochenta ";
          }else {
            cadenaFinal+="ochenta y ";
          }
        break;
        case(9):
          if(digitos.get(digitos.size()-i-2).getDigit()==0) {
            
            cadenaFinal+="noventa ";
          }else {
            cadenaFinal+="noventa y ";
          }
        break;
        default:
         
        
        break;
        
        }
        llave1=true;
      }
      if(digitos.get(digitos.size()-i-1).getPos()==1 && evaluarpos1 && digitos.get(digitos.size()-i-1).getDigit()>0) {
        int e=digitos.get(digitos.size()-i-1).getDigit();
  //no implementado      boolean asignado1= false; // llave para saber si la forma de 1 ( [ausencia], uno o un ) ha sido asignada
        switch(e) {
        case(1):
          if((digitos.get(digitos.size()-i-1).getOrd()==1 && digitos.size()==4) ||
              digitos.get(digitos.size()-i-1).getOrd()==3 && digitos.size()==10 ) {
            // no se añade nada pues seria solo "mil" o "mil millones"
          }else if(digitos.get(digitos.size()-i-1).getOrd()==2 && digitos.size()==8) {
            cadenaFinal+="un ";
            
          }else
            cadenaFinal+="uno ";
        /**
         * &&(
                digitos.get(digitos.size()-i-1).getDigit()>0 ||
                digitos.get(digitos.size()-i).getDigit()>0 ||
                digitos.get(digitos.size()-i+1).getDigit()>0) 
         */
        
        break;
        case(2):
          cadenaFinal+="dos ";
        break;
        case(3):
          cadenaFinal+="tres ";
        break;
        case(4):
          cadenaFinal+="cuatro ";
        break;
        case(5):
          cadenaFinal+="cinco ";
        break;
        case(6):
          cadenaFinal+="seis ";
        break;
        case(7):
          cadenaFinal+="siete ";
        break;
        case(8):
          cadenaFinal+="ocho ";
        break;
        case(9):
          cadenaFinal+="nueve ";
        break;
        default:
          
        break;
        
        }
        
        llave1=true;
            
            
          }
      if(digitos.get(digitos.size()-i-1).getPos()==1 && llave1) {
        evaluarpos1=true;//siempre se ejecuta despues de un trio, que es cuadno se debe volver a abrir la puerta
        
        int ord=digitos.get(digitos.size()-i-1).getOrd();
        switch(ord) {
          case(1):
            cadenaFinal+="mil ";
            
          break;
          case(2):
            
           if(digitos.get(digitos.size()-i-1).getDigit()>1) {
            cadenaFinal+="millones ";
          llave1=false;
           }
           else {
             cadenaFinal+="millon ";
             llave1=false;
           }
          break;
          case(3):
            cadenaFinal+="mil millones ";
            llave1=false;
          break;
          default:
            
            break;
          
        }
        
        
      }
      
    }
    /**
     * Ya que el metodo y el array son estaticos, se tiene que limpiar si se va a 
     * utiliar mas de una vez en un programa
     */
  digitos.clear();
  
  //HACER QUE EL PRIMER VALOR DE LA CADENA SE PASE A MAYUSCULA
  
    return(cadenaFinal);
  
  
  
  }
}
