package Dominio;
import ClasesExtra.*;
import Dominio.fichas.Bishop;
import Dominio.fichas.King;
import Dominio.fichas.Knight;
import Dominio.fichas.Pawn;
import Dominio.fichas.Queen;
import Dominio.fichas.Rook;
import java.util.*;

/**
 *
 * @author Joan
 */
public class CtrlProblemas {
    private Map<String, Pair <String, Integer> > Problems = new HashMap<>();
    private static final int numr = 2;
    private static final int numR = 2;
    private static final int numb = 2;
    private static final int numB = 2;
    private static final int numn = 2;
    private static final int numN = 2;
    private static final int nump = 8;
    private static final int numP = 8;
    private static final int numk = 1;
    private static final int numK = 1;
    private static final int numq = 1;
    private static final int numQ = 1;
    
    public CtrlProblemas() {
        Pair p1 = new Pair ("3K4/8/8/p2k4/pp1B4/N5N1/P2Q4/8 w", 3);
        Pair p2 = new Pair("2R3rk/3N4/7K/3N4/8/8/r4p2/8 w", 3);
//        Pair p3 = new Pair ("4n1bk/8/6PK/8/7N/8/8/8 w", 2);
//        Pair p4 = new Pair ("3K4/8/8/p2k4/pp1B4/N5N1/P2Q4/8 w", 3);
//        Pair p5 = new Pair ("1r6/5qpk/1b1R3B/3PpP2/8/6QP/5P2/6K1 w", 3);
        
        Problems.put("Jaque dificil en tres movimientos", p1);
        Problems.put("Jaque facil en tres movimientos", p2);
//        Problems.put("Jaque facil en dos movimientos", p3);
//        Problems.put("Jaque chungo en tres movimientos", p4);
//        Problems.put("Jaque sencillo en tres movimientos", p5);
    }
    
    public void addProblema(String id, String fen, int numM) {
        if (!existProblem(id)) {
            if (!existFEN(fen)) {
                Pair x = new Pair(fen,numM);
                Problems.put(id, x);
            }
            else System.out.println("Este problema ya está registrado.");
        }
        else System.out.println("El ID ya está siendo utilizado. Pruebe con otro.");
    }
    
    public boolean existProblem(String id) {
        return Problems.containsKey(id);
    }
    
    public boolean existFEN(String fen) {
        return Problems.containsValue(fen);
    }
    
