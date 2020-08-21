package com.kjbin0420.fakeinstagram.Entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Builder
public class PicturePath implements Serializable {

    private static final long serialVersionUID = -7538958502452292620L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "picturepath_id")
    private Integer UUID;

    @Column
    private String picturePath;
}
