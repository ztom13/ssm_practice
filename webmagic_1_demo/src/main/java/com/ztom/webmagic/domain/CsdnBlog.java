package com.ztom.webmagic.domain;

/**
 * author:ztom
 * date:2018/10/28 18:55
 */
public class CsdnBlog {

    private int id;// 编号

    private String title;// 标题

    private String date;// 日期

    private String tags;// 标签

    private String category;// 分类

    private int view;// 阅读人数

    private int comments;// 评论人数

    private int copyright;// 是否原创

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getCopyright() {
        return copyright;
    }

    public void setCopyright(int copyright) {
        this.copyright = copyright;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CsdnBlog{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", tags='").append(tags).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", view=").append(view);
        sb.append(", comments=").append(comments);
        sb.append(", copyright=").append(copyright);
        sb.append('}');
        return sb.toString();
    }
}