/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Dominio.CtrlProblemas;
import Dominio.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jordi
 */
public class CtrlRanking {
        CtrlProblemas ctrlP = new CtrlProblemas();

    
    public Map<String,Double> getmap(int id ){
        return ctrlP.getmap(id);
    }
}
