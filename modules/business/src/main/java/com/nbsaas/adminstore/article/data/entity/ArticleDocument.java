package com.nbsaas.adminstore.article.data.entity;

import com.haoxuer.discover.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "article_document")
public class ArticleDocument extends AbstractEntity {

    @Column(length = 6000)
    private String note;
}
