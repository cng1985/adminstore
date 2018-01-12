/**
 * @apiDefine 1App
 * 1 程序模块
 */


/**
 * @api {post} /app/findToken.htm 1.1 获取程序的token
 *
 * @apiVersion 0.0.1
 *
 * @apiName findToken
 *
 * @apiGroup 1App
 *
 *
 * @apiPermission none
 *
 * @apiDescription 获取程序的token
 *
 * @apiParam {String} appKey 程序Key
 * @apiParam {String} appSecret 程序密钥
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {String} msg 消息
 *
 *  @apiSuccess {String} token 程序令牌
 *
 */

/**
 * @api {post} /app/refreshToken.htm 1.2 更新程序的token
 *
 * @apiVersion 0.0.1
 *
 * @apiName refreshToken
 *
 * @apiGroup 1App
 *
 *
 * @apiPermission none
 *
 * @apiDescription 获取程序的token
 *
 * @apiParam {String} token token
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {String} msg 消息
 *
 *  @apiSuccess {String} token 程序令牌
 *
 */