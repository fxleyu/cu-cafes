package fx.leyu.project.jdata2017.domain;

import java.sql.Timestamp;

public class Action {
    private int id;
    private int userId;
    private int productId;
    private Timestamp time;
    private int modelId;
    private int type;
    private int cate;
    private int brand;
    
    public Action(int id, int userId, int productId, Timestamp time,
            int modelId, int type, int cate, int brand) {
        super();
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.time = time;
        this.modelId = modelId;
        this.type = type;
        this.cate = cate;
        this.brand = brand;
    }
    
    public Action(String[] strs) {
        userId = Integer.parseInt(strs[0]);
        productId = Integer.parseInt(strs[1]);
        time = Timestamp.valueOf(strs[2]);
        if (strs[3] != null && strs[3].length() > 0) {
            modelId = Integer.parseInt(strs[3]);
        }
        type = Integer.parseInt(strs[4]);
        cate = Integer.parseInt(strs[5]);
        brand = Integer.parseInt(strs[6]);
    }
    
    public int getId() {
        return id;
    }
    public int getUserId() {
        return userId;
    }
    public int getProductId() {
        return productId;
    }
    public Timestamp getTime() {
        return time;
    }
    public int getModelId() {
        return modelId;
    }
    public int getType() {
        return type;
    }
    public int getCate() {
        return cate;
    }
    public int getBrand() {
        return brand;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setTime(Timestamp time) {
        this.time = time;
    }
    public void setModelId(int modelId) {
        this.modelId = modelId;
    }
    public void setType(int type) {
        this.type = type;
    }
    public void setCate(int cate) {
        this.cate = cate;
    }
    public void setBrand(int brand) {
        this.brand = brand;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + brand;
        result = prime * result + cate;
        result = prime * result + id;
        result = prime * result + modelId;
        result = prime * result + productId;
        result = prime * result + ((time == null) ? 0 : time.hashCode());
        result = prime * result + type;
        result = prime * result + userId;
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
        Action other = (Action) obj;
        if (brand != other.brand)
            return false;
        if (cate != other.cate)
            return false;
        if (id != other.id)
            return false;
        if (modelId != other.modelId)
            return false;
        if (productId != other.productId)
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        if (type != other.type)
            return false;
        if (userId != other.userId)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Action [id=" + id + ", userId=" + userId + ", productId="
                + productId + ", time=" + time + ", modelId=" + modelId
                + ", type=" + type + ", cate=" + cate + ", brand=" + brand
                + "]";
    }
}
