package jsoft.ads.article;
import jsoft.objects.*;
import java.sql.*;
import jsoft.*;

public interface Article extends ShareControl {

    public boolean addArticle(ArticleObject item);
    public boolean editArticle(ArticleObject item);
    public boolean delArticle(ArticleObject item);
    public ResultSet getArticle(int id);
    public ResultSet getArticles(ArticleObject similar, int at, byte total );

}