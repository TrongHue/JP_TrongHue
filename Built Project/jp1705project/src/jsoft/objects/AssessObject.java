package jsoft.objects;

public class AssessObject {
    private int assess_id;
    private String assess_title;
    private String assess_content;
    private int assess_product_id;
    private String assess_created_date;
    private String assess_values;
    private String assess_author_name;
    private short assess_total_values;
    private short assess_visited;
    private boolean assess_enable;
    private boolean assess_delete;
    public AssessObject() {
    }

    public static void main(String[] args) {
        AssessObject assessobject = new AssessObject();
    }

    public void setAssess_id(int assess_id) {
        this.assess_id = assess_id;
    }

    public void setAssess_title(String assess_title) {
        this.assess_title = assess_title;
    }

    public void setAssess_content(String assess_content) {
        this.assess_content = assess_content;
    }

    public void setAssess_product_id(int assess_product_id) {
        this.assess_product_id = assess_product_id;
    }

    public void setAssess_created_date(String assess_created_date) {
        this.assess_created_date = assess_created_date;
    }

    public void setAssess_values(String assess_values) {
        this.assess_values = assess_values;
    }

    public void setAssess_author_name(String assess_author_name) {
        this.assess_author_name = assess_author_name;
    }

    public void setAssess_total_values(short assess_total_values) {
        this.assess_total_values = assess_total_values;
    }

    public void setAssess_visited(short assess_visited) {
        this.assess_visited = assess_visited;
    }

    public void setAssess_enable(boolean assess_enable) {
        this.assess_enable = assess_enable;
    }

    public void setAssess_delete(boolean assess_delete) {
        this.assess_delete = assess_delete;
    }

    public int getAssess_id() {
        return assess_id;
    }

    public String getAssess_title() {
        return assess_title;
    }

    public String getAssess_content() {
        return assess_content;
    }

    public int getAssess_product_id() {
        return assess_product_id;
    }

    public String getAssess_created_date() {
        return assess_created_date;
    }

    public String getAssess_values() {
        return assess_values;
    }

    public String getAssess_author_name() {
        return assess_author_name;
    }

    public short getAssess_total_values() {
        return assess_total_values;
    }

    public short getAssess_visited() {
        return assess_visited;
    }

    public boolean isAssess_enable() {
        return assess_enable;
    }

    public boolean isAssess_delete() {
        return assess_delete;
    }
}
