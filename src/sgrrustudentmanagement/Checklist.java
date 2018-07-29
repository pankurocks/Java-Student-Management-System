
package sgrrustudentmanagement;


public class Checklist {
    private int Studentid;

    public int getStudentid() {
        return Studentid;
    }

    public void setStudentid(int Studentid) {
        this.Studentid = Studentid;
    }
    private boolean xmark;
    private boolean xiimark;
    private boolean xcert;
    private boolean xiicert;
    private boolean dom;
    private boolean mc;
    private boolean tc;
    private boolean grad;
    
    
    public Checklist(){
        
    }

    public boolean isXmark() {
        return xmark;
    }

    public void setXmark(boolean xmark) {
        this.xmark = xmark;
    }

    public boolean isXiimark() {
        return xiimark;
    }

    public void setXiimark(boolean xiimark) {
        this.xiimark = xiimark;
    }

    public boolean isXcert() {
        return xcert;
    }

    public void setXcert(boolean xcert) {
        this.xcert = xcert;
    }

    public boolean isXiicert() {
        return xiicert;
    }

    public void setXiicert(boolean xiicert) {
        this.xiicert = xiicert;
    }

    public boolean isDom() {
        return dom;
    }

    public void setDom(boolean dom) {
        this.dom = dom;
    }

    public boolean isMc() {
        return mc;
    }

    public void setMc(boolean mc) {
        this.mc = mc;
    }

    public boolean isTc() {
        return tc;
    }

    public void setTc(boolean tc) {
        this.tc = tc;
    }

    public boolean isGrad() {
        return grad;
    }

    public void setGrad(boolean grad) {
        this.grad = grad;
    }
    
    public Checklist(int Studentid, boolean xmark, boolean xiimark, boolean xcert, boolean xiicert, boolean dom, boolean mc, boolean tc, boolean grad){
        this.Studentid = Studentid;
        this.xmark = xmark;
        this.xiimark = xiimark;
        this.xcert = xcert;
        this.xiicert = xiicert;
        this.dom = dom;
        this.mc = mc;
        this.tc = tc;
        this.grad = grad;
    }
}
