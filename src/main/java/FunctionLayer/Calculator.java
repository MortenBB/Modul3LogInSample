/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Morten
 */
public class Calculator {

    public int calculatorS(int length) {
        int smallBricks = (length % 4) % 2;
        return smallBricks;
    }

    public int calculatorM(int length) {
        int mediumBricks = 0;
        if (length % 4 != 0) {
            mediumBricks = (length % 4) / 2;
        }
        return mediumBricks;
    }

    public int calculatorL(int length) {
        int largeBricks = length / 4;
        return largeBricks;
    }
    
    public int brickwork(int lBricks, int mBricks, int sBricks){
        return
    }
}
