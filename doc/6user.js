/**
 * @apiDefine 6user 用户模块
 */




/**
 * @api {get} /user/loginoauthok.htm 1.5 通过第三方登陆
 *
 * @apiVersion 0.0.1
 *
 * @apiName loginOauth
 *
 * @apiGroup 6user
 *
 * @apiParam {String} token 令牌
 *
 * @apiParam {String} type 第三方类型（weixin，qq，iosqq,weiapp）
 *
 * @apiParam {String} openId openId
 *
 * @apiParam {String} accessToken accessToken
 *
 *
 * @apiPermission none
 *
 * @apiDescription 通过第三方登陆,要是没有用户信息，系统会创建一份用户信息
 *
 *
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 *
 */
