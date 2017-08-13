package fx.leyu.project.jdata2017.domain;

import java.sql.Date;

public class Comment {
    private int id;
    private Date date;
    private int productId;
    private int commentNum;
    private int hasBadComment;
    private double badCommentRate;

    public Comment(int id, Date date, int productId, int commentNum,
            int hasBadComment, double badCommentRate) {
        super();
        this.id = id;
        this.date = date;
        this.productId = productId;
        this.commentNum = commentNum;
        this.hasBadComment = hasBadComment;
        this.badCommentRate = badCommentRate;
    }
    
    public Comment(String[] strs) {
        date = Date.valueOf(strs[0]);
        productId = Integer.parseInt(strs[1]);
        commentNum = Integer.parseInt(strs[2]);
        hasBadComment = Integer.parseInt(strs[3]);
        badCommentRate = Double.parseDouble(strs[4]);
    }
    
    public int getId() {
        return id;
    }
    public Date getDate() {
        return date;
    }
    public int getProductId() {
        return productId;
    }
    public int getCommentNum() {
        return commentNum;
    }
    public int getHasBadComment() {
        return hasBadComment;
    }
    public double getBadCommentRate() {
        return badCommentRate;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }
    public void setHasBadComment(int hasBadComment) {
        this.hasBadComment = hasBadComment;
    }
    public void setBadCommentRate(double badCommentRate) {
        this.badCommentRate = badCommentRate;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(badCommentRate);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + commentNum;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + hasBadComment;
        result = prime * result + id;
        result = prime * result + productId;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Comment other = (Comment) obj;
        if (Double.doubleToLongBits(badCommentRate) != Double
                .doubleToLongBits(other.badCommentRate))
            return false;
        if (commentNum != other.commentNum)
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (hasBadComment != other.hasBadComment)
            return false;
        if (id != other.id)
            return false;
        if (productId != other.productId)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Comment [id=" + id + ", date=" + date + ", productId="
                + productId + ", commentNum=" + commentNum + ", hasBadComment="
                + hasBadComment + ", badCommentRate=" + badCommentRate + "]";
    }
}
