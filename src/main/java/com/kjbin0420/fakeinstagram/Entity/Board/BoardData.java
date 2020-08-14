package com.kjbin0420.fakeinstagram.Entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Builder @AllArgsConstructor
public class BoardData {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UUID;
}
