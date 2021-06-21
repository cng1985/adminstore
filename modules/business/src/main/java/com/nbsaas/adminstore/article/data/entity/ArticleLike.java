package com.nbsaas.adminstore.article.data.entity;

import com.haoxuer.discover.config.data.entity.User;
import com.haoxuer.discover.data.entity.AbstractEntity;
import com.nbsaas.codemake.annotation.FieldConvert;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by cng19 on 2017/12/2.
 */

@Data
@Entity
@Table(name = "article_like")
public class ArticleLike extends AbstractEntity {

    @FieldConvert(classType = "Long")
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    @FieldConvert(classType = "Long")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
