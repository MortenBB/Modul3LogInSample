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

    public int calculator2L(int length) {
        int largeBricks = length / 4;
        if (length % 4 == 0 && length > 8) {
            return largeBricks - 1;
        } else {
            return largeBricks;
        }
    }

    public int calculator2M(int length) {
        int mediumBricks = 0;
        if (length % 4 != 0) {
            mediumBricks = (length % 4) / 2;
        }
        if (length % 4 == 0 && length > 8) {
            return mediumBricks + 2;
        }
        return mediumBricks;
    }

    public int totalSBricks(int heigth, int sBricksl, int sBricksw) {
        int unequalS = (sBricksw + sBricksl) * (heigth / 2 - heigth);
        int equalS = (sBricksw + sBricksl) * heigth / 2;
        return (unequalS + equalS) * 2;
    }

    public int totalMBricks(int heigth, int mBricksl, int mBricksw, int mBricks2l, int mBricks2w) {
        int unequalL = (mBricksw + mBricksl) * (heigth / 2 - heigth);
        int equalL = (mBricks2w + mBricks2l) * heigth / 2;
        return (unequalL + equalL) * 2;
    }

    public int totalLBricks(int heigth, int lBricksl, int lBricksw, int lBricks2l, int lBricks2w) {
        int unequalL = (lBricksl + lBricksw) * (heigth / 2 - heigth);
        int equalL = (lBricks2l + lBricks2w) * heigth / 2;
        return (unequalL + equalL) * 2;
    }
}
