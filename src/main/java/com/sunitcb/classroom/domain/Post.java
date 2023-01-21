package com.sunitcb.classroom.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private  String content;
    private String author;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "post_id")
    @JsonManagedReference
    private List<Comment> comments;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private User user;
}
