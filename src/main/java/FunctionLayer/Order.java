package FunctionLayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Morten
 */
public class Order {
    private int id;
    private int SBrick;
    private int MBrick;
    private int LBrick;
    private boolean status;

    public Order(int id, int SBrick, int MBrick, int LBrick, boolean status) {
        this.id = id;
        this.SBrick = SBrick;
        this.MBrick = MBrick;
        this.LBrick = LBrick;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSBrick() {
        return SBrick;
    }

    public void setSBrick(int SBrick) {
        this.SBrick = SBrick;
    }

    public int getMBrick() {
        return MBrick;
    }

    public void setMBrick(int MBrick) {
        this.MBrick = MBrick;
    }

    public int getLBrick() {
        return LBrick;
    }

    public void setLBrick(int LBrick) {
        this.LBrick = LBrick;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", sBrick=" + SBrick + ", mBrick=" + MBrick + ", lBrick=" + LBrick + ", status=" + status + '}';
    }
}
