package com.nbsaas.adminstore.article.data.entity;

import com.haoxuer.discover.config.data.entity.User;
import com.haoxuer.discover.data.entity.AbstractEntity;
import com.haoxuer.discover.data.enums.StoreState;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * 文章
 *
 * @author 年高
 */
@Data
@Entity
@Table(name = "article")
public class Article extends AbstractEntity {

    public static Article fromId(Long id){
        Article result=new Article();
        result.setId(id);
        return result;
    }

    /**
     * 文章分类
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private ArticleCatalog catalog;
    /**
     * 文章评论数量
     */
    private Integer comments;

    /**
     * 喜欢的数量
     */
    private Integer likes;


    /**
     * 文章内容
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private ArticleDocument  document;

    /**
     * 文章扩展信息
     */
    private String extData;


    /**
     * 文章图片集
     */
    private String images;

    /**
     * 封面
     */
    private String img;

    /**
     * 文章介绍
     */
    private String introduction;
    @JoinTable(name = "article_link_tag")
    @ManyToMany
    private Set<ArticleTag> tags;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 点赞数量
     */
    private Integer ups;

    /**
     * 文章作者
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    /**
     * 文章查看数量
     */
    private Integer views;

    private StoreState storeState;

}
