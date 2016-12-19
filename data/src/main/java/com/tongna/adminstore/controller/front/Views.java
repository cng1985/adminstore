/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package com.tongna.adminstore.controller.front;

/**
 * 
 * 返回页面配置
 * 
 * @author langhsu
 *
 */
public interface Views {
	String REDIRECT_HOME = "redirect:/admin/index.htm";

	String LOGIN = "login";
	String REG = "/reg";
	String REG_RESULT = "/reg_result";
	String OAUTH_REG = "/oauth_reg";

	String FORGOT_APPLY = "/forgot/apply";
	String FORGOT_RESET = "/forgot/reset";

	String INDEX = "/index";

	String HOME_FEEDS = "/home/feeds";
	String HOME_POSTS = "/home/posts";
	String HOME_POSTS_UPDATE = "/home/update";
	String REDIRECT_HOME_POSTS = "redirect:/home/posts";
	String REDIRECT_POSTS_UPDATE = "redirect:/view/%s";
	String HOME_COMMENTS = "/home/comments";
	String HOME_FOLLOWS = "/home/follows";
	String HOME_FAVORS = "/home/favors";
	String HOME_FANS = "/home/fans";
	String HOME_NOTIFIES = "/home/notifies";

	String TA_HOME = "/ta/home";
	String ACCOUNT_AVATAR = "/account/avatar";
	String ACCOUNT_PASSWORD = "/account/password";
	String ACCOUNT_PROFILE = "/account/profile";
	String ACCOUNT_EMAIL = "/account/email";

	String BLOG_UPLOAD = "/post/upload";
	
	String TAGS_INDEX = "/tags/index";
	String TAGS_TAG = "/tags/tag";
	
	String BROWSE_GALLERY = "/gallery/index";
	String BROWSE_GALLERY_SNIPPET = "/gallery/snippet";
	String BROWSE_SEARCH = "/browse/search";
	String BROWSE_DETAIL = "/browse/detail";
	
	String ROUTE_POST_PUBLISH = "/group/%s/post";
	String ROUTE_POST_INDEX = "/group/%s/index";
	String ROUTE_POST_VIEW = "/group/%s/view";
}
