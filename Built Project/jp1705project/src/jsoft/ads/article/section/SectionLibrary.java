package jsoft.ads.article.section;

import jsoft.objects.*;
import java.util.*;

public class SectionLibrary {
    public SectionLibrary() {
    }
    public static String viewSections(ArrayList<SectionObject> items){
        String tmp = "";
        int no = 0;
        for(SectionObject item: items){
            no++;
            tmp += "<tr>";
            tmp += "<td>"+no+"</td>";
            tmp += "<td>"+item.getSection_name()+"</td>";
            tmp += "<td>"+item.getSection_notes()+"</td>";
            tmp += "<td>"+item.getSection_created_date()+"</td>";
            tmp += "<td>"+item.getSection_created_author_id()+"</td>";
            tmp += "<td>Sua</td>";
            tmp += "<td>Xoa</td>";
            tmp += "<td>"+item.getSection_id()+"</td>";
            tmp += "<tr>";

            tmp+="\n"; //sau nay len servlet thi bo di
        }
        return tmp;
    }

    public static void main(String[] args) {
    }
}
