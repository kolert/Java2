package lv.javaguru.java2.database.Entities;

import javax.persistence.*;

@Entity
@Table(name="mail")
public class Mail {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="sender_id", nullable = false)
    private Long senderId;

    @Column(name="recipient_id", nullable = false)
    private Long recipientId;

    @Column(name="message")
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", senderId=" + senderId +
                ", recipiantId=" + recipientId +
                ", message='" + message + '\'' +
                '}';
    }
}
