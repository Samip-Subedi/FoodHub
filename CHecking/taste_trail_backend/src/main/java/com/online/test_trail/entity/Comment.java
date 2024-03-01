package com.online.test_trail.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @SequenceGenerator(name = "contents_seq_gen", sequenceName = "contents_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "contents_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "content_id", referencedColumnName = "id")
    private Content content;


    @Column(name = "description", nullable = false)
    private String description;
}
