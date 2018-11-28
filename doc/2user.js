/**
 * @apiDefine 2user 用户模块
 */



/**
 * @api {get} /user/login.htm 2.01 通过账号密码登陆
 *
 * @apiVersion 0.0.1
 *
 * @apiName login
 *
 * @apiGroup 2user
 *
 * @apiParam {String} no 账号
 *
 * @apiParam {String} password 密码
 *
 *
 * @apiPermission none
 *
 * @apiDescription 通过账号密码登陆
 *
 *
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 *
 */


/**
 * @api {get} /user/loginoauth.htm 1.5 通过第三方登陆
 *
 * @apiVersion 0.0.1
 *
 * @apiName loginOauth
 *
 * @apiGroup 2user
 *
 * @apiParam {String} code 令牌
 *
 * @apiParam {String} type 第三方类型（weixin，qq，iosqq,weiapp）
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
