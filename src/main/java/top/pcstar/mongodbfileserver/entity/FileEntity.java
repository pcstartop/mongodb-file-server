package top.pcstar.mongodbfileserver.entity;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

/**
 * @Author: PanChao
 * @Description: 文件实体类
 * @Date: Created in 11:29 2018/9/4
 */
@Document
public class FileEntity {
    @Id //主键
    private String id;
    private String name; //文件名称
    private String contentType; //文件类型
    private long size; //文件大小
    private Date uploadDate; //上传时间
    private String md5; //MD5
    private Binary content; //文件内容
    private String path; //文件路径

    public FileEntity() {
    }

    public FileEntity(String name, String contentType, long size, Binary content) {
        this.name = name;
        this.contentType = contentType;
        this.size = size;
        this.uploadDate = new Date();
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Binary getContent() {
        return content;
    }

    public void setContent(Binary content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileEntity)) return false;
        FileEntity file = (FileEntity) o;
        return getSize() == file.getSize() &&
                Objects.equals(getId(), file.getId()) &&
                Objects.equals(getName(), file.getName()) &&
                Objects.equals(getContentType(), file.getContentType()) &&
                Objects.equals(getUploadDate(), file.getUploadDate()) &&
                Objects.equals(getMd5(), file.getMd5()) &&
                Objects.equals(getContent(), file.getContent()) &&
                Objects.equals(getPath(), file.getPath());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getContentType(), getSize(), getUploadDate(), getMd5(), getContent(), getPath());
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contentType='" + contentType + '\'' +
                ", size=" + size +
                ", uploadDate=" + uploadDate +
                ", md5='" + md5 + '\'' +
                ", content=" + content +
                ", path='" + path + '\'' +
                '}';
    }
}
