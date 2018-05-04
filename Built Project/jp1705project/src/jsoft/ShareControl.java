package jsoft;

public interface ShareControl {
    //chuc nang chia se dieu khien giua cac basic
   public ConnectionPool getCP();
   public void releaseConnection();
}
