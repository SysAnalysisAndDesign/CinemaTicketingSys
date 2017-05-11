package com.cinema_ticketing_sys.comment.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by huitianrui on 2017/5/11.
 */
@Entity
@Table(name = "comment", schema = "cinema_ticketing_db")
public class CommentEntity {
    private int commentId;
    private String content;
    private Integer rate;
    private Timestamp date;

    @Id
    @Column(name = "comment_id")
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "rate")
    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (commentId != that.commentId) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
