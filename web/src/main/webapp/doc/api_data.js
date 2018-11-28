define({ "api": [
  {
    "type": "post",
    "url": "/app/findToken.htm",
    "title": "1.1 获取程序的token",
    "version": "0.0.1",
    "name": "findToken",
    "group": "1App",
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>获取程序的token</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "appKey",
            "description": "<p>程序Key</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "appSecret",
            "description": "<p>程序密钥</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码(默认为0)</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>消息</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>程序令牌</p>"
          }
        ]
      }
    },
    "filename": "./1_app.js",
    "groupTitle": "1 程序模块",
    "sampleRequest": [
      {
        "url": "http://localhost:8080/web/rest/app/findToken.htm"
      }
    ]
  },
  {
    "type": "post",
    "url": "/app/refreshToken.htm",
    "title": "1.2 更新程序的token",
    "version": "0.0.1",
    "name": "refreshToken",
    "group": "1App",
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>获取程序的token</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>token</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码(默认为0)</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>消息</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "token",
            "description": "<p>程序令牌</p>"
          }
        ]
      }
    },
    "filename": "./1_app.js",
    "groupTitle": "1 程序模块",
    "sampleRequest": [
      {
        "url": "http://localhost:8080/web/rest/app/refreshToken.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/user/login.htm",
    "title": "2.01 通过账号密码登陆",
    "version": "0.0.1",
    "name": "login",
    "group": "2user",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "no",
            "description": "<p>账号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>通过账号密码登陆</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码(默认为0)</p>"
          }
        ]
      }
    },
    "filename": "./2user.js",
    "groupTitle": "用户模块",
    "sampleRequest": [
      {
        "url": "http://localhost:8080/web/rest/user/login.htm"
      }
    ]
  },
  {
    "type": "get",
    "url": "/user/loginoauth.htm",
    "title": "1.5 通过第三方登陆",
    "version": "0.0.1",
    "name": "loginOauth",
    "group": "2user",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>令牌</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "type",
            "description": "<p>第三方类型（weixin，qq，iosqq,weiapp）</p>"
          }
        ]
      }
    },
    "permission": [
      {
        "name": "none"
      }
    ],
    "description": "<p>通过第三方登陆,要是没有用户信息，系统会创建一份用户信息</p>",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Int",
            "optional": false,
            "field": "code",
            "description": "<p>状态码(默认为0)</p>"
          }
        ]
      }
    },
    "filename": "./2user.js",
    "groupTitle": "用户模块",
    "sampleRequest": [
      {
        "url": "http://localhost:8080/web/rest/user/loginoauth.htm"
      }
    ]
  }
] });