    public boolean cumpleRestriccionFichas(Problema crear) {
        int r = 0; 
        int n = 0; 
        int k = 0;
        int p = 0;
        int q = 0;
        int b = 0;
        int R = 0;
        int N = 0;
        int K = 0;
        int P = 0;
        int Q = 0;
        int B = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (crear.getFicha(new Coordenada(i,j)) != null) {
                    char c = crear.getFicha(new Coordenada(i,j)).getID();
                    switch(c) {
                        case 'r':
                            ++r;
                            if (r > numr) {
                                System.out.println("No puede haber más de 2 torres negras");
                                return false;
                            }
                            break;
                        case 'R':
                            ++R;
                            if (R > numR) {
                                System.out.println("No puede haber más de 2 torres blancas");
                                return false;
                            }
                            break;
                        case 'q':
                            ++q;
                            if (q > numq) {
                                System.out.println("No puede haber más de 1 reina negra");
                                return false;
                            }
                            break;
                        case 'Q':
                            ++Q;
                            if (Q > numQ) {
                                System.out.println("No puede haber más de 1 reina blanca");
                                return false;
                            }
                            break;
                        case 'b':
                            ++b;
                            if (b > numb) {
                                System.out.println("No puede haber más de 2 alfiles negros");
                                return false;
                            }
                            break;
                        case 'B':
                            ++B;
                            if (B > numB) {
                                System.out.println("No puede haber más de 2 alfiles blancos");
                                return false;
                            }
                            break;
                        case 'n':
                            ++n;
                            if (n > numn) {
                                System.out.println("No puede haber más de 2 caballos negros");
                                return false;
                            }
                            break;
                        case 'N':
                            ++N;
                            if (N > numN) {
                                System.out.println("No puede haber más de 2 caballos blancos");
                                return false;
                            }
                            break;
                        case 'p':
                            ++p;
                            if (p > nump) {
                                System.out.println("No puede haber más de 8 peones negros");
                                return false;
                            }
                            break;
                        case 'P':
                            ++P;
                            if (P > numP) {
                                System.out.println("No puede haber más de 8 peones blancos");
                                return false;
                            }
                            break;
                        case 'k':
                            ++k;
                            break;
                        case 'K':
                            ++K;
                            
                            break;
                    }
                    
                }
            }
        }
        if (K != numK) {
            System.out.println("Tiene que haber 1 rey blanco");
            return false;
        }
        if (k != numk) {
            System.out.println("Tiene que haber 1 rey negro");
            return false;
        }
        return true;
    }
    
    public void anadirFicha(Problema crear, String ficha, String color, String pos) {
        switch(ficha) {
            case "r":
                Rook r;
                if (color.equals("n")) {
                    r = new Rook(false, 'r');
                }
                else if (color.equals("b")) {
                    r = new Rook(true, 'R');
                }
                else {
                    System.out.println("Error, vuelva a intentarlo");
                    break;
                }
                Coordenada coordR = new Coordenada();
                coordR.stringToCoord(pos);
                try {
                    crear.setFicha(coordR,r);
                    crear.printTablero();
                } catch (ArrayIndexOutOfBoundsException e2){
                    System.out.println("Coordenadas fuera del rango del tablero, vuelva a probar.");
                    break;
                }
                break;
            case "k":
                King k;
                if (color.equals("n")) {
                    k = new King(false, 'k');
                   // hayReyNegro = true;
                }
                else if (color.equals("b")) {
                    k = new King(true, 'K');
                  //  hayReyBlanco = true;
                }
                else {
                    System.out.println("Error, vuelva a intentarlo");
                    break;
                }
                Coordenada coordK = new Coordenada();
                coordK.stringToCoord(pos);
                try {
                    crear.setFicha(coordK,k);
                } catch (ArrayIndexOutOfBoundsException e2){
                    System.out.println("Coordenadas fuera del rango del tablero, vuelva a probar.");
                    break;
                }
                break;
            case "q":
                Queen q;
                if (color.equals("n")) {
                    q = new Queen(false, 'q');
                }
                else if (color.equals("b")) {
                    q = new Queen(true, 'Q');
                }
                else {
                    System.out.println("Error, vuelva a intentarlo");
                    break;
                }
                Coordenada coordQ = new Coordenada();
                coordQ.stringToCoord(pos);
                try {
                    crear.setFicha(coordQ,q);
                } catch (ArrayIndexOutOfBoundsException e2){
                    System.out.println("Coordenadas fuera del rango del tablero, vuelva a probar.");
                    break;
                }
                break;
            case "p":
                Pawn p;
                if (color.equals("n")) {
                    p = new Pawn(false, 'p');
                }
                else if (color.equals("b")) {
                    p = new Pawn(true, 'P');
                }
                else {
                    System.out.println("Error, vuelva a intentarlo");
                    break;
                }
                Coordenada coordP = new Coordenada();
                coordP.stringToCoord(pos);
                try {
                    crear.setFicha(coordP,p);
                } catch (ArrayIndexOutOfBoundsException e2){
                    System.out.println("Coordenadas fuera del rango del tablero, vuelva a probar.");
                    break;
                }
                break;
            case "b":
                Bishop b;
                if (color.equals("n")) {
                    b = new Bishop(false, 'b');
                }
                else if (color.equals("b")) {
                    b = new Bishop(true, 'B');
                }
                else {
                    System.out.println("Error, vuelva a intentarlo");
                    break;
                }
                Coordenada coordB = new Coordenada();
                coordB.stringToCoord(pos);
                try {
                    crear.setFicha(coordB,b);
                } catch (ArrayIndexOutOfBoundsException e2){
                    System.out.println("Coordenadas fuera del rango del tablero, vuelva a probar.");
                    break;
                }
                break;
            case "n":
                Knight n;
                if (color.equals("n")) {
                    n = new Knight(false, 'n');
                }
                else if (color.equals("b")) {
                    n = new Knight(true, 'N');
                }
                else {
                    System.out.println("Error, vuelva a intentarlo");
                    break;
                }
                Coordenada coordN = new Coordenada();
                coordN.stringToCoord(pos);
                try {
                    crear.setFicha(coordN,n);
                } catch (ArrayIndexOutOfBoundsException e2){
                    System.out.println("Coordenadas fuera del rango del tablero, vuelva a probar.");
                    break;
                }
                break;
        }
    }
    
    public Pair <String, Integer> seleccionProblema(int n) {
        int index = 1;
        Pair r = new Pair();
        for(String key : Problems.keySet()) {
            if (n == index) {
                String fen = Problems.get(key).getKey();
                Integer nm = Problems.get(key).getValue();
                Pair f = new Pair(fen, nm);
                r = f;
            }
            ++index;
        }
        return r;
    }
    public void printProblemas() {
        int index = 1;
        for(String key : Problems.keySet()) {
            System.out.println(index + ". " +key);
            String fen = Problems.get(key).getKey();
            Problema p = new Problema();
            p.fenToMatrix(fen);
            p.printTablero();
            int nM = Problems.get(key).getValue();
            System.out.println("Se supera en "+ nM +" movimientos.");
            ++index;
        }
    }
}
