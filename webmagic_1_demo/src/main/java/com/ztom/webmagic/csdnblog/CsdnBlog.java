package com.ztom.webmagic.csdnblog;

/**
 * author:ztom
 * date:2018/10/29 14:17
 */
public class CsdnBlog {
    private Integer article_number;

    private String article_title;

    private String author_name;

    private String deploy_time;

    private String read_number;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CsdnBlog{");
        sb.append("article_number='").append(article_number).append('\'');
        sb.append(", article_title='").append(article_title).append('\'');
        sb.append(", author_name='").append(author_name).append('\'');
        sb.append(", deploy_time='").append(deploy_time).append('\'');
        sb.append(", read_number='").append(read_number).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getArticle_number() {
        return article_number;
    }

    public void setArticle_number(Integer article_number) {
        this.article_number = article_number;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getDeploy_time() {
        return deploy_time;
    }

    public void setDeploy_time(String deploy_time) {
        this.deploy_time = deploy_time;
    }

    public String getRead_number() {
        return read_number;
    }

    public void setRead_number(String read_number) {
        this.read_number = read_number;
    }
}
