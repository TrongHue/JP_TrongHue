package jsoft.ads.article;

import java.util.*;
import jsoft.objects.*;
public class ArticleLibrary {
    public ArticleLibrary() {
    }

    public static String viewAritcle(ArrayList<ArticleObject> items) {
        String tmp = "";

        int NO = 0;
      for (ArticleObject item : items) {
          NO++;
          tmp += "<tr>";
          tmp += "<td>"+NO+"</td>";
          tmp += "<td>"+item.getArticle_id()+"</td>";
          tmp += "<td>"+item.getArticle_title()+"</td>";
          tmp += "<td>"+item.getCategory_name()+"</td>";
          tmp += "<td>"+item.getSection_name()+"</td>";
          tmp += "<td>Xoa</td>";
          tmp += "<td>"+item.getArticle_id()+"</td>";
          tmp += "</tr>";
      }

        return tmp;
    }

}
