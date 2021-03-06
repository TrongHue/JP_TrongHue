package jsoft.ads.article.section;

import jsoft.*;
import jsoft.objects.*;

import java.util.*;

public class SectionControl {

    private SectionModel sm;

    public SectionControl(ConnectionPool cp) {
        this.sm = new SectionModel(cp);
    }

    protected void finalize() throws Throwable {
        this.sm = null;
        super.finalize();
    }

    public ConnectionPool getCP() {
        return this.sm.getCP();
    }

    public void releaseConnection() {
        this.sm.releaseConnection();
    }


    //--------------------------------------------
    public boolean addUser(SectionObject item) {
        return this.sm.addSection(item);
    }

    public boolean editUser(SectionObject item) {
        return this.sm.editSection(item);
    }

    public boolean delUser(SectionObject item) {
        return this.sm.delSection(item);
    }

    //--------------------------------------------


    public String viewSections(SectionObject similar, short page, byte total) {
        // lay danh sach doi tuong
        ArrayList<SectionObject>
                items = this.sm.getSectionObjects(similar, page, total);
        return SectionLibrary.viewSections(items);
    }

    public static void main(String[] args) {
        ConnectionPool cp = new ConnectionPoolImpl();
        SectionControl sc = new SectionControl(cp);

        String view = sc.viewSections(null, (short) 1, (byte) 15);
        System.out.println(view);
    }
}
