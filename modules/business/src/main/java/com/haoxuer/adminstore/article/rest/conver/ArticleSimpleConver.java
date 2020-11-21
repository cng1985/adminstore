package com.haoxuer.adminstore.article.rest.conver;

import com.haoxuer.adminstore.article.api.domain.simple.ArticleSimple;
import com.haoxuer.adminstore.article.data.entity.Article;
import com.haoxuer.discover.data.rest.core.Conver;


public class ArticleSimpleConver implements Conver<ArticleSimple, Article> {
    @Override
    public ArticleSimple conver(Article source) {
        ArticleSimple result = new ArticleSimple();
        result.setId(source.getId());
         result.setImg(source.getImg());
         result.setTitle(source.getTitle());
         result.setComments(source.getComments());
         result.setStoreState(source.getStoreState());
         result.setUps(source.getUps());
         result.setExtData(source.getExtData());
         result.setLikes(source.getLikes());
         result.setAddDate(source.getAddDate());
         result.setImages(source.getImages());
         result.setIntroduction(source.getIntroduction());
         result.setViews(source.getViews());

         result.setStoreStateName(source.getStoreState()+"");

        return result;
    }
}
