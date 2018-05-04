package jsoft.ads.article;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class ArticleControl {
    private ArticleModel am;
    public ArticleControl(ConnectionPool cp) {
        am = new ArticleModel(cp);
    }

    public ConnectionPool getCP() {
        return this.am.getCP();
    }
    public void releaseConnetion() {
        this.am.releaseConnetion();
    }


    public boolean addArticle(ArticleObject item) {
       return this.am.addArticle(item);
   }

   public boolean editArticle(ArticleObject item) {
       return this.am.editArticle(item);
   }

   public boolean del(ArticleObject item) {
       return this.am.delArticle(item);
   }

   public ArticleObject getArticle(short id) {
       return this.am.getArticle(id);
   }

   public String viewArticle(ArticleObject similar, short page, byte total ) {
       ArrayList<ArticleObject> items = this.am.getArticles(similar,page,total);
       return ArticleLibrary.viewAritcle(items);
   }

    public static void main(String[] args) {
        ConnectionPool cp = new ConnectionPoolImpl();
        ArticleControl a = new ArticleControl(cp);
        System.out.println(a.viewArticle(null, (short)1, (byte)10));
    }
}
