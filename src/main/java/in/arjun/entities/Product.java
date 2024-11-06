package in.arjun.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String title;
    private Double price;
    @Column(length = 1024)
    private String imageUrl;
    private String isActive;
    private Long quantity;
    @CreatedDate
    @Column(updatable = false)
    private Date createdDate;
    @LastModifiedDate
    @Column(insertable = false)
    private Date updatedDate;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
}
